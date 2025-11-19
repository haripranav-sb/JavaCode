package CourseManagement;

public class Course {
	
	private Department department;
	private int courseNumber;
	private String courseName;
	private CourseLevel level;
	
	Course(Department dept, int number, String name) {
		this.department = dept;
		this.courseNumber = number;
		this.courseName = name;
		this.level = getCourseLevel();
	}
	
	Course(String deptCode, String number, String name) {
		this.department = Department.fromCode(deptCode);
		this.courseNumber = Integer.parseInt(number);
		this.courseName = name;
		this.level = getCourseLevel();
	}
	
	Course(Department dept, int number, String name, CourseLevel level) {
		this.department = dept;
		this.courseNumber = number;
		this.courseName = name;
		this.level = level;
	}
	
	public CourseLevel getCourseLevel() {
		for(CourseLevel lvl: CourseLevel.values()) {
			if (lvl.isValidCourseNumber(courseNumber)) {
				return lvl;
			}
		}
		return null;
	}
	
	public String getFullCourseCode() {
		return department.getCode() + " " + courseNumber;
	}
	
	@Override
	public String toString() {
		return getFullCourseCode() + ": " + courseName + " [" + level+ "]";
	}
	
	public Department getDepartment() {
		return department;
	}
	
	
	

}
