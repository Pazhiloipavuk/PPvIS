package model;

import java.util.List;
import java.util.ArrayList;

public class ListOfStudent {
    private List<Student> students;
    
	public ListOfStudent() {
		this.students = new ArrayList<Student>();
	}
	
	public List<Student> getStudents() {
		return new ArrayList<>(this.students);
	}
	
	public void setStudents(List<Student> arrayList) {
		this.students = new ArrayList<>(arrayList);
	}
}
