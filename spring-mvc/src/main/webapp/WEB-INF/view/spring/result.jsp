<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang='ko'>
<head>
    <title>Title</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>

<main class="container">
    <h4>form</h4>
    <ul>
        <li><c:out value="${payload.userId}"/></li>
        <li><c:out value="${payload.email}"/></li>
        <li><c:out value="${payload.tel}"/></li>
        <li><c:out value="${payload.lastAccess}"/></li>
    </ul>
</main>
<%@ include file="/WEB-INF/view/include/footer.jsp"%>
</body>
</html>
