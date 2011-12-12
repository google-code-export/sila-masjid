/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @author Sumurmunding
 */
package entities;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Sumurmunding
 */
@Entity
public class DaftarProposal implements Serializable {

    public DaftarProposal() {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean checkId(Long id) {
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

    public boolean check(String email) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Proposal AS o WHERE o.email=:email");
            q.setParameter("email", email);
            int jumlahMasjid = ((Long) q.getSingleResult()).intValue();
            if (jumlahMasjid > 0) {
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
            boolean hasilCheck = this.checkId(id);
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

    public List<Proposal> getProposals() {//
        List<Proposal> proposals = new ArrayList<Proposal>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Proposal");
            proposals = q.getResultList();

        } finally {
            em.close();
        }
        return proposals;
    }

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
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
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
