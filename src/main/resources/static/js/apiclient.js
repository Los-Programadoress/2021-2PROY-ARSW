var apiclient = (function () {

    var addGameRoom = function(gameRoom){
		return $.ajax({
            url: "/https://lacman.herokuapp.com/lacman",
            type: "POST",
            data: JSON.stringify(gameRoom),
            contentType: "application/json",
        });
    }

    var getPasscodeByName = function (name){
        axios({
            method:'get',
            url: "/https://lacman.herokuapp.com/lacman/"+name,
        }).then(response=> Module.showPasscode(response.data))
            .catch(error=> console.log(error));
    };

	return {
        addGameRoom: addGameRoom,
        getPasscodeByName: getPasscodeByName
    }
})();