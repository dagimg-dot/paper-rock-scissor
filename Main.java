import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static private Map<String, String> calculatorMap = new HashMap<>();
    static private Map<String, String> Winner = new HashMap<>();
    static private boolean isPlayingAgain = false;

    static private void populate() {
        // populate the calculator map
        calculatorMap.put("rs", "r");
        calculatorMap.put("pr", "p");
        calculatorMap.put("sp", "s");
        calculatorMap.put("sr", "r");
        calculatorMap.put("rp", "p");
        calculatorMap.put("ps", "s");

        // populate the winner map
        Winner.put("r", "Rock breaks scissor");
        Winner.put("p", "Paper covers rock");
        Winner.put("s", "Scissor cuts paper");
    }

    static private void welcome() {
        System.out.println("\t\t Rock Paper Scissor Game");
        System.out.println("\t\t Developed in Java by dagimg-dot");
    }

    static private boolean validateChar(String c) {
        String[] possible_choice = { "r", "R", "p", "P", "s", "S" };
        boolean isValid = false;
        for (String ch : possible_choice) {
            if (c.equals(ch)) {
                isValid = true;
            }
        }
        return isValid;
    }

    static private String acceptInput(int player_num, Scanner input) {
        System.out.print("Player " + player_num + ": ");
        String player = input.next();
        while (validateChar(player) == false) {
            System.out.println("Invalid input, please enter your choice again");
            System.out.print("Player " + player_num + ": ");
            player = input.next();
        }
        return player;
    }

    static private boolean find(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }

    static private int acceptNumPlayers(Scanner input) {
        int num = 0;
        System.out.println("1. Multi Player");
        System.out.println("2. Single Player (play with the computer)");
        try {
            num = input.nextInt();
            int[] choices = { 1, 2 };
            while (!find(num, choices)) {
                System.out.print("Invalid input, enter again: ");
                num = input.nextInt();
            }

        } catch (Exception e) {
            System.out.println("You have to enter an integer !!");
        }
        return num;
    }

    static private String computerChoice() {
        String[] choices = { "r", "s", "p" };
        long choice = Math.round(Math.random() * 10);
        int index = (int) choice % 3;
        System.out.println("The computer'choice was " + choices[index]);

        return choices[index];
    }

    static private String calculateWinner(String p1, String p2) {
        return calculatorMap.get(p1 + p2);
    }

    public static void main(String[] args) {
        String play;
        String p1 = "", p2 = "";
        do {
            populate();
            if (!isPlayingAgain) {
                welcome();
            }
            Scanner input = new Scanner(System.in);
            int num = acceptNumPlayers(input);
            if (num == 1) {
                p1 = acceptInput(1, input);
                p2 = acceptInput(2, input);
            } else if (num == 2) {
                p1 = acceptInput(1, input);
                p2 = computerChoice();
            } else {
                System.out.println("Something is wrong");
                System.exit(0);
            }
            String winner = calculateWinner(p1.toLowerCase(), p2.toLowerCase());
            if (winner == null) {
                System.out.println("There is no winner in this round");
            } else {
                System.out.println(
                        "The winner is " + Winner.get(winner).split(" ")[0] + ", because " + Winner.get(winner));
            }

            System.out.print("Do you want to play again ? (Y/N) : ");
            play = input.next();
            boolean playAgain = play.equals("y") || play.equals("Y");
            if (playAgain)
                isPlayingAgain = true;
        } while (play.equals("y") || play.equals("Y"));
    }
}