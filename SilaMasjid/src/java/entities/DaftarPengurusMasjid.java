/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.PengurusMasjid;
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
 * @author Suichal
 */
public class DaftarPengurusMasjid implements Serializable {

    public DaftarPengurusMasjid() {
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
            Query q = em.createQuery("SELECT count(o) FROM PengurusMasjid AS o WHERE o.id=:id");
            q.setParameter("id", id);

            int jumlahPengurusMasjid = ((Long) q.getSingleResult()).intValue();
            if (jumlahPengurusMasjid > 0) {
                result = true;
            }
        } finally {
            em.close();
        }
        return result;
    }

    public PengurusMasjid getPengurusMasjid(Long id) {
        PengurusMasjid pengurus = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM PengurusMasjid AS o WHERE o.id=:id");
                q.setParameter("id", id);

                pengurus = (PengurusMasjid) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return pengurus;
    }

    public List<PengurusMasjid> getPengurusMasjids(Long idMasjid) {
        List<PengurusMasjid> pengurusMasjids = new ArrayList<PengurusMasjid>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM PengurusMasjid AS o WHERE o.idMasjid=:idMasjid");
            q.setParameter("idMasjid", idMasjid);
            pengurusMasjids = q.getResultList();

        } finally {
            em.close();
        }
        return pengurusMasjids;
    }

    public void editPengurusMasjid(PengurusMasjid pengurus) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(pengurus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addPengurusMasjid(PengurusMasjid pengurus) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(pengurus);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deletePengurusMasjid(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PengurusMasjid pengurus;
            try {
                pengurus = em.getReference(PengurusMasjid.class, id);
                pengurus.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The PengurusMasjid with id " + id + " no longer exists.", enfe);
            }
            em.remove(pengurus);
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