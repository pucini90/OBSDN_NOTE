
### 크롤링 관련 개선 아이디어 모음

1. 크롤링 아이디어
	- scrap( ) 구간에서 작동할 thread를 구성 ----  알수없는 알럿 처리
	- mainThread에서는 scrap( )은 오직 스크립트만 포함하고
	- thread에는 비정기적인 예외 요소들을 처리할 수 있는 스크립트 구성

2. HEADLESS
	- 랜더링 하지 않은 상태에서 크롤링 가능한지 (자원 최소화)

3. IMAGELESS
	- 모니터링 이미지 없애기 (자원 최소화)
	- 크롤링시 이미지 주소만 알면 되지 않나... 굳이 이미지 보면서 작업할 필요가 있나...

4. 각종 툴들의 OPEN API 연동
	1. 노션 신기술
	- 새로운 페이지에 넣어놓고 다시 전환시키면 형태 그대로 풀려서 이미지 포멧등을 지정할 수 있다!!!

5. CODE_REVIEW 
	- lint 도입

6. CODE_CONVENTION (fincette_crawler)
	 1. NAMING RULE
	 - element naming
	 - method naming
	 - 
	 2. STRUCTURE RULE 

7. Crawler Research
	1. SPEED CHECKER
		1. 특정 회사들의 크롤링 속도 측정
		2. 모니터링 에러율 측정
		3. 