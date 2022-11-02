package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "promostoapprenant", schema = "livecoding_simplon_clone", catalog = "")
@IdClass(PromostoapprenantEntityPK.class)
public class PromostoapprenantEntity {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "promoId")
    private int promoId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    @Column(name = "apprenantId")
    private int apprenantId;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public int getApprenantId() {
        return apprenantId;
    }

    public void setApprenantId(int apprenantId) {
        this.apprenantId = apprenantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromostoapprenantEntity that = (PromostoapprenantEntity) o;

        if (promoId != that.promoId) return false;
        if (apprenantId != that.apprenantId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = promoId;
        result = 31 * result + apprenantId;
        return result;
    }
}
