<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <title>hubble</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="${pageContext.request.contextPath}/static/custom/css/debugging_index.css" rel="stylesheet">
</head>
<body>
  <c:import url="../client_shared/shared_css.jsp" />
  <c:import url="../client_shared/nav.jsp" />
 
 <c:import url="../client_shared/_footer.jsp" />
 <c:import url="../client_shared/js.jsp" />
</body>
</html>
