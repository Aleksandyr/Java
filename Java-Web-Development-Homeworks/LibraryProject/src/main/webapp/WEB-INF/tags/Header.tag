<%@ attribute name="username" %>

<div class="navbar navbar-default">
<a class="navbar-brand" href="/library/">Library</a>
    <ul class="nav navbar-nav">
        <li><a href="/library/">Home</a></li>
        <li><a href="#">Books</a></li>
    </ul>
    <ul class="nav navbar-nav pull-right">
        <li><a class="navbar-brand"><u>${username}</u></a></li>
        <li><a href="#">Logout</a></li>
    </ul>
</div>