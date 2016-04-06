<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<ct:LoadScriptsAndStyles></ct:LoadScriptsAndStyles>
</head>
<body>
	<c:if test="${not empty book}">
		<form:form style="width:20%; height: 20%; margin-left: auto; margin-right: auto;" name="delete" class="form-delete" id="delete-form" action="/library/books/delete/${book.getId()}" method="POST">
	        <h2 class="form-signin-heading">Delete book</h2>
	        <label for="name">Name</label>
	        <input type="text" id="name" name="name" class="form-control" placeholder="${book.getName()}" readonly>
	        <label for="author">Author</label>
	        <input type="text" id="author" name="author" class="form-control" placeholder="${book.getAuthor()}" readonly>
	        <label for="yearOfPoublishing">Year of poublishing</label>
	        <input type="text" id="yearOfPoublishing" name="yearOfPoublishing" class="form-control" placeholder="${book.getYearOfPoublishing()}" readonly>

	        <input class="btn btn-danger btn-block" name="submit" type="submit" value="Delete" />
			<a class="btn btn-default btn-block" href="/library/books/all/">Cancel</a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      	</form:form>
   	</c:if>
</body>
</html>