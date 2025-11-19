package CourseManagement;

public class Driver {
	public class Main {
	    public static void main(String[] args) {
	        // ====== Create Students ======
	        Student s1 = new Student("Alice Johnson", 12345, 3); // 3 semesters
	        Student s2 = new Student("Bob Smith", "67890", 2);   // uses String ID

	        // ====== Create Courses using different constructors ======

	        // Using Department + int + name
	        Course c1 = new Course(Department.CSCE, 101, "Intro to Programming");
	        Course c2 = new Course(Department.MATH, 150, "Calculus I");
	        Course c3 = new Course(Department.ENGL, 110, "Composition");
	        Course c4 = new Course(Department.HIST, 120, "World History");

	        // Using String deptCode + String number + name
	        Course c5 = new Course("CSCE", "201", "Data Structures");
	        Course c6 = new Course("MATH", "250", "Calculus II");
	        Course c7 = new Course("PHYS", "210", "Physics I");

	        // Using everything
	        Course c8 = new Course(Department.CSCE, 301, "Algorithms", CourseLevel.JUNIOR);
	        Course c9 = new Course(Department.CSCE, 310, "Operating Systems", CourseLevel.JUNIOR);
	        Course c10 = new Course(Department.MATH, 305, "Linear Algebra", CourseLevel.JUNIOR);
	        Course c11 = new Course(Department.ENGL, 301, "Technical Writing", CourseLevel.JUNIOR);
	        Course c12 = new Course(Department.CSCE, 315, "Database Systems", CourseLevel.JUNIOR);

	        // ====== Add Courses to Semesters ======
	        // Student 1: Alice
	        s1.addCourse(0, c1);
	        s1.addCourse(0, c2);
	        s1.addCourse(0, c3);
	        s1.addCourse(0, c4);

	        s1.addCourse(1, c5);
	        s1.addCourse(1, c6);
	        s1.addCourse(1, c7);

	        s1.addCourse(2, c8);
	        s1.addCourse(2, c9);
	        s1.addCourse(2, c10);
	        s1.addCourse(2, c11);
	        s1.addCourse(2, c12);

	        // Student 2: Bob
	        s2.addCourse(0, new Course(Department.BIOL, 150, "Intro to Biology"));
	        s2.addCourse(1, new Course("HIST", "210", "Modern History"));

	        // ====== Demonstrate transcripts ======
	        System.out.println("\n===== Full Transcript (All Semesters) =====");
	        s1.displayTranscript();

	        System.out.println("\n===== Specific Semester (Semester 2) =====");
	        s1.displayTranscript(2);

	        System.out.println("\n===== Filter by Course Level (JUNIOR) =====");
	        s1.displayTranscript(CourseLevel.JUNIOR);

	        System.out.println("\n===== Filter by Department (CSCE) =====");
	        s1.displayTranscript(Department.CSCE);

	        System.out.println("\n===== Second Student (Bob) =====");
	        s2.displayTranscript();

	        // ====== Department.fromCode() ======
	        System.out.println("\n===== Department.fromCode() Demo =====");
	        String code = "MATH";
	        Department d = Department.fromCode(code);
	        if (d != null) {
	            System.out.println("Code '" + code + "' found: " + d.getFullName());
	        } else {
	            System.out.println("Department code '" + code + "' not found!");
	        }

	        // ====== Invalid department error testing ======
	        String badCode = "XXXX";
	        Department invalid = Department.fromCode(badCode);
	        System.out.println("Code '" + badCode + "' found? " + invalid);
	    }
	}
}
