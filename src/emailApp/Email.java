package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // Call a method asking for the department - return the department
        this.department = setDepartment();
        // Call a method that returns a random password;
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);
        // Combine elements to generate email
        this.email = firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + department + "." + companySuffix;

    }

    // Ask for department
    private String setDepartment(){
        System.out.print("New worker: " + firstName + "\nDEPARTMENT CODES\n1 For Sales \n2 For Development \n3 For Accounting \n0 For none \nEnter the department");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){
            return "sales";
        } else if (depChoice == 2){
            return "development";
        } else if (depChoice == 3){
            return "accounting";
        } else {
            return "";
        }
    }

    // Generate a random password

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailBox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display name: " + firstName + " " + lastName +
                "\nCompany email: " + email +
                "\nMailBox capacity:" + mailBoxCapacity + "mb";
    }

}
