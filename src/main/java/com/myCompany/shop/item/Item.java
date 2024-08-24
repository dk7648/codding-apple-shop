package com.myCompany.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable=false, unique=true)
    //@Column(columnDefinition = "TEXT") // 컬럼타입 지정 length=1000이런것도 가능
    //컬럼 설정 변경은 DB등록에 자동으로 안되니까 DB삭제후 다시 생성. 처음부터 잘만들기
    private String title;
    private Integer price;


}
