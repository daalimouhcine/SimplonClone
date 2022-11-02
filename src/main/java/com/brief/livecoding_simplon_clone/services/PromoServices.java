package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.ApprenantEntity;
import com.brief.livecoding_simplon_clone.entities.PromosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PromoServices {
    public List<PromosEntity> getAll() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<PromosEntity> query = em.createQuery("SELECT a FROM PromosEntity a", PromosEntity.class);
            List<PromosEntity> promoList = query.getResultList();
            em.getTransaction().commit();
            return promoList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<PromosEntity> getAllNulls() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<PromosEntity> query = em.createQuery("SELECT a FROM PromosEntity a WHERE a.formateurId = null", PromosEntity.class);
            List<PromosEntity> promoList = query.getResultList();
            em.getTransaction().commit();
            return promoList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean add(PromosEntity promos){
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(promos);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public PromosEntity findById(int id) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            return em.find(PromosEntity.class, id);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public PromosEntity findByFormateurId(int id) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            TypedQuery<PromosEntity> query = em.createQuery("SELECT a FROM PromosEntity a WHERE a.formateurId = " + id, PromosEntity.class);
            PromosEntity promo = query.getSingleResult();
            return promo;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(PromosEntity promo) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(promo);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
