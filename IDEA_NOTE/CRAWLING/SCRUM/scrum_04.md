1. 현행화 상황
	[[노우정]]
		- 
	[[변재우]]
		- 
	 [[서용호]]
		- 
	 [[위강은]]
		- 
		
	[[최우진]] 
		- ~~유구무언입니다~~ 20개가 줄어들지를 않네요
		- 메뉴얼 작성 : https://www.notion.so/ba0eb80cdb844e6ba6af0c6ed4e6bb44?pvs=4
		- 메뉴얼 다들 검수한번 부탁드립니다 
		
	[[1003 입사예정자 01]] 이기세
		- 
	[[1003 입사예정자 02]] 이다인
		-  


2. REMIND LIST
	1. 만기환급금 처리 
		 - 정해진 내용 만기환급금 정해진 column 있으면 크롤링
		 - 정해진 column 없으면 해약환급금에서 유추하여 대입
		 - 어떻게해도 만기환급금 알수 없다  ' - 1 ' 대입
		 - 공통화코드(Abstract Crawler) 수정필요
	1. 예상적립금 
		- 
	1. '대표가설 우선순위' 

3. MZI 일정
		- 일정상 12일까지 완료 - 11일에 진행경과 한번씩만 공유해주세요
		- 


4. 안 좋다고 생각한 코드 CASE
	- 사례 01 - CrawlingKBF / CrawlingKBFDirect / setTreaties( )
		![[Pasted image 20230926151540.png]]
		![[Pasted image 20230926151708.png]]
		![[Pasted image 20230926151758.png]]
		![[Pasted image 20230926151901.png]]
		
		desc
		특약을 설정하는 메서드 400줄 가까이
		1특약설정, 2특약명검사, 3특약개수 검사, 4체크여부 확인, 5체크여부 일괄처리
		특약설정 -> 기능과 역할 확대 -> 뚱뚱해짐
		내부적으로 메서드를 잘라주자
		1개의 메서드가 가지는 범위가 너무 커지면 유지/보수 하는 입장에서 힘들다
		어 굴러가네하는 식은  곤란 
		
		-> 단위별로 메서드 생성, 큰 메서드안에 기능별 메서드 호출 하는 방식 

4. QUIZ ()
	- 5자리 정수를 입력받는다 
	- 변수와 기본 연산자만 사용해서 역순으로 출력해보자

5. DB (재우님, 강은님 요청사항)
	1. "fincette" scheme
		 company - 보험사
		 product - 보험상품
		 product_master - 전체 특약
		 plan_master - 가설
		 plan_mapper - 가설 특약
		 plan_calc - 가설 금액정보 : : 보험료, 만기환급금, 
		 plan_return_money - 가설 해약환급정보
		 plan_annuity_money - 가설 연금정보
		 agr_product_main - 분석 상품
		 agr_product_basis - 분석 가설 
		 agr_product_treaty - 분석 특약 
		 code_master - 전환 코드 
		 		 
![[Pasted Image 20231006082049_567.png]]

6. API list (강은님 요청사항)
	1. nuzal
	2. crawling

8. 메뉴얼 수정 필요 _ 실질적인 운영에 대한 고민 (_

9. 펭귄 업데이트 
	1. 변수 / 클래스
	2. OOP
	3. 기본연산자
	4. 메서드

	1. 배열, Collection
	2. 조건문, 반복문
	3. 예외처리

	1. Modifier 제한자
	2. 다형성, 형변환
	3. 상속, interface

	1. Thread, Sync
	2. I/O
	3. Lambda, Stream
	4. Network (Socket)

10. 크롤링과 연관되는 정책 리스트 (우정님 요청사항)
	-  라마인드 리스트 총정리 필요

11. 에러 케이스 

12. 앞으로
	1. 개편
	2. 그 외