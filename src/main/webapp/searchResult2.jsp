<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Patients Data</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            font-family: Arial, sans-serif;
            margin-bottom: 2rem;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .main {
            text-align: center;
        }
        h2 {
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
<div class="main">
    <h2>Patients Data</h2>
    <table>
        <thead>
        <tr>
            <%
                DataFrame df = (DataFrame) request.getAttribute("filteredDataFrame");
                if (df == null) {
            %>
            <th colspan="4">No DataFrame found in request</th>
            <%
            } else {
                List<String> columnNames = df.getColumnNames();
                for (String columnName : columnNames) {
            %>
            <th><%= columnName %></th>
            <%
                    }
                }
            %>
        </tr>
        </thead>
        <tbody>
        <%
            if (df != null) {
                int rowCount = df.getRowCount();
                for (int row = 0; row < rowCount; row++) {
        %>
        <tr>
            <%
                List<String> columnNames = df.getColumnNames();
                for (String columnName : columnNames) {
                    String cellValue = df.getValue(columnName, row);
            %>
            <td><%= cellValue %></td>
            <%
                }
            %>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
