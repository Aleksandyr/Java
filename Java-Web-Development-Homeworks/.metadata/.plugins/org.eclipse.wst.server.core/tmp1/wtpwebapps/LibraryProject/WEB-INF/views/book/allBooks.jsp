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
			<c:if test="${not empty books}">	
		        <c:forEach var="b" items="${books}">		        
					<div class = "list-group">
					   <a href = "#" class = "list-group-item active">
					      <h4 class = "list-group-item-heading">
					         ${b.getName()}
					      </h4>
					       <table style="margin-left: 80%">
								<tr>
							       <sec:authorize access="hasRole('ROLE_ADMIN')">
										<td>
								     	 <form:form modelAttribute="users" action="/library/books/edit/${b.getId()}" id="deleteButtonForm" method="get" >
					                   		<%-- <td><a href="/library/users/delete/${u.getId()}" class="confirm-delete btn mini red-stripe">Delete</a></td> --%>
					               			<td><input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Edit" /></td>
					               		</form:form>
										</td>
										<td>
										<form:form modelAttribute="users" action="/library/books/delete/${b.getId()}" id="deleteButtonForm" method="get" >
					               			<td><input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Delete" /></td>
					               		</form:form>
					               		</td>
    				               	</sec:authorize>
				               		<td>
				               		<form:form modelAttribute="users" action="/library/books/lend/add/${b.getId()}" id="deleteButtonForm" method="get" >
				               			<td><input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Lend" /></td>
				               		</form:form>
				               		</td>
			               		</tr>
		               		</table>
					   </a>
					   
					   <a href = "#" class = "list-group-item">
					      <h4 class = "list-group-item-heading">
					         ${b.getAuthor()}
					      </h4>
					      
					      <p class = "list-group-item-text">
					         You will get a free domain registration with website pages.
					      </p>
					   </a>
					   
					   <a href = "#" class = "list-group-item">
					      <h4 class = "list-group-item-heading">
					         ${b.getYearOfPoublishing()}
					      </h4>
					      
					      <p class = "list-group-item-text">
					         We provide 24*7 support.
					      </p>
					   </a>
					</div>
				</c:forEach>
			</c:if>
		</jsp:body>
	</ct:PageTag>
</body>
</html>