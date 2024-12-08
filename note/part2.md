상품 추가기능 1 (Map 자료형)  
- input 태그에는 name=""으로 작명 해 줘야 전달이 잘 된다.
- GET, POST, DELETE 등이 동사이므로 URL이름은 명사로 쓰는게 관습이다.
- PostMapping 함수의 매개변수는 유저가 보낸 데이터를 받을 때 쓸 수 있음
  - 자료형은 받은 데이터를 해당 타입으로 변환한다는 뜻
- String addPost(@RequestParam(name = "title") String title) 이렇게 쓰는게 기본 문법이나 생략가능
- 매개변수에 @RequestParam Map formData 이런식으로 맵으로 받으면 한번에 받을 수 있음

상품 추가기능 2 & Navbar 만들기
- id값 자동설정 되어있으면 new Item()으로 만들어서 id값이 알아서 들어가게 해야함
- 이후에 title, price는 직접 대입해서 값 입력
- @RequestParam String title, @RequestParam int price 대신에 @ModelAttribute Item item 이런식으로 유저데이터를 받아올 수 있음
- th : fragment를 사용해서 하나의 html파일을 여러 곳에 import해서 사용할 수 있음
  - th : fragment = "이름" 으로 만들어두고
  - th : replace =" ~{파일 경로 :: 이름 }"으로 사용 
  - th:replace="nav.html :: navbar('데이터1', '데이터2')" 이렇게 데이터도 묶어서 보낼 수 있다

상세페이지 만들기1(Optional)
- @GetMapping("detail/{id}") 이렇게 url에 { } 넣으면 detail/ 뒤에 아무문자 더 붙으면 여기에 해당한다는 뜻
- 여러개 넣을 수 있고, 작명은 id말고도 다른것도 가능
- findById의 결과값은 null일 수도 있기 때문에 Optional타입으로 받아야 함
- Optinal로 받은 값들은 .get으로 꺼내줘야함
- null값일 때 .get하면 안되니까 if문 써야함
- @PathVariable Long id 이런식으로 {id} 받아올 수 있음

상세페이지 만들기2 & 예외처리
- th:href="@{'/detail/' + ${i.id} }" 이런식으로 url에 id값 넣어서 생성 가능
- 타임리프 설치한 경우에는 error.html이 있을 경우 에러발생시 자동으로 보여줌

REST API의 예외처리 방법
- rest api에서는 error.html쓸 수가없어서 try - catch 사용
- redirect도 잘 안될거기 때문에 return ResponseEntity.status().body(""); 이렇게 리턴함
- 모든 에러 케치하는 spring 문법도 있음. rest api에서 주로 사용
  - @ExceptionHandler(Exception.class)
    public void handler() {

    }
  - 같은 페이지 내의 모든 에러 처리할 수 있음
  - 모든 controller의 에러를 한번에 처리하고 싶다면 @ControllerAdvice파일을 만들어서 위에 코드 넣어주면 됨

Service 레이어로 분리하려면
- db입출력, 데이터 검사 등을 비즈니스 로직이라고 부름
- 비즈니스 로직을 담는 클래스는 Service라고 부름