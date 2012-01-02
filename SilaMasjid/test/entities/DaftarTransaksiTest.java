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
public class DaftarTransaksiTest {

    public DaftarTransaksiTest() {
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
     * Test of getEntityManager method, of class DaftarTransaksi.
     */
    /* @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarTransaksi instance = new DaftarTransaksi();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarTransaksi.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarTransaksi instance = new DaftarTransaksi();
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
     * Test of getTransaksi method, of class DaftarTransaksi.
     */
    @Test
    public void testGetTransaksi() {
        System.out.println("getTransaksi");
        Long id = null;
        DaftarTransaksi instance = new DaftarTransaksi();
        Transaksi expResult = null;
        Transaksi result = instance.getTransaksi(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTransaksis method, of class DaftarTransaksi.
     */
    @Test
    public void testGetTransaksis() {
        System.out.println("getTransaksis");
        Long idMasjid = null;
        DaftarTransaksi instance = new DaftarTransaksi();
        int expResult = 0;
        // List expResult = null;
        int result = instance.getTransaksis(idMasjid).size();
        //List result = instance.getTransaksis(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getTransaksis sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTrmKlr method, of class DaftarTransaksi.
     */
    @Test
    public void testGetTrmKlr() {
        System.out.println("getTrmKlr");
        Long idMasjid = null;
        String kdTrans = "";
        DaftarTransaksi instance = new DaftarTransaksi();
        int expResult = 0;
        //List expResult = null;
        int result = instance.getTransaksis(idMasjid).size();
        //List result = instance.getTrmKlr(idMasjid, kdTrans);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getTrmKlr sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editTransaksi method, of class DaftarTransaksi.
     */
    @Test
    public void testEditTransaksi() {
        System.out.println("editTransaksi");
        Long idMasjid = Long.parseLong("251");
        DaftarTransaksi instance = new DaftarTransaksi();
        List<Transaksi> list = instance.getTransaksis(idMasjid);
        Transaksi transaksi = list.get(0);
        transaksi.setIdMasjid(idMasjid);
        transaksi.setDon(null);
        transaksi.setJmlTran(100000.00);
        transaksi.setKdTrans("1121");
        transaksi.setRek(null);
        transaksi.setTglTran(null);
        try {
            instance.editTransaksi(transaksi);
            System.out.println("Tes editTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addTransaksi method, of class DaftarTransaksi.
     */
    @Test
    public void testAddTransaksi() {
        System.out.println("addTransaksi");
        Transaksi transaksi = new Transaksi();
        DaftarTransaksi instance = new DaftarTransaksi();
        int hasil1 = instance.getTransaksis(Long.parseLong("251")).size();
        transaksi.setIdMasjid(Long.parseLong("251"));
        transaksi.setDon(null);
        transaksi.setJmlTran(200000.00);
        transaksi.setKdTrans("1221");
        transaksi.setRek(null);
        transaksi.setTglTran(null);
        instance.addTransaksi(transaksi);
        int hasil2 = instance.getTransaksis(Long.parseLong("251")).size();
        try {
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("Tes addTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteTransaksi method, of class DaftarTransaksi.
     */
    @Test
    public void testDeleteTransaksi() throws Exception {
        System.out.println("deleteTransaksi");
        Long idMasjid = Long.parseLong("251");
        DaftarTransaksi instance = new DaftarTransaksi();
        List<Transaksi> list = instance.getTransaksis(idMasjid);
        Transaksi transaksi = list.get(0);
        Long id = transaksi.getId();
        int hasil1 = instance.getTransaksis(idMasjid).size();
        instance.deleteTransaksi(id);
        int hasil2 = instance.getTransaksis(idMasjid).size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteTransaksi sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEmf method, of class DaftarTransaksi.
     */
    /*@Test
    public void testGetEmf() {
        System.out.println("getEmf");
        DaftarTransaksi instance = new DaftarTransaksi();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setEmf method, of class DaftarTransaksi.
     */
    /*@Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarTransaksi instance = new DaftarTransaksi();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
