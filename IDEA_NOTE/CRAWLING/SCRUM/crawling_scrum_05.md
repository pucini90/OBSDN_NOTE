
#20231006 #스크럼

- ERR CASE 
	- 

- 안 좋다고 생각한 코드 CASE
	- 사례 01 - CrawlingKBF / CrawlingKBFDirect / setTreaties( )
		![[Pasted image 20230926151540.png]]
		![[Pasted image 20230926151708.png]]
		![[Pasted image 20230926151758.png]]
		![[Pasted image 20230926151901.png]]
		
		desc
			특약을 설정하는 메서드
			특약설정, 특약명검사, 특약개수 검사, 체크여부 확인, 체크여부 일괄처리
			특약설정 -> 기능과 역할 확대 
			내부적으로 메서드를 잘라주자
			1개의 메서드가 가지는 범위가 너무 커지면 유지/보수 하는 입장에서 힘들다