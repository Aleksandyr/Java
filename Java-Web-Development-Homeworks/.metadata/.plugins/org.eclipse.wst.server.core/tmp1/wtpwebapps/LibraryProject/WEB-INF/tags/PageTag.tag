<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="username" value= '<%= session.getAttribute("username") %>' />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<ct:Header username="${username}"></ct:Header>
<jsp:doBody></jsp:doBody>
<ct:Footer version="1.1"></ct:Footer>
