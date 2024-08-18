package com.myCompany.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//모든 api에서 에러가 난 경우 실행
public class MyExceptionHandler {
    // 해당 클래스 내에서 다음과 같은 에러가 발생할 경우 아래의 함수 실행
    @ExceptionHandler(Exception.class)
    //Exception.class : 모든 에러에 대해 대응
    //MethodArgumentTypeMismatchException.class : 메소드 인자 값 타입 에러에 대응

    public ResponseEntity<String> handler() {
        return ResponseEntity.status(400).body("Error");
    }
}
