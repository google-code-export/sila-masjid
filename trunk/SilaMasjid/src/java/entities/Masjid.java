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
 * @author Sumurmunding
 */
@Entity
public class Masjid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String nmMasjid="";
    private String almtMasjid="";
    private String kotaMasjid="";
    private String telpMasjid="";

    public String getAlmtMasjid() {
        return almtMasjid;
    }

    public void setAlmtMasjid(String almtMasjid) {
        this.almtMasjid = almtMasjid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKotaMasjid() {
        return kotaMasjid;
    }

    public void setKotaMasjid(String kotaMasjid) {
        this.kotaMasjid = kotaMasjid;
    }

    public String getNmMasjid() {
        return nmMasjid;
    }

    public void setNmMasjid(String nmMasjid) {
        this.nmMasjid = nmMasjid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelpMasjid() {
        return telpMasjid;
    }

    public void setTelpMasjid(String telpMasjid) {
        this.telpMasjid = telpMasjid;
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
        if (!(object instanceof Masjid)) {
            return false;
        }
        Masjid other = (Masjid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Masjid[ id=" + id + " ]";
    }
    
}
