import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        multiplication();
        int secretNum = generateRandom();
        compute(secretNum);
        vend();
        sc.close();
    }

    public static void multiplication()
    {
        for (int i = 2; i < 11; i += 2){
            for (int j = 2; j < 11; j += 2){
                int sum = i * j;
                System.out.println(i + " x " + j + " = " + sum);
            }
            System.out.println("Multiplication table of " + i);
        }
    }

    public static int generateRandom(){
        Random random = new Random();
        int secretNum = random.nextInt(101); // Ranges from 0=100
        System.out.println(secretNum); // to check conditions
        return secretNum;
    }

    public static void compute(int secretNum){
        int count = 0;
        int guess;

        System.out.println("I'm thinking of a number.");
        System.out.println("Guess what it is: ");

        while (count < 10){ // counter
           guess = sc.nextInt();
           count++;
           if (guess > secretNum){
               System.out.println("Sorry, that's too high.");
               System.out.println("Guess what it is: ");
           } else if (guess < secretNum) {
               System.out.println("No that's too low.");
               System.out.println("Guess what it is: ");
           } else {
               System.out.println("Congratulations! You guessed it!");
               break;
           }
        }
        System.out.println("I was thinking of the number " + secretNum +".");
    }

    public static void vend(){

        // 2 lists each having the product and price be equal to the same index location.
        String [] drinks = {"Coke", "Sprite", "MountainDew", "Dr.Pepper", "PowerAde"};
        double [] prices = {0.50, 1.00, 1.25, 0.75, 1.50};

        System.out.println("Put money in the vending machine: $");
        double balance = sc.nextDouble(); // Stores dollar amount


        System.out.println("Select your item: ");
        System.out.println("1. Coke\n2. Sprite\n3. Mountain Dew\n4. Dr.Pepper\n5. PowerAde");
        int choice = sc.nextInt();

        while (choice < 1 || choice > 5){ // Loop checks for valid input.
            System.out.println("Please choose a valid option!");
            System.out.println("Make another selection");
            System.out.println("1. Coke\n2. Sprite\n3. Mountain Dew\n4. Dr.Pepper\n5. PowerAde");
            choice = sc.nextInt();
        }

        while (balance >= 0.50){
            if (balance >= prices[choice - 1]) {
                balance -= prices[choice - 1];
                System.out.printf("You selected %s Your change is: $%.2f%n", drinks[choice - 1], balance);
                System.out.println("Please make another selection");
                System.out.println("1. Coke\n2. Sprite\n3. Mountain Dew\n4. Dr.Pepper\n5. PowerAde");
                 choice = sc.nextInt();
            } else if (balance < prices[choice - 1]) {
                System.out.println("Not enough money\nThank you for shopping!");
                System.out.printf("Change: $%.2f%n", balance);
                break;
            }
        }

    }
}