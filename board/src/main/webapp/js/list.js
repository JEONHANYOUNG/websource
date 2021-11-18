/**
 * qna_board_list.jsp
 */
$(function(){
	
	//페이지 번호를 클릭하면 actionForm을 보내기
	$(".move").click(function(e){
		e.preventDefault(); // a 태그 동작 막기
		
		let href = $(this).attr('href');// href가 4번이면 this가 이벤트가 일어난 대상이므로 4번으로 나온다.
		
		$("#actionForm").find("[name='page']").val(href);
		$("#actionForm").submit(); //무조건 움직인다. 막으려면 preventDefault를 넣어줘야한다.


	})
	
	
	//검색어에서 enter 치는 것 방지
	$(":text").keydown(function(e){
		if(e.keyCode == 13){
			e.preventDefault();
		}
	})
		
	
	
	//검색 버튼을 누르면 
	//검색 조건(criteria), 검색어(keyword) 가져온 후
	//내용이 안들어 있으면 메세지 띄우기
	$(".btn-primary").click(function(){
		let criteria = $("[name='criteria']"); 
		let keyword = $("[name='keyword']"); 
		
		if(criteria.val()=="n"){
			alert("검색 조건이 없습니다.");
			criteria.focus();
			return;
		} else if(keyword.val()==""){
			alert("검색어가 없습니다.");
			keyword.focus();
			return;
		}
		$("#search").submit();
		
	})
})