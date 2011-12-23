/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Alin
 */
@Entity
public class Transaksi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglTran;
    private Long idMasjid;
    private Double jmlTran;
    private String ket;
    private String flag;
    @ManyToOne
    private KodeTransaksi tran;
    @ManyToOne
    private Rekening rek;
    @ManyToOne
    private Donatur don;
    @ManyToOne
    private PenerimaDana pen;

    public Donatur getDon() {
        return don;
    }

    public void setDon(Donatur don) {
        this.don = don;
    }

    public Long getIdMasjid() {
        return idMasjid;
    }

    public Rekening getRek() {
        return rek;
    }

    public void setRek(Rekening rek) {
        this.rek = rek;
    }

    public KodeTransaksi getTran() {
        return tran;
    }

    public PenerimaDana getPen() {
        return pen;
    }

    public void setPen(PenerimaDana pen) {
        this.pen = pen;
    }

    public void setTran(KodeTransaksi tran) {
        this.tran = tran;
    }

    public void setIdMasjid(Long idMasjid) {
        this.idMasjid = idMasjid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Double getJmlTran() {
        return jmlTran;
    }

    public void setJmlTran(Double jmlTran) {
        this.jmlTran = jmlTran;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Date getTglTran() {
        return tglTran;
    }

    public void setTglTran(Date tglTran) {
        this.tglTran = tglTran;
    }

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
        if (!(object instanceof Transaksi)) {
            return false;
        }
        Transaksi other = (Transaksi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transaksi[ id=" + id + " ]";
    }
}
