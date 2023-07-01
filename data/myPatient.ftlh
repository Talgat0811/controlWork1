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
<div class="container-fluid">

        <#list patients as patient>
            <p>Имя: ${patient.name}</p>
            <p> Фамилия:  ${patient.lastName}</p>
            <p> Дата Рождения: ${patient.date}</p>
            <p> Время: ${patient.time}</p>
            <#if patient.type>
                <p style="background-color: red">Тип болезни: ${patient.type?string("тяжело","нормально")}</p>
            <#else>
                <p style="background-color: aquamarine">Тип болезни: ${patient.type?string("тяжело","нормально")}</p>
            </#if>
            <p>Краткий анализ: ${patient.analyze}</p>
            <hr>
        </#list>
</div>
</tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>