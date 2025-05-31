import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ATM atm = new ATM(sc);
        Deposit d = new Deposit(sc);
        Withdrawl w = new Withdrawl(sc);
        Transfer t = new Transfer(sc);
        Quit q = new Quit(sc);
        atm.start();
        System.out.println("To perform transaction,Enter the following:");
        System.out.println("1 for Deposit:"+" "+"2 for Withdrawl"+" "+"3 for Money Transfer"+" "+"4 for exit");
        String choice = sc.next();
        switch (choice) {
            case "1":
                d.deposit(atm);
                break;
            case "2":
                 w.withdrawl(atm);
                 break;
            case "3":
                t.transfer(atm);
                  break;
            case "4":
                q.quit(atm);
                break;
            default:
            System.out.println("Invalid Transaction:");
                break;
        }
        atm.printTransactionHistory();
        sc.close();
    }
}

class ATM {
    private String userID;
    private int userpin;
    private double balance = 1000; // minimum balance
    private Scanner sc;
    private String TransactionHistory="";
    public ATM(Scanner scanner) {
        this.sc = scanner;
    }

    void start() {
        System.out.println("Enter the userId:");
        userID = sc.nextLine();
        System.out.println("Enter the userpin:");
        userpin = sc.nextInt(); 
        sc.nextLine(); 
        
        if (userID.equals("ABCD") && userpin == 1234) {
            System.out.println("Welcome to ATM: Begin your transaction");
        } else {
            System.out.println("Wrong Credentials! Try again later");
            System.exit(0);
        }
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double newBalance) {
        balance = newBalance;
    }
    void addtotransactionhistory(String transaction){
        TransactionHistory+=transaction;
    }
    void printTransactionHistory(){
        System.out.println("Transaction History:");
        System.out.println(TransactionHistory+" ");
        sc.nextLine();
    }
}

class Withdrawl {
    private Scanner sc;

    public Withdrawl(Scanner scanner) {
        this.sc = scanner;
    }

    void withdrawl(ATM atm) { 
        System.out.println("Enter the withdrawal amount:");
        double withdrawAmt = sc.nextDouble();
        sc.nextLine(); 
        
        if (withdrawAmt <= atm.getBalance()) { 
            System.out.println("Transaction proceesed! Please collect cash");
            double newBalance = atm.getBalance() - withdrawAmt;
            atm.setBalance(newBalance);
            System.out.println("The current balance is: " + atm.getBalance());
            atm.addtotransactionhistory("Withdrawal of Rupee" + withdrawAmt);
        } else {
            System.out.println("Insufficent amount!");
        }
    }
}

class Deposit {
    private Scanner sc;

    public Deposit(Scanner scanner) {
        this.sc = scanner;
    }

    void deposit(ATM atm) {
        System.out.println("Enter the deposit amount:");
        double depositAmount = sc.nextDouble();
        sc.nextLine();
        
        double newBalance = atm.getBalance() + depositAmount;
        atm.setBalance(newBalance);
        System.out.println("The current balance is: " + atm.getBalance());
        atm.addtotransactionhistory("Deposit of Rupee" + depositAmount);
    }
}
class Transfer{
    private Scanner sc;

    public Transfer(Scanner scanner) {
        this.sc = scanner;
    }
    void transfer(ATM atm){
       System.out.println("Enter the userID of the receipent:");
       String userID=sc.next();
       System.out.println("Enter the userpin of the receipent:");
       int userpin= sc.nextInt();
       if(userID.equals("DEFG")&&userpin==5678){
        System.out.println("Credantials are correct:Proceed with Transfer");
       }else{
        System.out.println("Invalid receipent!");
        System.exit(0);
       }
       System.out.println("Enter the amount for transfer:");
       double transferamount= sc.nextDouble();
       if(transferamount<=atm.getBalance()){
        System.out.println("Transaction Succesful:Amount sent to receipent");
        double newBalance= atm.getBalance()-transferamount;
        atm.setBalance(newBalance);
        System.out.println("The balance is:"+atm.getBalance());
        atm.addtotransactionhistory("Transfer of Rupee" + transferamount+" " +"to"+" "+userID);
       }else{
        System.out.println("Amount insufficent!Try later");
       }
    }
}
class Quit{
    private Scanner sc;

    public Quit(Scanner scanner) {
        this.sc = scanner;
    }
    void quit(ATM atm){
        System.out.println("Thanks for processing:");
        System.out.println("Your balance is:"+atm.getBalance());
    }
}
