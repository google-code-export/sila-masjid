/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Proposal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author sumurmunding
 */
public class DaftarProposal implements Serializable {

    public DaftarProposal() {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    private static final long serialVersionUID = 1L;
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Proposal AS o WHERE o.id=:id");
            q.setParameter("id", id);

            int jumlahProposal = ((Long) q.getSingleResult()).intValue();
            if (jumlahProposal > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Proposal getProposal(Long id) {
        Proposal proposal = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Proposal AS o WHERE o.id=:id");
                q.setParameter("id", id);
                proposal = (Proposal) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return proposal;
    }

    public List<Proposal> getProposalBelums() {
        List<Proposal> proposals = new ArrayList<Proposal>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Proposal AS o where o.setuju=0");
            // q.setParameter("idMasjid", idMasjid);
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }
    public List<Proposal> getProposalSudahs() {
        List<Proposal> proposals = new ArrayList<Proposal>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Proposal AS o where o.setuju=1");
            // q.setParameter("idMasjid", idMasjid);
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }

    public List<Proposal> getProposals(Long idMasjid) {//
        List<Proposal> proposals = new ArrayList<Proposal>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Proposal AS o where o.idMasjid=:idMasjid and o.setuju=1");
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }

    /*  public List<Proposal> getProposals(Long idMasjid) {
    List<Proposal> proposals = new ArrayList<Proposal>();
    // idMasjid=null;
    EntityManager em = getEntityManager();
    try {
    Query q = em.createQuery("SELECT object(o) FROM Proposal AS o WHERE o.idMasjid=:idMasjid");
    q.setParameter("idMasjid", idMasjid);
    proposals = q.getResultList();
    
    } finally {
    em.close();
    }
    return proposals;
    }*/
    public void editProposal(Proposal proposal) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(proposal);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addProposal(Proposal proposal) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(proposal);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteProposal(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proposal proposal;
            try {
                proposal = em.getReference(Proposal.class, id);
                proposal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Proposal dengan ID ini : " + id + " tidak valid.", enfe);
            }
            em.remove(proposal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}
