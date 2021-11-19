/**
 * qna_board_list.jsp
 */
$(function(){
	
	//새글 작성을 클릭하면 actionForm 보내기
	//onclick = "location.href=''/view/qna_board_write.jsp'
	$(".btn-success").click(function(){
		$("#actionForm").find("[name='bno']").remove();
		$("#actionForm").attr("action","/view/qna_board_write.jsp");
		$("#actionForm").attr("method","get");
		$("#actionForm").submit();             
	})
	
	
	
	//제목을 클릭하면 actionForm을 보내기
	$(".count").click(function(e){
		e.preventDefault(); // a 태그 동작 막기
		
		let href = $(this).attr('href');// href를 가져오라고 하는 것이며, 해당 제목의 번호를 가져오는 것
		
		$("#actionForm").find("[name='bno']").val(href); // 보내는 것
		$("#actionForm").attr("action","/countUpdate.do"); // 동작을 주고, 원래 Form에 정보를 추가해서 보내는 것 
		$("#actionForm").submit(); //무조건 움직인다. 막으려면 preventDefault를 넣어줘야한다.
	})
	
	//페이지 번호를 클릭하면 actionForm을 보내기
	$(".move").click(function(e){
		e.preventDefault(); // a 태그 동작 막기
		
		let href = $(this).attr('href');// href가 4번이면 this가 이벤트가 일어난 대상이므로 4번으로 나온다.
		
		$("#actionForm").find("[name='bno']").remove();
		$("#actionForm").find("[name='page']").val(href);
		$("#actionForm").attr("action","/list.do"); // 동작을 주고, 원래 Form에 정보를 추가해서 보내는 것 
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
		
		$("#search").find("[name='page']").val("1"); // 페이지 검색 후 1로 변경하라는 의미	
		$("#search").submit();
	})
})