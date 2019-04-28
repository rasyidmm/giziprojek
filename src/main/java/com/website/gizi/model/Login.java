package com.website.gizi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author rasyid
 */
@Entity
public class Login extends Additional implements Serializable {
    @JsonIgnore
    @OneToOne(mappedBy = "login")
    private Aktor aktor;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usernameAktor;
    private String passwordAktor;
    @ManyToOne
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LoginController[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the usernameAktor
     */
    public String getUsernameAktor() {
        return usernameAktor;
    }

    /**
     * @param usernameAktor the usernameAktor to set
     */
    public void setUsernameAktor(String usernameAktor) {
        this.usernameAktor = usernameAktor;
    }

    /**
     * @return the passwordAktor
     */
    public String getPasswordAktor() {
        return passwordAktor;
    }

    /**
     * @param passwordAktor the passwordAktor to set
     */
    public void setPasswordAktor(String passwordAktor) {
        this.passwordAktor = passwordAktor;
    }

    /**
     * @return the aktor
     */
    public Aktor getAktor() {
        return aktor;
    }

    /**
     * @param aktor the aktor to set
     */
    public void setAktor(Aktor aktor) {
        this.aktor = aktor;
    }

    /**
     * @return the roleName
     */

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
