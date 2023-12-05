
##### 2023.11.08 수

---

### 01. CRAWLING_TASK

	[[노우정]]
	- 8개 남은 상태
	- 큰 특이사항 없음
	- 해약 -> 해지 안먹히는 케이스 있음
	
	[[변재우]]
	- 특이사항 없음
	
	[[서용호]]
	- 특이사항 없음
	
	[[위강은]]
	- 특이사항 없음
	
	[[최우진]] 
	- 특이사항 있음
	- KBF : : 코드 리뷰 다음 기회에 
	
	[[이기세]] (부재 / 예비군)

---
### 02. REMIND

- 코드 관리 
	- 시험적으로 강은님 업무로 분류
	- GIT 관리, 관련 정책과 연계
	- 코드 관리

- GIT 정책
	- fincette-crawler

- surfsharkVPN 당분간 사용정지

- ---
### 03. REVIEW	

3-1 에러케이스  	
	![[Pasted image 20231101200352.png]]
	증상 : 상품마스터(특약)에 여러개 걸려잇는 product_id (상품)
	원인 : 파악중
	대처 : 원인파악과 기능개선 전까지 정기적 데이터 검사 실행
	개선 : product_id ',' 로 잘라서 임시로라도 보여줄 수 있게 임의 수정, 관련 유효성 검사 추가, product_id값의 추가/변경시 잘못된 로직


3-2 저축성 상품 특약 데이터 관리 (데이터 변경)
	- 기존 특약1개로 TND 전부 매핑하여 관리
	- 앞으로는 AUTOMATION과 같이 TND를 1:1로 대응
	- 저축, 연금에만 가설있는 상태

3-3 에러 케이스
- 테이블의 column 변경시,  관련 쿼리, 연관되는 다른 테이블과의 
- 확인 후에 다시


---
### 04. CODE_REVIEW

4-1
	![[Pasted image 20231101200931.png]]
	
	sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	actions.moveByOffset(0, 0).click().build().perform();

4-2
	아래 내용 잘못 이해 함;; 
	![[Pasted image 20231101212341.png]]


---
### 05. GIT

- 앞으로 강은님이 코드 컨벤션 관리할 것
- 관련 스크립트 수정 요청들어오면 수정해주시면 됨 
- GIT 도 마찬가지

MAIN / PROD / FEAT / EMERGENCY 


---
### 06. 응?!
	
	![[Pasted image 20231102115436.png]]
	전 부평을 가본 적이 없습니다
	일단 로그아웃 처리함 
	다른 분들도 한번 확인해보세요


---
### 07. WEEKLY REPORT
	
	기본적으로 앞으로 주간단위 작업양 기록은 MONDAY에 함 
	단 몇주간 공동으로 작업할 거임 ㅇㅇ
	
	![[image (20).png]]
	데이터 수집팀의 01 항목은 동일 
	01. 데이터 현행화 
		- 모니터링 : (현재 완료된 상품 건수) 
		- 스크립트 작성 : 주간 현행화 작업 + 관련 개인별 스크립트 수정 작업 포함 
		- 데이터 검증 : 주간 모니터링시 재작업한 모든 상품 건수 
	02. 추가작업 
		- 우정님 쓰신 내용 참조 


---
### 08. SFI_MDC_D005

	SFI_MDC_D005 상품가입연령 19세 이상으로 되어 있는 이유

DBF_AMD_F004
DBF_AMD_D005

조사 