package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaTemplate {

    private static EntityManagerFactory emf;
    private static JpaTemplate instance;

    public static JpaTemplate getInstance(){
        if(instance == null){
            emf = Persistence.createEntityManagerFactory("bookmanager");
            instance = new JpaTemplate();
        }

        return instance;
    }

    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

}
