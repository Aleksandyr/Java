<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ct:Header username="${username}"></ct:Header>
	<div id="success-message"></div>
	<div id="error-message"></div>
	<div id="wrapper" style="width: 1100px; height: 500px; margin: 0 auto;">
		<jsp:doBody></jsp:doBody>
	</div>
<ct:Footer></ct:Footer>

