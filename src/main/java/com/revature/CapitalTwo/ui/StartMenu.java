package com.revature.CapitalTwo.ui;

import com.revature.CapitalTwo.models.User;
import com.revature.CapitalTwo.services.FontService;
import com.revature.CapitalTwo.services.UserService;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidAddressException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidPaswordException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidStateException;
import com.revature.CapitalTwo.util.custom_exceptions.InvalidUserException;

import java.util.Scanner;
import java.util.UUID;

public class StartMenu implements MenuTemplate{
    Scanner scanner = new Scanner(System.in);

    private final UserService userService;

    public StartMenu(UserService userService){this.userService = userService;}

    FontService font = new FontService();

    public void start() {
        displayIntroMenu();
        System.out.print(font.green("\nEnter: "));
        String input = scanner.nextLine();
        exit:{
//    Select menu
            while(true) {
                switch (input) {
                    case "1":
                        login();
                        break;
                    case "2":
                        createAcc();
                        break;
                    case "3":
                        System.out.println(font.purpleBold("\nWe await your return..."));
                        break exit;
                    default:
                        System.out.println("Wrong input.");
                }
            }
        }
    }

    private void displayIntroMenu() {
        System.out.println(font.whiteBold("+------------------------------------------------------------+\n"));
        System.out.println(font.redBold("            WELCOME TO CAPITAL TWO             \n"));
        System.out.println(font.greenBold("                     Press Enter to Proceed\n"));
        System.out.println(font.whiteBold("+------------------------------------------------------------+\n"));
        scanner.nextLine();
        System.out.println(font.whiteBold("+------------------------------------------------------------>\n"));
        System.out.println(font.greenBold("            PLEASE SELECT FROM THE FOLLOWING OPTIONS.\n"));
        System.out.println(font.whiteBold("+------------------------------------------------------------>\n"));
        System.out.println("[1]"+font.whiteBold(" Login\n"));
        System.out.println("[2]"+font.whiteBold(" Create Account\n"));
        System.out.println("[3]"+font.redBold(" Exit"));
    }

    private void login() {
        String username;
        String password;
        User user = new User();
        while (true) {
            System.out.println(font.whiteBold("<+------------------------------------------------------------+>\n"));
            System.out.println(font.greenBold("                             LOGIN\n"));
            System.out.println(font.whiteBold("<+------------------------------------------------------------+>\n"));
            System.out.print(font.whiteBold("                   Username: "));
            username = scanner.nextLine();

            System.out.print(font.whiteBold("\n                   Password: "));
            password = scanner.nextLine();
            System.out.println(font.whiteBold("\n<+------------------------------------------------------------+>\n"));
            try {
                user = userService.login(username, password);
                    new FirstUserMenu(user).start();
                    break;
            } catch (InvalidUserException e) {
                System.out.println(e.getMessage());
            } catch (InvalidPaswordException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private void createAcc() {
        System.out.println("Let's start creating your new account!");

        completeExit:
        {
            try {
                while (true) {

                    String username = createUserName();
                    String password = createPassword();
                    String name = createName();
                    String address = createAddress();
                    String state = createState();
                    int annualSal = createAnnaulSal();


                    System.out.print(font.whiteBold("Confirm password: ")); // Confirm Password
                    String confirmPassword = scanner.nextLine();

                    if (confirmPassword.equals(password)) {
                        System.out.println(font.greenBold("Let's confirm your information!"));

                    } else {
                        System.out.println(font.red("Passwords do not match. Try again."));
                        createPassword();
                    }

                    confirmExit:
                    {
                        System.out.println(font.greenBold("Please confirm your entered information (y/n)"));
                        System.out.println(font.whiteBold("Name: ") + name);
                        System.out.println(font.whiteBold("Username: ") + username);
                        System.out.println(font.whiteBold("Password: ") + password);


                        System.out.print(font.green("Input: "));
                        String input = scanner.nextLine();

                        switch (input) {
                            case "y":
                                User user = new User(UUID.randomUUID().toString(), name, address, state, username, password, annualSal);

                                userService.register(user);
                                login();
                                break;
                            case "n":
                                break confirmExit;
                            default:
                                System.out.println(font.red("Invalid input"));
                                break;

                        }

                    }
                }
            }
            catch(InvalidAddressException e){
                System.out.println(e.getMessage());
            } catch(InvalidStateException e){
                System.out.println(e.getMessage());
            } catch(InvalidUserException e){
                System.out.println(e.getMessage());
            } catch(InvalidPaswordException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private String createUserName() {
        String username;
        while (true) { // Make username
            System.out.print(font.whiteBold("Username: "));
            username = scanner.nextLine();

            try {
                if (userService.isValidUsername(username)) {
                    if(userService.isNotDuplicateUsername(username)) break;
                }
            }  catch(InvalidUserException e){
                System.out.println(e.getMessage());
            }
        }
        return username;
    }
    private String createPassword() {
        String password;

        while (true) { // Make password
            System.out.print(font.whiteBold("Password: "));
            password = scanner.nextLine();

            try {
                if (userService.isValidPassWord(password)) break;
            }
            catch (InvalidPaswordException e){
                System.out.println(e.getMessage());
            }
        }
        return password;
    }

    private String createAddress(){
        String address;

        while(true){
            System.out.print(font.whiteBold("Address: "));
            address = scanner.nextLine();

            try{
                if (userService.isValidAddress(address)) break;
            } catch (InvalidAddressException e){
                System.out.println(e.getMessage());
            }
        }
        return address;
    }
    private String createState(){
        String state;
        while(true){
            System.out.print(font.whiteBold("State (e.g AZ): "));
            state = scanner.nextLine();

            try{
                if (userService.isValidState(state)) break;
            } catch (InvalidStateException e){
                System.out.println(e.getMessage());
            }
        }
        return state;
    }

    private String createName(){
        String name;
        while(true){
            System.out.print(font.whiteBold("Name: "));
            name = scanner.nextLine();
            break;
        }
        return name;
    }

    private int createAnnaulSal(){
        int salary;
        while(true){
            System.out.print(font.whiteBold("Salary: "));
            salary = scanner.nextInt();
            break;
        }
        return salary;
    }

}



