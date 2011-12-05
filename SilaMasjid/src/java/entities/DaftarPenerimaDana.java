/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.PenerimaDana;
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

public class DaftarPenerimaDana implements Serializable {

    private static class idMasjid {

        public idMasjid() {
        }
    }
    
    public DaftarPenerimaDana()
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
            Query q = em.createQuery("SELECT count(o) FROM PenerimaDana AS o WHERE o.id=:id");
            q.setParameter("id", id);
 
            int jumlahPenerimaDana = ((Long) q.getSingleResult()).intValue();
            if (jumlahPenerimaDana > 0)
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
    
    public PenerimaDana getPenerimaDana(Long id)
    {
        PenerimaDana penerimaDana = null;
        EntityManager em = getEntityManager();
        try
        {
            boolean hasilCheck = this.check(id);
            if (hasilCheck)
            {
                Query q = em.createQuery("SELECT object(o) FROM PenerimaDana AS o WHERE o.id=:id");
                q.setParameter("id", id);
 
                penerimaDana = (PenerimaDana) q.getSingleResult();
            }
        }
        finally
        {
            em.close();
        }
        return penerimaDana;
    }
    
    public PenerimaDana findPenerimaDana(Long id) {
        PenerimaDana penerimaDana = null;
        EntityManager em = getEntityManager();
        try {
            boolean hasilCheck = this.check(id);
            if (hasilCheck) {
                Query q = em.createQuery("SELECT object(o) FROM PenerimaDana AS o WHERE o.id=:id");
                q.setParameter("id", id);
                penerimaDana = (PenerimaDana) q.getSingleResult();
            }
        } finally {
            em.close();
        }
        return penerimaDana;
    }
    
    public List<PenerimaDana> getPenerimaDanas(Long idMasjid) {
        List<PenerimaDana> penerimaDanas = new ArrayList<PenerimaDana>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT object(o) FROM PenerimaDana AS o WHERE o.idMasjid=:idMasjid");
            q.setParameter("idMasjid", idMasjid);
            penerimaDanas = q.getResultList();

        } finally {
            em.close();
        }
        return penerimaDanas;
    }
    
    public void editPenerimaDana(PenerimaDana penerimaDana)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try
        {
            em.merge(penerimaDana);
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
    
    public void addPenerimaDana(PenerimaDana penerimaDana)
    {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try
        {
            em.persist(penerimaDana);
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

    public void deletePenerimaDana(Long id) throws NonexistentEntityException
    {
        EntityManager em = null;
        try
        {
            em = getEntityManager();
            em.getTransaction().begin();
            PenerimaDana penerimaDana;
            try
            {
                penerimaDana = em.getReference(PenerimaDana.class, id);
                penerimaDana.getId();
            }
            catch (EntityNotFoundException enfe)
            {
                throw new NonexistentEntityException("Penerima Dana dengan ID ini : " + id + " tidak valid.", enfe);
            }
            em.remove(penerimaDana);
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
