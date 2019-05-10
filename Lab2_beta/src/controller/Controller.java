package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

import model.*;

public class Controller {
	
	private ListOfStudents list;
	private Parser parser;
	
	public Controller(ListOfStudents list) {
		this.list = list;
		parser = new Parser();
	}
	
	public void loadStudents(File fileOpen) throws SAXException, IOException, ParserConfigurationException {
		list.setStudents(parser.read(fileOpen));
		calculateAverageGrade();
	}
	
	public void saveStudents(File fileSave) throws ParserConfigurationException, TransformerException {
		parser.write(fileSave, list.getStudents());
	}
	
	public void addStudent(String nameToAdd, String surnameToAdd, String middleNameToAdd, String groupToAdd, String stringOfExams, String stringOfGrades) {
		List<Student> addedStudent = list.getStudents();
		String[] nameOfExams = stringOfExams.split(" ");
		String[] stringGrades = stringOfGrades.split(" ");
		ArrayList<Integer> grades = new ArrayList<>();
		Map<String, Integer> examsToAdd = new LinkedHashMap<>();
		for (int i = 0; i < stringGrades.length; i++) {
			grades.add(Integer.parseInt(stringGrades[i]));
		}
		for (int i = 0; i < nameOfExams.length; i++) {
			examsToAdd.put(nameOfExams[i], grades.get(i));
		}
		addedStudent.add(new Student(nameToAdd, surnameToAdd, middleNameToAdd, groupToAdd, examsToAdd));
		list.setStudents(addedStudent);
		calculateAverageGrade();
	}
	
	public void calculateAverageGrade() {
		double averageGrade = 0;
 	    for (Student student : list.getStudents()) {
 	    	for (int value : student.getExams().values()) {
 	    		averageGrade = value + averageGrade;
 	    	}
 	    averageGrade = averageGrade / student.getExams().size();
 	    student.setAverageGrade(averageGrade);
 	    averageGrade = 0;
 	    }
	}
	
	public List<Student> findByAverageGrade(int lowerGrade, int upperGrade, String surnameToSearch) {
		ArrayList<Student> studentToFind = new ArrayList<>();
		for (Student student : list.getStudents()) {
			if (student.getAverageGrade() >= lowerGrade && student.getAverageGrade() <= upperGrade && surnameToSearch.equals(student.getSurname())) {
				studentToFind.add(student);	
			}
		}
		return studentToFind;
	}
	
	public List<Student> findByNumberOfGroup(String groupToSearch, String surnameToSearch) {
		ArrayList<Student> studentToFind = new ArrayList<>();
		for (Student student : list.getStudents()) {
			if (groupToSearch.equals(student.getGroup()) && surnameToSearch.equals(student.getSurname())) {
				studentToFind.add(student);	
			}
		}
		return studentToFind;
	}
	
	public List<Student> findByGradeByDiscipline(String examToSearch, String surnameToSearch, int lowerGrade, int upperGrade) {
		ArrayList<Student> studentToFind = new ArrayList<>();
		for (Student student : list.getStudents()) {
			for (Map.Entry<String, Integer> pair : student.getExams().entrySet()) {
				if (examToSearch.equals(pair.getKey()) &&  pair.getValue() >=  lowerGrade && pair.getValue() <= upperGrade && surnameToSearch.equals(student.getSurname())) {
					studentToFind.add(student);	
				}
			}
		}
		return studentToFind;
	}
	
	public int removeStudent(List<Student> studentToRemove) {
		List<Student> removeStudent = list.getStudents();
		int size = removeStudent.size();
		for (Student student : studentToRemove) {
			removeStudent.remove(student);
		}
		list.setStudents(removeStudent);
		return size - removeStudent.size();
	}
	
	public List<Student> getStudents(){
		return list.getStudents();
	}
}
