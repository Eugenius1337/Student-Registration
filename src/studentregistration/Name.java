/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentregistration;

/**
 * This class constructs a full name with a first and last name.
 * @author eugeniomartin-carreras
 */
public class Name {
    
    // Variables
    private String firstName;
    private String lastName;
    
    // Default constructor
    public Name() {
        this.firstName = "";
        this.lastName = "";
    }
    
    /**
     * Constructor for a name object
     * @param firstName Student first name
     * @param lastName Student last name
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Getter for first name
     * @return First name
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * Setter for first name
     * @param firstName First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Getter for last name
     * @return Last name
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Setter for last name
     * @param lastName Last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Overridden toString that returns last name first name
     * @return Last name, First name
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }
}
