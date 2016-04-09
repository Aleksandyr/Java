<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<ct:LoadScriptsAndStyles></ct:LoadScriptsAndStyles>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
		  <h1><i class="fa fa-ban red"></i> 403 Access Denied!</h1>
		  <p class="lead">Sorry! You don't have access permissions for that on <em><span id="display-domain"></span></em>.</p>
		    <p><button onclick="window.location = '/library/home/';" class="btn btn-default btn-lg"><span class="green">Take Me To The Homepage</span></button>
		    </p>
		</div>
		</div>
		<div class="container">
		  <div class="body-content">
		    <div class="row">
		      <div class="col-md-6">
		        <h2>What happened?</h2>
		        <p class="lead">A 403 error status indicates that you don't have permission to access the file or page. In general, web servers and websites have directories and files that are not open to the public web for security reasons.</p>
		      </div>
		      <div class="col-md-6">
		        <h2>What can I do?</h2>
		        <p class="lead">If you're a site visitor</p>
		        <p>Please use your browsers back button and check that you're in the right place. If you need immediate assistance, please send us an email instead.</p>
		        <p class="lead">If you're the site owner</p>
		         <p>Please check that you're in the right place and get in touch with your website provider if you believe this to be an error.</p>
		     </div>
		    </div>
		  </div>
		</div>
</body>
</html>