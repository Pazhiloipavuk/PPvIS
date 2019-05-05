package model;

import java.util.ArrayList;

public class List {
    private java.util.List<Student> students;
    
	public List() {
		this.students = new ArrayList<Student>();
	}
	
	public ArrayList<Student> getStudents() {
		return new ArrayList<>(this.students);
	}
	
	public void setStudents(ArrayList<Student> arrayList) {
		this.students = new ArrayList<>(arrayList);
	}
}
