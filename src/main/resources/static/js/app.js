var Module = (function () {
    const showPasscode = function () {
        var passcode = $("#newpasscode").val();
        if(passcode.length<4){
            document.getElementById("ready").innerHTML = "¡Código minimo de cuatro digitos!";
        }
        else{
            document.getElementById("getpasscode").innerHTML = passcode;
            document.getElementById("ready").innerHTML = "¡Código de acceso asignado!";
        }
    };

    var addGameRoom = function(){
        var name = $("#newname").val();
        var passcode = $("#newpasscode").val();
        if(passcode.length>3){
            var gameRoom = { name: name, passcode: passcode };
            apiclient.addGameRoom(gameRoom).then(
                function () {
                    window.location.href='https://lacman-react.herokuapp.com/';
                },
                function () {
                    alert("failed!");
                }
            ); 
        }
        else{
            alert("passcode minimo de 4 digitos");
        }
    };

    var getPasscodeByName = function(){
        var name = $("#newname").val();
        apiclient.getPasscodeByName(name);
    };

    var isPasscode = function(){
        var passcode = $("#joinpasscode").val();
        apiclient.isPasscode(passcode).then(
            function () {
                window.location.href='https://lacman-react.herokuapp.com/';
            },
            function () {
                alert("invalid passcode");
            }
		);
    };

    return{
        getPasscodeByName: getPasscodeByName,
        addGameRoom: addGameRoom,
        showPasscode: showPasscode,
        isPasscode: isPasscode
    }
})();