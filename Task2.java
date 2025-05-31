import java.util.*;
public class Task2{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int attempts=10;//declaring max attempts 
    int score =0;
    boolean playonce= true;

    System.out.println("Welcome to the Game, where you would have fun");
    System.out.println("To win, you have" +" "+ attempts + " " + "Attempts");
    while (playonce) {
        int randomnumber = getrandN(1,100);
        boolean choose = false;
        for(int k = 0;k<attempts;k++){//initalizing a for loop for efficncy in code
             System.out.println("Enter the number:");
             int num=sc.nextInt();
              if(num>randomnumber){
                System.out.println("Too high number");
              }
              else if(num<randomnumber){
                System.out.println("Too low number");
              }
              else{
                System.out.println("You won the game");
                choose = true;
                score +=1;
                break;
              }
        }
      if(choose == false){
        System.out.println("Oops!! You have lost the game...");
        System.out.println("The number is:"+randomnumber);
      }
      System.out.println("Wanna play again (Yes/No)");
      String check = sc.next();
      playonce=check.equalsIgnoreCase("Yes");
    }
    System.out.println("The game is done");
    System.out.println("Your score is:"+score);
     sc.close();
    }
    public static int getrandN(int min,int max){
    return (int)(Math.random()*(max-min+1)+min);
    } 
  }
