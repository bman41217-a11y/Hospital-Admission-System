/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitaladmissionsystem;

/**
 *
 * @author bshon
 */

import java.util.ArrayList;

public class HospitalMananger {
    private ArrayList<Patient> patientList = new ArrayList<>();
    //Structure layout dor variables for the bed layout 
    private final int ROWS = 4;
    private final int COLUMNS = 5;
    private String[][] wardLayout = new String[ROWS][COLUMNS];
    private Inpatient[][] bedOccupied = new Inpatient[ROWS][COLUMNS];
    
    public HospitalMananger(){
        int bedNum = 1;
        //Nested loop for iteration
        for(int i = 0; i < ROWS; i++){
            for(int b = 0; b < COLUMNS; b++){
                wardLayout[i][b] = String.format(" ", bedNum++);
                bedOccupied[i][b] = null;
            }
        }  
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
    
    //Feature 1: Patient CRUD
    public boolean registerPatient(Patient p){
        for(Patient existing : patientList){
            if(existing.getPatientId().equalsIgnoreCase(p.getPatientId())){
                System.out.println("Error: Duplicate Patient ID!");
                return false;
            }
        }
        patientList.add(p);
        System.out.println("Patient registered successfully.");
        return true;
    }
   
    public Patient searchPatient(String id){
        for(Patient p : patientList){
            if(p.getPatientId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }
    
    public boolean deletePatient(String id){
        Patient p = searchPatient(id);
        if(p != null){
            if(p instanceof Inpatient && !((Inpatient) p).getBedNumber().equals("None")){
                releaseBed(((Inpatient) p).getBedNumber());
            }
            patientList.remove(p);
            return true;
        }
        return false;
    }
    
    //Feature 2: Bed Management
    public boolean allocateBed(Inpatient ip){
        if(!ip.getBedNumber().equals("None")){
            System.out.println("Patient already has a bed allocated");
            return false;
        }
        for(int i = 0; i < ROWS; i++){
            for(int b = 0; b < COLUMNS; b++){
                if(bedOccupied[i][b] == null){
                    bedOccupied[i][b] = ip;
                    ip.setBedNumber(wardLayout[i][b]);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean releaseBed(String bedId){
        for(int i = 0; i < ROWS; i++){
            for(int b = 0; b < COLUMNS; b++){
                if(wardLayout[i][b].equalsIgnoreCase(bedId)){
                    if(bedOccupied[i][b] != null){
                        bedOccupied[i][b].setBedNumber("None");
                        bedOccupied[i][b] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void displayWardLayout(){
        for(int i = 0; i < ROWS; i++){
            for(int b = 0; b < COLUMNS; b++){
                String label = (bedOccupied[i][b] != null) ?"[x]" : "[0]";
                System.out.print(wardLayout[i][b] + label+ "\t");
            }
            System.out.println();
        }
    }
    
    //feature 3: Sorting & Reports
    public void sortBySurname(){
        patientList.sort((p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
    }
    
    public void generatReport(){
        int occupied = 0;
        for(int i = 0; i < ROWS; i++){
            for(int b = 0; b < COLUMNS; b++){
                if(bedOccupied[i][b] != null) occupied++;
            }
        }
        System.out.println("\n==== Ward Report ====");
        System.out.println("Total Patients: "+patientList.size());
        System.out.println("Occupied Beds: "+occupied+ "/20");
        System.out.printf("Occupancy Rate: %.2f%%\n ", ((double) occupied / 20) * 100);
    }
}
