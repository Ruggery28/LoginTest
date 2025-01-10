/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tasklist;

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
        
        System.out.println("Enter your email: ");
        email = kBoard.nextLine();
        System.out.println("Enter your password: ");
        password = kBoard.nextLine();
        
        User user = new User();
        user.getEmail(email);
        user.getPassword(password);
        
        System.out.println("email: " + user.setEmail());
        System.out.println("password: " + user.setPassword());
        
        
        
        
        
        
        
    }
    
}
