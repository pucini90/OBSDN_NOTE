
##### 2023.11.08 수

---

### 01. CRAWLING_TASK

	[[노우정]]

	[[변재우]]

	[[서용호]]

	[[위강은]]

	[[최우진]] 

	[[이기세]]


### 02. REMIND

- 코드 관리 
	- 시험적으로 강은님 업무로 분류
	- GIT 관리, 관련 정책과 연계
	- 코드 관리

- GIT 정책
	- fincette-crawler

	- 

### 03. REVIEW	

3-1 에러케이스  	
	![[Pasted image 20231101200352.png]]
	증상 : 상품마스터(특약)에 여러개 걸려잇는 product_id (상품)
	원인 : 파악중
	대처 : 원인파악과 기능개선전까지 정기적 데이터 검사 실행
	개선 : 관련 유효성검사 추가, product_id값의 추가/변경시 잘못된 로직

3-2 저축성상품 특약 데이터 관리 (데이터 변경)

3-3 에러 케이스
- 테이블의 columne 변경시,  관련 쿼리, 연관되는 다른 테이블과의 


### 04. CODE_REVIEW

4-1
	![[Pasted image 20231101200931.png]]
	
	sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	actions.moveByOffset(0, 0).click().build().perform();

4-2
	![[Pasted image 20231101212341.png]]


5. GIT