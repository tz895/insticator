<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
        <h2>${trivia.content}</h2>
        <%--<p class="lead"></p>--%>
    </div>

    <form:form action = "${pageContext.request.contextPath}/trivia/next/${uId}/${tId}" method = "post" modelAttribute="answer">

        <h3></h3>


        <c:if test="${trivia.answersA != null && trivia.answersA.length() != 0}">
        <div class="form-check">
            <%--<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>--%>
            <input:radiobutton path="answer" id="exampleRadios1" value="1" checked="1" />
            <label class="form-check-label" for="exampleRadios1">
                    ${trivia.answersA}
            </label>
        </div>
        </c:if>

        <c:if test="${trivia.answersB != null && trivia.answersB.length() != 0}">
        <div class="form-check">
            <input:radiobutton path="answer" id="exampleRadios2" value="2" />
            <label class="form-check-label" for="exampleRadios2">
                    ${trivia.answersB}
            </label>
        </div>
        </c:if>

        <c:if test="${trivia.answersC != null && trivia.answersC.length() != 0}">
        <div class="form-check">
            <input:radiobutton path="answer" id="exampleRadios3" value="3"/>
            <label class="form-check-label" for="exampleRadios3">
                    ${trivia.answersC}
            </label>
        </div>
        </c:if>

        <c:if test="${trivia.answersD != null && trivia.answersD.length() != 0}">
        <div class="form-check">
            <input:radiobutton path="answer" id="exampleRadios4" value="4" />
            <label class="form-check-label" for="exampleRadios4">
                    ${trivia.answersD}
            </label>
        </div>
        </c:if>


        <br>

        <input type="submit" value="submit" class="btn btn-primary">
        <a href="<c:url value="${pageContext.request.contextPath}/index"/>" class="btn btn-light">Home</a>

    </form:form>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>
