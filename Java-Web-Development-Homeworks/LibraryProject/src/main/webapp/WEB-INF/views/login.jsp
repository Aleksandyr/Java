<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<ct:PageTag>
			<jsp:body>
				<form name="login" class="form-signin" action="/library/login" method="POST">
			        <h2 class="form-signin-heading">Please sign in</h2>
			        <label for="username" class="sr-only">Username</label>
			        <input type="text" id="username" name="username" class="form-control" placeholder="Email address" required autofocus>
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
			</jsp:body>
		</ct:PageTag>
	</body>
</html>