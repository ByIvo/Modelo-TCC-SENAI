/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import rocks.byivo.todolist.entities.Task;

/**
 *
 * @author byivo
 */
public class HibernateUtil {

    private static final Class<?>[] mAnnotedClasses = {
        Task.class
    };
    private static final SessionFactory sessionFactory = buildSessionFactory();
    

    private static SessionFactory buildSessionFactory() {
        try {
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .configure().buildServiceRegistry();
            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            //metadataSources.addResource("persistence.xml");
            
            for(Class<?> clazz : mAnnotedClasses) {
                metadataSources.addAnnotatedClass(clazz);
            }
            
            Metadata metadata = metadataSources.buildMetadata();
            return metadata.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
