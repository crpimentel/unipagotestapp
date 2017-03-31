package com.unipago.pruebadesarrollador.repository;

/**
 * Created by cristian on 3/26/17.
 */

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Stateless
public class  Repository<T> implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;
    public Repository() {
    }

    EntityManager getEntityManager() {
        return entityManager;
    }

    private Class<T> entity;

    public Repository(Class<T> entity) {
        this.entity = entity;
    }

    public T find(Integer id) {

        T object = null;

        try {
            object = getEntityManager().find(entity, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public List<T> findAll() {
        try {
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<T> cq = cb.createQuery(entity);
            Root<T> rootEntry = cq.from(entity);
            CriteriaQuery<T> all = cq.select(rootEntry);
            TypedQuery<T> allQuery = getEntityManager().createQuery(all);
            return allQuery.getResultList();
//            return entityManager.createQuery("select a from " + entity.getSimpleName() + " a").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public T merge(T object)  {

        try {
            object = getEntityManager().merge(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return object;
    }

    public void save(T object) {

        try {
            getEntityManager().persist(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(T object)  {

        try {
            getEntityManager().refresh(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(T object) {

        try {
            object = getEntityManager().merge(object);
            getEntityManager().remove(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
