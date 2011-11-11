/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Masjid;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author Sumurmunding
 */
public class MasjidJpaController implements Serializable {

    public MasjidJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Masjid masjid) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(masjid);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Masjid masjid) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            masjid = em.merge(masjid);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = masjid.getId();
                if (findMasjid(id) == null) {
                    throw new NonexistentEntityException("The masjid with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Masjid masjid;
            try {
                masjid = em.getReference(Masjid.class, id);
                masjid.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The masjid with id " + id + " no longer exists.", enfe);
            }
            em.remove(masjid);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Masjid> findMasjidEntities() {
        return findMasjidEntities(true, -1, -1);
    }

    public List<Masjid> findMasjidEntities(int maxResults, int firstResult) {
        return findMasjidEntities(false, maxResults, firstResult);
    }

    private List<Masjid> findMasjidEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Masjid.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Masjid findMasjid(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Masjid.class, id);
        } finally {
            em.close();
        }
    }

    public int getMasjidCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Masjid> rt = cq.from(Masjid.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
