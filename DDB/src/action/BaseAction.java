/**
 * 
 */
package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import service.impl.AccuracyService;
import service.impl.ActivityDiaryService;
import service.impl.ActivityService;
import service.impl.CpadbActivityService;
import service.impl.FcdbFoodService;
import service.impl.FoodDiaryService;
import service.impl.FoodIngredientService;
import service.impl.FoodService;
import service.impl.MealService;
import service.impl.SubjectService;
import service.impl.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Chen
 * @version 1.2
 */
public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, CookiesAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1095251973376097402L;

	// Basic web application context.
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected Map<String, String> cookies;

	// Services.
	protected AccuracyService accuracyService;
	protected UserService userService;
	protected SubjectService subjectService;
	protected FoodDiaryService foodDiaryService;
	protected ActivityDiaryService activityDiaryService;
	protected ActivityService activityService;
	protected MealService mealService;
	protected FoodService foodService;
	protected FoodIngredientService foodIngredientService;
	protected FcdbFoodService fcdbFoodService;
	protected CpadbActivityService cpadbActivityService;

//	// For Struts2-jquery-Gridtag
//	public List<?> gridModel;
//	protected int rows; // Get how many rows we want to have into the grid - rowNum attribute in the grid
//	protected int page; // Get the requested page. By default grid sets this to 1.
//	protected int total; // Totally how many page.
//	protected int record; // All record;
//	protected String sord; // Sorting order ? asc or desc.
//	protected String sidx; // Get index row which user cliked to sort.
//	protected String searchField; // The searching string.
//	protected String searchOperation; // The Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']

	@Override
	public void setCookiesMap(Map<String, String> map) {
		this.cookies = map;
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.session = map;
	}

	public AccuracyService getAccuracyService() {
		return accuracyService;
	}

	public void setAccuracyService(AccuracyService accuracyService) {
		this.accuracyService = accuracyService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public FoodDiaryService getFoodDiaryService() {
		return foodDiaryService;
	}

	public void setFoodDiaryService(FoodDiaryService foodDiaryService) {
		this.foodDiaryService = foodDiaryService;
	}

	public ActivityDiaryService getActivityDiaryService() {
		return activityDiaryService;
	}

	public void setActivityDiaryService(ActivityDiaryService activityDiaryService) {
		this.activityDiaryService = activityDiaryService;
	}

	public ActivityService getActivityService() {
		return activityService;
	}

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	public MealService getMealService() {
		return mealService;
	}

	public void setMealService(MealService mealService) {
		this.mealService = mealService;
	}

	public FoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}

	public FoodIngredientService getFoodIngredientService() {
		return foodIngredientService;
	}

	public void setFoodIngredientService(FoodIngredientService foodIngredientService) {
		this.foodIngredientService = foodIngredientService;
	}

	public FcdbFoodService getFcdbFoodService() {
		return fcdbFoodService;
	}

	public void setFcdbFoodService(FcdbFoodService fcdbFoodService) {
		this.fcdbFoodService = fcdbFoodService;
	}

	public CpadbActivityService getCpadbActivityService() {
		return cpadbActivityService;
	}

	public void setCpadbActivityService(CpadbActivityService cpadbActivityService) {
		this.cpadbActivityService = cpadbActivityService;
	}

	
}
