package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.BriefEntity;
import jakarta.persistence.EntityManager;

public class BriefService {
    public boolean add(BriefEntity brief) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(brief);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean update(BriefEntity brief) {
        try {
            EntityManager em = EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(brief);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
