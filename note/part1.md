init
1. spring initializr 사용해서 프로젝트 만들기
2. project structure에서 자바 버전을 프로젝트와 동일하게 설정
3. settings - build - build tools - gradle에서 [ Gradle -> Intellij ]로 실행하기 설정
4. java compiler - additional command line parameters에 [ -parameters ] 추가
---
웹페이지 만들기(Controller)
- @Controller 어노테이션 쓰면 서버기능 만들 수 있다.
  - main함수에 직접 안만들어도 @Controller 덕분에 스프링이 알아서 실행시켜 준다.
- @GetMapping URL이 동일하면 이곳으로 이동
- @ResponseBody 문자 데이터를 그대로 웹으로 보내기
- resources/static에 정적인 파일들 보관 가능


