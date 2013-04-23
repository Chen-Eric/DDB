$(document).ready(function() {
	$("#FDMealGrid").subscribe('beforeLoad_FDMealGrid', function(event, data) {
		// Function for set Accuracy Column for FD_Grid.
		console.log(event);
		$("#myGrid").jqGrid("GridUnload");
		var newFDColModel = $("#FDMealGrid").jqGrid('getGridParam', "colModel").concat({
			name:'accuracyId',
			index:'accuracyId',
			Title:'Accuracy',
			editable:true,
			edittype:'select',
			editoptions:{
				dataUrl : 'Accuracy/showAllAccuracies',
				buildSelect : function(response) {
					console.log(response);
					var s = '<select>';
                    if (response && response.length) {
                        for (var i = 0, l=response.length; i<l ; i++) {
                            var ri = response[i];
                            s += '<option value="'+ri+'">'+ri+'</option>';
                        }
                    }
                    return s + "</select>";
				} 
			}
		});
		$("#myGrid").jqGrid("setGridParam", {colModel: newFDColModel}).trigger("reloadGrid");
	});
	
});