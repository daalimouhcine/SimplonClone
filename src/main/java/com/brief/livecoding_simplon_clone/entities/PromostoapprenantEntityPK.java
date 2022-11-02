package com.brief.livecoding_simplon_clone.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PromostoapprenantEntityPK implements Serializable {
    @Column(name = "promoId")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int promoId;
    @Column(name = "apprenantId")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

        PromostoapprenantEntityPK that = (PromostoapprenantEntityPK) o;

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
