<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: tianyouzhou
  Date: 2018/9/6
  Time: 下午11:23
  To change this template use File | Settings | File Templates.
--%>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Checkout example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value = "/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value = "/resources/css/form-validation.css"/>" rel="stylesheet">

    <!-- fontawesome CSS -->
    <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
</head>
<body>
<div class="container-wrapper">
    <div class = "container">
        <div class = "page-header">
            <h1>Inventory Page</h1>

            <p class="lead">This is the inventory page!</p>
        </div>

        <div class = "page-information">
            <h5>Trivia <a href="<spring:url value="/trivia/create" />" class="btn btn-primary btn-sm">Add Trivia</a></h5>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="table-success">
                <th>Content</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items = "${trivias}" var="trivia">
                <tr>
                    <td>${trivia.content}</td>
                    <td>

                        <a href="<spring:url value = "/trivia/delete/${trivia.tId}"/>"><i class="fas fa-trash"></i></a>

                        <a href="<spring:url value = "/trivia/edit/${trivia.tId}"/>"><i class="fas fa-edit"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class = "page-information">
            <h5>Poll <a href="<spring:url value="/poll/create" />" class="btn btn-primary btn-sm">Add Poll</a></h5>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="table-success">
                <th>Content</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items = "${polls}" var="poll">
                <tr>
                    <td>${poll.content}</td>
                    <td>

                        <a href="<spring:url value = "/poll/delete/${poll.pId}"/>"><i class="fas fa-trash"></i></a>

                        <a href="<spring:url value = "/poll/edit/${poll.pId}"/>"><i class="fas fa-edit"></i></a>
                    </td>
                </tr>
            </c:forEach>


        </table>


        <div class = "page-information">
            <h5>Checkbox <a href="<spring:url value="/checkbox/create" />" class="btn btn-primary btn-sm">Add Checkbox</a></h5>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="table-success">
                <th>Content</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items = "${checkbox}" var="box">
                <tr>
                    <td>${box.content}</td>
                    <td>

                        <a href="<spring:url value = "/checkbox/delete/${box.cId}"/>"><i class="fas fa-trash"></i></a>

                        <a href="<spring:url value = "/checkbox/edit/${box.cId}"/>"><i class="fas fa-edit"></i></a>
                    </td>
                </tr>
            </c:forEach>


        </table>



    </div>

</body>
</html>
