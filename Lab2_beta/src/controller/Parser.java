package controller;

import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Parser {
    
	private final String ELEMENT_SCHOOL = "school";
	private final String ELEMENT_STUDENT = "student";
	private final String ELEMENT_NAME = "name";
	private final String ELEMENT_SURNAME = "surname";
	private final String ELEMENT_MIDDLE_NAME = "middlename";
	private final String ELEMENT_EXAM = "exam";
	private final String ELEMENT_GRADE = "grade";
	private final String ELEMENT_GROUP = "group";


	public void write(File file, List<Student> students) throws ParserConfigurationException, TransformerException {		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
		
		Element schoolElement = document.createElement(ELEMENT_SCHOOL);
		document.appendChild(schoolElement);
		
		for (Student student : students) {

			Element studentElement = document.createElement(ELEMENT_STUDENT);
			schoolElement.appendChild(studentElement);
			
			Element nameElement = document.createElement(ELEMENT_NAME);
			nameElement.setTextContent(student.getName());
			studentElement.appendChild(nameElement);
			Element surnameElement = document.createElement(ELEMENT_SURNAME);
			surnameElement.setTextContent(student.getSurname());
			studentElement.appendChild(surnameElement);
			Element middleNameElement = document.createElement(ELEMENT_MIDDLE_NAME);
			middleNameElement.setTextContent(student.getMiddleName());
			studentElement.appendChild(middleNameElement);
 	    	for (Map.Entry<String, Integer> pair : student.getExams().entrySet()) {
 				Element examElement = document.createElement(ELEMENT_EXAM);
 				examElement.setAttribute(ELEMENT_GRADE, pair.getValue().toString());
 				examElement.setTextContent(pair.getKey());
 				studentElement.appendChild(examElement);
 	    	}
			Element groupElement = document.createElement(ELEMENT_GROUP);
			groupElement.setTextContent(student.getGroup());
			studentElement.appendChild(groupElement);
		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		DOMSource source = new DOMSource(document);

		StreamResult result =  new StreamResult(file);
		
		transformer.transform(source, result);
	}

    public ArrayList<Student> read(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        StudentHandler handler = new StudentHandler();
        parser.parse(file, handler); 
        
        return handler.returnStudents();
    }

    private static class StudentHandler extends DefaultHandler {
        private String name;
        private String surname;
        private String middleName;
        private String group;
        private String lastElementName;
        private String exam;
        private int grades;
        private Map<String, Integer> parseExams = new LinkedHashMap<>();
        private ArrayList<Student> students = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        	if ("exam".equals(qName)) {
        		grades = Integer.parseInt(attributes.getValue("grade"));
        	}
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = information;
                if (lastElementName.equals("surname"))
                    surname = information;
                if (lastElementName.equals("middlename"))
                    middleName = information;
                if (lastElementName.equals("exam")) {
                	exam = information;
                	parseExams.put(exam, grades);
                }
                if (lastElementName.equals("group")) {
                	group = information;
                	students.add(new Student(name, surname, middleName, group, parseExams));
                	parseExams = new LinkedHashMap<>();
                } 
            }
        }
        
		public ArrayList<Student> returnStudents() {
			return students;
		}
    }	
}
