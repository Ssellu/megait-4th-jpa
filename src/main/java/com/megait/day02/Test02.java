package com.megait.day02;

import com.megait.day01.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            factory = Persistence.createEntityManagerFactory("myunit");
            em = factory.createEntityManager();
            tx = em.getTransaction();

            System.out.println("----------- 본문 실행 -----------");
            tx.begin(); // 트랜잭션 시작

            // Pokemon 객체 2개를 DB 에 저장해보자
            Pokemon p1 = new Pokemon();
            p1.setName("피카츄");
            p1.setLevel(10);

            Pokemon p2 = new Pokemon();
            p2.setName("라이츄");
            p2.setLevel(20);

            System.out.println("################");

            em.persist(p1);
            em.persist(p2);

            System.out.println("################");

            tx.commit(); // commit (최종 저장)
            System.out.println("----------- 본문 끝 -------------");


        } catch (Exception e){
            if (tx != null)
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
