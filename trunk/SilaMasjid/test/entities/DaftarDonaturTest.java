/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sumurmunding
 */
public class DaftarDonaturTest {

    public DaftarDonaturTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class DaftarDonatur.
     */
    /*@Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarDonatur instance = new DaftarDonatur();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarDonatur.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarDonatur instance = new DaftarDonatur();
        boolean expResult = false;
        boolean result = instance.check(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes check sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDonatur method, of class DaftarDonatur.
     */
    @Test
    public void testGetDonatur() {
        System.out.println("getDonatur");
        Long id = null;
        DaftarDonatur instance = new DaftarDonatur();
        Donatur expResult = null;
        Donatur result = instance.getDonatur(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getDonatur sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDonaturs method, of class DaftarDonatur.
     */
    @Test
    public void testGetDonaturs() {
        System.out.println("getDonaturs");
        Long idMasjid = null;
        DaftarDonatur instance = new DaftarDonatur();
        int expResult = 0;
        //List expResult = null;
        int result = instance.getDonaturs(idMasjid).size();
        //List result = instance.getDonaturs(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getDonaturs sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editDonatur method, of class DaftarDonatur.
     */
    @Test
    public void testEditDonatur() {
        System.out.println("editDonatur");
        Donatur donatur = null;
        DaftarDonatur instance = new DaftarDonatur();
        List<Donatur> list = instance.getDonaturs(Long.parseLong("251"));
        donatur = list.get(0);
        donatur.setNmDonatur("Dona Saputra");
        donatur.setAlmtDonatur("Jalan Kemerdekaan");
        try {
            instance.editDonatur(donatur);
            System.out.println("Tes editDonatur");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addDonatur method, of class DaftarDonatur.
     */
    @Test
    public void testAddDonatur() {
        System.out.println("addDonatur");
        Donatur donatur = new Donatur();
        DaftarDonatur instance = new DaftarDonatur();
        int hasil1 = instance.getDonaturs(Long.parseLong("251")).size();
        donatur.setIdMasjid(Long.parseLong("251"));
        donatur.setNmDonatur("Subejo Trimbil");
        donatur.setAlmtDonatur("Jalan Pejuang");
        donatur.setTelpDonatur("1234567");
        instance.addDonatur(donatur);
        int hasil2 = instance.getDonaturs(Long.parseLong("251")).size();
        try {
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("Tes addDonatur sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteDonatur method, of class DaftarDonatur.
     */
    @Test
    public void testDeleteDonatur() throws Exception {
        System.out.println("deleteDonatur");
        Long idMasjid = Long.parseLong("251");//diganti sesuai id masjid dalam database
        DaftarDonatur instance = new DaftarDonatur();
        List<Donatur> list = instance.getDonaturs(idMasjid);
        int hasil1 = instance.getDonaturs(idMasjid).size();
        Donatur donatur = list.get(0);
        Long id = donatur.getId();
        instance.deleteDonatur(id);
        int hasil2 = instance.getDonaturs(idMasjid).size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteDonatur sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of getEmf method, of class DaftarDonatur.
     */
    /* @Test
    public void testGetEmf() {
    System.out.println("getEmf");
    DaftarDonatur instance = new DaftarDonatur();
    EntityManagerFactory expResult = null;
    EntityManagerFactory result = instance.getEmf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setEmf method, of class DaftarDonatur.
     */
    /*@Test
    public void testSetEmf() {
    System.out.println("setEmf");
    EntityManagerFactory emf = null;
    DaftarDonatur instance = new DaftarDonatur();
    instance.setEmf(emf);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
}
