/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tasklist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
public class TaskList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner kBoard = new Scanner(System.in);
        String email, password;

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
        
            //NOW LEARNING ARRYS AND LOOP
        ArrayList<User> users = new ArrayList();
        
        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter your email: ");
            email = kBoard.nextLine();
            System.out.printf("Enter your password: ");
            password = kBoard.nextLine();
            
            /*
            Object user was created so it can be used along the class User with
            the methods Set.
            */
            
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            
            /*
            The user will add the email and passoword and it will be stored inside
            the arraylist that was created outside the for.
            */
            
            users.add(user);
        }
        
        
        for (int i = 0; i < users.size(); i++){
            
            /*The variable userTemp will be a temporary variable that will store
            and get the value inside the Array, inside the brakets I'm using (i)
            that means they will get the first value and when the loops start again
            it will get the second and so on, because I'm incringing it in the FOR*/
            
            User userTemp = users.get(i);
            
            /*
            Now, printing it on screen, and we can do it in two different ways,
            first one using the variable userTemp(will point the first value in the 
            Array) + getEmail(will get the first value that was stored), Second way
            is to use the Array method Get and then the User method in sequence.
            */
            
            System.out.println("email" + i + " is: "+ userTemp.getEmail()); //users.get(i).getEmail()
            System.out.println("password" + i + " is: " + userTemp.getPassword()); //users.get(i).getPassword()
            
        }
        
        
    }

}
