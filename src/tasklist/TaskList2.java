/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasklist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
public class TaskList2 {

    public static Scanner scanner = new Scanner(System.in);
    public static User userLogged = null;

    public static void main(String[] args) {

        boolean working = true;
        ArrayList<User> users = new ArrayList();

        while (working) {

            System.out.println("==== TASK LIST MENU ====");
            System.out.println("[1] User Registration");
            System.out.println("[2] Login Page");
            System.out.println("[3] Exit");
            System.out.printf("Enter an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1": {
                    System.out.println("==== TASK LIST REGISTER ====");
                    System.out.printf("Enter an email: ");
                    String email = scanner.nextLine();
                    System.out.printf("Enter a password: ");
                    String password = scanner.nextLine();

                    User user = new User();         //create a new object of User class
                    user.setEmail(email);           //set email to User class
                    user.setPassword(password);     //set password to User class

                    ArrayList<Task> tasks = new ArrayList(); //instantiate the list array when registering the user
                    user.setTasks(tasks);

                    users.add(user);                //add user to ArrayList users
                    System.out.println("===> Email registered successfully!");
                    break;
                }
                case "2": {
                    System.out.println("==== TASK LIST LOGIN ====");
                    System.out.printf("Enter an email: ");
                    String email = scanner.nextLine();
                    System.out.printf("Enter a password: ");
                    String password = scanner.nextLine();

                    boolean loginCheck = false;
                    for (User u : users) { //A new object U is created to compare with all the users in the Array Users.

                        String uEmail = u.getEmail();           //a new variable uEmail will receive a getEmail 
                        String uPassword = u.getPassword();     //same here to password

                        boolean emailCheck = email.equals(uEmail);          //emailCheck will check if the email entered is the same in the class
                        boolean passwordCheck = password.equals(uPassword); //same here to password

                        if (emailCheck && passwordCheck) {  //checking if both are true
                            loginCheck = true;              //If it's true I'll change loginCheck to true so the next If can check that again
                            userLogged = u;                 //If we find the user, we will tell the program that U was logged in. 
                            break;
                        }
                    }

                    if (!loginCheck) {  //if LoginCheck is still false, it's because the first if didnt find the user and password
                        System.out.println("===> Email/Password incorrect! ");
                    } else {            //if the first If found the user, it will print and send the user to the new page
                        System.out.println("Login successful");
                        homePage();     //go to the method HomePage
                    }

                    break;
                }
                case "3": {
                    System.out.println("===> Exit successfully executed!");
                    working = false;
                    break;
                }
                default: {
                    System.out.println("Enter a valid option!");
                }

            }

        }

    }

