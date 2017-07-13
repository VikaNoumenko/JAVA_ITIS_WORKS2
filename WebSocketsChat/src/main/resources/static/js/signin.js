function login(login, password) {
    $.ajax({
        url: 'http://localhost:8080/login',
        type: 'post',
        headers: {
            login: login,
            password: password
        },
        success: function (data, textStatus, request) {
            token = request.getResponseHeader('Auth-Token');
            document.cookie = "Auth-Token=" + token;
            if (token !== null) {
                window.location = "http://localhost:8080/chat.html";
            }
        }
    })
}