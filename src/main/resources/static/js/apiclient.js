var apiclient = (function () {

    var addGameRoom = function(gameRoom){
		return $.ajax({
            url: "https://lacman.herokuapp.com/lacman",
            type: "POST",
            data: JSON.stringify(gameRoom),
            contentType: "application/json",
        });
    }

    var getPasscodeByName = function (name, callback) {
        $.getJSON("https://lacman.herokuapp.com/lacman/" + name ,function (data) {
                callback(null,data);
            }
        );
    };

	return {
        addGameRoom: addGameRoom,
        getPasscodeByName: getPasscodeByName,
    }
})();