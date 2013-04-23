package service;

import java.util.List;

public interface ICpadbActivityService {
	
	public List listMajorHeadings();
	
	public List findByProperty(String property, String value);
	
	public List fingByMajorHeading(String majorHeading);
	
}
