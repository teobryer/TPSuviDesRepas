<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Téo
  Date: 25/03/2021
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(System.currentTimeMillis());
    String dateJour = formatter.format(date); %>
<html>
<head>
    <title>Ajouter un repas</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="/administration/decoration/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

</head>
<body>
<div class="row justify-content-center">
    <h1 class="col-8 mt-4 mb-4 text-center">Ajout d'un repas</h1>
</div>


<form method="post" action="AjoutRepas">
    <div class="form-group row justify-content-center">
        <label for="example-date-input" class="col-1 col-form-label text-right">Date</label>
        <div class="col-4 ">
            <input class="form-control" type="date" value="<%=dateJour%>" name="dateRepas" id="example-date-input">
        </div>
    </div>

    <div class="form-group row justify-content-center">
        <label for="example-time-input" class="col-1 col-form-label text-right">Heure</label>
        <div class="col-4">
            <input class="form-control" type="time"  name="heureRepas"  value="13:45:00" id="example-time-input">
        </div>
    </div>

    <div class="form-group row justify-content-center" >


            <label for="example-time-input" class="col-1 col-form-label text-right">Repas</label>
            <div  class="col-4 ">
                <textarea class="form-control" id="exampleFormControlTextarea1"  name="aliments"  ></textarea>
            </div>


    </div>

    <div class="form-group row justify-content-center" >

        <div  class="col-2 ">
            <button class="form-control" id="btnAnnuler" >Annuler</button>
        </div>
        <div  class="col-2 ">
            <button type="submit" class="form-control" id="btnvValider" >Valider</button>
        </div>


    </div>
</form>

</body>
</html>
