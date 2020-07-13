import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Integer player1 = 0;
        Integer player2 = 0;
        Integer draw = 0;
        String player1Hands = "";
        String player2Hands = "";
        PokerSolution ps = new PokerSolution();

        List<String> tokens = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            StringTokenizer st = new StringTokenizer(scanner.nextLine());

            while (st != null && st.hasMoreElements()) {
                tokens.add(st.nextToken());
            }

            player1Hands = tokens.get(0) + " " + tokens.get(1) + " " + tokens.get(2) + " " + tokens.get(3) + " "
                    + tokens.get(4);

            player2Hands = tokens.get(5) + " " + tokens.get(6) + " " + tokens.get(7) + " " + tokens.get(8) + " "
                    + tokens.get(9);

            if (ps.analyzeHands(player1Hands) > ps.analyzeHands(player2Hands)) {
                player1 += 1;
            } else if (ps.analyzeHands(player1Hands) < ps.analyzeHands(player2Hands)) {
                player2 += 1;
            } else {
                draw += 1;
            }

            tokens.clear();
        }
        scanner.close();

        System.out.println("Game result:");
        System.out.println("Player1 wins: " + player1.toString() + " hands");
        System.out.println("Player2 wins: " + player2.toString() + " hands");
        System.out.println("Draws: " + draw.toString() + " hands");

    }

}