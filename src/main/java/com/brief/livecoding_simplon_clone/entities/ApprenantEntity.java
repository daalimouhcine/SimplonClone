package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "apprenant", schema = "livecoding_simplon_clone", catalog = "")
public class ApprenantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @ManyToMany(mappedBy = "apprenantsPerPromo")
    private Collection<PromosEntity> promosByPromoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity apprenant = (ApprenantEntity) o;

        if (id != apprenant.id) return false;
        if (firstname != null ? !firstname.equals(apprenant.firstname) : apprenant.firstname != null) return false;
        if (lastname != null ? !lastname.equals(apprenant.lastname) : apprenant.lastname != null) return false;
        if (email != null ? !email.equals(apprenant.email) : apprenant.email != null) return false;
        if (password != null ? !password.equals(apprenant.password) : apprenant.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<PromosEntity> getPromosByPromoId() {
        return this.promosByPromoId;
    }

    public void setPromosByPromoId(Collection<PromosEntity> promosByPromoId) {
        this.promosByPromoId = promosByPromoId;
    }

    @Override
    public String toString() {
        return "Apprenant{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", promosByPromoId=" + promosByPromoId +
                '}';
    }
}
