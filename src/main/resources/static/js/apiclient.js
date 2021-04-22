var apiclient = (function () {

    var addGameRoom = function(gameRoom){
		return $.ajax({
            url: "http://lacman.herokuapp/lacman",
            type: "POST",
            data: JSON.stringify(gameRoom),
            contentType: "application/json",
        });
    };

    var getPasscodeByName = function (name){
        axios({
            method:'get',
            url: "http://lacman.herokuapp/lacman/"+name,
        }).then(response=> Module.showPasscode(response.data))
            .catch(error=> console.log(error));
    };

    var isPasscode = function(passcode){
        return $.ajax({
            url: "http://lacman.herokuapp/lacman/passcode",
            type: "POST",
            data: passcode,
            contentType: "application/json",
        });
    };

	return {
        addGameRoom: addGameRoom,
        getPasscodeByName: getPasscodeByName,
        isPasscode: isPasscode
    }
})();