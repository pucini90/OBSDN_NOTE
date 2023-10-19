
### 크롤링 관련 개선 아이디어 모음

1. 크롤링 아이디어
	- scrap( ) 구간에서 작동할 thread를 구성 ----  알수없는 알럿 처리
	- mainThread에서는 scrap( )은 오직 스크립트만 포함하고
	- thread에는 비정기적인 예외 요소들을 처리할 수 있는 스크립트 구성
	- multi thread 구성

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

7. Crawler DATA Research
	1. 특정 회사들의 크롤링 속도 측정
	2. 모니터링 회사별 에러 비율, 자주 에러나는 상품, 상태 측정

8. 버전관리

9. 기능별 크롤러 (이삭 크롤러)

10. 검증단계 강화
	1. 프로세스 단계 강화 
		- weekly routine
	1. 코드 강화 
		- 표준화

11. crawler api - 서버 데이터 통신 방식 전환
	ASIS.     REST API 단일 방법
	TOBE.    추가로 MESSAGE QUEUE, NETTY, WEBFLUX 등 구현

12. bot 활용한 script reading 구조 탈피
	- 속도 면에서는 script 배포 후 읽는 방식보다 서버자체에서 코드만 수정하여 실행방식이 더 빠를거라 예상...

13. DB 단일화
	- 분석, 크롤링 팀간 다른 DB사용중 - 단일화 하여 데이터 리스크 관리

14. 로그 시스템
	- 검증 단계 강화의 일환
	- 분석 데이터로도 활용 가능

15. 