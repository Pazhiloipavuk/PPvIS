package model;

import java.util.Map;

public class Student {
    private String name;
    private String surname;
    private String middleName;
    private String group;
    private double averageGrade;
	private Map<String, Integer> examNameToGrade;

    public Student(String name, String surname, String middleName, String group, Map<String, Integer> examsinput) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.group = group;
        this.examNameToGrade = examsinput;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        return group;
    }
    
    public Map<String, Integer> getExams() {
        return examNameToGrade;
    } 
    
    public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
}
