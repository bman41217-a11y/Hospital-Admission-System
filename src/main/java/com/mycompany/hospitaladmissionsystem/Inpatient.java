/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitaladmissionsystem;

/**
 *
 * @author bshon
 */
public class Inpatient extends Patient {
    //Attributes specifically to admitted inpatients
    private String wardNumber;
    private String bedNumber;
    
    //constructor that uses super() to send general info to the base class
    public Inpatient(String patientId, String firstName, String lastName, int age, String gender, String medCondition, String wardNumber){
        //hardcodes the category to INPATIENT usining the parent constructor
        super(patientId, firstName, lastName, age, gender, medCondition, PatientCategory.INPATIENT);
        this.wardNumber = wardNumber;
        this.bedNumber = "None"; //begins with no bed 
    }
    
    //Accesor methods for unique attributes
    public String getWardNumber() {
        return wardNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }
    
    //Override method to invoke the parent display method first
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(" Allocated: Ward "+wardNumber+ " | Bed "+bedNumber);
    }

    
    
            
    
    
}
