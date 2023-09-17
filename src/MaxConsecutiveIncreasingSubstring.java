import java.util.Scanner;//task 22.1

public class MaxConsecutiveIncreasingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        double startTime = System.currentTimeMillis();
        String input = scanner.nextLine();
        scanner.close();

        String maxIncreasingSubstring = findMaxConsecutiveIncreasingSubstring(input);


        if (maxIncreasingSubstring.isEmpty()) {
            System.out.println("No consecutive increasing substring found.");
        } else {
            System.out.println("Maximum consecutive increasing substring: " + maxIncreasingSubstring);
        }
        double endTime = System.currentTimeMillis();
        double time = endTime - startTime;
        System.out.println("The execution time for operation is " + time + " millisecond");
    }


    public static String findMaxConsecutiveIncreasingSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        String maxSubstring = "";
        String currentSubstring = String.valueOf(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);
            if (currentChar > prevChar) {
                currentSubstring += currentChar;
            } else {
                if (currentSubstring.length() > maxSubstring.length()) {
                    maxSubstring = currentSubstring;
                }
                currentSubstring = String.valueOf(currentChar);
            }
        }
        if (currentSubstring.length() > maxSubstring.length()) {
            maxSubstring = currentSubstring;
        }

        return maxSubstring;
    }
}
