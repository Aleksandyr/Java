<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<ct:LoadScriptsAndStyles></ct:LoadScriptsAndStyles>
</head>
<body>
	<form:form style="width:25%; height: 20%; margin-left: auto; margin-right: auto;" name="add-user" class="form-add-user" id="add-user-form" action="/library/users/add" modelAttribute="autoUser" method="POST">
        <h2 class="form-signin-heading">Add user</h2>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Name" required>
        <label for="status_add_user">Status</label>
        <select class="form-control" name="status" id="status_add_user">
		    <option value="0">Inactiv</option>
  			<option value="1" selected="selected">Active</option>
		</select>
		<label for="role_add_user">Role</label>
	 	<select class="form-control" name="role" id="role_add_user">
	 		<c:if test="${not empty authorities}">	
		        <c:forEach var="auth" items="${authorities}">
				    <option value="${auth.getId()}">${auth.getAuthority()}</option>
	  			 </c:forEach>
			</c:if>
		</select>
		<label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>
        <label for="date_of_birth">Date of birth</label>
        <input type="date" id="date_of_birth" name="dateOfBirth" class="form-control" required>
        <label for="pid">PID</label>
        <input type="text" id="pid" name="pid" class="form-control" placeholder="PID" required>
        

        <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Add" style="margin-top: 3%" />
		<a class="btn btn-default btn-block" href="/library/home/">Cancel</a>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   	</form:form>
</body>
</html>