<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tianyouzhou
  Date: 2018/9/6
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You have finished all questions</title>
</head>
<body>
You have finished all questions!
<a href="<c:url value="${pageContext.request.contextPath}/index"/>" class="btn btn-light">Home</a>
</body>
</html>
