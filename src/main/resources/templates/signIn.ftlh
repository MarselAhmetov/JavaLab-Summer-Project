<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Авторизация</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/signIn.css">
</head>

<body class="body">
    <div class="bg-image"></div>
    <main class="content_wrapper">
        <div class="title_wrapper">
            <h2 class="title">Авторизация</h2>
        </div>
        <div class="form_wrapper">
            <form action="/signIn" method="POST" class="form">
                <div class="input_wrapper">
                    <label class="input_label">Электронная почта</label>
                    <input type="email" name="email" class="input" />
                </div>
                <div class="input_wrapper">
                    <label class="input_label">Пароль</label>
                    <input type="password" name="password" class="input" />
                </div>
                <div class="input_wrapper submit_button_wrapper">
                    <input type="submit" class="submit_button" value="Войти">
                </div>
            </form>
            <div class="else">
                <a class="link" href="/signUp">Нет аккаунта?</a>
            </div>
        </div>
    </main>
</body>

</html>