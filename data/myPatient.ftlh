<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Books</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <meta content="ie=edge" http-equiv="X-UA-Compatible">
  <title>Books</title>
  <link href="css/freemarker.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid" >

  <table class="table">
    <thead>
    <tr>
      <th scope="col">Имя</th>
      <th scope="col">Фамилия</th>
      <th scope="col">День Рождения</th>
      <th scope="col">Тип болезни</th>
      <th scope="col">Краткий анализ</th>
    </tr>
    </thead>
    <tbody>
    <#list days as day>
      <#list patients as patient>
      <#if patient.type>
    <tr style="background-color: red">
      <td>${patient.name}</td>
      <td>${patient.lastName}</td>
      <td>${patient.date}</td>
        <td>${patient.type?string("тяжело","нормально")}</td>
      <td><p><a href="books/bookInfo" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">Info</a></p></td>
        <#else>
          <tr style="background-color: red">
          <td>${patient.name}</td>
          <td>${patient.lastName}</td>
          <td>${patient.date}</td>
          <td>${patient.type?string("тяжело","нормально")}</td>
          <td><p><a href="books/bookInfo" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">Info</a></p></td>

      </#if>
    </tr>

      </#list>
    </#list>

</div>
</tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>