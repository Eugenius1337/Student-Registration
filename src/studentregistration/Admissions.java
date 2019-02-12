/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Stores and manipulates data for student objects.
 *
 * @author eugeniomartin-carreras
 */
public class Admissions {

    // ArrayLists for enrolled and dropped students.
    ArrayList<Student> enrolled = new ArrayList();
    ArrayList<Student> dropped = new ArrayList();

    // Variables
    private String currentAction;

    /**
     * Starts the program, asking the user for an input
     */
    public void start() {
        currentAction = GetData.getWord("my.fiu.edu"
                + "\n 1) Add Student"
                + "\n 2) Drop Student"
                + "\n 3) List Students"
                + "\n 4) Add/Drop Courses"
                + "\n 5) Exit Program");

        if ("1".equals(currentAction)) {
            addStudent();
        } else if ("2".equals(currentAction)) {
            dropStudent();
        } else if ("3".equals(currentAction)) {
            listStudents();
        } else if ("4".equals(currentAction)) {
            editStudent();
        } else if ("5".equals(currentAction)) {
            System.exit(0);
        }
    }

    /**
     * Simple loop to make other edits in the database
     */
    public void mainMenu() {
        currentAction = GetData.getWord("my.fiu.edu"
                + "\n 1) Add Student"
                + "\n 2) Drop Student"
                + "\n 3) List Student"
                + "\n 4) Add/Drop Courses"
                + "\n 5) Exit Program");

        if ("1".equals(currentAction)) {
            addStudent();
        } else if ("2".equals(currentAction)) {
            dropStudent();
        } else if ("3".equals(currentAction)) {
            listStudents();
        } else if ("4".equals(currentAction)) {
            editStudent();
        } else if ("5".equals(currentAction)) {
            System.exit(0);
        }
    }

    /**
     * Adds a student to the database containing ID, first, and last name
     */
    public void addStudent() {
        Student student = new Student();
        student.setID(GetData.getWord("Enter the student's ID. "));
        student.setFirstName(GetData.getWord("Enter the student's first name."));
        student.setLastName(GetData.getWord("Enter the student's last name."));
        enrolled.add(student);
        JOptionPane.showMessageDialog(null, "Student added.");
        mainMenu();
    }

    /**
     * Drops a student from the database by ID and adds them to dropped list
     */
    public void dropStudent() {
        String id = GetData.getWord("Enter the ID of the student being dropped.");
        int index = -1;
        
        // Searches students for matching ID
        for (int i = 0; i < enrolled.size(); i++) {
            if (enrolled.get(i).getID().equals(id)) {
                index = i;
                break;
            }
        }
        
        // If the ID is not found, tell the user
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Student not found."
                    + "\n Try searching the list for a valid ID.");
          
          // If the ID is found, remove that student from the enrolled list
          // and add them to the dropped list
        } else {
            dropped.add(enrolled.get(index));
            enrolled.remove(index);
            JOptionPane.showMessageDialog(null, "Student dropped."
                    + " Added to dropped list.");
        }
        mainMenu();
    }

    /**
     * Lists either database if they contain any students (Enrolled/Dropped).
     */
    public void listStudents() {
        // If there are any students in the enrolled list, display them
        if (enrolled.size() > 0) {
            JTextArea enrolledText = new JTextArea("*CURRENTLY ENROLLED*");
            enrolledText.append("\n \n");
            enrolledText.append(enrolled.toString().replace("[","").replace("]",""));
            JScrollPane list = new JScrollPane(enrolledText);
            list.setPreferredSize(new Dimension(300, 300));
            JOptionPane.showMessageDialog(null, list);
        }
        
        // If there are any students in the dropped list, display them
        if (dropped.size() > 0) {
            JTextArea droppedText = new JTextArea("*STUDENTS WHO WERE DROPPED*");
            droppedText.append("\n \n");
            droppedText.append(dropped.toString().replace("[","").replace("]",""));
            JScrollPane dList = new JScrollPane(droppedText);
            dList.setPreferredSize(new Dimension(300, 300));
            JOptionPane.showMessageDialog(null, dList);
        }
            mainMenu();
    }

    /**
     * Allows user to add and drop courses for students.
     */
    public void editStudent() {
        // Saves String value of ID being searched for in list
        String search = GetData.getWord("Enter the ID of the student to add/drop courses.");
        
        // Iterates through list looking for the specific student with saved ID
        for (int i = 0; i < enrolled.size(); i++) {
            
            // If the student contains that ID, ask user to add or drop course
            if (enrolled.get(i).getID().contains(search)) {
                currentAction = GetData.getWord(
                        "Course List for " + enrolled.get(i).getID()
                        + "\n 1) Add Course"
                        + "\n 2) Drop Course");
                
                // If user wants to add a course, ask them for the course code
                if ("1".equals(currentAction) && enrolled.get(i).getCourses().size() < 5) {
                    String newCourse = GetData.getWord(
                            "Enter the course code that you wish to add.");
                    enrolled.get(i).addCourse(newCourse);
                    JOptionPane.showMessageDialog(null, "Course added.");
                    mainMenu();
                    
                  // If the user wants to drop a course, ask them for the course code
                } else if ("2".equals(currentAction)) {
                    String dropping = GetData.getWord(
                            "Enter the course code that you wish to drop.");
                    
                    // If the course exists in the course list, drop it
                        if (enrolled.get(i).getCourses().contains(dropping)) {
                            enrolled.get(i).dropCourse(dropping);
                            JOptionPane.showMessageDialog(null, "Course dropped.");
                            mainMenu();
                            
                          // If the course is not in the list, tell the user
                        } else {
                            JOptionPane.showMessageDialog(null, "Course not found.");
                            mainMenu();
                        }
                        
                  // If the course list has 5 items, tell the user it is full        
                } else {
                    JOptionPane.showMessageDialog(null,
                            "The course list is full. Drop a class to add another.");
                }
            }
        } 
        mainMenu();
    }
}
