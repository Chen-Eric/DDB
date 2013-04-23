function build_Description_SELECT_BOX(foodChapter) {
	console.log(foodChapter);
	var url = "FCDB_Food/showSelectedFoodDescription";
	var param = {
			foodChapter : foodChapter
	};
	$.post(url, param, function(data) {
		console.log("Data from Server:" + data);
		$("#fcdbFoodDescription").html(data);
	});
}