package action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import domain.CpadbActivity;
import domain.FcdbFood;

public class FcdbFoodAction extends BaseAction{
	
	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = -4732948910116275337L;
	
	private List lc; // list of chapters.
	private List<FcdbFood> lff; // list of food from fcdb in mysql.
	private InputStream inputStream;
	private String foodChapter;
	
	public String showAllChapters() throws UnsupportedEncodingException{
		
		lc = fcdbFoodService.listFoodChapters();
		
		String s = "<select'>";
		s += "<option>--Select Food Chapter--</option>";
		for (Object c : lc) {
			s += "<option value='" + c.toString() + "'>" + c.toString() + "</option>";
		}
		s += "</select>";
		
		inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));
		
		return SUCCESS;
	}
	
	public String showSelectedFoodDescription() throws UnsupportedEncodingException{
		
		lff = fcdbFoodService.fingByChapter(foodChapter);
		
		String s = "<select'>";
		s += "<option>--Select Food Description--</option>";
		for (FcdbFood ff : lff) {
			s += "<option value='" + ff.getFcdbFoodDescription() + "' id='" + ff.getId() + "'>" + ff.getFcdbFoodDescription() + "</option>";
		}
		s += "</select>";
		
		inputStream = new ByteArrayInputStream(s.getBytes("UTF-8"));	
		
		return SUCCESS;
	}

	public List getLc() {
		return lc;
	}

	public void setLc(List lc) {
		this.lc = lc;
	}

	public List<FcdbFood> getLff() {
		return lff;
	}

	public void setLff(List<FcdbFood> lff) {
		this.lff = lff;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFoodChapter() {
		return foodChapter;
	}

	public void setFoodChapter(String foodChapter) {
		this.foodChapter = foodChapter;
	}
	
}
