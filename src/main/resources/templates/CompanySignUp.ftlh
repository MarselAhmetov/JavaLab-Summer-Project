<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация Работодателя</title>
    <#include "common/head-common.ftlh">
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/signUp.css">
    <script src="/js/signUp.js"></script>
</head>

<body class="body">
<div class="bg-image"></div>
<main class="content_wrapper">
    <div class="back_wrapper">
        <a href="/signUp" class="back link"><- Назад</a>
    </div>
    <div class="title_wrapper">
        <h2 class="title">Регистрация</h2>
    </div>
    <div class="form_wrapper">
        <form action="/signUp/company" method="POST" class="form">
            <div class="input_wrapper">
                <label class="input_label">Название организации</label>
                <input type="text" name="name" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Адрес оргацизации</label>
                <input type="text" name="address" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Описание</label>
                <textarea type="text" name="description" class="input" rows="3"></textarea>
            </div>
            <div class="input_wrapper">
                <label class="input_label">Имя пользователя</label>
                <input type="text" name="username" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Электронная почта</label>
                <input type="email" name="email" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Пароль</label>
                <input type="password" name="password" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Подтвердите пароль</label>
                <input type="password" name="confirmPassword" class="input" />
            </div>
            <div class="input_wrapper submit_button_wrapper">
                <input type="submit" class="submit_button" value="Зарегистрироваться">
            </div>
        </form>
        <div class="else">
            <a class="link" href="/signIn">Уже есть аккаунт?</a>
        </div>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</body>

</html>