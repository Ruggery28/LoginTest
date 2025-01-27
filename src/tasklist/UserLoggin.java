/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tasklist;

import model.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
public class UserLoggin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner kBoard = new Scanner(System.in);
        ArrayList<User> users = new ArrayList();
        boolean exit = true;
        
        while (exit) {
            System.out.println("[1] Register new user: ");
            System.out.println("[2] List all users: ");
            System.out.println("[3] Search for user by Email: ");
            System.out.println("[4] Update user data: ");
            System.out.println("[5] Delete user data: ");
            System.out.println("[6] Exit: ");
            
            System.out.printf("Enter an option:  ");
            String option = kBoard.nextLine();
            
            switch (option) {
                case "1": {
                    System.out.println("====REGISTER A NEW USER====");
                    System.out.printf("Enter email: ");
                    String email = kBoard.nextLine();
                    System.out.printf("Enter password: ");
                    String password = kBoard.nextLine();
                    
                    User user = new User();     //creating a new object
                    user.setEmail(email);       //setting email to the class User
                    user.setPassword(password); //setting password to the class User

                    users.add(user);            //adding the values inside the Array
                    break;
                }
                case "2": {
                    System.out.println("====LISTING ALL THE USERS EMAIL====");
                    for (int i = 0; i < users.size(); i++) {
                        User userTemp = users.get(i);   //created a variable userTemp and stored the same number as 'i'

                        System.out.println("User " + i + ":");
                        System.out.println("\tEmail: " + users.get(i).getEmail()); //different ways to get a value 
                        System.out.println("\tSenha: " + userTemp.getPassword());
                    }
                    break;
                }
                case "3": {
                    System.out.println("====SEARCH FOR USER BY EMAIL====");
                    System.out.println("Enter email: ");
                    String email = kBoard.nextLine();
                    boolean emailFound = false; //If user doesnt exists I'll check it in another IF

                    for (int i = 0; i < users.size(); i++) {
                        User userTemp = users.get(i);
                        
                        if (email.equals(userTemp.getEmail())) { //comparing if email = userTemp
                            System.out.println("Email has been found: ");
                            System.out.println("\tEmail: " + userTemp.getEmail());
                            System.out.println("\tPassword: " + userTemp.getPassword());
                            emailFound = true;
                            break;
                        }
                    }
                    if (!emailFound) { //If user was not found, emailFound will be different than false(TRUE)  
                        System.out.println("User doesn't exit!");
                    }
                    break;
                }
                case "4": {
                    System.out.println("====UPDATE AN USER====");
                    
                    for (int i = 0; i < users.size(); i++) {
                        User userTemp = users.get(i); //created a variable userTemp and stored the same number as 'i'
                        
                        System.out.println("[" + i + "] " + userTemp.getEmail()); //it will show all the users
                    }
                    System.out.println("Enter the reference number: "); //asking to enter which user they want to update
                    int num = kBoard.nextInt();
                    kBoard.nextLine();
                    
                    System.out.println("Enter new Email: ");
                    String newEmail = kBoard.nextLine();
                    System.out.println("Enter new Password: ");
                    String newPassword = kBoard.nextLine();
                    
                    User u = users.get(num); //stored in a new object and get the same index it was stored before
                    u.setEmail(newEmail); //set new email
                    u.setPassword(newPassword); //set new password
                    
                    break;
                }
                case "5": {
                    System.out.println("====DELETE AN USER====");
                    
                    for (int i = 0; i < users.size(); i++) {
                        User userTemp = users.get(i); //created a variable userTemp and stored the same number as 'i'
                        
                        System.out.println("[" + i + "] " + userTemp.getEmail());
                    }
                    System.out.println("Enter the reference number: "); //asking to enter which user they want to delete
                    int num = kBoard.nextInt();
                    kBoard.nextLine();
                    
                    users.remove(num); //remore the index they want to delete
                    
                    break;
                }
                case "6": {
                    exit = false;
                    break;
                }
            }
            
        }
        //===LEARNING HOW TO USE OBJECT AND SETTING IT IN A DIFFERENT CLASS FILE===
//        System.out.printf("Enter your email: ");
//        email = kBoard.nextLine();
//        System.out.printf("Enter your password: ");
//        password = kBoard.nextLine();
//        
//        /*Object user was created so it can be used along the class User
//        User user = new User();
//        I'm sending email and password to the class User and storing it in the 
//        private variables using the method Get*/
//        user.setEmail(email);
//        user.setPassword(password);
//        
//        /*Now, I'm getting the information that was stored in the variables in
//        the User class and printing on the screen.*/
//        System.out.println("email: " + user.getEmail());
//        System.out.println("password: " + user.getPassword());
        //=================NOW LEARNING ARRYS AND LOOP================
//        ArrayList<User> users = new ArrayList();
//        
//        for (int i = 0; i < 3; i++) {
//            System.out.printf("Enter your email: ");
//            email = kBoard.nextLine();
//            System.out.printf("Enter your password: ");
//            password = kBoard.nextLine();
//            
//            /*
//            Object user was created so it can be used along the class User with
//            the methods Set.
//            */
//            
//            User user = new User();
//            user.setEmail(email);
//            user.setPassword(password);
//            
//            /*
//            The user will add the email and passoword and it will be stored inside
//            the arraylist that was created outside the for.
//            */
//            
//            users.add(user);
//        }
//        
//        
//        for (int i = 0; i < users.size(); i++){
//            
//            /*The variable userTemp will be a temporary variable that will store
//            and get the value inside the Array, inside the brakets I'm using (i)
//            that means they will get the first value and when the loops start again
//            it will get the second and so on, because I'm incringing it in the FOR*/
//            
//            User userTemp = users.get(i);
//            
//            /*
//            Now, printing it on screen, and we can do it in two different ways,
//            first one using the variable userTemp(will point the first value in the 
//            Array) + getEmail(will get the first value that was stored), Second way
//            is to use the Array method Get and then the User method in sequence.
//            */
//            
//            System.out.println("email" + i + " is: "+ userTemp.getEmail()); //users.get(i).getEmail()
//            System.out.println("password" + i + " is: " + userTemp.getPassword()); //users.get(i).getPassword()
//            
//        }
    }
    
}
