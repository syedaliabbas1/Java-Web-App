<!--<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.DataFrame" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <ul>
    <%
      List<String> patients = (List<String>) request.getAttribute("patientNames");
      DataFrame df = (DataFrame) request.getAttribute("dataFrame");
      for (String patient : patients)
      {%>
    <h1><%=patient%></h1>
    <%
        ArrayList<String> columnValues= df.getColumnValues(patient);

        String href = "dummypage.html";
    %>
    <li><a href="<%=href%>"><%=patient%></a>
    </li>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
-->