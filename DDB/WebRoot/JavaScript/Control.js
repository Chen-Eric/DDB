$(document).ready(function() {

	/**
	 * For selection of columns.
	 */
	$("#SubjectGrid").subscribe('showcolumns', function(event, data) {
		// console.log("Comming soon!");
		$.struts2_jquery.require("js/plugins/grid.setcolumns.js");
		$("#SubjectGrid").jqGrid('setColumns', {}); // alternatively, may use new widget: Column Chooser.
	});

	/**
	 * jquery lib requirements for datatimepicker.
	 */
	$.struts2_jquery.require("js/plugins/jquery-ui-timepicker-addon.min.js");
	// Initialization of DatePicker.
	datepicker = function(element) {
		$(element).datepicker({
			dateFormat : 'yy-mm-dd',
			buttonImage : "calendar.gif",
			buttonImageOnly : true,
			zIndex : '1004'
		});
	};
	// Initialization of DateTimePicker.
	datetimepicker = function(element) {
		$(element).datetimepicker({
			dateFormat : 'yy-m-dd',
			buttonImage : "calendar.gif",
			buttonImageOnly : 'true',
			zIndex : '1004'
		});
	};

	// Function for display FDs & ADs according to the subscription from SubjectGrid_Row_Select_Event.
	$("#SubjectGrid").subscribe('SubjectRowSelect', function(event, data) {
		console.log("SubjectRowSelect:" + event.originalEvent.id);
		$("#SubjectGrid").data("selectedSubjectID", event.originalEvent.id);
		$("#subjectgridinfo").html('<p>Selected Row : ' + event.originalEvent.id + '</p>');

		// Function for display subject's FDs.
		$("#FDGrid").jqGrid('setGridParam', {
			url : 'FoodDiary/showFoodDiaries',
			postData : {
				subjectID : event.originalEvent.id
			},
			jsonReader : {
				id : 'id.id'
			}
		}).trigger('reloadGrid');

		// Function for display subject's ADs.
		$("#ADGrid").jqGrid('setGridParam', {
			url : 'ActivityDiary/showActivityDiaries',
			postData : {
				subjectID : event.originalEvent.id
			},
			jsonReader : {
				id : 'id.id'
			}
		}).trigger('reloadGrid');
	});

	// Function for display Meals in a FoodDiary from FDGrid_Row_Select_Event.
	$("#FDGrid").subscribe('FDRowRelect', function(event, data) {
		console.log("FDRowRelect:" + event.originalEvent.id);
		$("#FDGrid").data("selectedFDID", event.originalEvent.id);
		$("#FDgridinfo").html('<p>Selected Row : ' + event.originalEvent.id + '</p>');
		$("#FDMealGrid").jqGrid('setGridParam', {
			url : 'FoodDiary/showFDMeals',
			postData : {
				subjectID : $("#SubjectGrid").data("selectedSubjectID"),
				fdID : event.originalEvent.id
			},
			jsonReader : {
				id : 'id.id'
			}
		}).trigger('reloadGrid');
	});

	// Function for display Food in a Meal from MealGrid_Row_Select_Event.
	$("#FDMealGrid").subscribe('FDMealRowSelect', function(event, data) {
		$("#FDMealGrid").data("selectedMealID", event.originalEvent.id);
		console.log("selectedMealID:" + $("#FDMealGrid").data("selectedMealID"));
		$("#MealFoodGrid").jqGrid('setGridParam', {
			url : 'FoodDiary/showMealFood',
			postData : {
				subjectID : $("#SubjectGrid").data("selectedSubjectID"),
				fdID : $("#FDGrid").data("selectedFDID"),
				mealID : $("#FDMealGrid").data("selectedMealID")
			},
			jsonReader : {
				id : 'id.id'
			}
		}).trigger('reloadGrid').ajaxComplete(function() {
			$("#fcdbFoodChapter").change(function(event) {
				console.log("Selected Food Chapter: " + $("#fcdbFoodChapter option:selected").text());
				build_Description_SELECT_BOX($("#fcdbFoodChapter option:selected").text());
			});
			$("#fcdbFoodDescription").change(function(event) {
				$("#fcdbFoodId").attr('value', $("#fcdbFoodDescription option:selected").attr("id"));
				console.log("selectedFcdbFoodID:" + $("#fcdbFoodDescription option:selected").attr("id"));
			});
		});
	});

	// Function for display Activities in a ActivityDiary from ADGrid_Row_Select_Event.
	$("#ADGrid").subscribe('ADRowSelect', function(event, data) {
		console.log("ADRowSelect:" + event.originalEvent.id);
		$("#ADGrid").data("selectedADID", event.originalEvent.id);
		$("#ADgridinfo").html('<p>Selected Row : ' + event.originalEvent.id + '</p>');

		// Function for display AD's Activities.
		$("#ADActivityGrid").jqGrid('setGridParam', {
			url : 'ActivityDiary/showADActivities',
			postData : {
				subjectID : $("#SubjectGrid").data("selectedSubjectID"),
				adID : event.originalEvent.id,
			},
			jsonReader : {
				id : 'id.id'
			},
		// TODO Bind Sub-Select box properly. Now just work on second click on the add_button. This sucks...
		}).trigger('reloadGrid').ajaxComplete(function() {
			$("#majorHeading").change(function(event) {
				console.log("Selected Major Heading: " + $("#majorHeading option:selected").text());
				build_Specific_SELECT_BOX($("#majorHeading option:selected").text());
			});
			$("#specificActivity").change(function(event) {
				$("#cpadbActivityId").attr('value', $("#specificActivity option:selected").attr("id"));
				console.log("selectedCpadbActivityID:" + $("#specificActivity option:selected").attr("id"));
			});
		});
	});

	$("#SubjectGrid").subscribe('oneditsuccess', function(event, data) {
		var message = event.originalEvent.response.statusText;
		$("#gridinfo").html('<p>Status: ' + message + '</p>');
	});

	// Doesnt work.
	$("#SubjectGrid").subscribe('SSS', function(event, data) {
		console.log(SSS);
	});
	$("#SubjectGrid").subscribe('searchgrid', function(event, data) {
		$("#gridedittable").jqGrid('searchGrid', {
			sopt : [ 'cn', 'bw', 'eq', 'ne', 'lt', 'gt', 'ew' ]
		});
	});

	$("#majorHeading").subscribe('majorHeadingChanged', function(event, data) {
		console.log("majorHeadingChanged");
	});

	$.subscribe('majorHeadingTest', function(event, data) {
		console.log("majorHeadingTest");
	});

});