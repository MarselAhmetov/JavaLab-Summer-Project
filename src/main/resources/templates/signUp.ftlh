<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/signUp.css">
    <title>Регистрация: Кем вы являетесь?</title>
</head>
<body class="body">
    <div class="bg-image"></div>
    <main class="content_wrapper">
        <div class="title_wrapper">
            <h2 class="title">Регистрация</h2>
            <h5>Кем вы являетесь?</h5>
        </div>
        <div class="items_wrapper">
            <div class="else">
                <a href="/signUp/student" class="link">Я студент</a>
            </div>
            <div class="else">
                <a href="/signUp/company"  class="link">Я работодатель</a>
            </div>
            <div class="else">
                <a href="/signUp/teacher"  class="link">Я преподаватель</a>
            </div>
        </div>
    </main>
</body>
</html>