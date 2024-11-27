상품 추가기능 1 (Map 자료형)  
- input 태그에는 name=""으로 작명 해 줘야 전달이 잘 된다.
- GET, POST, DELETE 등이 동사이므로 URL이름은 명사로 쓰는게 관습이다.
- PostMapping 함수의 매개변수는 유저가 보낸 데이터를 받을 때 쓸 수 있음
  - 자료형은 받은 데이터를 해당 타입으로 변환한다는 뜻
- String addPost(@RequestParam(name = "title") String title) 이렇게 쓰는게 기본 문법이나 생략가능
- 매개변수에 @RequestParam Map formData 이런식으로 맵으로 받으면 한번에 받을 수 있음