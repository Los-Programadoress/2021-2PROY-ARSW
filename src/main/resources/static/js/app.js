var Module = (function () {
    var url = "js/apiclient.js";

    const _getCode = function (passcode) {
        let pass = passcode;
        console.log(pass);
        document.getElementById("getpasscode").innerHTML = passcode;
        document.getElementById("ready").innerHTML = "¡Código de acceso asignado!";
    };

    var addGameRoom = function(){
        var name = $("#newname").val();
        var passcode = $("#newpasscode").val();
        var gameRoom = { name: name, passcode: passcode };
        apiclient.addGameRoom(gameRoom).then(
            function () {
                getPasscodeByName();
            },
            function () {
                alert("failed!");
            }
		);
    };

    var getPasscodeByName = function(){
        $.getScript(url, function () {
            var name=$("#newname").val();
            document.getElementById("getpasscode").innerHTML = name;
            document.getElementById("ready").innerHTML = "¡Código de acceso asignado!";
            apiclient.getPasscodeByName(name);
        });
    };

    return{
        addGameRoom: addGameRoom,
    }
})();