/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Rekening;
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
 * @author yooganz
 */

public class DaftarRekening implements Serializable {
    
    public DaftarRekening()
    {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
    public boolean check(Long id)
    {
        boolean result = false;
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("SELECT count(o) FROM Rekening AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahRekening = ((Long) q.getSingleResult()).intValue();
            if (jumlahRekening > 0)
            {
                result = true;
            }
        }
        finally
        {
            em.close();
        }
        return result;
    }
    
    public Rekening getRekening(Long id)
    {
        Rekening rekening = null;
        EntityManager em = getEntityManager();
        try
        {
            boolean hasilCheck = this.check(id);
            if (hasilCheck)
            {
                Query q = em.createQuery("SELECT object(o) FROM Rekening AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                rekening = (Rekening) q.getSingleResult();
            }
        }
        finally
        {
            em.close();
        }
        return rekening;
    }
    
    public List<Rekening> getRekenings(Long idMasjid) {
        List<Rekening> rekenings = new ArrayList<Rekening>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM Rekening AS o WHERE o.idMasjid=:idMasjid");
            q.setParameter("idMasjid", idMasjid);
            rekenings = q.getResultList();

        } finally {
            em.close();
        }
        return rekenings;
    }
    
    public void editRekening(Rekening rekening)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try
        {
            em.merge(rekening);
            em.getTransaction().commit();
        }
            catch (Exception e)
            {
            em.getTransaction().rollback();
            }
        finally
        {
            em.close();
        }
    }
    
    public void addRekening(Rekening rekening)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try
        {
            em.persist(rekening);
            em.getTransaction().commit();
        }
            catch (Exception e)
            {
            em.getTransaction().rollback();
            }
        finally
        {
            em.close();
        }
    }

    public void deleteRekening(Long id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            Rekening rekening;
            try
            {
                rekening = em.getReference(Rekening.class, id);
                rekening.getId();
            }
            catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("Nomor Rekening dengan ID ini : " + id + " tidak valid.", enfe);
            }
            em.remove(rekening);
            em.getTransaction().commit();
        }
        finally
        {
            if (em != null)
            {
                em.close();
            }
        }
    }
    
    public EntityManagerFactory getEmf()
    {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
}
