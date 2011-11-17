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
 * @author yooganz
 */
@Entity
public class DaftarRekening implements Serializable {
    
    public DaftarRekening()
    {
        emf = Persistence.createEntityManagerFactory("masjid");
    }
    private static final long serialVersionUID = 1L;
    
    @Id
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
    
    public boolean check(String noRek, String nmRek, String bank)
    {
        boolean result = false;
        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("SELECT count(o) FROM Rekening AS o WHERE o.noRek=:noRek AND o.nmRek=:nmRek AND o.bank=:bank");
            q.setParameter("noRek", noRek);
            q.setParameter("nmRek", nmRek);
            q.setParameter("bank", bank);
            int jumlahMasjid = ((Long) q.getSingleResult()).intValue();
            if (jumlahMasjid > 0)
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

    public Rekening getRekening(String noRek, String nmRek, String bank)
    {
        Rekening rekening = null;
        EntityManager em = getEntityManager();
        try
        {
            boolean hasilCheck = this.check(noRek, nmRek, bank);
            if (hasilCheck)
            {
                Query q = em.createQuery("SELECT count(o) FROM Rekening AS o WHERE o.noRek=:noRek AND o.nmRek=:nmRek AND o.bank=:bank");
                q.setParameter("noRek", noRek);
                q.setParameter("nmRek", nmRek);
                q.setParameter("bank", bank);
                rekening = (Rekening) q.getSingleResult();
            }
        }
        finally
        {
            em.close();
        }
        return rekening;
    }

    public List<Rekening> getRekening()
    {
        List<Rekening> rekenings = new ArrayList<Rekening>();

        EntityManager em = getEntityManager();
        try
        {
            Query q = em.createQuery("SELECT object(o) FROM Rekening AS o");
            rekenings = q.getResultList();
        }
        finally
        {
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
                throw new NonexistentEntityException("Nomor Rekening " + id + " sudah tidak valid.", enfe);
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

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /*@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DaftarRekening)) {
            return false;
        }
        DaftarRekening other = (DaftarRekening) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DaftarRekening[ id=" + id + " ]";
    }*/
    
}
