<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">


<ct:Header username="${username}"></ct:Header>
	<div id="wrapper">
		<jsp:doBody></jsp:doBody>
	</div>
<ct:Footer></ct:Footer>

