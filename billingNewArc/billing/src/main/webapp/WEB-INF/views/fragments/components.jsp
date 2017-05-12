<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet" media="screen" th:href="@{/resources/css/bootstrap.min.css}"/>
</head>
<body>
<!-- Reusable alert -->
<div th:fragment="alert (type, message)" class="alert alert-dismissable" th:classappend="'alert-' + ${type}">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <span th:text="${message}">Test</span>
</div>
<!-- Reusable modal -->
<div th:fragment="modal (id, title)" class="modal fade" th:id="${id}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel" th:text="${title}">My modal</h4>
            </div>
            <div class="modal-body" th:id="${id + '-body'}"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
