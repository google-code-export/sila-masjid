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
public class DaftarPengurusMasjidTest {

    public DaftarPengurusMasjidTest() {
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
     * Test of getEntityManager method, of class DaftarPengurusMasjid.
     */
    /*  @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
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
     * Test of getPengurusMasjid method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testGetPengurusMasjid() {
        System.out.println("getPengurusMasjid");
        Long id = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        PengurusMasjid expResult = null;
        PengurusMasjid result = instance.getPengurusMasjid(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes GetPengurusMasjid Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of findPengurusMasjid method, of class DaftarPengurusMasjid.
     */
   /* @Test
    public void testFindPengurusMasjid() {
        System.out.println("findPengurusMasjid");
        Long id = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        PengurusMasjid expResult = null;
        PengurusMasjid result = instance.findPengurusMasjid(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes findPengurusMasjid Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }*/

    /**
     * Test of getPengurusMasjids method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testGetPengurusMasjids() {
        System.out.println("getPengurusMasjids");
        Long idMasjid = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        // List expResult= null;
        int expResult = 0;
        // List result = instance.getPengurusMasjids(idMasjid);
        int result = instance.getPengurusMasjids(idMasjid).size();
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getPengurusMasjids Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editPengurusMasjid method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testEditPengurusMasjid() {
        System.out.println("editPengurusMasjid");
        PengurusMasjid pengurus = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        List<PengurusMasjid> list = instance.getPengurusMasjids(Long.parseLong("201"));
        pengurus = list.get(0);
        pengurus.setNama("Soeharto");
        pengurus.setJabatan("Ketua");
        try {
            instance.editPengurusMasjid(pengurus);
            System.out.println("Tes editPengurusMasjids Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addPengurusMasjid method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testAddPengurusMasjid() {
        System.out.println("addPengurusMasjid");
        PengurusMasjid pengurus = new PengurusMasjid();
        pengurus.setIdMasjid(Long.parseLong("201"));//diganti sesuai dengan idMasjid yang ada di database
        pengurus.setNama("Sodikin");
        pengurus.setJabatan("Ketua");
        pengurus.setNoTelp("08176549277");
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        // int hasil1 = instance.
        try {
            instance.addPengurusMasjid(pengurus);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of deletePengurusMasjid method, of class DaftarPengurusMasjid.
     */
    @Test
    public void testDeletePengurusMasjid() throws Exception {
        System.out.println("deletePengurusMasjid");
        Long idMasjid = Long.parseLong("201");
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        List<PengurusMasjid> list = instance.getPengurusMasjids(idMasjid);
        PengurusMasjid pengurus = list.get(0);
        Long id = pengurus.getId();
        try {
            instance.deletePengurusMasjid(id);
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEmf method, of class DaftarPengurusMasjid.
     */
    /* @Test
    public void testGetEmf() {
    System.out.println("getEmf");
    DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
    EntityManagerFactory expResult = null;
    EntityManagerFactory result = instance.getEmf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }
    
    /**
     * Test of setEmf method, of class DaftarPengurusMasjid.
     */
    /*@Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarPengurusMasjid instance = new DaftarPengurusMasjid();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
