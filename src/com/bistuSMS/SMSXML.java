package com.bistuSMS;

import com.sun.xml.internal.bind.v2.TODO;
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
import java.util.ArrayList;

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

    public static Document open() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse(fileName);
        return doc;
    }

    public static void addUser(SMSUser user) throws Exception {
        try {
            open();
            NodeList userInfo = doc.getElementsByTagName("user");
            int i = 0;
            for (;i<userInfo.getLength();i++) {
                Element userElement = (Element)userInfo.item(i);
                if (userElement.getAttributeNode("userName").getTextContent().equals(user.getUserName())) {
                    throw new Exception("用户名已存在!");
                }
            }
            Node users = doc.getElementsByTagName("userInfo").item(0);
            Element userElement = doc.createElement("user");
            userElement.setAttribute("userName", user.getUserName());
            userElement.setAttribute("userPsw", user.getUserPsw());
            users.appendChild(userElement);
            save();
        } catch (Exception e) {
            if (e.getMessage().equals("用户名已存在!")) {
                throw e;
            }
            e.printStackTrace();
        }
    }

    public static void removeUser(SMSUser user) {
        try {
            open();
            NodeList userInfo = doc.getElementsByTagName("user");
            for (int i = 0;i<userInfo.getLength();i++) {
                Element userElement = (Element) userInfo.item(i);
                if (userElement.getAttributeNode("userName").getTextContent().equals(user.getUserName()) && userElement.getAttributeNode("userPsw").getTextContent().equals(user.getUserPsw())) {
                    Node userInfoNode = doc.getElementsByTagName("userInfo").item(0);
                    userInfoNode.removeChild(userElement);
                    break;
                }
            }
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(SMSStudent student) throws Exception {
        try {
            open();
            NodeList studentInfo = doc.getElementsByTagName("student");
            int i = 0;
            for (;i<studentInfo.getLength();i++) {
                Element studentElement = (Element) studentInfo.item(i);
                if (studentElement.getAttributeNode("stuNumber").getTextContent().equals(student.getStuNumber())) {
                    throw new Exception("学号重复!");
                }
            }
            if (i == studentInfo.getLength()) {
                Node students = doc.getElementsByTagName("studentInfo").item(0);
                Element studentElement = doc.createElement("student");
                Element stuName = doc.createElement("stuName");
                stuName.setNodeValue(student.getStuName());
                Element stuDom = doc.createElement("stuDom");
                stuDom.setNodeValue(student.getStuDorm());
                Element joinCCP = doc.createElement("joinCCP");
                joinCCP.setNodeValue(student.getJoinCCP());
                studentElement.setAttribute("stuClass",student.getStuClass());
                studentElement.setAttribute("stuNumber",student.getStuNumber());
                studentElement.setAttribute("stuSex",student.getStuSex());
                studentElement.appendChild(stuName);
                studentElement.appendChild(stuDom);
                studentElement.appendChild(joinCCP);
                students.appendChild(studentElement);
                save();
            }
        } catch (Exception e) {
            if (e.getMessage().equals("学号重复!")) {
                throw e;
            }
            e.printStackTrace();
        }
    }

    public static void removeStudent(SMSStudent student) {
        try {
            open();
            NodeList studentInfo = doc.getElementsByTagName("student");
            Element studentElement = null;
            for (int i = 0;i<studentInfo.getLength();i++) {
                studentElement = (Element) studentInfo.item(i);
                if (studentElement.getAttributeNode("stuNumber").getTextContent().equals(student.getStuNumber())) {
                    Node students = doc.getElementsByTagName("studentInfo").item(0);
                    students.removeChild(studentElement);
                    save();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SMSUserList getUsers() {
        try {
            open();
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
            open();
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
            getStudents();
            getUsers();
//            removeUser(new SMSUser("abcd", "5f4dcc3b5aa765d61d8327deb882cf99"));
            addStudent(new SMSStudent("","","","201","",""));
            addUser(new SMSUser("abc","password"));
            save();
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
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
