package Week4;

import java.util.Hashtable;
import java.util.Scanner;

public class Week4 {
    static void GameDecision(String x, String y, String z) {
        if (x.equals("Win")) {
            System.out.println("Congratulations, you won! \nYou picked: " + y + "\nThe computer picked: " + z);
            return;
        }else if (x.equals("Loss")){
            System.out.println("Try      again, you lost to the computer! \nYou picked: " + y + "\nThe computer picked: " + z);
            return;
        } else
            System.out.println("Wow! What are the chances? You tied with the computer. \nYou picked: " + y + "\nThe computer picked: " + z);
            return;
    }
    public static void main(String[] args) {
        //Dictionary to change robotNumber to a String
        Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>();
        my_dict.put(1, "Rock");
        my_dict.put(2, "Paper");
        my_dict.put(3, "Scissors");
        my_dict.put(4, "Lizard");
        my_dict.put(5, "Spock");

        //Setting up
        String userInput;
        Scanner input = new Scanner(System.in);
        boolean playGame = true;
        int winCount = 0;
        int lossCount = 0;
        int tiedCount = 0;
        int totalGames = 0;

        //START
        System.out.println("Hello! We will be playing Rock Paper Scissors Lizard Spock today.");

        //Loop for playing game
        while (playGame) {
            //robot input
            int robotNumber = (int) (Math.random() * 5) + 1;
            String robotInput = my_dict.get(robotNumber);

            //user input
            System.out.println("Please input your choice: \n < Rock >\n < Paper >\n < Scissors >\n < Lizard >\n < Spock >");
            userInput = input.nextLine();
            while (!userInput.equalsIgnoreCase("Rock") && !userInput.equalsIgnoreCase("Paper") && !userInput.equalsIgnoreCase("Scissors") && !userInput.equalsIgnoreCase("Lizard") && !userInput.equalsIgnoreCase("Spock")) {
                System.out.println(userInput + " is not a valid choice. Please input your choice: \n < Rock >\n < Paper >\n < Scissors >\n < Lizard >\n < Spock >");
                userInput = input.nextLine();
            }
            if (userInput.equalsIgnoreCase("Rock") && (robotInput.equals("Lizard") || robotInput.equals("Scissors"))) {
                //user -> rock
                GameDecision("Win", userInput, robotInput);
                winCount += 1;
            } else if (userInput.equalsIgnoreCase("Paper") && (robotInput.equals("Spock") || robotInput.equals("Rock"))) {
                //user -> paper
                GameDecision("Win", userInput, robotInput);
                winCount += 1;
            } else if (userInput.equalsIgnoreCase("Scissors") && (robotInput.equals("Lizard") || robotInput.equals("Paper"))) {
                //user -> scissors
                GameDecision("Win", userInput, robotInput);
                winCount += 1;
            } else if (userInput.equalsIgnoreCase("Spock") && (robotInput.equals("Scissors") || robotInput.equals("Rock"))) {
                //user -> spock
                GameDecision("Win", userInput, robotInput);
                winCount += 1;
            } else if (userInput.equalsIgnoreCase("Lizard") && (robotInput.equals("Spock") || robotInput.equals("Paper"))) {
                //user -> Lizard
                GameDecision("Win", userInput, robotInput);
                winCount += 1;
            } else if (userInput.equalsIgnoreCase(robotInput)){
                GameDecision("Tie", userInput, robotInput);
                tiedCount += 1;
            } else {
                GameDecision("Loss", userInput, robotInput);
                lossCount += 1;
            }
            System.out.println("Do you want to play again? Yes/No");
            userInput = input.nextLine();
            while (!userInput.equalsIgnoreCase("Yes") && !userInput.equalsIgnoreCase("No")) {
                System.out.println("That is not a valid choice. Please choose < Yes > or < No >");
                userInput = input.nextLine();
            }
            if (userInput.equalsIgnoreCase("Yes")) {
                playGame = true;
            } else {
                playGame = false;
            }
        }
        totalGames = (winCount + lossCount + tiedCount);

        System.out.println("Thank you for playing! Here are some stats from these/this "+totalGames+" game(s).");
        System.out.println("You won: " +winCount+"\nYou loss: "+lossCount+"\nYou tied: "+tiedCount);
    }

}
