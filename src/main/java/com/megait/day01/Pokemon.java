package com.megait.day01;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  // 이것은 테이블이다
@Getter @Setter @ToString
public class Pokemon {
    @Id  // PK 임을 선언
    @GeneratedValue  // AUTO_INCREMENT 적용(정확히는 dialect에 따라 auto_increment / sequence 가 선택)
    private Long id; // PK 는 Wrapper class (Long, Integer) 추천.

    private String name;

    private int level;

}
