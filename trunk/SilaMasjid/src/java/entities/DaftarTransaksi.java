/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Transaksi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import jpa.exceptions.NonexistentEntityException;

/**
 *
 * @author alin
 */
public class DaftarTransaksi implements Serializable {

    public DaftarTransaksi() {
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
            Query q = em.createQuery("SELECT count(o) FROM Transaksi AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahTransaksi = ((Long) q.getSingleResult()).intValue();
            if (jumlahTransaksi > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Transaksi getTransaksi(Long id) {
        Transaksi transaksi = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Transaksi AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                transaksi = (Transaksi) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return transaksi;
    }

    public List<Transaksi> getTransaksis(Long idMasjid) {
        List<Transaksi> transaksis = new ArrayList<Transaksi>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Transaksi AS o WHERE o.idMasjid=:idMasjid ORDER BY o.kdTrans");
            q.setParameter("idMasjid", idMasjid);
            transaksis = q.getResultList();

        } finally {
            em.close();
        }
        return transaksis;
    }
    public List<Transaksi> getTerima(Long idMasjid) {
        List<Transaksi> transaksis = new ArrayList<Transaksi>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Transaksi AS o WHERE o.idMasjid=:idMasjid and kdTrans like '1%' ORDER BY o.kdTrans");
            q.setParameter("idMasjid", idMasjid);
            transaksis = q.getResultList();

        } finally {
            em.close();
        }
        return transaksis;
    }

    public void editTransaksi(Transaksi transaksi) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(transaksi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addTransaksi(Transaksi transaksi) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(transaksi);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteTransaksi(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transaksi transaksi;
            try {
                transaksi = em.getReference(Transaksi.class, id);
                transaksi.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transaksi with id " + id + " no longer exists.", enfe);
            }
            em.remove(transaksi);
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