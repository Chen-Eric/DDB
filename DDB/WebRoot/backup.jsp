<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" type="text/css" href="CSS/page.css">


</head>

<body>
	<s:url var="ShowFoodDiariesActionURL" action="showFoodDiaries"
		namespace="FoodDiary" />
	<s:url var="EditFoodDiaryActionURL" action="editFoodDiary"
		namespace="FoodDiary" />
	<strong>Food Diaries here.</strong>
	<sjg:grid gridModel="FDGridModel" id="FDGrid" autowidth="true"
		loadonce="false" resizable="true" height="200"
		caption="Food Diary Gird" dataType="json"
		editurl="%{EditFoodDiaryActionURL}" viewrecords="true"
		rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
		navigator="true" navigatorAdd="true"
		navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		navigatorAddOptions="{height:'550', 'width':'500', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
		navigatorEditOptions="{'height':'550', 'reloadAfterSubmit':'false'}"
		navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true', }"
		navigatorEdit="true" navigatorView="true" navigatorDelete="true"
		onSelectRowTopics="FDRowRelect"
		onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
		<sjg:gridColumn name="id.id" index="id.id" title="ID" editable="false"
			formatter="integer" width="30" sortable="true" />
		<sjg:gridColumn name="name" index="name" title="DiaryName"
			editable="true" sortable="true" />
		<sjg:gridColumn name="note" index="note" title="Note" editable="true"
			sortable="true" />
		<sjg:gridColumn name="accuracyId" index="accuracyId" title="Accuracy"
			editable="true" sortable="true" edittype="select"
			editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
		<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
			editable="true" disabled="false"
			editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
			editable="true" disabled="false"
			editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
			editable="false" disabled="false" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="lastUpdate" index="lastUpdate" editable="false"
			disabled="false" title="LastUpdate" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
	</sjg:grid>
	<div id="FDgridinfo" class="ui-widget-content ui-corner-all">
		<p>Selected FD Row :</p>
	</div>
	<strong>Meals here.</strong>
	<s:url var="ShowFDMealsActionURL" action="showFDMeals"
		namespace="FoodDiary" />
	<s:url var="EditFDMealActionURL" action="editFDMeal"
		namespace="FoodDiary" />
	<sjg:grid gridModel="FDMealGridModel" id="FDMealGrid" autowidth="true"
		loadonce="false" resizable="true" height="200" caption="Meal Gird"
		dataType="json" editurl="%{EditFDMealActionURL}" viewrecords="true"
		rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
		navigator="true" navigatorAdd="true"
		navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		navigatorAddOptions="{height:'550', 'width':'400', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
		navigatorEditOptions="{'height':'550', 'reloadAfterSubmit':'false'}"
		navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true', }"
		navigatorEdit="true" navigatorView="true" navigatorDelete="true"
		onSelectRowTopics="FDMealRowSelect"
		onBeforeTopics="beforeLoad_FDMealGrid"
		onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
		<sjg:gridColumn name="id.id" index="id" title="ID" formatter="integer"
			width="30" sortable="true" />
		<sjg:gridColumn name="name" index="name" title="MealName"
			editable="true" sortable="true" />
		<sjg:gridColumn name="info" index="info" title="MealInfo"
			editable="true" sortable="true" />
		<sjg:gridColumn name="accuracyId" index="accuracyID" title="Accuracy"
			editable="true" sortable="true" edittype="select"
			editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
		<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
			disabled="false" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="lastUpdate" index="lastUpdate" disabled="false"
			title="LastUpdate" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
	</sjg:grid>
	<div id="FDMealgridinfo" class="ui-widget-content ui-corner-all">
		<p>Selected Meal Row :</p>
	</div>

	<strong>Food here.</strong>
	<s:url var="ShowMealFoodActionURL" action="showFDMeals"
		namespace="FoodDiary" />
	<s:url var="EditMealFoodActionURL" action="editFDMeal"
		namespace="FoodDiary" />
	<sjg:grid gridModel="FDMealGridModel" id="MealFoodGrid"
		autowidth="true" loadonce="false" resizable="true" height="200"
		caption="Food Gird" dataType="json" draggable="true"
		editurl="%{EditMealFoodActionURL}" viewrecords="true"
		rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
		navigator="true" navigatorAdd="true"
		navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		navigatorAddOptions="{height:'550', 'width':'400', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
		navigatorEditOptions="{'height':'550', 'reloadAfterSubmit':'false'}"
		navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true', }"
		navigatorEdit="true" navigatorView="true" navigatorDelete="true"
		onSelectRowTopics="MealRowSelect"
		onBeforeTopics="beforeLoad_FDMealGrid"
		onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
		<sjg:gridColumn name="id.id" index="id" title="ID" formatter="integer"
			width="30" sortable="true" />
		<sjg:gridColumn name="foodID" index="foodID" title="foodID"
			editable="true" sortable="true" />
		<sjg:gridColumn name="recipe" index="recipe" title="recipe"
			editable="true" sortable="true" />
		<sjg:gridColumn name="accuracyId" index="accuracyID" title="Accuracy"
			editable="true" sortable="true" edittype="select"
			editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
		<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
			disabled="false" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="lastUpdate" index="lastUpdate" disabled="false"
			title="LastUpdate" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
	</sjg:grid>
	<div id="MealFoodgridinfo" class="ui-widget-content ui-corner-all">
		<p>Selected Food Row :</p>
	</div>
	<!--  -->

	<strong>ActivityDiaries here.</strong>
	<div id="ActivityDiaryErrorMessage" class="ErrorMessage"></div>
	<s:url var="ShowActivityDiariesActionURL" action="showActivityDiaries"
		namespace="ActivityDiary" />
	<s:url var="EditActivityActionURL" action="editActivityDiary"
		namespace="ActivityDiary" />
	<sjg:grid gridModel="ADGridModel" id="ADGrid" autowidth="true"
		loadonce="false" resizable="true" height="200"
		caption="Activity Diary Gird" dataType="json"
		editurl="%{EditActivityActionURL}" viewrecords="true"
		rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
		navigator="true" navigatorAdd="true"
		navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		navigatorAddOptions="{height:'550', 'width':'400', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
		navigatorEditOptions="{'height':'550', 'reloadAfterSubmit':'false'}"
		navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true', }"
		navigatorEdit="true" navigatorView="true" navigatorDelete="true"
		onSelectRowTopics="ADRowSelect"
		onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
		<sjg:gridColumn name="id.id" index="id" title="ID" formatter="integer"
			width="30" sortable="true" />
		<sjg:gridColumn name="name" index="name" title="DiaryName"
			editable="true" sortable="true" />
		<sjg:gridColumn name="note" index="note" title="Note" editable="true"
			sortable="true" />
		<sjg:gridColumn name="accuracyId" index="accuracyId" title="Accuracy"
			editable="true" sortable="true" edittype="select"
			editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
		<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
			editable="true" disabled="false"
			editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
			editable="true" disabled="false"
			editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
			editable="false" disabled="false" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="lastUpdate" index="lastUpdate" editable="false"
			disabled="false" title="LastUpdate" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
	</sjg:grid>
	<div id="ADgridinfo" class="ui-widget-content ui-corner-all">
		<p>Selected AD Row :</p>
	</div>
	<strong>Activities here.</strong>
	<div id="ActivityErrorMessage" class="ErrorMessage"></div>
	<s:url var="ShowADActivitiesActionURL" action="showADActivities"
		namespace="ActivityDiary" />
	<s:url var="EditADActivityActionURL" action="editADActivities"
		namespace="ActivityDiary" />
	<sjg:grid gridModel="ADActivityGridModel" id="ADActivityGrid"
		autowidth="true" loadonce="false" resizable="true" height="200"
		caption="Activity Gird" dataType="json"
		editurl="%{EditADActivityActionURL}" viewrecords="true"
		rowList="2,5,10,15,20" rowNum="5" rownumbers="true" pager="true"
		navigator="true" navigatorAdd="true"
		navigatorSearchOptions="{sopt:['eq','ne','lt','gt']}"
		navigatorAddOptions="{height:'550', 'width':'400', 'reloadAfterSubmit':'true', 'closeAfterAdd':'true'}"
		navigatorEditOptions="{'height':'550', 'reloadAfterSubmit':'false'}"
		navigatorDeleteOptions="{'height':'250', 'width':'400', 'reloadAfterSubmit':'true'}"
		navigatorEdit="true" navigatorView="true" navigatorDelete="true"
		onSelectRowTopics="ADActivityRowSelect"
		onEditInlineSuccessTopics="oneditsuccess" shrinkToFit="false">
		<sjg:gridColumn name="id.id" index="id" title="ID" formatter="integer"
			width="30" sortable="true" />
		<sjg:gridColumn name="name" index="name" title="DiaryName"
			editable="true" sortable="true" />
		<sjg:gridColumn name="note" index="note" title="Note" editable="true"
			sortable="true" />
		<sjg:gridColumn name="accuracyId" index="accuracyId" title="Accuracy"
			editable="true" sortable="true" edittype="select"
			editoptions="{dataUrl:'%{selectAccuraciesURL}'}" />
		<sjg:gridColumn name="starttime" index="starttime" title="StratTime"
			disabled="false" editable="true"
			editoptions="{dataInit:datetimepicker, attr:{title:'Start Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="endtime" index="endtime" title="EndTime"
			editable="true" disabled="false"
			editoptions="{dataInit:datetimepicker, attr:{title:'End Time:'}}"
			formatter="date" formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="addtime" index="addtime" title="AddTime"
			disabled="false" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
		<sjg:gridColumn name="lastUpdate" index="lastUpdate" disabled="false"
			title="LastUpdate" formatter="date"
			formatoptions="{'newformat':'Y-m-d H:i:s'}" />
	</sjg:grid>
	<div id="ADActivitygridinfo" class="ui-widget-content ui-corner-all">
		<p>Selected AD Row :</p>
	</div>

</body>
</html>
