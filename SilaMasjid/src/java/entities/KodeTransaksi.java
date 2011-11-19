/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alin
 */
@Entity
public class KodeTransaksi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int idMasjid;
    private int kdTrans;
    private String nmTrans;

    public int getKdTrans() {
        return kdTrans;
    }

    public int getIdMasjid() {
        return idMasjid;
    }

    public void setIdMasjid(int idMasjid) {
        this.idMasjid = idMasjid;
    }

    public void setKdTrans(int kdTrans) {
        this.kdTrans = kdTrans;
    }

    public String getNmTrans() {
        return nmTrans;
    }

    public void setNmTrans(String nmTrans) {
        this.nmTrans = nmTrans;
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
        if (!(object instanceof KodeTransaksi)) {
            return false;
        }
        KodeTransaksi other = (KodeTransaksi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.KodeTransaksi[ id=" + id + " ]";
    }
    
}
