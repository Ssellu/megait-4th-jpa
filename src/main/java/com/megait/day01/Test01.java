package com.megait.day01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// JPA가 잘 로드되는지 확인
public class Test01 {
    public static void main(String[] args) {
        System.out.println("main() 실행!");
        // pesistence.xml 에 선언된 "myunit" 설정대로, EntityManagerFactory 생성
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("myunit");

        // Factory에서 EntityManager 객체 생성시키고 이를 얻어오기
        EntityManager em = factory.createEntityManager();

        // 여기까지 진행된다면 JPA 로드가 잘 된 것임!

        // 마지막엔 꼭 close() 하기!
        em.clear();
        factory.close();
        System.out.println("정상 종료!");

        // IntelliJ 저장 : 자동 저장임.
        // IntelliJ 실행 : ctrl + shift + F10
    }
}
