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
public class DaftarProposalTest {

    public DaftarProposalTest() {
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
     * Test of getEntityManager method, of class DaftarProposal.
     */
    /*    @Test
    public void testGetEntityManager() {
    System.out.println("getEntityManager");
    DaftarProposal instance = new DaftarProposal();
    EntityManager expResult = null;
    EntityManager result = instance.getEntityManager();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of check method, of class DaftarProposal.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        Long id = null;
        DaftarProposal instance = new DaftarProposal();
        boolean expResult = false;
        boolean result = instance.check(id);
        try {
            assertEquals(expResult, result);
            System.out.println("tes Check sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getProposal method, of class DaftarProposal.
     */
    @Test
    public void testGetProposal() {
        System.out.println("getProposal");
        Long id = null;
        DaftarProposal instance = new DaftarProposal();
        Proposal expResult = null;
        Proposal result = instance.getProposal(id);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getProposal sukses");
        } catch (Exception e) {// TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getProposalBelums method, of class DaftarProposal.
     */
    @Test
    public void testGetProposalBelums() {
        System.out.println("getProposalBelums");
        DaftarProposal instance = new DaftarProposal();
        int expResult = 0;
        //List expResult = null;
        int result = instance.getProposalBelums().size();
        //List result = instance.getProposalBelums();
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getProposalBelums sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getProposalSudahs method, of class DaftarProposal.
     */
    @Test
    public void testGetProposalSudahs() {
        System.out.println("getProposalSudahs");
        Long idMasjid = null;
        DaftarProposal instance = new DaftarProposal();
        int expResult = 0;
        //List expResult = null;
        int result = instance.getProposalSudahs(idMasjid).size();
        //List result = instance.getProposalSudahs(idMasjid);
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getProposalSudahs sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getProposals method, of class DaftarProposal.
     */
    @Test
    public void testGetProposals() {
        System.out.println("getProposals");
        DaftarProposal instance = new DaftarProposal();
        int expResult = 2; //diganti sesuai dengan record proposal pada tabel Proposal
        //List expResult = null;
        int result = instance.getProposals().size();
        //List result = instance.getProposals();
        try {
            assertEquals(expResult, result);
            System.out.println("Tes getProposals sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of editProposal method, of class DaftarProposal.
     */
    @Test
    public void testEditProposal() {
        System.out.println("editProposal");
        Proposal proposal = null;
        DaftarProposal instance = new DaftarProposal();
        List<Proposal> list = instance.getProposalSudahs(Long.parseLong("251"));//diganti sesuai idMasjid yang ada di database
        proposal = list.get(0);
        proposal.setNama("Bejo");
        proposal.setNoTelp("031123456");
        try {
            instance.editProposal(proposal);
            System.out.println("Tes editProposal sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addProposal method, of class DaftarProposal.
     */
    @Test
    public void testAddProposal() {
        System.out.println("addProposal");
        Proposal proposal = new Proposal();
        DaftarProposal instance = new DaftarProposal();
        int hasil1 = instance.getProposals().size(); //jumlah objek sebelum ditambah
        proposal.setIdMasjid(Long.parseLong("251"));
        proposal.setNama("Bejo 2");
        proposal.setAlamat("Sumurmunding");
        proposal.setEmail("a@ymail.com");
        proposal.setBesarDana(1000000);
        proposal.setSetuju(false);
        instance.addProposal(proposal);
        int hasil2 = instance.getProposals().size();
        try {
            // instance.addProposal(proposal);
            assertEquals(hasil1 + 1, hasil2);
            System.out.println("tes addProposal Sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of deleteProposal method, of class DaftarProposal.
     */
    @Test
    public void testDeleteProposal() throws Exception {
        System.out.println("deleteProposal");
        Long id = Long.parseLong("4520"); //diganti sesuai id proposal pada database
        DaftarProposal instance = new DaftarProposal();
        List<Proposal> list = instance.getProposals();
        Proposal proposal = list.get(0);
        int hasil1 = list.size();
        instance.deleteProposal(id);
        int hasil2 = instance.getProposals().size();
        try {
            assertEquals(hasil1 - 1, hasil2);
            System.out.println("Tes deleteMasjid sukses");
        } catch (Exception e) {
            // TODO review the generated test code and remove the default call to fail.
            fail("The test case is a prototype.");
        }
    }
    /**
     * Test of getEmf method, of class DaftarProposal.
     */
    /* @Test
    public void testGetEmf() {
    System.out.println("getEmf");
    DaftarProposal instance = new DaftarProposal();
    EntityManagerFactory expResult = null;
    EntityManagerFactory result = instance.getEmf();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of setEmf method, of class DaftarProposal.
     */
    /*@Test
    public void testSetEmf() {
    System.out.println("setEmf");
    EntityManagerFactory emf = null;
    DaftarProposal instance = new DaftarProposal();
    instance.setEmf(emf);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
}
