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
public class DaftarKodeTransaksiTest {

    public DaftarKodeTransaksiTest() {
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
     * Test of getEntityManager method, of class DaftarKodeTransaksi.
     */
    /* @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
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
     * Test of getKodeTransaksi method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testGetKodeTransaksi() {
        System.out.println("getKodeTransaksi");
        Long id = null;
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        KodeTransaksi expResult = null;
        KodeTransaksi result = instance.getKodeTransaksi(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getKodeTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getKodeTransaksis method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testGetKodeTransaksis() {
        System.out.println("getKodeTransaksis");
        Long idMasjid = null;
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        int expResult = 0;
        // List expResult = null;
        int result = instance.getKodeTransaksis(idMasjid).size();
        //List result = instance.getKodeTransaksis(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getKodeTransaksis sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getKodeTerimas method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testGetKodeTerimas() {
        System.out.println("getKodeTerimas");
        Long idMasjid = null;
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        int expResult = 0;
        // List expResult = null;
        int result = instance.getKodeTerimas(idMasjid).size();
        // List result = instance.getKodeTerimas(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getKodeTerimas sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getKodeKeluars method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testGetKodeKeluars() {
        System.out.println("getKodeKeluars");
        Long idMasjid = null;
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        int expResult = 0;
        // List expResult = null;
        int result = instance.getKodeKeluars(idMasjid).size();
        // List result = instance.getKodeKeluars(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getKodeKeluars");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editKodeTransaksi method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testEditKodeTransaksi() {
        System.out.println("editKodeTransaksi");
        Long idMasjid = Long.parseLong("251");//diganti sesuai dengan idMasjid yang ada dalam database
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        List<KodeTransaksi> list = instance.getKodeTransaksis(idMasjid);
        KodeTransaksi kode = list.get(0);
        kode.setIdMasjid(idMasjid);
        kode.setKdTrans("1121");
        kode.setNmTrans("Penerimaan Sedekah");
        try {
            instance.editKodeTransaksi(kode);
            System.out.println("Tes editKodeTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addKodeTransaksi method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testAddKodeTransaksi() {
        System.out.println("addKodeTransaksi");
        Long idMasjid = Long.parseLong("251");
        KodeTransaksi kode = new KodeTransaksi();
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        int hasil1 = instance.getKodeTransaksis(idMasjid).size();
        kode.setIdMasjid(idMasjid);
        kode.setKdTrans("1234");
        kode.setNmTrans("Penerimaan Lain-Lain");
        instance.addKodeTransaksi(kode);
        int hasil2 = instance.getKodeTransaksis(idMasjid).size();
        try {
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("Tes addKodeTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteKodeTransaksi method, of class DaftarKodeTransaksi.
     */
    @Test
    public void testDeleteKodeTransaksi() throws Exception {
        System.out.println("deleteKodeTransaksi");
        Long idMasjid = Long.parseLong("251");
        DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
        int hasil1 = instance.getKodeTransaksis(idMasjid).size();
        KodeTransaksi kode = instance.getKodeTransaksis(idMasjid).get(0);
        Long id = kode.getId();
        instance.deleteKodeTransaksi(id);
        int hasil2 = instance.getKodeTransaksis(idMasjid).size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteTransaksi");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of getEmf method, of class DaftarKodeTransaksi.
     */
    /* @Test
    public void testGetEmf() {
    System.out.println("getEmf");
    DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
    EntityManagerFactory expResult = null;
    EntityManagerFactory result = instance.getEmf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setEmf method, of class DaftarKodeTransaksi.
     */
    /*@Test
    public void testSetEmf() {
    System.out.println("setEmf");
    EntityManagerFactory emf = null;
    DaftarKodeTransaksi instance = new DaftarKodeTransaksi();
    instance.setEmf(emf);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
}
