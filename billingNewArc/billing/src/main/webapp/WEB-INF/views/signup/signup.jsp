<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Signup</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet" media="screen" th:href="@{/resources/css/bootstrap.min.css}"/>
    <link href="../../../resources/css/core.css" rel="stylesheet" media="screen" th:href="@{/resources/css/core.css}" />
    <script src="../../../resources/js/jquery.min.js" th:src="@{/resources/js/jquery.min.js}"></script>
    <script src="../../../resources/js/bootstrap.min.js" th:src="@{/resources/js/bootstrap.min.js}"></script>
</head>
<body>
<div th:replace="fragments/layout :: header"></div>
<form class="form-narrow form-horizontal" method="post" th:action="@{/signup}" th:object="${signupForm}" th:fragment="signupForm">
    <!--/* Show general error message when form contains errors */-->
    <th:block th:if="${#fields.hasErrors('${signupForm.*}')}">
        <div th:replace="fragments/components :: alert (type='danger', message='Form contains errors. Please try again.')">Alert</div>
    </th:block>
    <fieldset>
        <legend>Please Sign Up</legend>
        <div class="form-group" th:classappend="${#fields.hasErrors('email')}? 'has-error'">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" id="email" placeholder="Email address" th:field="*{email}" />
                <span class="help-block" th:if="${#fields.hasErrors('email')}" th:errors="*{email}">Incorrect email</span>
            </div>
        </div>
        <div class="form-group" th:classappend="${#fields.hasErrors('password')}? 'has-error'">
            <label for="password" class="col-lg-2 control-label">Password</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="password" placeholder="Password" th:field="*{password}"/>
                <span class="help-block" th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Incorrect password</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Sign up</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <p>Already have an account? <a href="signin" th:href="@{/signin}">Sign In</a></p>
            </div>
        </div>
    </fieldset>
</form>
<div th:replace="fragments/layout :: footer"></div>
</body>
</html>