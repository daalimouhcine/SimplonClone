package com.brief.livecoding_simplon_clone.services;

import com.brief.livecoding_simplon_clone.config.EntityManagerConfig;
import com.brief.livecoding_simplon_clone.entities.FormateurEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FormateurServices {
    public boolean add(FormateurEntity formateur){
        try {
            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.persist(formateur);
            em.getTransaction().commit();
            return false;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;

    }
    public FormateurEntity findbyId(int id){
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            return em.find(FormateurEntity.class, id);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public boolean update(FormateurEntity formateur)
    {
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();
            em.getTransaction().begin();
            em.merge(formateur);
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
            FormateurEntity formateur = em.find(FormateurEntity.class, id);
            em.remove(formateur);
            em.getTransaction().commit();
            return true;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<FormateurEntity> getAll()
    {
        try{

            EntityManager em= EntityManagerConfig.getInstance().getEntityManager();

            em.getTransaction().begin();
            TypedQuery<FormateurEntity> query = em.createQuery("SELECT f FROM FormateurEntity f", FormateurEntity.class);
            List<FormateurEntity> list = query.getResultList();
            em.getTransaction().commit();
            return list;
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
