<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="#{view.index.title}">Welcome!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet" media="screen" th:href="@{/resources/css/bootstrap.min.css}"/>
    <link href="../../../resources/css/core.css" rel="stylesheet" media="screen" th:href="@{/resources/css/core.css}" />
    <script src="../../../resources/js/jquery.min.js" th:src="@{/resources/js/jquery.min.js}"></script>
    <script src="../../../resources/js/bootstrap.min.js" th:src="@{/resources/js/bootstrap.min.js}"></script>
</head>
<body>
<div th:replace="fragments/layout :: header"></div>
<div class="container">
    <!-- /* Handle the flash message */-->
    <th:block th:if="${message != null}">
        <!-- /* The message code is returned from the @Controller */ -->
        <div th:replace="fragments/components :: alert (type=${#strings.toLowerCase(message.type)}, message=#{${message.message}(${#authentication.name})})">&nbsp;</div>
    </th:block>
    <p class="lead text-center">
        Welcome to the Spring MVC Quickstart application!
    </p>
    <div th:replace="fragments/layout :: footer"></div>
</div>
</body>
</html>