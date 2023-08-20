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

    static private String calculateWinner(String p1, String p2) {
        return calculatorMap.get(p1 + p2);
    }

    public static void main(String[] args) {
        populate();
        if (!isPlayingAgain) {
            welcome();
        }
        Scanner input = new Scanner(System.in);
        String p1 = acceptInput(1, input);
        String p2 = acceptInput(2, input);
        String winner = calculateWinner(p1.toLowerCase(), p2.toLowerCase());
        System.out.print(Winner.get(winner));
    }
}