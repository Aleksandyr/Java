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
<ct:Header username="${username}"></ct:Header>
	<div id="wrapper" style="width: 1100px; height: 500px; margin: 0 auto;">
		<header class="help-page">
		    <div class="content-wrapper">
		        <div class="float-left">
		            <h1>Library system API Help Page</h1>
		        </div>
		    </div>
		</header>
		<div id="body" class="help-page">
		    <section class="featured">
		        <div class="content-wrapper">
		            <h2>Introduction</h2>
		            <p>
		                Provide a general description of my APIs here.
		            </p>
		        </div>
		    </section>
		    <section class="content-wrapper main-content clear-fix">
		
		<h2 id="Account">Home</h2>
		<table class="help-page-table">
		    <thead>
		        <tr><th>API</th><th>Description</th></tr>
		    </thead>
		    <tbody>
		        <ct:ApiTableCol urlPath="/home/" methodType="GET" description="Home page."></ct:ApiTableCol>
		    </tbody>
		</table>
		
		
		<h2 id="Account">User</h2>
		<table class="help-page-table">
		    <thead>
		        <tr><th>API</th><th>Description</th></tr>
		    </thead>
		    <tbody>
		        <ct:ApiTableCol urlPath="/users/all" methodType="GET" description="Get all users."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/users/add" methodType="POST" description="Add new user."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/users/delete/{id}" methodType="POST" description="Delete user."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/users/edit/{id}" methodType="POST" description="Edit user."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/users/all?name={username}" methodType="GET" description="Search by username."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/users/all?pid={pid}" methodType="GET" description="Search by PID."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/users/all?dateOfBirth={dateOfBirth}" methodType="GET" description="Search by birth day."></ct:ApiTableCol>
		    </tbody>
		</table>
		
		<h2 id="Account">Profile</h2>
		<table class="help-page-table">
		    <thead>
		        <tr><th>API</th><th>Description</th></tr>
		    </thead>
		    <tbody>
		        <ct:ApiTableCol urlPath="/profile/show" methodType="GET" description="My profile info."></ct:ApiTableCol>
		         <ct:ApiTableCol urlPath="/profile/edit" methodType="POST" description="Change my profile info."></ct:ApiTableCol>
		    </tbody>
		</table>
		
		<h2 id="Values">Book</h2>
		<table class="help-page-table">
		    <thead>
		        <tr><th>API</th><th>Description</th></tr>
		    </thead>
		    <tbody>
		        <ct:ApiTableCol urlPath="/books/all" methodType="GET" description="Get all books."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/books/my" methodType="GET" description="My books."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/books/add" methodType="POST" description="Add new book."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/books/delete/{id}" methodType="POST" description="Delete book."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/edit/{id}" methodType="POST" description="Edit book."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/all?name={name}" methodType="GET" description="Search by book name."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/all?author={author}" methodType="GET" description="Search by author."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/all?yearOfPoublishing={yearOfPoublishing}" methodType="GET" description="Search by year of poublishing."></ct:ApiTableCol>
		</table>   
		
		<h2 id="Values">Lend</h2>
		<table class="help-page-table">
		    <thead>
		        <tr><th>API</th><th>Description</th></tr>
		    </thead>
		    <tbody>
		        <ct:ApiTableCol urlPath="/books/lends/all" methodType="GET" description="Get all lends."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/books/lends/add/{id}" methodType="POST" description="Add new lend."></ct:ApiTableCol>
		        <ct:ApiTableCol urlPath="/books/lends/delete/{id}" methodType="POST" description="Delete lend."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/lends/edit/{id}" methodType="POST" description="UPDATE lend."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/lends/all?bookName={bookName}" methodType="GET" description="Search by book name."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/lends/all?clientName={clientName}" methodType="GET" description="Search by client name."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/lends/all?dateOfLending={dateOfLending}" methodType="GET" description="Search by date of lending."></ct:ApiTableCol>
		    	<ct:ApiTableCol urlPath="/books/lends/all?dateOfReturn={dateOfReturn}" methodType="GET" description="Search by date of return."></ct:ApiTableCol>
		</table>   
		 </section>
		 </div>
</body>
</html>