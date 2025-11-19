package CourseManagement;

public enum Department {
	CSCE("CSCE", "Computer Science and Computer Engineering"),
	MATH("MATH", "Mathematics"),
	ENGL("ENGL","English"),
	HIST("HIST", "History"),
	PHYS("PHYS", "Physics"),
	BIOL("BIOL", "Biology");
	
	private String code;
	private String fullName;
	
	Department(String courseCode, String name) {
		boolean validStudentCode = true;
		for (int i=0; i< courseCode.length(); i++) {
			if (!Character.isLetter(courseCode.charAt(i))) {
				validStudentCode = false;
			}
		}
		if (validStudentCode == true) {
			this.code = courseCode;
		} else {
			this.code = "ERROR";
		}
		this.fullName = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	@Override
	public String toString() {
		return code + "-" + fullName;
	}
	
	public static Department fromCode(String code) {
		for (Department dept: Department.values()) {
			if (dept.code.equals(code)) {
				return dept;
			}
		}
		return null;
	}
}
