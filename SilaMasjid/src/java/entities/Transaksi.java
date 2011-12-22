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
    private Long idTran;
    private String kdTrans;
    private Long idRek;
    private Long idMasjid;
    private String kasBank;
    private Double jmlTran;
    private String ket;
    private String flag;
    /*@ManyToOne
    @JoinColumn(name = "kdTrans")
    private KodeTransaksi nmTran;
    @ManyToOne
    @JoinColumn(name = "idRek")
    private Rekening nmRek;*/

    public Long getIdMasjid() {
        return idMasjid;
    }

    public void setIdMasjid(Long idMasjid) {
        this.idMasjid = idMasjid;
    }

    public Long getIdRek() {
        return idRek;
    }

    public void setIdRek(Long idRek) {
        this.idRek = idRek;
    }

    public Long getIdTran() {
        return idTran;
    }

    public void setIdTran(Long idTran) {
        this.idTran = idTran;
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

    public String getKasBank() {
        return kasBank;
    }

    public void setKasBank(String kasBank) {
        this.kasBank = kasBank;
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
