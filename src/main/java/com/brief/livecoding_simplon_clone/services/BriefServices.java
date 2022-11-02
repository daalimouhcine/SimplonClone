package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.BriefEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BriefServices {
    public boolean add(BriefEntity brief){
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(brief);
            em.getTransaction().commit();
            return false;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;

    }
    public BriefEntity findbyId(int id){
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            BriefEntity brief = em.find(BriefEntity.class, id);
            em.getTransaction().commit();
            return brief;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public boolean update(BriefEntity brief)
    {
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(brief);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean deleteByID(int id)
    {
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            BriefEntity brief = em.find(BriefEntity.class, id);
            em.remove(brief);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<BriefEntity> getAll()
    {
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            TypedQuery<BriefEntity> query = em.createQuery("SELECT b FROM BriefEntity b", BriefEntity.class);
            List<BriefEntity> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
