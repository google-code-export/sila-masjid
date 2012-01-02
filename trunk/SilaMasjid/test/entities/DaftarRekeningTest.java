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
 * @author yooganz
 */
public class DaftarRekeningTest {
    
    public DaftarRekeningTest() {
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
     * Test of getEntityManager method, of class DaftarRekening.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarRekening instance = new DaftarRekening();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of check method, of class DaftarRekening.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarRekening instance = new DaftarRekening();
        boolean expResult = false;
        boolean result = instance.check(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getRekening method, of class DaftarRekening.
     */
    @Test
    public void testGetRekening() {
        System.out.println("getRekening");
        Long id = null;
        DaftarRekening instance = new DaftarRekening();
        Rekening expResult = null;
        Rekening result = instance.getRekening(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findRekening method, of class DaftarRekening.
     */
    @Test
    public void testFindRekening() {
        System.out.println("findRekening");
        Long id = null;
        DaftarRekening instance = new DaftarRekening();
        Rekening expResult = null;
        Rekening result = instance.findRekening(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getRekenings method, of class DaftarRekening.
     */
    @Test
    public void testGetRekenings() {
        System.out.println("getRekenings");
        Long idMasjid = null;
        DaftarRekening instance = new DaftarRekening();
        List expResult = null;
        List result = instance.getRekenings(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of editRekening method, of class DaftarRekening.
     */
    @Test
    public void testEditRekening() {
        System.out.println("editRekening");
        Rekening rekening;
        DaftarRekening instance = new DaftarRekening();
        List<Rekening> list = instance.getRekenings(Long.parseLong("1"));
        rekening = list.get(1);
        rekening.setNoRek("9090");
        rekening.setNmRek("tedjo");
        rekening.setBank("Bang Toyib");
        try {
        instance.editRekening(rekening);
        // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addRekening method, of class DaftarRekening.
     */
    @Test
    public void testAddRekening() {
        System.out.println("addRekening");
        Rekening rekening = null;
        rekening.setNoRek("6787");
        rekening.setNmRek("Retha");
        rekening.setBank("BRI");
        DaftarRekening instance = new DaftarRekening();
        int hasil1 = instance.getRekenings(Long.parseLong("1")).size();
        instance.addRekening(rekening);
        int hasil2 = instance.getRekenings(Long.parseLong("1")).size();
        // TODO review the generated test code and remove the default call to fail.
        try {
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("Tes <List> Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteRekening method, of class DaftarRekening.
     */
    @Test
    public void testDeleteRekening() throws Exception {
        System.out.println("deleteRekening");
        Long id = Long.parseLong("1");
        DaftarRekening instance = new DaftarRekening();
        int hasil1 = instance.getRekenings(Long.parseLong("1")).size(); //sebelum delete
        instance.deleteRekening(id);
        int hasil2 = instance.getRekenings(Long.parseLong("1")).size(); //sesudah delete
        // TODO review the generated test code and remove the default call to fail.
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteMasjid Sukses");
        }  catch (Exception e){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEmf method, of class DaftarRekening.
     */
    @Test
    public void testGetEmf() {
        System.out.println("getEmf");
        DaftarRekening instance = new DaftarRekening();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEmf method, of class DaftarRekening.
     */

    @Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarRekening instance = new DaftarRekening();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
} 
