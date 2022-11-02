package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "promos", schema = "livecoding_simplon_clone", catalog = "")
public class PromosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "promostoapprenant",
            joinColumns = @JoinColumn(name = "promoId"),
            inverseJoinColumns = @JoinColumn(name = "apprenantId")
    )
    private Collection<ApprenantEntity> apprenantsPerPromo;
    @OneToMany(mappedBy = "promosByPromoId")
    private Collection<BriefEntity> briefsById;
    @ManyToOne
    @JoinColumn(name = "formateurId", referencedColumnName = "id", insertable = false, updatable = false)
    private FormateurEntity formateurByFormateurId;
    @Basic
    @Column(name = "formateurId")
    private Integer formateurId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromosEntity promos = (PromosEntity) o;

        if (id != promos.id) return false;
        if (name != null ? !name.equals(promos.name) : promos.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<ApprenantEntity> getApprenantsById() {
        return apprenantsPerPromo;
    }

    public Collection<BriefEntity> getBriefsById() {
        return briefsById;
    }

    public void setBriefsById(Collection<BriefEntity> briefsById) {
        this.briefsById = briefsById;
    }

    public FormateurEntity getFormateurByFormateurId() {
        return formateurByFormateurId;
    }

    public void setFormateurByFormateurId(FormateurEntity formateurByFormateurId) {
        this.formateurByFormateurId = formateurByFormateurId;
    }

    public Integer getFormateurId() {
        return formateurId;
    }

    public void setFormateurId(Integer formateurId) {
        this.formateurId = formateurId;
    }

    public void setApprenantsPerPromo(Collection<ApprenantEntity> apprenantsPerPromo) {
        this.apprenantsPerPromo = apprenantsPerPromo;
    }
}
