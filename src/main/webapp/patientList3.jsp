<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.DataFrame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>DataFrame Spreadsheet</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<div class="main">
    <h2>DataFrame Spreadsheet:</h2>
    <table>
        <thead>
        <tr>
            <%
                DataFrame df = (DataFrame) request.getAttribute("dataFrame");
                List<String> columnNames = df.getColumnNames();
                for (String columnName : columnNames) {
            %>
            <th><%= columnName %></th>
            <%
                }
            %>
        </tr>
        </thead>
        <tbody>
        <%
            int rowCount = df.getRowCount();
            for (int row = 0; row < rowCount; row++) {
        %>
        <tr>
            <%
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
        %>
        </tbody>
    </table>
</div>
</body>
</html>
