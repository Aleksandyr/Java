<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<ct:LoadScriptsAndStyles></ct:LoadScriptsAndStyles>
</head>
<body>
	<ct:PageTag>
		<jsp:body>
		<div id="myModal" class="modal hide fade">
		    <div class="modal-header">
		        <button type="button" class="close"></button>
		        <h3 id="myModalLabel">Delete</h3>
		    </div>
		    <div class="modal-body">
		        <p></p>
		    </div>
		    <div class="modal-footer">
		        <button class="btn">Close</button>
		        <button class="btn red" id="btnYes">Confirm</button>
		    </div>
	   </div>
	   <c:choose>
	   		<c:when test="${not empty books}">	
			   <table class="table table-striped table-hover table-users">
					<thead>
						<tr>
							
							<th class="hidden-phone">Name</th>
							<th>Author</th>
							<th>Date of publishing</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
				        <c:forEach var="b" items="${books}">
					        <tr>   
								<td class="hidden-phone">${b.getName()}</td>
								<td>${b.getAuthor()}</td>
								<td>${b.getYearOfPoublishing()}</td>
															   			               	  					
								<form:form modelAttribute="book" action="/library/books/edit/${b.getId()}" id="deleteButtonForm" method="get" >
			                   		<%-- <td><a href="/library/users/delete/${u.getId()}" class="confirm-delete btn mini red-stripe">Delete</a></td> --%>
			               			<td><input class="btn-primary btn mini red-stripe" name="submit" type="submit" value="Edit" /></td>
			               		</form:form>
			               		
			               		<form:form modelAttribute="book" action="/library/books/lend/add/${b.getId()}" id="deleteButtonForm" method="get" >
			                   		<%-- <td><a href="/library/users/delete/${u.getId()}" class="confirm-delete btn mini red-stripe">Delete</a></td> --%>
			               			<td><input class="btn-success btn mini red-stripe" name="submit" type="submit" value="Lend" /></td>
			               		</form:form>
								
								<form:form modelAttribute="book" action="/library/books/delete/${b.getId()}" id="deleteButtonForm" method="get" >
			               			<td><input class="btn-danger btn mini red-stripe" name="submit" type="submit" value="Delete" /></td>
			               		</form:form>
			               </tr>
				        </c:forEach>
		           </tbody>
		  		</table>
			</c:when>
			<c:otherwise>
				<h1>No books!</h1>
			</c:otherwise>
		</c:choose>
	</jsp:body>
</ct:PageTag>
</body>
</html>