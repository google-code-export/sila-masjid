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
public class DaftarLaporan implements Serializable {

    public DaftarLaporan() {
        emf = Persistence.createEntityManagerFactory("SilaMasjidPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //mencari jumlah group by n digit kode
    public Double getJumlah(Long idMasjid, String kdTrans) {
        //   Transaksi transaksi = null;
        Double transaksi = null;
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT sum(o.jmlTran) as jmlTran FROM "
                    + "Transaksi AS o WHERE o.idMasjid=:idMasjid and o.kdTrans "
                    + "LIKE :kdTrans");
            q.setParameter("idMasjid", idMasjid);
            q.setParameter("kdTrans", kdTrans + "%");

            transaksi = (Double) q.getSingleResult();

        } finally {
            em.close();
        }
        if (transaksi == null) {
            transaksi = Double.valueOf(0);
        }
        return transaksi;

    }
//Untuk laporan penrimaan/pengeluaran berdasarkan tiap kode transaksi
    public List<Transaksi> getTransByKd(Long idMasjid,String kdTrans) {
        List<Transaksi> transaksis = new ArrayList<Transaksi>();

        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT Object(o) "
                    + "FROM Transaksi AS o WHERE o.idMasjid=:idMasjid and "
                    + "o.kdTrans LIKE :kdTrans "
                    + "ORDER by o.tglTran");
            q.setParameter("idMasjid", idMasjid);
            q.setParameter("kdTrans", kdTrans+"%");
            transaksis = q.getResultList();

        } finally {
            em.close();
        }
        return transaksis;
    }

     public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}