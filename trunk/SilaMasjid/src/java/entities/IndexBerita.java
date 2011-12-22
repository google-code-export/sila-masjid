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
 * @author danke
 */
@Entity
public class IndexBerita implements Serializable {

    public IndexBerita() {
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
            Query q = em.createQuery("SELECT count(o) FROM Berita AS o WHERE o.id=:id");
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

    
    public Berita getBerita(Long id) {
        Berita berita = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.checkId(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM Berita AS o WHERE o.id=:id");
                q.setParameter("id", id);
                berita = (Berita) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return berita;
    }

    public List<Berita> getBeritas() {//
        List<Berita> beritas = new ArrayList<Berita>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Berita AS o");
            beritas = q.getResultList();

        } finally {
            em.close();
        }
        return beritas;
    }

    public void editBerita(Berita berita) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(berita);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addBerita(Berita berita) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(berita);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void deleteBerita(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Berita berita;
            try {
                berita = em.getReference(Berita.class, id);
                berita.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The berita with id " + id + " no longer exists.", enfe);
            }
            em.remove(berita);
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
