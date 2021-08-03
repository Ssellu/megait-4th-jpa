package com.megait.day02;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.reflect.Constructor;

/*
Member 엔티티
 프로퍼티 : id(PK), name(팀원 이름)
 메서드 : getter, setter, toString

Test07 에서 팀원 "A", "B", "C" 이름을 가진 3개 엔티티 생성 후 저장.
 */
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Member {
    @Id @GeneratedValue
    private Integer no;

    private String name;
}
