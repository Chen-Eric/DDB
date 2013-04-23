/**
 * 
 */
package util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.AccuracyService;
import service.impl.ActivityService;

import dao.impl.AccuracyDAO;
import dao.impl.ActivityDAO;
import dao.impl.ActivityDiaryDAO;
import dao.impl.CpadbActivityDAO;
import dao.impl.FcdbFoodDAO;
import dao.impl.FoodDAO;
import dao.impl.MealDAO;
import dao.impl.UserSubjectDAO;
import domain.Activity;
import domain.ActivityDiary;
import domain.Food;
import domain.FoodId;
import domain.MealId;

/**
 * @author Chen
 * 
 */
public class HStest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		AccuracyDAO accuracyDAO = (AccuracyDAO) ctx.getBean("AccuracyDAO");
//		AccuracyService accuracyService = (AccuracyService) ctx.getBean("AccuracyService");
//		UserSubjectDAO usDAO = (UserSubjectDAO) ctx.getBean("UserSubjectDAO");
//		ActivityDiaryDAO adDAO = (ActivityDiaryDAO) ctx.getBean("ActivityDiaryDAO");
//		ActivityDAO activityDAO = (ActivityDAO) ctx.getBean("ActivityDAO");
//		FoodDAO foodDAO = (FoodDAO) ctx.getBean("FoodDAO");
//		CpadbActivityDAO cpadbActivityDAO = (CpadbActivityDAO) ctx.getBean("CpadbActivityDAO");
//		FcdbFoodDAO fcdbFoodDAO = (FcdbFoodDAO) ctx.getBean("FcdbFoodDAO");
//		ActivityDAO activityDAO = (ActivityDAO) ctx.getBean("ActivityDAO");
//		ActivityService activityService = (ActivityService) ctx.getBean("ActivityService");
		MealDAO mealDAO = (MealDAO) ctx.getBean("MealDAO");
		
//		activityService.addActivityForAD(1, 1, 1, "ss", "ss", "100", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), "11", 1);
//		
//		FoodId foodId = new FoodId();
//		
//		foodId.setMealFoodDiarySubjectId(1);
//		foodId.setMealFoodDiaryId(1);
//		foodId.setMealId(2);
//		
//		Food food = new Food();
//		food.setId(foodId);
//		food.setFcdbFoodChapter("A");
//		food.setFcdbFoodId(1);
//		food.setFcdbFoodDescription("for test");
//		food.setAmount("1");
//		food.setAmountUnit("cup");
//		
//		foodDAO.save(food);
		
		MealId mealId = new MealId();
		mealId.setFoodDiarySubjectId(1);
		mealId.setFoodDiaryId(1);
		mealId.setId(4);
		
		System.out.println(mealDAO.findById(mealId));
		
	}
}
