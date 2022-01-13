package model;

public class StudentManagementSystem {
	private Student[] students;
	private int NOS;
	
	public StudentManagementSystem() {
		this.students = new Student[1000];
	}
	
	public Student[] getStudents() {
		Student[] students = new Student[NOS];
		for (int i = 0; i < this.NOS; i ++) {
			students[i] = this.students[i];
		}
		return students;
	}
	
	public void addStudent(Student student) {
		this.students[this.NOS] = student;
		this.NOS ++;
	}
	
	public void registerAll(Course course) {

		for (int i = 0; i < this.NOS; i ++) {
			Course[] courses = this.students[i].getCourses();
			boolean incourse = false;
			for (int c = 0; c < this.students[i].getNOC(); c ++) {
				if (courses[c] == course) {
					incourse = true;
				}
			}
			if (incourse == false) {
				this.students[i].register(course);
			}
		}
		
		
		
	}
}

