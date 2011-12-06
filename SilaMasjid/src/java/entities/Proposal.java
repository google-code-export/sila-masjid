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
public class Proposal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private Integer besarDana=null;
    private String judul;
    private String detailProposal;
    private boolean setuju = false;
    private Long idMasjid;

    public Long getIdMasjid() {
        return idMasjid;
    }

    public void setIdMasjid(Long idMasjid) {
        this.idMasjid = idMasjid;
    }

    public boolean isSetuju() {
        return setuju;
    }

    public void setSetuju(boolean setuju) {
        this.setuju = setuju;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getBesarDana() {
        return besarDana;
    }

    public void setBesarDana(Integer besarDana) {
        this.besarDana = besarDana;
    }

    public String getDetailProposal() {
        return detailProposal;
    }

    public void setDetailProposal(String detailProposal) {
        this.detailProposal = detailProposal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
        if (!(object instanceof Proposal)) {
            return false;
        }
        Proposal other = (Proposal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proposal[ id=" + id + " ]";
    }
    
}
