/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration_and_login1;

import java.util.Scanner;


public class Registration_and_Login1 {
   
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        Login login = new Login();
        
        //Declaring variables for global use
        String username = "";
        String password = "";
        String cellnumber = "";
        
        
        
         while (true) { //creating a loop until conditions for username are met 
        System.out.println("Enter your username");
        username= scan.nextLine();
        
        if (username.length() <=5 && username.contains("_")) { //equal to or less than 5 characters and contains underscore
            System.out.println("Username successfully captured");
            break; // break loop
         } 
         
        else {
 System.out.println("Username is not correctly formartted; please ensure that username contains an underscore and is no more than five characters in length");}
         }
                
        
while (true) { //Loop until conditions for password are met
System.out.println("Enter your new password");
password = scan.nextLine();

String regex_password = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_]).{8,}$"; // Declaring and assigning regex

if (password.length() >=8 && password.matches(regex_password)) {
     /** ^,it means the beginning of the string
         (?=.*[A-Z], it scans for at least one uppercase
         (?=.*[0-9]), it scans for at least one number
         (?=.*[\\W_]), it scans for at least one special character
          {8,} , it means at least 8 characters long
         +$, means end of the string, containing one or more previous groups */ 
     System.out.println("Password successfully captured");
break;} //break loop
   else {
System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character");
}  
}

while(true) { //Loop until it meets the required conditions for cellphone
  System.out.println("Enter your cell phone number");
cellnumber= scan.nextLine();

String regex = "^\\+[0-9]{1,3}[0-9]{1,15}$"; //Declaring and assigning regex


if (cellnumber.matches(regex)) {
    /** Regex explanation :
^\+ means the cell number will start with a +
[0-9] country code, {1,3} only 1 to 3 digits allowed
[0-9] number parts, {1,15} only 1 to 15 digits allowed
$, means the last part must end with the last group*/
    
System.out.println("Cell phone number successfully added");
break;} 

else { 
System.out.println("Cell phone number incorrectly formatted or does not contain international code");
}
}

// previous registration details for username, password, and cell must remain the same)

// to give an update if the registration is successful or not
String regStatus = login.registerUser(username, password);
System.out.println(regStatus);

// 2. LOGIN PROCESS
while (true) {
    System.out.println("Enter your username to login");
    String login_username = scan.nextLine();
    
    System.out.println("Enter your password to login");
    String login_password = scan.nextLine();
    
    // We check if the login is successful or not
    if (login.loginUser(login_username, username, login_password, password)) {
        
        // Print the "A successful login" message from the Login class
        System.out.println(login.returnLoginStatus(login_username, username, login_password, password));
        
        System.out.println("Welcome " + username + " it is great to see you again");
        break;
    } else {
        // Print the "A failed login" message from the Login class
        System.out.println(login.returnLoginStatus(login_username, username, login_password, password));
        
        // YOUR MUST-HAVE MESSAGE:
        System.out.println("Username or password incorrect please try again");
    }
}
    }
}