package com.test;

import com.util.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest {
    @Test
    public void findAll(){      //查询全部
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="from Customer ";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o"+o);
        }
        tx.commit();
        entityManager.close();
    }

    @Test
    public void findById(){     //条件查找
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="from Customer where custId=?";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1,1L);
        Object result = query.getSingleResult();
        System.out.println("result = " + result);
        tx.commit();
        entityManager.close();
    }

    @Test
    public void count(){    //统计
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="select count(*) from Customer ";
        Query query = entityManager.createQuery(jpql);
        Object result = query.getSingleResult();
        System.out.println("result = " + result);
        tx.commit();
        entityManager.close();
    }

    @Test
    public void paixu(){        //排序
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }
        tx.commit();
        entityManager.close();
    }

    @Test
    public void page(){     //分页
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="from Customer ";
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult(2);
        query.setMaxResults(3);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println("o = " + o);
        }
        tx.commit();
        entityManager.close();
    }


    @Test
    public void findByObject(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        String jpql="select new Customer(custName,custLevel) from Customer ";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object o : resultList) {
                System.out.println("o = " + o);
        }
        tx.commit();
        entityManager.close();
    }
}
