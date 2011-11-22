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
 * @author Sumurmunding
 */
@Entity
public class DaftarMasjid implements Serializable {

    public DaftarMasjid() {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean check(String email, String password) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Masjid AS o WHERE o.email=:email AND o.password=:password");
            q.setParameter("email", email);
            q.setParameter("password", password);
            int jumlahMasjid = ((Long) q.getSingleResult()).intValue();
            if (jumlahMasjid > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public boolean check2(Long id) {
        boolean result = false;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT count(o) FROM Masjid AS o WHERE o.id=:id");
            q.setParameter("id", id);
            int jumlahMasjid = ((Long) q.getSingleResult()).intValue();
            if (jumlahMasjid > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public Masjid getMasjid(String email, String password) {
        Masjid masjid = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(email, password);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Masjid AS o WHERE o.email=:email AND o.password=:password");
                q.setParameter("email", email);
                q.setParameter("password", password);
                masjid = (Masjid) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return masjid;
    }

    public Masjid getMasjid2(Long id) {
        Masjid masjid = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check2(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Masjid AS o WHERE o.id=:id");
                q.setParameter("id", id);
                masjid = (Masjid) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return masjid;
    }

    public List<Masjid> getMasjids(Long id) {//edit tanggal 21 nop 2011
        List<Masjid> masjids = new ArrayList<Masjid>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Masjid AS o where o.id=:id");
            masjids = q.getResultList();

        } finally {
            em.close();
        }
        return masjids;
    }

    public void editMasjid(Masjid masjid) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(masjid);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addMasjid(Masjid masjid) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(masjid);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteMasjid(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Masjid masjid;
            try {
                masjid = em.getReference(Masjid.class, id);
                masjid.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
            }
            em.remove(masjid);
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
