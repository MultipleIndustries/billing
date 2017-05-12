<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet" media="screen" th:href="@{/resources/css/bootstrap.min.css}"/>
</head>
<body>

<!-- Header -->
<div class="navbar navbar-inverse navbar-fixed-top" th:fragment="header">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Demo project</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li th:classappend="${module == 'home' ? 'active' : ''}">
                    <a href="#" th:href="@{/}">Home</a>
                </li>
                <li th:classappend="${module == 'about' ? 'active' : ''}">
                    <a href="#about" th:href="@{/about}">About</a>
                </li>
                <li th:classappend="${module == 'product' ? 'active' : ''}">
                    <a href="#product" th:href="@{/product}">Product</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li th:if="${#authorization.expression('!isAuthenticated()')}">
                    <a href="/signin" th:href="@{/signin}">
                        <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp;Sign in
                    </a>
                </li>
                <li th:if="${#authorization.expression('isAuthenticated()')}">
                    <a href="/logout" th:href="@{#}" onclick="$('#form').submit();">
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;Logout
                    </a>
                    <form style="visibility: hidden" id="form" method="post" action="#" th:action="@{/logout}"></form>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

<!-- Footer -->
<div th:fragment="footer" th:align="center">
    &copy;&nbsp;<span th:text="${#temporals.format(#temporals.createNow(), 'yyyy')}">2016</span>
    Demo project <span th:text="${@environment.getProperty('app.version')}"></span>
</div>

</body>
</html>