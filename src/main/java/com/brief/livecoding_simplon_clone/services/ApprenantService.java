package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.ApprenantEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ApprenantService {

    public boolean add(ApprenantEntity apprenant) {
        try{
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(apprenant);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ApprenantEntity findById(int id) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            return em.find(ApprenantEntity.class, id);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(ApprenantEntity apprenant) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(apprenant);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteById(int id) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            ApprenantEntity apprenantToDelete = em.find(ApprenantEntity.class, id);
            em.remove(apprenantToDelete);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<ApprenantEntity> getAll() {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<ApprenantEntity> query = em.createQuery("SELECT a FROM ApprenantEntity a", ApprenantEntity.class);
            List<ApprenantEntity> ApprenantList = query.getResultList();
            em.getTransaction().commit();
            return ApprenantList;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
