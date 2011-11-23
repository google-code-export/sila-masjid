/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.KodeTransaksi;
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
 * @author alin
 */
public class DaftarKodeTransaksi implements Serializable {

    public DaftarKodeTransaksi() {
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
            Query q = em.createQuery("SELECT count(o) FROM KodeTransaksi AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahKodeTransaksi = ((Long) q.getSingleResult()).intValue();
            if (jumlahKodeTransaksi > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public KodeTransaksi getKodeTransaksi(Long id) {
        KodeTransaksi kodeTransaksi = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM KodeTransaksi AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                kodeTransaksi = (KodeTransaksi) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return kodeTransaksi;
    }

    public List<KodeTransaksi> getKodeTransaksis(Long idMasjid) {
        List<KodeTransaksi> kodeTransaksis = new ArrayList<KodeTransaksi>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM KodeTransaksi AS o WHERE o.idMasjid=:idMasjid ORDER BY o.kdTrans");
            q.setParameter("idMasjid", idMasjid);
            kodeTransaksis = q.getResultList();

        } finally {
            em.close();
        }
        return kodeTransaksis;
    }

    public void editKodeTransaksi(KodeTransaksi kodeTransaksi) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(kodeTransaksi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addKodeTransaksi(KodeTransaksi kodeTransaksi) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(kodeTransaksi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteKodeTransaksi(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            KodeTransaksi kodeTransaksi;
            try {
                kodeTransaksi = em.getReference(KodeTransaksi.class, id);
                kodeTransaksi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The KodeTransaksi with id " + id + " no longer exists.", enfe);
            }
            em.remove(kodeTransaksi);
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
