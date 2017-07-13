function showStatus(status) {

}
// описываем функцию работы с вебсокетами
jQuery(function ($) {
    var token;

    // функция вывода статуса
    function writeStatus(message) {
        $("#statusOutput").val($("#statusOutput").val() + message + '\n');
    }

    // запись сообщения
    function writeMessage(message) {
        $('#messageOutput').append(message + '\n');
    }

    // подключения
    $('#connect')
        .click(function doConnect() {
            // создается объект websocket
            websocket = new WebSocket("ws://localhost:8080/authHandler");
            // при подключении написать CONNECTED
            websocket.onopen = function (evt) {
                var token = getCookie("Auth-Token");
                if (typeof websocket != 'undefined') {
                    websocket.send(token + " " + "1" + " " + $('#message').val());
                } else {
                    alert("Not connected.");
                }
                writeStatus("CONNECTED");
            };

            websocket.onclose = function (evt) {
                writeStatus("DISCONNECTED");
            };

            websocket.onmessage = function (evt) {
                writeMessage(evt.data);
            };

            websocket.onerror = function (evt) {
                onError(writeStatus('ERROR:' + evt.data))
            };
        });


    $('#disconnect')
        .click(function () {
            if (typeof websocket != 'undefined') {
                websocket.close();
                websocket = undefined;
            } else {
                alert("Not connected.");
            }

        });

    $('#send')
        .click(function () {
            var json = {};
            json["message"] = $("#message").val();
            $.ajax({
                url: 'http://localhost:8080/chats/1/messages',
                type: 'post',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                headers: {
                    'Auth-Token': getCookie("Auth-Token")
                },
                data: JSON.stringify(json),
                success: function (data) {
                    alert(data);
                },
                failure: function (errMsg) {
                    alert(errMsg);
                }
            })
        });

    function getCookie(name) {
        var matches = document.cookie.match(new RegExp(
            "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }
});