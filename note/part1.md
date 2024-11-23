init
1. spring initializr 사용해서 프로젝트 만들기
2. project structure에서 자바 버전을 프로젝트와 동일하게 설정
3. settings - build - build tools - gradle에서 [ Gradle -> Intellij ]로 실행하기 설정
4. java compiler - additional command line parameters에 [ -parameters ] 추가
---
웹페이지 만들기(Controller)
- @Controller 어노테이션 쓰면 서버기능 만들 수 있다.
  - main함수에 직접 넣으려면 templates폴더에 html파일을 넣어야 함
- 그리고 해당 html호안만들어도 @Controller 덕분에 스프링이 알아서 실행시켜 준다.
- @GetMapping URL이 동일하면 이곳으로 이동
- @ResponseBody 문자 데이터를 그대로 웹으로 보내기
- resources/static에 정적인 파일들 보관 가능

---
상품목록 페이지 만들기(Thymeleaf)
라이브러리 설치하고 싶다면 build.gradle - dependencies 에서 설치
load gradle change 코끼리 버튼 눌러서 적용

- html에 서버데이터 출하는 함수에 매개변수 Model model 사용
- model.addAttribute로 전달할 데이터 이름, 데이터를 인자값으로 전달
- html 안에서 thymeleaf문법으로 데이터 사용 가능
  - < h4 th:text ="${name}" >이름< /h4 >
  - name에 해당하는 값이 '이름' 위에 덮어쓰기된다.

---
테이블 만들기(Entity)
- JPA에서는 @Entity 클래스 만들면 Table이 자동으로 생성된다.
- @Entity 붙은 클래스의 이름이 테이블명, 클래스의 멤버변수들이 속성이 된다.
- 기본키에는 @Id를 붙여야함
- @GeneratedValue(strategy = GenerationType.IDENTITY) 붙이면 투플 추가될 때 마다 자동으로 1추가된 값이 할당
- @Column(nullable = false) 속성값에 세부설정 가능
- DB에 반영이 늦을 수 있음