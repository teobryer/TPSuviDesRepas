<%@ page import="bo.Repas" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 25/03/2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="/administration/decoration/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

</head>
<body>
<table class="table">
    <thead>
    <tr>

        <th scope="col">Date</th>
        <th scope="col">Heure</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Repas> listeRepas= (List<Repas>)  request.getAttribute("listeRepas");
        for (Repas r: listeRepas) {
            SimpleDateFormat formatterDate= new SimpleDateFormat("dd-MM-yyyy");
            String dateRepas = formatterDate.format(r.getDateRepas());
            SimpleDateFormat formatterHeure= new SimpleDateFormat("hh mm");
            String heureRepas = formatterDate.format(r.getDateRepas());
            out.print(
                    "<tr>"+
                    "<td>"+dateRepas+"</td>"+
                    "<td>"+heureRepas+"</td>"+
                    "<td>"+"<a href=\"google.fr\">  <button   id=\"btnConsulter\" >Consulter les repas </button></a>"+"</td>"+
                   " </tr>"
            );
        }

    %>
    </tbody>
</table>
</body>
</html>
