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
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPenerimaDanas method, of class DaftarPenerimaDana.
     */
    @Test
    public void testGetPenerimaDanas() {
        System.out.println("getPenerimaDanas");
        Long idMasjid = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        List expResult = null;
        List result = instance.getPenerimaDanas(idMasjid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testEditPenerimaDana() {
        System.out.println("editPenerimaDana");
        PenerimaDana penerimaDana = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        List<PenerimaDana> list = instance.getPenerimaDanas(Long.parseLong("1"));
        penerimaDana = list.get(1);
        penerimaDana.setNmPenDan("Bedjo");
        penerimaDana.setAlmtPenDan("Bandung");
        penerimaDana.setNotelpPenDan("68886868");
        
        try {
        instance.editPenerimaDana(penerimaDana);
        // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addPenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testAddPenerimaDana() {
        System.out.println("addPenerimaDana");
        PenerimaDana penerimaDana = null;
        penerimaDana.setNmPenDan("yooganz");
        penerimaDana.setAlmtPenDan("jakarta");
        penerimaDana.setNotelpPenDan("232424");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        int hasil1 = instance.getPenerimaDanas(Long.parseLong("1")).size();
        instance.addPenerimaDana(penerimaDana);
        int hasil2 = instance.getPenerimaDanas(Long.parseLong("1")).size();
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
     * Test of deletePenerimaDana method, of class DaftarPenerimaDana.
     */
    @Test
    public void testDeletePenerimaDana() throws Exception {
        System.out.println("deletePenerimaDana");
        Long id = Long.parseLong("1");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        int hasil1 = instance.getPenerimaDanas(Long.parseLong("1")).size();
        instance.deletePenerimaDana(id);
        int hasil2 = instance.getPenerimaDanas(Long.parseLong("1")).size();
        // TODO review the generated test code and remove the default call to fail.
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes delete Sukses");
        }  catch (Exception e){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEmf method, of class DaftarPenerimaDana.
     */
    @Test
    public void testGetEmf() {
        System.out.println("getEmf");
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmf method, of class DaftarPenerimaDana.
     */
    @Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarPenerimaDana instance = new DaftarPenerimaDana();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
