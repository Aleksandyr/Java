<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	   <table class="table table-striped table-hover table-users">
			<thead>
				<tr>
					
					<th class="hidden-phone">Name</th>
					<th>Username</th>
					<th>Status</th>
					<th class="hidden-phone">Date of birth</th>
					<th class="hidden-phone">PID</th>
					<th class="hidden-phone">Authority</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty users}">	
			        <c:forEach var="u" items="${users}">
				        <tr>   
							<td class="hidden-phone">${u.getName()}</td>
							<td>${u.getUsername()}</td>
							<c:choose>
								<c:when test="${u.getStatus() == 1}">
								    <td><span class="label label-warning">Active</span></td>
							  	</c:when>
				               	<c:otherwise>
	    							<td><span class="label label-warning">Not Active</span></td>
	  							</c:otherwise>
  							</c:choose>
							<td class="hidden-phone">${u.getDateOfBirth()}</td>
		                    <td class="hidden-phone">${u.getPid()}</td>
		                    <td class="hidden-phone">
			        			<c:forEach var="a" items="${u.getAuthorities()}">
			        				<p class="hidden-phone">${a.getAuthority()}</p>
			        			</c:forEach>
							</td>
														   			               	  					
							<td><a class="btn mini blue-stripe" href="{site_url()}admin/editFront/1">Edit</a></td>
		
		                   <td><a href="#" class="confirm-delete btn mini red-stripe">Delete</a></td>
		               </tr>
			        </c:forEach>
				</c:if>
           </tbody>
  		</table>
	</jsp:body>
</ct:PageTag>
</body>
</html>