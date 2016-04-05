<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
	<head>
		<title>Login</title>
		<ct:LoadScriptsAndStyles></ct:LoadScriptsAndStyles>
	</head>
	<body>
		<form style="width:20%; height: 20%; margin-left: auto; margin-right: auto;" name="login" class="form-signin" id="login-form" action="/library/login" method="POST">
	        <h2 class="form-signin-heading">Please sign in</h2>
	        <label for="username" class="sr-only">Username</label>
	        <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
	        <label for="password" class="sr-only">Password</label>
	        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
	        </div>
	        <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Sign in" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      	</form>
	</body>
</html>