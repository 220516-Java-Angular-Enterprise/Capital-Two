package com.revature.CapitalTwo.ui;

import com.revature.CapitalTwo.models.User;
import com.revature.CapitalTwo.services.FontService;

import java.util.Scanner;

public class MainMenu implements MenuTemplate{
// Choose open debit / credit account
FontService font = new FontService();
Scanner scan = new Scanner(System.in);
private final User user;

    public MainMenu(User user) {
        this.user = user;
    }

    @Override
    public void start() {

    }

    private void displayMainMenu(){
        System.out.println(font.whiteBold("+------------------------------------------------------------>\n"));
        System.out.println(font.greenBold("            PLEASE SELECT FROM THE FOLLOWING OPTIONS.\n"));
        System.out.println(font.whiteBold("+------------------------------------------------------------>\n"));
        System.out.println("[1]"+font.whiteBold(" View Debit Account"));
        System.out.println("[2]"+font.whiteBold(" View Credit Account") );
        System.out.println("[3]"+font.whiteBold(" View Loan Details"));
        System.out.println("[4]"+font.whiteBold(" View Account Information"));
        System.out.println("[x]"+font.redBold(" Log Out\n"));
        System.out.println(font.whiteBold("+------------------------------------------------------------>\n"));

        selectMenu:
        {
            Scanner scan = new Scanner(System.in);
            System.out.print(font.green("Enter: "));
            String input = scan.nextLine();
            switch (input) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "x":

                    break;
                case "c":

                    break;
                default:
                    System.out.println("Wrong input.");
                    break selectMenu;
            }
        }
    }


    private void checkingMenu(Debit debit){
        System.out.println(font.whiteBold(""));

    }
}
