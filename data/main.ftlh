<#import "layout.ftlh" as main>
<@main.layout title="Main">

<table class="table">
    <thead>
    <tr>
        <th scope="col">Days</th>
        <th scope="col">info</th>
    </tr>
    </thead>
    <tbody>
    <#list days as day>
    <tr>
        <td>${day.day} day</td>
        <td><p><a href="/myPatient?id=${day.day}" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">Info</a></p></td>
    </tr>
    </#list>
    </tbody>
</table>


</@main.layout>
