
##### 2023.11.01 수

---

### 01. CRAWLING_TASK
	
	[[노우정]]

	[[변재우]]

	[[서용호]]

	[[위강은]]

	[[최우진]] 

	[[이기세]]

02. [데이터 수집 개선사항 관리 시트](https://docs.google.com/spreadsheets/d/1hzfj9y8lSPy5eplOKX50IKlCoEuUKZI_TaJT-OlgqBk/edit#gid=1495740114) 
	- 구글 시트 
	- 작성 예시

03. [CODE_CONVENTION](https://www.notion.so/05-CODE_CONVENTION-d2bf9022dfaf42a2a7fca341d99fa1b6?pvs=4)
	- NOTION
	- 주기적으로 리마인드
	- 확인 및 수정 가능 체크 필요

04. CODE_REVIEW
	1. 자체 랜더링 시점이 있는 프론트 프레임워크
		- 대부분 최신 프론트 프레임워크는 자체DOCUMENT(?) 사용중 / ex. React, Vue, Angular...
		- ANGULAR - ex. KBF_CHL_D012
			- SE은 기본 랜더링된 이후 HTML을 읽어서 내용을 긁는 방식 (동적변경 이후 읽음)
			- 엥귤러 같은 자체 랜더링 시점이 있는 프론트 라이브러리 사용하는 경우 있음
				- Actions - SE계열이라 대개 화면상 변화 없음 (랜더링전으로 인식하는 듯 함)
				- 현재는 특정한 이벤트 발생시킨 후, 다시 해당 엘리먼트 찾음 (ex. jse.scrollTo() )
			- 자체 Document 객체에 접근할 방법 찾을 필요 있음
			- escape character 처리 유틸기능 필요