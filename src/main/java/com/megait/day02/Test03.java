package com.megait.day02;

import com.megait.day01.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Test03 {
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

            Pokemon p2 = em.find(Pokemon.class, 2L);
            System.out.println("수정 전 name : " + p2.getName()); // 라이츄
            p2.setName("치코리타");
            System.out.println("수정 후 name : " + p2.getName()); // 치코리타

            tx.commit(); // 여기서 update 쿼리가 날아감.
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