    public static void homePage() {

        boolean working = true;

        while (working) {
            System.out.println("==== HOME PAGE ====");
            System.out.println("[1] Add New Task");
            System.out.println("[2] Finalise Task");
            System.out.println("[3] Show Task List");
            System.out.println("[4] Show Completed Tasks");
            System.out.println("[5] Show Not Completed Tasks ");
            System.out.println("[6] Remove Task");
            System.out.println("[7] Logout");
            System.out.printf("Enter an option: ");
            String option = scanner.nextLine();

            switch (option) {

                case "1": {
                    System.out.println("==== ADD NEW TASK ====");
                    System.out.println("Enter the name of the task: ");
                    String title = scanner.nextLine();

                    Task t = new Task();    //creating a new object T 
                    t.setTitle(title);      //sending title to class Title
                    t.setFinished(false);   //sending false to classe Title, cause as new is still in progress

                    userLogged.getTasks().add(t);   //get all tasks and adding it to the userLogged
                    System.out.println("Task saved successfully!");

                    break;
                }
                case "2": {
                    System.out.println("==== FINALISE A TASK ====");

                    ArrayList<Task> list = userLogged.getTasks();
                    ArrayList<Task> noFinished = new ArrayList();

                    for (Task t : list) {         //run all the list and store in the variable T
                        if (!t.isFinished()) {    //if T is not finished or false
                            noFinished.add(t);  //add the task in the new array nofinished
                        }
                    }

                    if (list.isEmpty()) {
                        System.out.println("There is no Task to Finalise");
                    } else {

                        for (int i = 0; i < noFinished.size(); i++) {
                            Task t = noFinished.get(i);
                            System.out.println("Task: " + i + " - Title: " + t.getTitle());
                        }

                        System.out.println("Enter the Task number you want to Finalise: ");
                        int position = scanner.nextInt();
                        scanner.nextLine();         //clean buffer

                        Task finalisedTask = noFinished.get(position);    //creat a new object and get the position inside the array noFinished
                        finalisedTask.setFinished(true);            //and then setting true inside the class setFinished

                        //userLogged.getTasks().get(position).setFinished(true); //Same thing as before but all in one line
                        System.out.println("Task finalised successfully!");
                    }
                    break;
                }
                case "3": {
                    System.out.println("==== TASKS ====");
                    ArrayList<Task> list = userLogged.getTasks(); //inside the Array Task I'm creating a list of task and getting everything from the user that was logged

                    if (list.isEmpty()) { //if list is empty it will show this message before the FOR
                        System.out.println("Task List is Empty!");
                    }

                    for (int i = 0; i < list.size(); i++) {
                        Task t = list.get(i); //creating a temporary t to store the first item of the Array
                        System.out.println("Task " + i); //printing Task + index
                        System.out.println("\tTitle: " + t.getTitle()); //printing title of the Task
                        System.out.println("\tFinished: " + t.isFinished()); //printing if the task was finished
                    }

                    break;
                }
                case "4": {
                    System.out.println("==== FINALISED TASKS ====");
                    ArrayList<Task> list = userLogged.getTasks();   //inside the Array Task I'm creating a list of task and getting everything from the user that was logged
                    ArrayList<Task> finished = new ArrayList();     //in this Array I will store all the task that was finished

                    for (Task t : list) {        //all task will be listed here
                        if (t.isFinished()) {    //if the task is finished   
                            finished.add(t);    //I'll add them inside T
                        }
                    }

                    if (finished.isEmpty()) {
                        System.out.println("There is no finished tasks!");
                    }

                    for (int i = 0; i < finished.size(); i++) {      //For to read all the finished list
                        Task t = finished.get(i);                   //stored in T

                        System.out.println("Task " + i);
                        System.out.println("\tTitle: " + t.getTitle());
                        System.out.println("\tFinished: " + t.isFinished());
                    }
                    break;
                }
                case "5": {
                    System.out.println("==== NOT FINALISED TASKS ====");
                    ArrayList<Task> list = userLogged.getTasks();   // Same idea, creating a list with all the tasks that was created by the logged user
                    ArrayList<Task> notFinished = new ArrayList();  // Creating a new Array to store all the task that havent been completed yet.

                    for (Task t : list) {         //a for to scan all the task inside the list
                        if (!t.isFinished()) {    //a If to compare if the task wasnt finished
                            notFinished.add(t); //if not finished I will store inside the variable T
                        }
                    }

                    if (notFinished.isEmpty()) {
                        System.out.println("There is no Not finished tasks!");
                    }

                    for (int i = 0; i < notFinished.size(); i++) {    //for to read all unfinished
                        Task t = notFinished.get(i);                //store everything in T

                        System.out.println("Task " + i);
                        System.out.println("\tTitle: " + t.getTitle());
                        System.out.println("\tFinished: " + t.isFinished());
                    }

                    break;
                }
                case "6": {
                    System.out.println("==== DELETE TASKS ====");
                    ArrayList<Task> list = userLogged.getTasks();

                    if (list.isEmpty()) {
                        System.out.println("There is no task to delete!");
                    } else { 
                        for (int i = 0; i < list.size(); i++) {         //create a for to run over all the task inside the list
                            Task t = list.get(i);                       //store in a temporary variable t inside the class Task and get the position
                            System.out.println("Task: " + i + " - Title: " + t.getTitle());
                        }

                        System.out.println("Enter the number of Task you want to Delete");
                        int position = scanner.nextInt();
                        scanner.nextLine();     //clean buffer

                        list.remove(position);  //remove the task according to the position
                        System.out.println("Task deleted successfully!");
                    }
                    break;
                }
                case "7": {
                    System.out.println("===>Logging out...");
                    working = false;
                    userLogged = null;  //just to clear the user after log out
                    break;
                }
            }
        }
    }

}
