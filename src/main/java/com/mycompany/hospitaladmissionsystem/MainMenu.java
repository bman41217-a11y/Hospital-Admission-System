/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitaladmissionsystem;

/**
 *
 * @author bshon
 */

import java.util.Scanner;

public class MainMenu {
    
    public static void main(String[] args){
        HospitalMananger manager = new HospitalMananger();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        
        //app runtime execution monitoring block loop
        while(choice != 5){
            System.out.println("\n==== Hospital Menu ====");
            System.out.println("1. Manage Patients (Register, search, or Delete)");
            System.out.println("2. Manage Beds (Allocate, Realease, or View Layout)");
            System.out.println("3. View Sorted Patients");
            System.out.println("4. Ward Reports");
            System.out.println("5. Exit");
            System.out.print("ENTER YOUR CHOICE (1, 2, 3, 4, 5): ");
            
            //Exception handling blocks guarding runtime crashes 
            try{
                choice = Integer.parseInt(input.nextLine());
                switch(choice){
                    case 1:
                        System.out.println("\n=== Patient Management ===");
                        System.out.println("1. Register New Patient");
                        System.out.println("2. Search Patient by ID");
                        System.out.println("3. Delete Patient");
                        System.out.print("Enter Choice: ");
                        int patientChoice = Integer.parseInt(input.nextLine());
                        
                        if(patientChoice == 1 ){   
                           System.out.print("Enter ID: "); String id = input.nextLine();
                           System.out.print("First Name: "); String fn = input.nextLine();
                           System.out.print("Last Name: "); String ln = input.nextLine();
                           System.out.print("Age:  "); int age = Integer.parseInt(input.nextLine());
                           System.out.print("Gender: "); String gender = input.nextLine();
                           System.out.print("Medical Condition: "); String condition = input.nextLine();
                        
                           System.out.print("Category (INPATIENT, OUTPATIENT, EMERGENCY): ");
                           String categoryInput = input.nextLine().toUpperCase().trim();
                           PatientCategory cat = PatientCategory.valueOf(categoryInput);
                        
                        if(cat == PatientCategory.INPATIENT){
                            System.out.print("Enter Ward Number: ");
                            String ward = input.nextLine();
                            manager.registerPatient(new Inpatient(id, fn, ln, age, gender, condition, ward));
                        }else{
                            manager.registerPatient(new Patient(id, fn, ln, age, gender, condition, cat));
                        }
                        
                        }
                        else if(patientChoice == 2 ){
                            //Search Logic
                            System.out.print("Enter Patient ID to Search: ");
                            String searchId = input.nextLine();
                            Patient found = manager.searchPatient(searchId);
                            if(found != null){
                                found.displayDetails();
                            }else{
                                System.out.println("Patient bnot found.");
                            }
                        }
                        
                        else if(patientChoice == 3){
                            //Delete LOgic
                            System.out.print("Enter Patient ID to delete: ");
                            String deleteId = input.nextLine();
                            boolean deleted = manager.deletePatient(deleteId);
                            if(deleted){
                                System.out.println("Success, patient has been removed from system.");
                            }else{
                                System.out.println("Failed. Patient ID not found.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("\n=== Bed Management ===");
                        System.out.println("1. View Current Layout");
                        System.out.println("2. Allocate Bed to Inpatient");
                        System.out.println("3. Release Occupied Bed");
                        System.out.print("Enter Choice: ");
                        int bedChoice = Integer.parseInt(input.nextLine());
                        
                        if(bedChoice == 1){
                            // View Layout
                            manager.displayWardLayout();
                        }
                        else if(bedChoice == 2){
                            //Allocate Bed
                            System.out.print("Enter patient ID to allocate bed: ");
                            String allocateId = input.nextLine();
                            Patient p = manager.searchPatient(allocateId);
                            
                            if(p == null){
                                System.out.println("Error: Patient ID not found.");
                            }else if(!(p instanceof Inpatient)){
                                System.out.println("Error: Only INPATIENT categories can be allocated beds.");
                            }else{
                                boolean allocated = manager.allocateBed((Inpatient) p);
                                if(allocated){
                                    System.out.println("Success. Bed has been assigned.");
                                }else{
                                    System.out.println("Failed. Invalid bed ID.");
                                }
                            }
                        }
                        
                        break;
                    case 3:
                        manager.sortBySurname();
                        for(Patient p : manager.getPatientList()) p.displayDetails();
                        break;
                    case 4:
                        manager.generatReport();
                        break;
                }
                
            }catch(Exception e){
                System.out.println("Invalid entry. Please try again.");
            }
        }
    }
    
}
