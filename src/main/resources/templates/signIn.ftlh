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
            <div class="alternatives_wrapper">
                <form action="https://github.com/login/oauth/authorize" method="GET">
                    <input hidden type="text" name="client_id" value="3849d58cb5cf51a635fb">
                    <div class="input_wrapper">
                        <div class="input_wrapper submit_button_wrapper">
                            <button onclick="(event) => event.submit();" class="github_submit_button">Войти с помощью
                                GitHub<img alt="" width="24" height="24" src="../assets/github_logo.svg">
                            </button>
                        </div>
                </form>
                <!--TODO: fix gitlab login -->
                <form action=https://gitlab.example.com/oauth/authorize" method="GET">
                    <input hidden type="text" name="client_id" value="4c1ec1c3abdabd342377eab257c39d16063d0d96d9b0e87e519e8376b4c47679">
                    <div class="input_wrapper">
                        <div class="input_wrapper submit_button_wrapper">
                            <button onclick="(event) => event.submit();" class="github_submit_button">Войти с помощью
                                GitLab<img width="24" height="24" src="../assets/GitLab_Logo.svg" alt="">
                            </button>
                        </div>
                </form>
            </div>
            <div class="else">
                <a class="link" href="/signUp">Нет аккаунта?</a>
            </div>
        </div>
    </main>
</body>

</html>