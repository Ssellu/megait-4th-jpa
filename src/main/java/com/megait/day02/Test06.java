package com.megait.day02;

import com.megait.day01.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Test06 {
    public static void main(String[] args) {
        // EntityManager : JPA 관리자. 얘가 주인공
        // persistence.xml 의 myunit 설정대로 Factory 생성
        // 참고) Factory 패턴
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            factory = Persistence.createEntityManagerFactory("myunit");
            em = factory.createEntityManager();
            tx = em.getTransaction();

            System.out.println("----------- 본문 실행 -----------");
            tx.begin();

            List<Pokemon> list =
                    em.createQuery("SELECT p FROM Pokemon AS p", Pokemon.class)
                      .getResultList();

            System.out.println("list : " + list);

            tx.commit();
            System.out.println("----------- 본문 끝 -------------");


        } catch (Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if(em != null)
                em.close();
            if(factory != null)
                factory.close();
        }
    }
}
