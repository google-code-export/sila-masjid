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
public class DaftarPenerimaDanaTest {

    public DaftarPenerimaDanaTest() {
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
     * Test of getEntityManager method, of class DaftarPenerimaDana.
     */
    /* @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarPenerimaDana instance = new DaftarPenerimaDana();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarPenerimaDana.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        boolean expResult = false;
        boolean result = instance.check(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes Check sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testGetPenerimaDana() {
        System.out.println("getPenerimaDana");
        Long id = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        PenerimaDana expResult = null;
        PenerimaDana result = instance.getPenerimaDana(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getPenerimaDana sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testFindPenerimaDana() {
        System.out.println("findPenerimaDana");
        Long id = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        PenerimaDana expResult = null;
        PenerimaDana result = instance.findPenerimaDana(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes findMasjid sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getPenerimaDanas method, of class DaftarPenerimaDana.
     */
    @Test
    public void testGetPenerimaDanas() {
        System.out.println("getPenerimaDanas");
        Long idMasjid = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        int expResult = 0;
        //List expResult = null;
        int result = instance.getPenerimaDanas(idMasjid).size();
        //List result = instance.getPenerimaDanas(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getPenerimaDanas sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testEditPenerimaDana() {
        System.out.println("editPenerimaDana");
        Long idMasjid = Long.parseLong("251");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        List<PenerimaDana> list = instance.getPenerimaDanas(idMasjid);
        PenerimaDana pendan = list.get(0);
        pendan.setAlmtPenDan("Jalan Gajahmada");
        pendan.setNmPenDan("Andre K.");
        pendan.setNotelpPenDan("08881245638");
        try {
            instance.editPenerimaDana(pendan);
            System.out.println("Tes edtPenerimaDana sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testAddPenerimaDana() {
        System.out.println("addPenerimaDana");
        PenerimaDana pendan = new PenerimaDana();
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        int hasil1 = instance.getPenerimaDanas(Long.parseLong("251")).size();//nomor id disesuaikan dengan record dalam tabel PenerimaDana
        pendan.setAlmtPenDan("Jalan Semilir No. 56");
        pendan.setIdMasjid(Long.parseLong("251"));
        pendan.setNmPenDan("Gorgon Zolla");
        pendan.setNotelpPenDan("12345678");
        instance.addPenerimaDana(pendan);
        int hasil2 = instance.getPenerimaDanas(Long.parseLong("251")).size();
        try {
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("Tes addMasjid Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deletePenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testDeletePenerimaDana() throws Exception {
        System.out.println("deletePenerimaDana");
        Long idMasjid = Long.parseLong("251");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        List<PenerimaDana> list = instance.getPenerimaDanas(idMasjid);//idMasjid diganti sesuai dengan idMasjid dalam tabel PenerimaDana
        PenerimaDana pendan = list.get(0);
        int hasil1 = list.size();
        Long id = pendan.getId();
        instance.deletePenerimaDana(id);
        int hasil2 = instance.getPenerimaDanas(idMasjid).size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deletePenerimaDana sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of getEmf method, of class DaftarPenerimaDana.
     */
    /*@Test
    public void testGetEmf() {
    System.out.println("getEmf");
    DaftarPenerimaDana instance = new DaftarPenerimaDana();
    EntityManagerFactory expResult = null;
    EntityManagerFactory result = instance.getEmf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setEmf method, of class DaftarPenerimaDana.
     */
    /*@Test
    public void testSetEmf() {
    System.out.println("setEmf");
    EntityManagerFactory emf = null;
    DaftarPenerimaDana instance = new DaftarPenerimaDana();
    instance.setEmf(emf);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
}
