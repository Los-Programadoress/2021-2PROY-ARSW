var apiclient = (function () {

    var addGameRoom = function(gameRoom){
		return $.ajax({
            url: "http://localhost:8080/lacman",
            type: "POST",
            data: JSON.stringify(gameRoom),
            contentType: "application/json",
        });
    }

    var getPasscodeByName = function (name, callback) {
        $.getJSON("http://localhost:8080/lacman/" + name ,function (data) {
                callback(null,data);
            }
        );
    };

	return {
        addGameRoom: addGameRoom,
        getPasscodeByName: getPasscodeByName,
    }
})();