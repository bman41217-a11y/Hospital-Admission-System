/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospitaladmissionsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bshon
 */
public class HospitalManangerTest {
    private HospitalMananger manager;
    
    @BeforeEach
    public void setUp(){
        //initialize a clean manager instance before a test runs
        manager = new HospitalMananger();
    }

    @Test
    public void testGetPatientList() {
    }

    @Test
    public void testRegisterPatient() {
        Patient p = new Patient("P01", "Girly", "West", 22, "Female", "flu", PatientCategory.OUTPATIENT);
        assertTrue(manager.registerPatient(p));
        assertEquals(1, manager.getPatientList().size());
    }

    @Test
    public void testSearchPatient() {
        Patient p = new Patient("P01", "Girly", "West", 22, "Female", "flu", PatientCategory.OUTPATIENT);
        manager.registerPatient(p);
        assertNotNull(manager.searchPatient("P01"));
        assertNull(manager.searchPatient("432")); //to test a non-existing ID
    }

    @Test
    public void testDeletePatient() {
        Patient p = new Patient("P01", "Girly", "West", 22, "Female", "flu", PatientCategory.OUTPATIENT);
        manager.registerPatient(p);
        assertTrue(manager.deletePatient("P01"));
        assertNull(manager.searchPatient("P01"));
    }

    @Test
    public void testAllocateBed() {
        Inpatient ip =  new Inpatient("P02", "James", "Xulu", 45, "Male", "HIV", "Ward 1");
        assertTrue(manager.allocateBed(ip));
        assertEquals("B01", ip.getBedNumber());
    }

    @Test
    public void testReleaseBed() {
        Inpatient ip =  new Inpatient("P02", "James", "Xulu", 45, "Male", "HIV", "Ward 1");
        manager.allocateBed(ip);
        assertTrue(manager.releaseBed("B01"));
        assertEquals("None", ip.getBedNumber());
    }

    @Test
    public void testDisplayWardLayout() {
    }

    @Test
    public void testSortBySurname() {
    }

    @Test
    public void testGeneratReport() {
    }
    
}
