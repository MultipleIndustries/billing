<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Welcome to the Spring MVC Quickstart application! Get started quickly by signing up!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet" media="screen" th:href="@{/resources/css/bootstrap.min.css}"/>
    <link href="../../../resources/css/core.css" rel="stylesheet" media="screen" th:href="@{/resources/css/core.css}" />
    <script src="../../../resources/js/jquery.min.js" th:src="@{/resources/js/jquery.min.js}"></script>
    <script src="../../../resources/js/bootstrap.min.js" th:src="@{/resources/js/bootstrap.min.js}"></script>
</head>
<body>
<div th:replace="fragments/layout :: header"></div>
<div class="container">
    <div class="text-center">
        <h1>Test</h1>
        <p class="lead">
            Welcome to the Spring MVC Quickstart application!
            Get started quickly by signing up.
        </p>
        <p>
            <a class="btn btn-success btn-lg" id="signup">Sign up</a>
        </p>
    </div>
    <div th:replace="fragments/layout :: footer">&copy; 2016 The Static Templates</div>
</div>
<script th:inline="javascript" type="text/javascript">
    /* Fill in modal with content loaded with Ajax */
    $(document).ready(function () {
        $('#signup').on('click', function () {
            $("#signup-modal").modal();
            $("#signup-modal-body").text("");
            $.ajax({
                url: "signup",
                cache: false
            }).done(function (html) {
                $("#signup-modal-body").append(html);
            });
        })
    });
</script>
<!-- Signup modal -->
<div th:replace="fragments/components :: modal(id='signup-modal', title='Signup')"></div>
</body>
</html>