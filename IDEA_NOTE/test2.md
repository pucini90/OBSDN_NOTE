

stateDiagram 
	state "구매 시도" as purchase_request 
	state "구매 진행" as purhcase_process 
	state "취소" as cancel 
	state "완료" as complete 
	state "실패" as fail state if_state <<choice>> 
	
	[*] --> purchase_request purchase_request --> purhcase_process purchase_request --> cancel purhcase_process --> if_state if_state --> complete: 결제 성공 if_state --> fail : 결제 실패 complete --> [*] fail --> [*]