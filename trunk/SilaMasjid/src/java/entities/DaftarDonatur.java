/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
 * @author danke
 */
@Entity
public class DaftarDonatur implements Serializable {

    public DaftarDonatur() {
        emf = Persistence.createEntityManagerFactory("donatur");
    }
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String nama , String alamat, String telepon) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Donatur AS o WHERE o.nama=:nama AND o.alamat=:alamat AND o.telepon=:telepon");
            q.setParameter("nama", nama);
            q.setParameter("alamat", alamat);
            q.setParameter("telepon", telepon);
            int jumlahDonatur = ((Long) q.getSingleResult()).intValue();
            if (jumlahDonatur > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Donatur getDonatur(String nama, String alamat, String telepon) {
        Donatur donatur = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(nama, alamat, telepon);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Donatur AS o WHERE o.nama=:nama AND o.alamat=:alamat AND o.telepon=:telepon");
                q.setParameter("nama", nama);
                q.setParameter("alamat", alamat);
                q.setParameter("telepon", telepon);
                donatur = (Donatur) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return donatur;
    }

    public List<Donatur> getDonatur() {
        List<Donatur> donaturs = new ArrayList<Donatur>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Donatur AS o");
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
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
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
