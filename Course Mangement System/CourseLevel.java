package CourseManagement;

public enum CourseLevel {
	FRESHMAN(100, 199),
	SOPHOMORE(200, 299),
	JUNIOR(200, 399),
	SENIOR(400, 499);
	
	//Instance variables for each enum constant
	private int minCourseNum;
	private int maxCourseNum;
	
	//Constructor - called when each enum constant is created
	CourseLevel(int min, int max) {
		this.minCourseNum = min;
		this.maxCourseNum = max;
	}
	
	//Method to check if a course number fits within this level 
	public boolean isValidCourseNumber(int courseNum) {
		return courseNum >= minCourseNum && courseNum <=maxCourseNum;
	}
	
	public String getRange() {
		return minCourseNum + "-" + maxCourseNum;
	}
	
}
