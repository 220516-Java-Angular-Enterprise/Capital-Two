package com.revature.CapitalTwo.ui;

import com.revature.CapitalTwo.models.User;
import com.revature.CapitalTwo.services.FontService;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class FirstUserMenu implements MenuTemplate{
    private final User user;
    public FirstUserMenu(User user) {
        this.user = user;
    }
    FontService font = new FontService();
    Scanner scan = new Scanner(System.in);



    @Override
    public void start() {
        private void displayOptions(){
            System.out.println();
            System.out.println("[1]"+font.whiteBold(" Open a checkings account"));
            System.out.println("[2]"+font.whiteBold(" Open a credit account") );
            System.out.println("[3]"+font.whiteBold(" Open a loan"));


            System.out.print(font.green("Enter: "));
            String input = scan.nextLine();
            BankAcc bankAcc = new BankAcc(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), user.getId(), 0);
            bankAccService.save(bankAcc);
            switch (input) {
                case "1":
                    Debit debit = new Debit(bankAcc.getDebitId, 0, 0);
                   new MainMenu(user).checkingMenu(debit);
                    break;
                case "2":
                    Credit credit = new Credit(bankAcc.getCreditId, 0, 0, bankAcc.getDebitId);
                    new MainMenu(user).creditMenu(credit);
                    break;
                case "3":
                    LoanHistory loanHist = new LoanHistory(UUID.randomUUID().toString(), LocalDateTime.now(), "null", "null");
                    Loan loan = new Loan(UUID.randomUUID().toString(), 0, loanHist.getId);
                    bankAcc.setLoanId(loan.getID);
                    bankAccService.update(bankAcc);
                    new MainMenu(user).loanMenu(loan);
                    break;
                default:
                    System.out.println("Wrong input.");
            }

        }
    }
}
