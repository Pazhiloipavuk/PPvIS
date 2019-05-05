package test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class DOMExample {
    // ������ ��� ����������� �� XML �����
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // ��������� �������, ����� ����� �������� ������ ����������.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // �������� �� ������� ������, ������� ������ XML, ������� ��������� Document � ���� �������������� ������.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // ��������� XML, ������ ��������� Document. ������ � ��� ���� ������ �� ���� ���������, ����� ��� �����.
        Document document = builder.parse(new File("xml_file1.xml"));

        // ��������� ������ ���� ��������� employee ������ ��������� �������� (getDocumentElement ���������� ROOT ������� XML �����).
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");

        // ������� ���� ��������� employee
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);

            // ��������� ��������� ������� ��������
            NamedNodeMap attributes = employee.getAttributes();

            // ���������� ����������. ������� - ���� Node, ������ ��� ����� �������� �������� �������� � ������� ������ getNodeValue()
            employees.add(new Employee(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("job").getNodeValue()));
        }

        // ����� ���������� � ������ ����������
        for (Employee employee : employees)
            System.out.println(String.format("���������� � ����������: ��� - %s, ��������� - %s.", employee.getName(), employee.getJob()));
    }
}
