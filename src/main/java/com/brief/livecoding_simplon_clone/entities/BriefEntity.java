package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brief", schema = "livecoding_simplon_clone", catalog = "")
public class BriefEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "promoId", referencedColumnName = "id", nullable = false)
    private PromosEntity promosByPromoId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BriefEntity brief = (BriefEntity) o;

        if (id != brief.id) return false;
        if (name != null ? !name.equals(brief.name) : brief.name != null) return false;
        if (description != null ? !description.equals(brief.description) : brief.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public PromosEntity getPromosByPromoId() {
        return promosByPromoId;
    }

    public void setPromosByPromoId(PromosEntity promosByPromoId) {
        this.promosByPromoId = promosByPromoId;
    }
}
