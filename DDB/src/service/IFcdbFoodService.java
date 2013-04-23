package service;

import java.util.List;

public interface IFcdbFoodService {

	public List listFoodChapters();
	
	public List findByProperty(String property, String value);
	
	public List fingByChapter(String chapter);
	
}
