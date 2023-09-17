import java.util.Scanner;//task 22.2

public class MaxIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        double startTime = System.currentTimeMillis();
        String inputString = input.nextLine();
        String maxIncreasingSubsequence = findMaxIncreasingSubsequence(inputString);
        System.out.println("Maximum Increasing Subsequence: " + maxIncreasingSubsequence);
        double endTime = System.currentTimeMillis();
        double time = endTime - startTime;
        System.out.println("Estimated time for operation is " + time + " millisecond");
    }
    public static String findMaxIncreasingSubsequence(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "";
        }
        int length = inputString.length();
        int[] dp = new int[length];
        int[] prev = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (inputString.charAt(i) > inputString.charAt(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxLength = 0;
        int endIndex = 0;

        for (int i = 0; i < length; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }
        StringBuilder result = new StringBuilder();
        while (endIndex >= 0) {
            result.insert(0, inputString.charAt(endIndex));
            endIndex = prev[endIndex];
        }
        return result.toString();
    }
}
