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
		<div>
			<form class="navbar-form navbar-left" role="search">
			    <div class="form-group">
			        <input type="text" class="form-control" name="bookName" id="bookName" placeholder="Search by book name">
			    </div>
			    <button type="submit" class="btn btn-default">Search</button>
			</form>
			<form class="navbar-form navbar-left" role="search">
			    <div class="form-group">
			        <input type="text" class="form-control" name="clientName" id=""clientName"" placeholder="Search by client name">
			    </div>
			    <button type="submit" class="btn btn-default">Search</button>
			</form>
			<form class="navbar-form navbar-left" role="search">
			    <div class="form-group">
			    	<label for="dateOfLending">Date of lending</label>
			        <input type="date" class="form-control" name="dateOfLending" id="dateOfLending" placeholder="Search by date of lend">
			    </div>
			    <button type="submit" class="btn btn-default">Search</button>
			</form>
			<form class="navbar-form navbar-left" role="search">
			    <div class="form-group">
			    	<label for="dateOfReturn">Date of return</label>
			        <input type="date" class="form-control" name="dateOfReturn" id="dateOfReturn" placeholder="Search by date of return">
			    </div>
			    <button type="submit" class="btn btn-default">Search</button>
			</form>
		</div>
		
		<input type="submit" class="btn btn-default" value="All Lends" onclick="window.location = '/library/books/lends/all';">
		
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
	   		<c:when test="${not empty lendsBook}">	
			   <table class="table table-striped table-hover table-users">
					<thead>
						<tr>
							<th>Username</th>
							<th>Name</th>
							<th>Author</th>
							<th>Year of publishing</th>
							<th>Date of lending</th>
							<th>Date of return</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
				        <c:forEach var="lb" items="${lendsBook}">
					        <tr>   
					        	<td>${lb.getUsername()}</td>
								<td>${lb.getName()}</td>
								<td>${lb.getAuthor()}</td>
								<td>${lb.getYearOfPoublishing()}</td>
								<td>${lb.getDateOfLending()}</td>
								<td>${lb.getDateOfReturn()}</td>
								
								<td>
									<input type="button" class="btn-primary btn mini red-stripe" value="Edit" onclick="window.location = '/library/books/lends/edit/${lb.getBookId()}/${lb.getId()}';">
								</td>
								<td>
									<input type="button" class="btn-danger btn mini red-stripe" value="Delete" onclick="window.location = '/library/books/lends/delete/${lb.getBookId()}/${lb.getId()}';">
								</td>						
  			                </tr>
				        </c:forEach>
		           </tbody>
		  		</table>
			</c:when>
			<c:otherwise>
				<h1>No lend books!</h1>
			</c:otherwise>
		</c:choose>
	</jsp:body>
</ct:PageTag>
</body>
</html>