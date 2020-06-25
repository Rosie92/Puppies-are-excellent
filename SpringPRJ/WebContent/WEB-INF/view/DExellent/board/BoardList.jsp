<%@page import="java.util.ArrayList"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.BoardDTO"%>
<%@page import="poly.dto.PagingDTO"%>
<%@ page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  	List<BoardDTO> bList = (List<BoardDTO>)request.getAttribute("bList");
    /* BMFBDTO bDTO = (BMFBDTO) request.getAttribute("bDTO"); */
        
    PagingDTO paging= (PagingDTO)request.getAttribute("paging");
 
   System.out.println("bList.size :" + bList.size());
   
    %>
<!DOCTYPE html>
<html>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>자유게시판</title>
    <link href="/css/styles.css" rel="stylesheet" />
<style>
.move{
transition : 1s;
}
.move:hover{
transform: scale(2,2);
border-radius: 20% 20%
}
</style>
</head>

<body style="overflow-x: hidden;  background-image: url('../../assets/img/DEIMG/BoardList.jpg');">
    <div style="width: 350px; margin: auto; text-align:center;">
	<div>
    <hr>
            <span style="font-size: 20px"><b>번호</b></span>
            <span style="text-align: center; ; margin-left: 60px; font-size: 20px"><b>글제목</b></span>
            <span style="margin-left: 85px; font-size: 20px"><b>작성</b></span>
            <span style="margin-left: 5px; font-size: 20px"><b>수정</b></span><br><hr>
    </div>                     
    <div>
         <% for(BoardDTO bDTO : bList) { %>
    <div style=" padding:15px 0px 20px 0px;">
             <span style="margin-left:10px">
                <%=CmmUtil.nvl(bDTO.getBoard_seq()) %>
            </span>
          
            <span>
            <div id="move" style="width:210px; text-align:center; display:inline-block;"><a href="/DExellent/board/BoardDetail.do?seq=<%=bDTO.getBoard_seq()%>"><%=CmmUtil.nvl(bDTO.getTitle()).replaceAll("<","&lt;").replaceAll(">","&gt;") %></a></div>
            </span>
         
            <span>
            <div style=" width:50px; text-align:center; display:inline-block;">
            <%=CmmUtil.nvl(bDTO.getUser_name()) %>
            </div>            
            </span>
         
            <span>
            <%=CmmUtil.nvl(bDTO.getUpd_date()).substring(5,10) %>
            </span> 
    </div>
          <%} %>
	<div class="tab-pane active" role="tabpanel" id="tab-1">
            <div class="thread-list-head">
                <nav class="thread-pages">
                    <div class="pagination">
         <%
            if(paging.isPrev()==true) { %>
               <a class="page-item page-link" href="/DExellent/board/BoardList.do?Pno=<%=paging.getStartPage()-3%>">이전</a>&nbsp;
               <%}   %>
         
         <% for(int a= paging.getStartPage(); a <= paging.getEndPage(); a++){
            if(paging.getPage()==a) { %>
               <div class='page-item page-link' style="background-color:#1abc9c;color:white;"><%=a%></div>
         <%} else {%>
               <a class='pNum' href="/DExellent/board/BoardList.do?Pno=<%=a%>">&ensp;<%=a%>&ensp;</a>
         <%}}%>
         <%
            if(paging.isNext()==true) { %>
               &nbsp;<a class="page-item page-link" href="/DExellent/board/BoardList.do?Pno=<%=paging.getEndPage()+1%>">다음</a>
         <%}   %>
         </div>
         </nav>
         </div>
         </div>
         </div>
	
	<div>
	<div class="nav nav-tabs">
   		<div class="nav-item"><a class="btn btn-primay" href="/DExellent/board/BoardWrite.do" role="button">글작성<span class="badge badge-pill badge-primary">★</span></a></div>
    </div>
	</div>
	</div>
    <script src="/js/Board/jquery.min.js"></script>
</body>



</html>