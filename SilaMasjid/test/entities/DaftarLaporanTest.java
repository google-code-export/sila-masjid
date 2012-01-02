/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
public class DaftarLaporanTest {

    public DaftarLaporanTest() {
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
     * Test of getEntityManager method, of class DaftarLaporan.
     */
    /*@Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarLaporan instance = new DaftarLaporan();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of getJumlah method, of class DaftarLaporan.
     */
    @Test
    public void testGetJumlah() {
        System.out.println("getJumlah");
        Long idMasjid = null;
        String kdTrans = "";
        DaftarLaporan instance = new DaftarLaporan();
        Double expResult = 0.0;
       // Double expResult = null;
        Double result = instance.getJumlah(idMasjid, kdTrans);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getJumlah sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getTransaksis method, of class DaftarLaporan.
     */
    /*@Test
    public void testGetTransaksis() {
        System.out.println("getTransaksis");
        Long idMasjid = null;
        DaftarLaporan instance = new DaftarLaporan();
        List expResult = null;
        List result = instance.getTransaksis(idMasjid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getTrmKlr method, of class DaftarLaporan.
     */
    /*@Test
    public void testGetTrmKlr() {
        System.out.println("getTrmKlr");
        Long idMasjid = null;
        String kdTrans = "";
        DaftarLaporan instance = new DaftarLaporan();
        List expResult = null;
        List result = instance.getTrmKlr(idMasjid, kdTrans);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of editTransaksi method, of class DaftarLaporan.
     */
    /*@Test
    public void testEditTransaksi() {
        System.out.println("editTransaksi");
        Transaksi transaksi = null;
        DaftarLaporan instance = new DaftarLaporan();
        instance.editTransaksi(transaksi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of addTransaksi method, of class DaftarLaporan.
     */
    /*@Test
    public void testAddTransaksi() {
        System.out.println("addTransaksi");
        Transaksi transaksi = null;
        DaftarLaporan instance = new DaftarLaporan();
        instance.addTransaksi(transaksi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of deleteTransaksi method, of class DaftarLaporan.
     */
    /*@Test
    public void testDeleteTransaksi() throws Exception {
        System.out.println("deleteTransaksi");
        Long id = null;
        DaftarLaporan instance = new DaftarLaporan();
        instance.deleteTransaksi(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of getEmf method, of class DaftarLaporan.
     */
    /*@Test
    public void testGetEmf() {
        System.out.println("getEmf");
        DaftarLaporan instance = new DaftarLaporan();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setEmf method, of class DaftarLaporan.
     */
    /*@Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        DaftarLaporan instance = new DaftarLaporan();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
