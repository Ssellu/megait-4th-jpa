package com.megait.day02;

import com.megait.day01.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test04 {
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

            // 1번 포켓몬의 이름을 "파이리"로 수정
            Pokemon p = em.find(Pokemon.class, 1L);
            p.setName("파이리");

            // commit 하기 전에 1번 포켓몬을 조회 (과연 이름이 파이리?)
            Pokemon p2 = em.find(Pokemon.class, 1L);
            System.out.println("p의 name : " + p.getName());
            System.out.println("p2의 name : " + p2.getName());

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
