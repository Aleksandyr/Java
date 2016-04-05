<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="username" %>

<div class="navbar navbar-default">
<a class="navbar-brand" href="/library/home/">Library</a>
    <ul class="nav navbar-nav">
        <li><a href="/library/home/">Home</a></li>
        <li><a href="#">Books</a></li>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
	        <li class="dropdown" style="margin-top: 4%">
			  <button class="btn btn-link" type="button" data-toggle="dropdown">User
			  <span class="caret"></span></button>
			  <ul class="dropdown-menu">
			    <li><a href="/library/users/all">All Users</a></li>
			    <li><a href="/library/users/add">Add Users</a></li>
			  </ul>
			</li>
		</sec:authorize>
    </ul>
    <ul class="nav navbar-nav pull-right">
        <li><a class="navbar-brand">${username}</a></li>
        <li><a href="/library/account/logout">Logout</a></li>
    </ul>
</div>