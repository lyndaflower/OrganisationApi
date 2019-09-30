package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentOrgTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
        assertEquals("finance", testDepartmentOrg.getName());
    }

    @Test
    public void setNameSetsCorrectName() throws Exception {
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
        testDepartmentOrg.setName("finance");
        assertNotEquals("accounting", testDepartmentOrg.getName());
    }


    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception{
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
        assertEquals("handle finance business", testDepartmentOrg.getDescription());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
        testDepartmentOrg.setDescription("handle finance business");
        assertNotEquals("handle accounting business", testDepartmentOrg.getDescription());
    }

    @Test
    public void getNumberOfEmployeesReturnsCorrectNumEmployee() {
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();epartment();
        assertEquals(12, testDepartmentOrg.getNumEmployees());
    }

    @Test
    public void setNumberOfEmployeesSetsCorrectNumber() {
        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
        testDepartmentOrg.setNumEmployees(12);
        assertNotEquals(13, testDepartmentOrg.getNumEmployees());
    }
}