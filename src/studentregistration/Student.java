/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

import java.text.*;
import java.util.*;

/**
 * This class contains student info, as well as the ability to add and drop
 * courses from an array.
 *
 * @author eugeniomartin-carreras
 */
public class Student {

    // Variables
    private String firstName;
    private String lastName;
    private String name;
    private String id;
    private ArrayList<String> courses = new ArrayList();
    private Date date;

    // Default constructor for use in Admissions class
    public Student() {
        this.id = null;
        this.name = null;
        this.date = null;
    }

    /**
     * Constructor for student objects
     *
     * @param name Name of student
     * @param id Unique ID for student
     * @param courses List of courses student is enrolled in
     * @param date Date created
     */
    public Student(String name, String id, String[] courses, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    /**
     * Getter for student name
     *
     * @return Student name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the student's first name
     *
     * @param firstName The student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter for the student's last name
     *
     * @param lastName The student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter for the student name
     *
     * @param name The student name
     */
    public void setName(String name) {
        name = firstName + lastName;
        this.name = name;
    }

    /**
     * Getter for student ID
     *
     * @return Student ID
     */
    public String getID() {
        return id;
    }

    /**
     * Setter for student ID number
     *
     * @param id The ID for the student
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Getter for list of courses student is enrolled in
     *
     * @return List of courses
     */
    public List getCourses() {
        return courses;
    }

    /**
     * Getter for date
     *
     * @return Date created
     */
    public Date getDate() {
        return date;
    }

    /**
     * Adds a course to the list of courses
     *
     * @param newCourse The new course being added
     */
    public void addCourse(String newCourse) {
            courses.add(newCourse);
    }

    /**
     * Drops a course from the list of courses
     *
     * @param dropping The course being removed from the list
     */
    public void dropCourse(String dropping) {
        courses.remove(dropping);
    }

    /**
     * Overridden toString method to return all variables
     *
     * @return ID, Name, Date, and Course List
     */
    @Override
    public String toString() {
        SimpleDateFormat now = new SimpleDateFormat("MMMM d, yyyy");
        Date date = new Date();

        return "ID Number: " + id + "\n"
                + "Name: " + lastName + ", " + firstName + "\n"
                + "Date: " + now.format(date) + "\n"
                + "Courses: " + courses.toString()
                + "\n \n";

    } 
}
