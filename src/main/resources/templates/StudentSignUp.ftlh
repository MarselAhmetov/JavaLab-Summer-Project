<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация Студента</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/signUp.css">
    <script src="/js/signUp.js"></script>
</head>

<body class="body">
<div class="bg-image"></div>
<main class="content_wrapper">
    <div class="back_wrapper">
        <a href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/signUp" class="back link"><- Назад</a>
    </div>
    <div class="title_wrapper">
        <h2 class="title">Регистрация</h2>
    </div>
    <div class="form_wrapper">
        <form action="http://34.71.144.13:8888/javalab-summer-project-0.0.1/signUp/student" method="POST" class="form">
            <div class="input_wrapper">
                <label class="input_label">Имя</label>
                <input type="text" name="firstName" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Фамилия</label>
                <input type="text" name="lastName" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Отчество (если есть)</label>
                <input type="text" name="middleName" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Дата рождения</label>
                <input type="date" name="dateOfBirth" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Имя пользователя</label>
                <input type="text" name="username" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Электронная почта</label>
                <input type="email" name="email" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Пароль</label>
                <input type="password" name="password" class="input form-control"/>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Подтвердите пароль</label>
                <input type="password" name="confirmPassword" class="input form-control"/>
            </div>
            <div class="checkboxes">
                <input type="checkbox" name="sex" value="male" class="mr-1">
                <label class="checkbox_label">Мужской</label>
                <input type="checkbox" name="sex" value="female" class="mr-1 ml-1">
                <label class="checkbox_label">Женский </label>
            </div>
            <div class="input_wrapper submit_button_wrapper">
                <input type="submit" class="submit_button btn btn-block" value="Зарегистрироваться">
            </div>
        </form>
        <div class="else">
            <a class="link" href="http://34.71.144.13:8888/javalab-summer-project-0.0.1/signIn">Уже есть аккаунт?</a>
        </div>
    </div>
</main>
</body>

</html>