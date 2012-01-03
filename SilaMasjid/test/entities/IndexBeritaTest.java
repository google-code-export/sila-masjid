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
 * @author umum
 */
public class IndexBeritaTest {

    public IndexBeritaTest() {
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
     * Test of getEntityManager method, of class IndexBerita.
     */
    @Test
    public void testCheckId() {
        System.out.println("check");
        Long id = null;
        IndexBerita instance = new IndexBerita();
        boolean expResult = false;
        boolean result = instance.checkId(id);
        try {
            assertEquals(expResult, result);
            System.out.println("tes Check sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of checkId method, of class IndexBerita.
     */



    /**
     * Test of getBerita method, of class IndexBerita.
     */
    @Test
    public void testGetBerita() {
        System.out.println("getBerita");
        Long id = null;
        IndexBerita instance = new IndexBerita();
        Berita expResult = null;
        Berita result = instance.getBerita(id);
         try {
            assertEquals(expResult, result);
            System.out.println("Tes getBerita sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getBeritas method, of class IndexBerita.
     */
    @Test
    public void testGetBeritas() {
        System.out.println("getBeritas");
        IndexBerita instance = new IndexBerita();
        List expResult = null;
        List result = instance.getBeritas();
         try {
            assertEquals(expResult, result);
            System.out.println("Tes getBeritas sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editBerita method, of class IndexBerita.
     */
    @Test
    public void testEditBerita() {
        System.out.println("editBerita");
        Berita berita = null;

        IndexBerita instance = new IndexBerita();
        List<Berita> list = instance.getBeritas();
        berita = list.get(0);
        berita.setJudul("eko");
        berita.setIsiBerita("nama saya eko");
        try {
            instance.editBerita(berita);
            System.out.println("Tes editBerita sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addBerita method, of class IndexBerita.
     */
    @Test
    public void testAddBerita() {
        System.out.println("addBerita");
        Berita berita = new Berita();
        IndexBerita instance = new IndexBerita();
        int hasil1 = instance.getBeritas().size(); //jumlah objek sebelum ditambah
        berita.setIdMasjid(Long.parseLong("251"));
        berita.setJudul("Saya");
        berita.setIsiBerita("Nama saya");

        instance.addBerita(berita);
        int hasil2 = instance.getBeritas().size();
        try {
            // instance.addProposal(proposal);
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("tes addBerita Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteBerita method, of class IndexBerita.
     */
    @Test
    public void testDeleteBerita() throws Exception {
        System.out.println("deleteBerita");
        Long id = Long.parseLong("4520"); //diganti sesuai id berita pada database
        IndexBerita instance = new IndexBerita();
        List<Berita> list = instance.getBeritas();
        Berita berita = list.get(0);
        int hasil1 = list.size();
        instance.deleteBerita(id);
        int hasil2 = instance.getBeritas().size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteBerita sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getEmf method, of class IndexBerita.

    @Test
    public void testGetEmf() {
        System.out.println("getEmf");
        IndexBerita instance = new IndexBerita();
        EntityManagerFactory expResult = null;
        EntityManagerFactory result = instance.getEmf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmf method, of class IndexBerita.

    @Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        IndexBerita instance = new IndexBerita();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
}