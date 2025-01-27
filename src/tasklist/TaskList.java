/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasklist;

import dao.UserDAO;
import dao.taskDAO;
import model.Task;
import model.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ruggery
 */
public class TaskList {

    public static Scanner scanner = new Scanner(System.in);
    public static User userLogged = null;

    public static void main(String[] args) {

        boolean working = true;

        while (working) {

            System.out.println("==== MAIN PAGE ====");
            System.out.println("[1] User Registration");
            System.out.println("[2] Login Page");
            System.out.println("[3] Exit");
            System.out.printf("Enter an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1": {
                    System.out.println("==== USER REGISTER ====");
                    System.out.printf("Enter an email: ");
                    String email = scanner.nextLine();
                    System.out.printf("Enter a password: ");
                    String password = scanner.nextLine();

                    User user = new User();         //create a new object of User class
                    user.setEmail(email);           //set email to User class
                    user.setPassword(password);     //set password to User class

                    ArrayList<Task> tasks = new ArrayList(); //instantiate the list array when registering the user
                    user.setTasks(tasks);

                    boolean registered = UserDAO.insertUser(user);//add user to the method insertUser inside the class USERDAO
                    if (registered) {
                        System.out.println("===> Email registered successfully!");
                    } else {
                        System.out.println("===> Error when register user, try again!");
                    }

                    break;
                }
                case "2": {
                    System.out.println("==== LOGIN PAGE ====");
                    System.out.printf("Enter an email: ");
                    String email = scanner.nextLine();
                    System.out.printf("Enter a password: ");
                    String password = scanner.nextLine();
                    //User u will check inside the method searchUserEmail if exist 
                    User u = UserDAO.searchUserEmail(email);

                    boolean loginCheck = false;
                    //if email exist and password match I will change loginCheck to true
                    if (u != null && u.getPassword().equals(password)) {
                        loginCheck = true;
                    }

                    if (loginCheck) {        //if loggin is right, I'll send userLogged U and go to homepage
                        System.out.println("Login successful");
                        userLogged = u;     //if sucessfull I'm telling to userLogged that he is new user U
                        homePage();         //go to the method HomePage
                    } else {                 //If not it means that email or password dont match
                        System.out.println("===> Email/Password incorrect! ");

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
                    t.setTitle(title);      //setting title to class Title
                    t.setFinished(false);   //setting false to classe Title, cause as new is still in progress
                    t.setidUser(userLogged.getId());  //setting idUser with the Id of the user who was logged

                    boolean insert = taskDAO.insertTask(t);   //get all tasks and adding it to the userLogged
                    if (insert) {
                        System.out.println("Task saved successfully!");
                    } else {
                        System.out.println("Error while inserting new task. Try again. ");
                    }
                    break;
                }
                case "2": {
                    System.out.println("==== FINALISE A TASK ====");

                    ArrayList<Task> list = taskDAO.searchUserTask(userLogged);
                    ArrayList<Task> noFinished = new ArrayList();

                    for (Task t : list) {         //run all the list and store in the variable T
                        if (!t.isFinished()) {    //if T is not finished or false
                            noFinished.add(t);  //add the task in the new array nofinished
                        }
                    }

                    if (list.isEmpty()) {
                        System.out.println("There is no Task to Finalise");
                    } else {

                        for (Task t : noFinished) {
                            System.out.println("Task: " + t.getId() + " - Title: " + t.getTitle());
                        }

                        System.out.println("Enter the Task number you want to Finalise: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();         //clean buffer

                        Task t = new Task();
                        t.setFinished(true);
                        t.setId(id);
                        t.setidUser(userLogged.getId());

                        boolean finished = taskDAO.updateTask(t);

                        if (finished) {
                            System.out.println("Task finalised successfully!");
                        } else {
                            System.out.println("Error while finishing a task. Try again.");
                        }
                        break;
                    }
                }
                case "3": {
                    System.out.println("==== TASKS ====");
                    ArrayList<Task> list = taskDAO.searchUserTask(userLogged); //inside the taskDAO I'm searching all tasks and getting everything from the user that was logged

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
                    ArrayList<Task> list = taskDAO.searchUserTask(userLogged);   //inside the Array Task I'm creating a list of task and getting everything from the user that was logged
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
                    ArrayList<Task> list = taskDAO.searchUserTask(userLogged);   // Same idea, creating a list with all the tasks that was created by the logged user
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
                    ArrayList<Task> list = taskDAO.searchUserTask(userLogged);

                    if (list.isEmpty()) {
                        System.out.println("There is no task to delete!");
                    } else {
                        for (Task t : list) {         //create a for to run over all the task inside the list
                            System.out.println("Task: " + t.getId() + " - Title: " + t.getTitle());
                        }

                        System.out.println("Enter the number of Task you want to Delete");
                        int id = scanner.nextInt();
                        scanner.nextLine();     //clean buffer

                        Task t = new Task();
                        t.setId(id);
                        t.setidUser(userLogged.getId());

                        boolean deleted = taskDAO.deleteTask(t);  //remove the task according to the position
                        if (deleted) {
                            System.out.println("Task deleted successfully!");
                        } else {
                            System.out.println("Error while deleting a task. Try again.");
                        }
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
