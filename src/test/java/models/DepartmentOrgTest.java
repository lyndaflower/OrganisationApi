//package models;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class DepartmentOrgTest {
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getNameReturnsCorrectName() throws Exception {
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        assertEquals("managemant", testDepartmentOrg.getName());
//    }
//
//    @Test
//    public void setNameSetsCorrectName() throws Exception {
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        testDepartmentOrg.setName("managemant");
//        assertNotEquals("accounting", testDepartmentOrg.getName());
//    }
//
//    @Test
//    public void getDescriptionReturnsCorrectDescription() throws Exception{
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        assertEquals(" managemant business", testDepartmentOrg.getDescription());
//    }
//
//    @Test
//    public void setDescriptionSetsCorrectDescription() throws Exception {
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        testDepartmentOrg.setDescription("managemant");
//        assertNotEquals(" accounting business", testDepartmentOrg.getDescription());
//    }
//
//    @Test
//    public void getNumberOfEmployeesReturnsCorrectNumEmployee() {
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        assertEquals(12, testDepartmentOrg.getNumemployees());
//    }
//
//    @Test
//    public void setNumberOfEmployeesSetsCorrectNumber() {
//        DepartmentOrg testDepartmentOrg= setupDepartmentOrg();
//        testDepartmentOrg.setNumemployees(12);
//        assertNotEquals(13, testDepartmentOrg.getNumemployees());
//    }
//
//    //helper
//    public DepartmentOrg setupDepartmentOrg() {
//        return new DepartmentOrg("managemant", "managemant business","3");
//    }
//}