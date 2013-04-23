function test() {
	var url = "Accuracy/showAllAccuracies";
	$.post(url, showData);
}

function showData(data) {
	console.log(data);
}
