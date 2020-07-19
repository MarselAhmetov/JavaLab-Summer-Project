<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>

<body class="body">
<#include "header.ftlh">
<br>
<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <form action="/edit/company">
                <div class="form-group">
                    <input type="email" name="email" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Enter email" value="${company.user.email}">
                </div>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.user.username}">
                </div>
                <div class="form-group">
                    <input type="text" name="name" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.name}">
                </div>
                <div class="form-group">
                    <input type="text" name="address" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.address}">
                </div>
                <div class="form-group">
                    <input type="text" name="description" class="form-control" <#if !principal?? || principal.user.id != company.user.id> disabled</#if> placeholder="Text" value="${company.description}">
                </div>
                <#if principal?? && principal.user.id == company.user.id>
                    <input type="submit" class="btn btn-primary" placeholder="Submit">
                </#if>
            </form>
        </div>
        <div class="col-1"></div>
    </div>
</div>
</body>

</html>