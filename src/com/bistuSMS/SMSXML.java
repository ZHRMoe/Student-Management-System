package com.bistuSMS;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.text.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by bill on 16/5/19.
 */
public class SMSXML {
    static String fileName = "SystemSupports.xml";
    static Document doc;
    public static void save() throws TransformerException {
        // 创建TransformerFactory对象
        TransformerFactory tFactory = TransformerFactory.newInstance();
        // 创建Transformer对象
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        File file = new File(fileName);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

    public static Document open(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(fileName);
        return doc;
    }

    public static void addUser() {

    }

    public static void removeUser() {

    }

    public static void addStudent() {

    }

    public static void removeStudent() {

    }

    public static SMSUserList getUsers() {
        try {
            open(fileName);
            NodeList userInfo = doc.getElementsByTagName("user");
            SMSUserList list = new SMSUserList();
            for (int i = 0;i<userInfo.getLength();i++) {
                Element user = (Element)userInfo.item(i);
                String userPsw = user.getAttributeNode("userPsw").getTextContent();
                String userName = user.getAttributeNode("userName").getTextContent();
                SMSUser tempUser = new SMSUser(userName, userPsw);
                list.userList.add(tempUser);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new SMSUserList();
        }
    }

    public static SMSStudentArray getStudents() {
        try {
            open(fileName);
            NodeList studentInfo = doc.getElementsByTagName("student");
            SMSStudentArray studentArray = new SMSStudentArray();
            for (int i = 0;i<studentInfo.getLength();i++) {
                Element student = (Element)studentInfo.item(i);
                String stuClass = student.getAttributeNode("stuClass").getTextContent();
                String stuNumber = student.getAttributeNode("stuNumber").getTextContent();
                String stuSex = student.getAttributeNode("stuSex").getTextContent();
                String stuName = ((Element)student.getElementsByTagName("stuName").item(0)).getTextContent();
                String stuDom = ((Element)student.getElementsByTagName("stuDom").item(0)).getTextContent();
                String joinCCP = ((Element)student.getElementsByTagName("joinCCP").item(0)).getTextContent();
                SMSStudent tempStudent = new SMSStudent(stuName,stuSex,stuClass,stuNumber,stuDom,joinCCP);
                studentArray.addStudent(i,tempStudent);
            }
            return studentArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new SMSStudentArray();
        }
    }

    public static void main(String[] args) {
        try {
            SMSXML.getStudents();
            SMSXML.getUsers();
            SMSXML.save(doc);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("SystemSupports.xml");
            NodeList userInfo = doc.getElementsByTagName("user");
            NodeList studentInfo = doc.getElementsByTagName("student");

            for (int i = 0;i<userInfo.getLength();i++) {
                Element user = (Element)userInfo.item(i);
                Element userpsw = (Element)userInfo.item(0);
                String userPsw = userInfo.item(0).getTextContent();
                String userName = user.getAttributeNode("userName").getTextContent();
            }
//            for (int i = 0; i < userInfo.getLength(); i++) {
//                Element node = (Element) nl.item(i);
//                Element email = doc.createElement("email");
//                node.appendChild(email);
//                email.appendChild(doc.createTextNode(node.getElementsByTagName("Email").item(0).getFirstChild().getNodeValue()));
//                NodeList Email = node.getElementsByTagName("Email");
//                node.removeChild(Email.item(0));
//                node.removeAttribute("性别");
//            }
//            nl = doc.getElementsByTagName("学生信息");
//            for (int i = 0; i < nl.getLength(); i++) {
//                Element node = (Element) nl.item(i);
//                Element student = doc.createElement("学生");
//                node.appendChild(student);
//                student.setAttribute("班级", "0802");
//                student.setAttribute("学号", "002");
//                Element name = doc.createElement("姓名");
//                name.appendChild(doc.createTextNode("李四"));
//                student.appendChild(name);
//                Element age = doc.createElement("年龄");
//                age.appendChild(doc.createTextNode("19"));
//                student.appendChild(age);
//                Element email = doc.createElement("email");
//                email.appendChild(doc.createTextNode("ls@tom.com"));
//                student.appendChild(email);
//            }
            save(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
