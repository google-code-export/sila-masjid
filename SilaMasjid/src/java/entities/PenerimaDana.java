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
 * @author yooganz
 */
@Entity
public class PenerimaDana implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idMasjid;
    private String nmPenDan;
    private String almtPenDan;

    public String getAlmtPenDan() {
        return almtPenDan;
    }

    public void setAlmtPenDan(String almtPenDan) {
        this.almtPenDan = almtPenDan;
    }

    public Long getIdMasjid() {
        return idMasjid;
    }

    public void setIdMasjid(Long idMasjid) {
        this.idMasjid = idMasjid;
    }

    public String getNmPenDan() {
        return nmPenDan;
    }

    public void setNmPenDan(String nmPenDan) {
        this.nmPenDan = nmPenDan;
    }

    public String getNotelpPenDan() {
        return notelpPenDan;
    }

    public void setNotelpPenDan(String notelpPenDan) {
        this.notelpPenDan = notelpPenDan;
    }
    private String notelpPenDan;

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
        if (!(object instanceof PenerimaDana)) {
            return false;
        }
        PenerimaDana other = (PenerimaDana) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PenerimaDana[ id=" + id + " ]";
    }
    
}
