<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: tianyouzhou
  Date: 2018/9/4
  Time: 下午11:39
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
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
</head>

<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>${matric.content}</h2>
    </div>

    <form action="${pageContext.request.contextPath}/main/next/matric/${uId}/${matric.mId}" method="post">

    <table class="table table-striped table-hover">
        <thead>
        <tr class="table-success">
            <th>${matric.title}</th>
            <c:forEach items="${rows}" var="row" varStatus="rowstatus">
                <th>
                    ${row}
                </th>
            </c:forEach>

        </tr>
        </thead>

        <c:forEach items = "${cols}" var="col" varStatus="colstatus">
            <tr>
                <td>${col}</td>
            <c:forEach items="${rows}" var="row" varStatus="rowstatus">
                <td>
                    <input type="radio" id="${colstatus.index * fn:length(rows) + rowstatus.index}"  name="customRadio" class="custom-control-input" value="${colstatus.index * fn:length(rows) + rowstatus.index}" required>
                    <label class="custom-control-label" for="${colstatus.index * fn:length(rows)  + rowstatus.index}">Yes</label>
                </td>
            </c:forEach>
            </tr>
        </c:forEach>

    </table>

    <input type="submit" value="submit" class="btn btn-primary">
    <a href="<c:url value="${pageContext.request.contextPath}/index"/>" class="btn btn-light">Cancel</a>

    </form>

    <%--<form:form action = "${pageContext.request.contextPath}/main/next/poll/${uId}/${pId}" method = "post" modelAttribute="answer">--%>

        <%--<h3></h3>--%>




        <%--<br>--%>



    <%--</form:form>--%>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
