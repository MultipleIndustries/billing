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
    <p class="lead text-center">
        About
    </p>
</div>
<div th:replace="fragments/layout :: footer"></div>
</body>
</html>