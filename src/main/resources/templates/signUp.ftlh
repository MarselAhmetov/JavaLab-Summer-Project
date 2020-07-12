<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/signUp.css">
</head>

<body class="body">
<div class="bg-image"></div>
<main class="content_wrapper">
    <div class="title_wrapper">
        <h2 class="title">Регистрация</h2>
    </div>
    <div class="form_wrapper">
        <form action="/signUp" method="POST" class="form">
            <div class="input_wrapper">
                <label class="input_label">Имя</label>
                <input type="text" name="name" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Фамилия</label>
                <input type="text" name="surname" class="input" />
            </div>
            <div class="input_wrapper">
                <label class="input_label">Отчество (если есть)</label>
                <input type="text" name="patronymic" class="input" />
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
            <div class="input_label_wrapper">
                <label class="input_label">Кто вы?</label>
            </div>
            <div class="checkboxes">
                <label class="checkbox_label">
                    <input type="checkbox" name="student">Я студент
                </label>
                <label class="checkbox_label">
                    <input type="checkbox" name="teacher">Я преподаватель
                </label>
                <label class="checkbox_label">
                    <input type="checkbox" name="employer">Я работодатель
                </label>

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