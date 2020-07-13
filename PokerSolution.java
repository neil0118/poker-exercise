
import java.util.Arrays;

public class PokerSolution {

    public double analyzeHands(String input) {
        String[] cards = input.split(" ");
        Integer[] nums = { 0, 0, 0, 0, 0 };
        Integer[] royalFlush = { 10, 11, 12, 13, 14 };
        String suits = "";
        for (int i = 0; i < cards.length; i++) {
            char[] tmps = cards[i].toCharArray();
            switch (tmps[0]) {
                case 'T':
                    nums[i] = 10;
                    break;
                case 'J':
                    nums[i] = 11;
                    break;
                case 'Q':
                    nums[i] = 12;
                    break;
                case 'K':
                    nums[i] = 13;
                    break;
                case 'A':
                    nums[i] = 14;
                    break;
                default:
                    nums[i] = Integer.parseInt(Character.toString(tmps[0]));
            }
            suits += Character.toString(tmps[1]);
        }
        Arrays.sort(nums);

        double param = nums[4] * 0.01 + nums[3] * 0.0001 + nums[2] * 0.000001 + nums[1] * 0.00000001
                + nums[0] * 0.0000000001;

        // 5 cards in same suits
        if (suits.equals("DDDDD") || suits.equals("HHHHH") || suits.equals("SSSSS") || suits.equals("CCCCC")) {
            if (Arrays.equals(nums, royalFlush)) {
                // royal flush
                return 10;
            }

            if (nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
                // straight flush
                return 9.0 + param;
            }

            if (nums[0] == nums[3] || nums[1] == nums[4]) {
                // Four of a kind
                int tmp = 0;
                if (nums[0] != nums[2]) {
                    tmp = nums[0];
                } else {
                    tmp = nums[4];
                }
                return 8.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + nums[2] * 0.00000001
                        + tmp * 0.0000000001;
            }

            if ((nums[0] == nums[2] && nums[3] == nums[4]) || (nums[0] == nums[1] && nums[2] == nums[4])) {
                // Full House
                int tmp = 0;
                if (nums[0] != nums[2]) {
                    tmp = nums[0];
                } else {
                    tmp = nums[4];
                }
                return 7.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + tmp * 0.00000001
                        + tmp * 0.0000000001;
            }

            // flush
            return 6.0 + param;
        }

        if (nums[0] == nums[3] || nums[1] == nums[4]) {
            // Four of a kind
            int tmp = 0;
            if (nums[0] != nums[2]) {
                tmp = nums[0];
            } else {
                tmp = nums[4];
            }
            return 8.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + nums[2] * 0.00000001
                    + tmp * 0.0000000001;
        }

        if ((nums[0] == nums[2] && nums[3] == nums[4]) || (nums[0] == nums[1] && nums[2] == nums[4])) {
            // Full House
            int tmp = 0;
            if (nums[0] != nums[2]) {
                tmp = nums[0];
            } else {
                tmp = nums[4];
            }
            return 7.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + tmp * 0.00000001 + tmp * 0.0000000001;
        }

        if (nums[4] - nums[3] == 1 && nums[3] - nums[2] == 1 && nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) {
            // straight
            return 5.0 + param;
        }

        // Three of a kind
        if ((nums[0] == nums[2])) {
            return 4.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + nums[4] * 0.00000001
                    + nums[3] * 0.0000000001;
        }
        if ((nums[1] == nums[3])) {
            return 4.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + nums[4] * 0.00000001
                    + nums[1] * 0.0000000001;
        }
        if ((nums[2] == nums[4])) {
            return 4.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[2] * 0.000001 + nums[1] * 0.00000001
                    + nums[0] * 0.0000000001;
        }

        // Two pairs
        if ((nums[0] == nums[1] && nums[2] == nums[3])) {
            return 3.0 + nums[2] * 0.01 + nums[2] * 0.0001 + nums[0] * 0.000001 + nums[0] * 0.00000001
                    + nums[4] * 0.0000000001;
        }
        if ((nums[0] == nums[1] && nums[3] == nums[4])) {
            return 3.0 + nums[3] * 0.01 + nums[3] * 0.0001 + nums[1] * 0.000001 + nums[1] * 0.00000001
                    + nums[2] * 0.0000000001;
        }
        if ((nums[1] == nums[2] && nums[3] == nums[4])) {
            return 3.0 + nums[3] * 0.01 + nums[3] * 0.0001 + nums[1] * 0.000001 + nums[1] * 0.00000001
                    + nums[0] * 0.0000000001;
        }

        // Pair
        if ((nums[0] == nums[1])) {
            return 2.0 + nums[1] * 0.01 + nums[0] * 0.0001 + nums[4] * 0.000001 + nums[3] * 0.00000001
                    + nums[2] * 0.0000000001;
        }
        if ((nums[1] == nums[2])) {
            return 2.0 + nums[2] * 0.01 + nums[1] * 0.0001 + nums[4] * 0.000001 + nums[3] * 0.00000001
                    + nums[0] * 0.0000000001;
        }
        if ((nums[2] == nums[3])) {
            return 2.0 + nums[3] * 0.01 + nums[2] * 0.0001 + nums[4] * 0.000001 + nums[1] * 0.00000001
                    + nums[0] * 0.0000000001;
        }
        if ((nums[3] == nums[4])) {
            return 2.0 + param;
        }

        // High card
        return 1.0 + param;
    }

}