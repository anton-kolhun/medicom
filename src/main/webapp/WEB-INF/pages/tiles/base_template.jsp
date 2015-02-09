<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>medicom</title>

    <c:url value='' var="WEB_ROOT" />
    <base href="//${pageContext.request.serverName}:${pageContext.request.serverPort}${WEB_ROOT}"/>
    <t:insertAttribute name="header"/>
</head>

<body>

<t:insertAttribute name="contentBase"/>

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<t:insertAttribute name="footer"/>
</body>

</html>