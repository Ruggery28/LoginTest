/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tasklist;

/**
 *
 * @author Ruggery
 */
public class User {
    
    /* 
    When a class is Private, it will only share inside the class, so you can only
    call the variable if you are in the same class, it's safer and better. However,
    it's still possible to store it from another class in another file, but we need
    the parameters Get and Set.
    */
    private String email, password;
    
    
    /*Here in this method Get, the user will enter a value in the main[TaskList]
    and it will be stored here in this.email [references private String email] 
    and it will receive the value in the String email I'm getting from the main[TaskList]*/
    public void getEmail(String email){
        this.email = email;
    }
    
    /*
    Here in this method Set, what email user entered in the main[TaskList] after 
    is stored in the private email here in this class, I need to see it in the 
    main[TaksList]. so, I can create a setEmail method that returns the email value
    stored in the getEmail method.
    */
    public String setEmail(){
        return email;
    }
    
    public void getPassword(String password){
        this.password = password;
    }
    
    public String setPassword(){
        return password;
    }
    
}
