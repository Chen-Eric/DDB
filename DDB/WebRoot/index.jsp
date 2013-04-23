<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib uri="/struts-jquery-grid-tags" prefix="sjg"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Diary Management</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="CSS/page.css">
<link rel="stylesheet" type="text/css"
	href="struts/themes/jquery-ui-timepicker-addon.css">

<sj:head jqueryui="true" jquerytheme="start" debug="true"
	loadAtOnce="true" compressed="true" />

<script type="text/javascript"
	src="struts/js/plugins/jquery-ui-timepicker-addon.min.js?s2j=3.5.1 "></script>
<script type="text/javascript" src="JavaScript/Control.js"></script>
<script type="text/javascript" src="JavaScript/CPADB-SELECT-BOX.js"></script>
<script type="text/javascript" src="JavaScript/FCDB-SELECT-BOX.js"></script>
<script type="text/javascript" src="JavaScript/test.js"></script>

</head>

<body>
	<s:url var="selectAccuraciesURL" action="showAllAccuracies"
		namespace="Accuracy" />
	<s:url var="showActivityMajorHeadingsURL" action="showAllMajorHeadings"
		namespace="CPADB_Activity" />
	<s:url var="showFoodChaptersURL" namespace="FCDB_Food"
		action="showAllFoodChapters" />
	<div id="container">
		<div id="header">
			<h1>
				Food Intake and Activity Diary: <strong>${
					sessionScope.loginUserName }</strong>
			</h1>
		</div>
		<div id="SubjectGridDIV">
			<s:url var="ShowSubjectActionURL" action="showUserSubjects"
				namespace="Subject" />
			<s:url var="EditSubjectActionURL" action="editUserSubject"
				namespace="Subject" />
			<sjg:grid gridModel="subjectGridModel" id="SubjectGrid"
				loadonce="false" resizable="true" caption="Subject Grid"
				dataType="json" href="%{ShowSubjectActionURL}"
				editurl="%{EditSubjectActionURL}" viewrecords="true"
				rowList="2,5,10,15" rowNum="5" rownumbers="true" pager="true"
				navigator="true" navigatorAdd="true"
				navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
				navigatorAddOptions="{height:'550', 'width':'700', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true', 'zIndex':'1003'}"
				navigatorEditOptions="{'height':'550', 'width':'700','reloadAfterSubmit':'true','zIndex':'1003', }"
				navigatorDeleteOptions="{'height':'250', 'width':'700', 'reloadAfterSubmit':'true', 'zIndex':'1003'}"
				navigatorViewOptions="{'width':'750'}"
				navigatorEdit="true" navigatorView="true" navigatorDelete="true"
				onSelectRowTopics="SubjectRowSelect"
				navigatorExtraButtons="{seperator: { title : 'seperator' }, 
				hide : { title : 'Show/Hide', icon: 'ui-icon-wrench', topic: 'showcolumns' },
				alert : { title : 'Alert', onclick: function(){ alert('Grid Button clicked!') }}}"
				shrinkToFit="false">
				<sjg:gridColumn name="id" index="id" title="ID" formatter="integer"
					editable="false" width="30" sortable="true" hidden="true" />
				<sjg:gridColumn name="referenceID" index="referenceID"
					title="ReferenceID" width="110" sortable="false" editable="true" />
				<sjg:gridColumn name="sureName" index="sureName" title="FirstName"
					hidden="true" editrules="{edithidden:true}" width="100"
					sortable="false" editable="true" />
				<sjg:gridColumn name="familyName" index="familyName" hidden="true"
					editrules="{edithidden:true}" title="FamilyName" width="100"
					sortable="false" editable="true" />
				<sjg:gridColumn name="gender" index="gender" title="Gender"
					editable="true" edittype="select" onChangeTopics="SSS"
					editoptions="{value:'Male:Male;Female:Female'}" />
				<sjg:gridColumn name="special" index="special" title="Special"
					editable="true" />
				<sjg:gridColumn name="dob" index="dob" title="D.o.B" editable="true"
					formatter="date" formatoptions="{'newformat':'Y-m-d'}"
					editoptions="{dataInit:datepicker, attr:{title:'Select the D.o.B:'}}" />
				<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
					hidden="false" editable="false" formatter="date" width="200"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="lastupdate" index="lastupdate" width="200"
					title="LastUpdate" hidden="false" editable="false" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="height" index="height" title="Height"
					editable="true" />
				<sjg:gridColumn name="weight" index="weight" title="weight"
					editable="true" />
				<sjg:gridColumn name="mobile" index="mobile" title="mobile"
					editable="true" />
			</sjg:grid>
			<div id="subjectgridinfo" class="ui-widget-content ui-corner-all">
				<p>Selected Subject in Row:</p>
			</div>
		</div>
		<div>
			<hr class="hr">
		</div>
		<div id="wrapper">
			<div id="content">
				<strong>Food in Meal</strong>
				<s:url var="ShowMealFoodActionURL" action="showMealFood"
					namespace="FoodDiary" />
				<s:url var="EditMealFoodActionURL" action="editMealFood"
					namespace="FoodDiary" />
				<sjg:grid gridModel="mealFoodGridModel" id="MealFoodGrid"
					autowidth="true" loadonce="false" resizable="true"
					caption="Food Grid" dataType="json" draggable="true"
					editurl="%{EditMealFoodActionURL}" viewrecords="true"
					rowList="2,5,10,15,20" rowNum="10" rownumbers="true" pager="true"
					navigator="true" navigatorAdd="true"
					navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
					navigatorAddOptions="{height:'550', 'width':'700', 'reloadAfterSubmit':true, 'closeAfterAdd':true, 'zIndex':'1003'}"
					navigatorEditOptions="{'height':'550', 'width':'700', 'reloadAfterSubmit':false, 'zIndex':'1003'}"
					navigatorDeleteOptions="{'height':'250', 'width':'700', 'reloadAfterSubmit':true, 'zIndex':'1003'}"
					navigatorViewOptions="{'height':'550', 'width':'750', 'closeOnEscape':true, 'zIndex':'1003'}"
					navigatorEdit="true" navigatorView="true" navigatorDelete="true"
					onSelectRowTopics="MealRowSelect"
					onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="true">
					<sjg:gridColumn name="id.id" index="id" title="ID" hidden="true"
						formatter="integer" width="30" sortable="true" />
					<sjg:gridColumn name="fcdbFoodId" index="fcdbFoodId"
						title="FcdbFoodId" hidden="true" editrules="{edithidden:true}"
						width="100" sortable="false" editable="true" />
					<sjg:gridColumn name="fcdbFoodChapter" index="fcdbFoodChapter"
						title="Food Chapter" editable="true" sortable="true"
						edittype="select" editoptions="{dataUrl:'%{showFoodChaptersURL}'}" />
					<sjg:gridColumn name="fcdbFoodDescription" index="fcdbFoodDescription"
						title="Food Description" editable="true" sortable="true"
						edittype="select"
						editoptions="{value:'default:--Select Food Description--'}" />
					<sjg:gridColumn name="recipe" index="recipe" title="Recipe"
						editable="true" sortable="true" />
					<sjg:gridColumn name="amount" index="amount" title="Amount"
						editable="true" sortable="true" />
					<sjg:gridColumn name="amountUnit" index="amountUnit" title="AmountUnit"
						editable="true" sortable="true" />
					<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
						disabled="false" formatter="date"
						formatoptions="{'newformat':'Y-m-d H:i:s'}" />
					<sjg:gridColumn name="lastUpdate" index="lastUpdate"
						disabled="false" title="LastUpdate" formatter="date"
						formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				</sjg:grid>
				<div id="MealFoodgridinfo" class="ui-widget-content ui-corner-all">
					<p>Selected Food Row :</p>
				</div>
			</div>
		</div>
		<div id="navigation">
			<strong>Meals</strong>
			<s:url var="ShowFDMealsActionURL" action="showFDMeals"
				namespace="FoodDiary" />
			<s:url var="EditFDMealActionURL" action="editFDMeal"
				namespace="FoodDiary" />
			<sjg:grid gridModel="FDMealGridModel" id="FDMealGrid"
				autowidth="true" loadonce="false" resizable="true"
				caption="Meal Grid" dataType="json" editurl="%{EditFDMealActionURL}"
				viewrecords="true" rowList="2,5,10,15,20" rowNum="5"
				rownumbers="true" pager="true" navigator="true" navigatorAdd="true"
				navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
				navigatorAddOptions="{height:'550', 'width':'500', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true', 'zIndex':'1003'}"
				navigatorEditOptions="{'height':'550','width':'500', 'reloadAfterSubmit':'false', 'zIndex':'1003'}"
				navigatorDeleteOptions="{'height':'250', 'width':'500', 'reloadAfterSubmit':'true', 'zIndex':'1003'}"
				navigatorEdit="true" navigatorView="true" navigatorDelete="true"
				onSelectRowTopics="FDMealRowSelect"
				onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
				<sjg:gridColumn name="id.id" index="id" title="ID" hidden="true"
					formatter="integer" width="30" sortable="true" />
				<sjg:gridColumn name="name" index="name" title="MealName"
					editable="true" sortable="true" />
				<sjg:gridColumn name="info" index="info" title="MealInfo"
					editable="true" sortable="true" />
				<sjg:gridColumn name="accuracyId" index="accuracyID"
					title="Accuracy" editable="true" sortable="true" edittype="select"
					editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
				<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
					disabled="false" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="lastUpdate" index="lastUpdate"
					disabled="false" title="LastUpdate" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
			</sjg:grid>
			<div id="FDMealgridinfo" class="ui-widget-content ui-corner-all">
				<p>Selected Meal Row :</p>
			</div>
			<hr class="hr">
			<strong>Activities</strong>
			<div id="ActivityErrorMessage" class="ErrorMessage"></div>
			<s:url var="ShowADActivitiesActionURL" action="showADActivities"
				namespace="ActivityDiary" />
			<s:url var="EditADActivityActionURL" action="editADActivity"
				namespace="ActivityDiary" />
			<sjg:grid gridModel="ADActivityGridModel" id="ADActivityGrid"
				autowidth="true" loadonce="false" resizable="true"
				caption="Activity Grid" dataType="json"
				editurl="%{EditADActivityActionURL}" viewrecords="true"
				rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
				navigator="true" navigatorAdd="true"
				navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
				navigatorAddOptions="{height:'650', 'width':'850', 'reloadAfterSubmit':true, 'closeAfterAdd':true, 'zIndex':'1003'}"
				navigatorEditOptions="{'height':'650', 'width':'850', 'reloadAfterSubmit':false, 'zIndex':'1003'}"
				navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':true, 'zIndex':'1003'}"
				navigatorViewOptions="{'height':'650', 'width':'750', 'closeOnEscape':true, 'zIndex':'1003'}"
				navigatorEdit="true" navigatorView="true" navigatorDelete="true"
				onSelectRowTopics="ADActivityRowSelect"
				onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
				<sjg:gridColumn name="id.id" index="id" title="ID" hidden="true"
					formatter="integer" width="30" sortable="true" />
				<sjg:gridColumn name="cpadbActivityId" index="cpadbActivityId"
					title="CpadbActivityId" hidden="true" editrules="{edithidden:true}"
					width="100" sortable="false" editable="true" />
				<sjg:gridColumn name="majorHeading" index="majorHeading"
					title="MajorHeading" editable="true" sortable="true"
					edittype="select"
					editoptions="{dataUrl:'%{showActivityMajorHeadingsURL}'}" />
				<sjg:gridColumn name="specificActivity" index="specificActivity"
					title="SpecificActivity" editable="true" sortable="true"
					edittype="select"
					editoptions="{value:'default:--Select Specific Activity--'}" />
				<sjg:gridColumn name="accuracyId" index="accuracyId"
					title="Accuracy" editable="true" sortable="true" edittype="select"
					editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
				<sjg:gridColumn name="note" index="note" title="Note"
					editable="true" sortable="true" />
				<sjg:gridColumn name="realtime" index="realtime" title="RealTime"
					disabled="false" editable="true"
					editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
					disabled="false" editable="true"
					editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
					editable="true" disabled="false"
					editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
					disabled="false" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="lastUpdate" index="lastUpdate"
					disabled="false" title="LastUpdate" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
			</sjg:grid>
			<div id="ADActivitygridinfo" class="ui-widget-content ui-corner-all">
				<p>Selected Activity Row :</p>
			</div>
		</div>
		<div id="extra">
			<strong>Food Diaries</strong>
			<div id="SubjectErrorMessage" align="right" class="ErrorMessage"></div>
			<s:url var="ShowFoodDiariesActionURL" action="showFoodDiaries"
				namespace="FoodDiary" />
			<s:url var="EditFoodDiaryActionURL" action="editFoodDiary"
				namespace="FoodDiary" />
			<sjg:grid gridModel="FDGridModel" id="FDGrid" autowidth="true"
				loadonce="false" resizable="true" caption="Food Diary Grid"
				dataType="json" editurl="%{EditFoodDiaryActionURL}"
				viewrecords="true" rowList="2,5,10,15,20" rowNum="5"
				rownumbers="true" pager="true" navigator="true" navigatorAdd="true"
				navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
				navigatorAddOptions="{height:'550', 'width':'500', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true', 'afterShowForm':'function(){ss}', 'zIndex':'1003'}"
				navigatorEditOptions="{'height':'550', 'width':'500', 'reloadAfterSubmit':'false', 'afterShowForm':'ss', 'zIndex':'1003'}"
				navigatorDeleteOptions="{'height':'250', 'width':'500', 'reloadAfterSubmit':'true', 'zIndex':'1003'}"
				navigatorEdit="true" navigatorView="true" navigatorDelete="true"
				onSelectRowTopics="FDRowRelect"
				onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
				<sjg:gridColumn name="id.id" index="id.id" title="ID" hidden="true"
					editable="false" formatter="integer" width="30" sortable="true" />
				<sjg:gridColumn name="name" index="name" title="DiaryName"
					required="true" editable="true" sortable="true" />
				<sjg:gridColumn name="note" index="note" title="Note"
					editable="true" sortable="true" />
				<sjg:gridColumn name="accuracyId" index="accuracyId"
					title="Accuracy" editable="true" sortable="true" edittype="select"
					editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
				<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
					editable="true" disabled="false"
					editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
					editable="true" disabled="false"
					editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
					editable="false" disabled="false" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="lastUpdate" index="lastUpdate"
					editable="false" disabled="false" title="LastUpdate"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
			</sjg:grid>
			<div id="FDgridinfo" class="ui-widget-content ui-corner-all">
				<p>Selected FD Row :</p>
			</div>
			<hr class="hr">
			<strong>Activity Diaries</strong>
			<div id="ActivityDiaryErrorMessage" class="ErrorMessage"></div>
			<s:url var="ShowActivityDiariesActionURL"
				action="showActivityDiaries" namespace="ActivityDiary" />
			<s:url var="EditActivityActionURL" action="editActivityDiary"
				namespace="ActivityDiary" />
			<sjg:grid gridModel="ADGridModel" id="ADGrid" autowidth="true"
				loadonce="false" resizable="true" caption="Activity Diary Grid"
				dataType="json" editurl="%{EditActivityActionURL}"
				viewrecords="true" rowList="2,5,10,15,20" rowNum="5"
				rownumbers="true" pager="true" navigator="true" navigatorAdd="true"
				navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
				navigatorAddOptions="{height:'550', 'width':'400', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
				navigatorEditOptions="{'height':'550', 'width':'400', 'reloadAfterSubmit':'false'}"
				navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true', }"
				navigatorEdit="true" navigatorView="true" navigatorDelete="true"
				onSelectRowTopics="ADRowSelect"
				onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
				<sjg:gridColumn name="id.id" index="id" title="ID" hidden="true"
					formatter="integer" width="30" sortable="true" />
				<sjg:gridColumn name="name" index="name" title="DiaryName"
					editable="true" sortable="true" />
				<sjg:gridColumn name="note" index="note" title="Note"
					editable="true" sortable="true" />
				<sjg:gridColumn name="accuracyId" index="accuracyId"
					title="Accuracy" editable="true" sortable="true" edittype="select"
					editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
				<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
					editable="true" disabled="false"
					editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
					editable="true" disabled="false"
					editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i'}" />
				<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
					editable="false" disabled="false" formatter="date"
					formatoptions="{'newformat':'Y-m-d H:i:s'}" />
				<sjg:gridColumn name="lastUpdate" index="lastUpdate"
					editable="false" disabled="false" title="LastUpdate"
					formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
			</sjg:grid>
			<div id="ADgridinfo" class="ui-widget-content ui-corner-all">
				<p>Selected AD Row :</p>
			</div>
		</div>
		<div id="footer">
			<p>
				The footer
				<s:debug></s:debug>
			</p>
		</div>
	</div>
</body>
</html>
