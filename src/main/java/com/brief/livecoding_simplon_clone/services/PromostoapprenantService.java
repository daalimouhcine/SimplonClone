package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.PromosEntity;
import com.brief.livecoding_simplon_clone.entities.PromostoapprenantEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PromostoapprenantService {
    public boolean add(PromostoapprenantEntity promostoapprenant){
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(promostoapprenant);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<PromostoapprenantEntity> findByPromoId(int pId) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            TypedQuery<PromostoapprenantEntity> query = em.createQuery("SELECT p FROM PromostoapprenantEntity p WHERE p.promoId = " + pId, PromostoapprenantEntity.class);
            List<PromostoapprenantEntity> promostoapprenant = query.getResultList();
            return promostoapprenant;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public PromostoapprenantEntity findByApprenantId(int appId) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            TypedQuery<PromostoapprenantEntity> query = em.createQuery("SELECT p FROM PromostoapprenantEntity p WHERE p.apprenantId = " + appId, PromostoapprenantEntity.class);
            PromostoapprenantEntity promostoapprenant = query.getSingleResult();
            return promostoapprenant;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(PromostoapprenantEntity promostoapprenant) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(promostoapprenant);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean remove(PromostoapprenantEntity promostoapprenant) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.remove(promostoapprenant);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
