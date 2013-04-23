function build_Specific_SELECT_BOX(majorHeading) {
	console.log(majorHeading);
	var url = "CPADB_Activity/showSelectSpecificActivities";
	var param = {
			majorHeading : majorHeading
	};
	$.post(url, param, function(data) {
		console.log("Data from Server:" + data);
		$("#specificActivity").html(data);
	});
}