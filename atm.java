import java.util.*;

class bank {
    Scanner sc = new Scanner(System.in);
    double amt;
    String username;
    private int password;

    public void registration() {
        System.out.print("Enter your bank user name:");
        this.username = sc.nextLine();
        System.out.print("Enter your 4-digit ATM password:");
        password = sc.nextInt();
    }

    private boolean authenticate() {
        System.out.println("Enter your 4-digit ATM password for authentication:");
        int enteredPassword = sc.nextInt();
        return enteredPassword == password; // Return true if the entered password matches the stored password
    }

    public void deposit() {
        if (authenticate()) {
            System.out.println("Enter amount to deposit");
            double dep = sc.nextDouble();
            if (amt + dep <= 1000000) {
                amt = amt + dep;
                System.out.println("Successfully deposited");
            } else {
                System.out.println("Failed! Deposit limit is 1000000.0 \nContact to the bank");
            }
        } else {
            System.out.println("Authentication failed! Access denied.");
        }
    }

    public void withdraw() {
        if (authenticate()) {
            System.out.println("Enter the amount to withdraw:");
            double with = sc.nextDouble();
            if (amt >= with) {
                amt = amt - with;
                System.out.println("Withdrawn successfully!!");
            } else {
                System.out.println("Transation failed!!! Insufficient balance");
            }
        } else {
            System.out.println("Authentication failed! Access denied.");
        }
    }

    public void checkbalance() {
        System.out.println("Your balance amt:" + amt);
    }
}

public class atm {
    public static void main(String args[]) {
        System.out.println("WELCOME TO THE ATM , ABC BANK, SALKIA");
        Scanner s = new Scanner(System.in);
        bank ob = new bank();
        ob.registration();
        System.out.println("\n       Please enter your choice, " + ob.username + ".  \n");
        while (true) {
            System.out.println("1.Deposit \n 2.Withdraw \n 3.Balance \n 4.Exit \n Enter your choice : ");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    ob.deposit();
                    break;
                case 2:
                    ob.withdraw();
                    break;
                case 3:
                    ob.checkbalance();
                    break;
                case 4:
                    s.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
