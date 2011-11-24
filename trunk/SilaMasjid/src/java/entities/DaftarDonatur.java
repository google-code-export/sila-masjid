/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Donatur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author danke
 */
public class DaftarDonatur implements Serializable {

    public DaftarDonatur() {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Donatur AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahDonatur = ((Long) q.getSingleResult()).intValue();
            if (jumlahDonatur > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Donatur getDonatur(Long id) {
        Donatur donatur = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Donatur AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                donatur = (Donatur) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return donatur;
    }

    public List<Donatur> getDonaturs(Long idMasjid) {
        List<Donatur> donaturs = new ArrayList<Donatur>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Donatur AS o WHERE o.idMasjid=:idMasjid ORDER BY o.nmDonatur");
            q.setParameter("idMasjid", idMasjid);
            donaturs = q.getResultList();

        } finally {
            em.close();
        }
        return donaturs;
    }

    public void editDonatur(Donatur donatur) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(donatur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addDonatur(Donatur donatur) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(donatur);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteDonatur(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Donatur donatur;
            try {
                donatur = em.getReference(Donatur.class, id);
                donatur.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The Donatur with id " + id + " no longer exists.", enfe);
            }
            em.remove(donatur);
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
