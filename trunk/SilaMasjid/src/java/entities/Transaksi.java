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
    private Date tglTrans;
    private String kdTrans;
    private Long idBank;
    private String kasBank;
    private Double jmlTrans;
    private String ket;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getIdBank() {
        return idBank;
    }

    public void setIdBank(Long idBank) {
        this.idBank = idBank;
    }

    public Double getJmlTrans() {
        return jmlTrans;
    }

    public void setJmlTrans(Double jmlTrans) {
        this.jmlTrans = jmlTrans;
    }

    public String getKasBank() {
        return kasBank;
    }

    public void setKasBank(String kasBank) {
        this.kasBank = kasBank;
    }

    public String getKdTrans() {
        return kdTrans;
    }

    public void setKdTrans(String kdTrans) {
        this.kdTrans = kdTrans;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Date getTglTrans() {
        return tglTrans;
    }

    public void setTglTrans(Date tglTrans) {
        this.tglTrans = tglTrans;
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
