package com.megait.day02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Test07 {
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

            Member m1 = new Member();
            m1.setName("A");
            Member m2 = new Member();
            m2.setName("B");
            Member m3 = new Member();
            m3.setName("C");
            System.out.println(m1.getNo());

            System.out.println("00000000000000000000000000");
            em.persist(m1);
            em.persist(m2);
            em.persist(m3);

            System.out.println("1111111111111111111111111");

            List<Member> list =
                    em.createQuery("select m from Member as m")
                    .getResultList();

            System.out.println("22222222222222222222222222");

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
