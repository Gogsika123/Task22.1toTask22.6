import java.util.Scanner;//task 22.5

public class LongestSameNumberSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a series of numbers ending with 0:");
        int currentNumber = scanner.nextInt();
        int longestNumber = currentNumber;
        int currentLength = 1;
        int longestLength = 1;
        int currentIndex = 0;
        int longestIndex = 0;

        int index = 1;

        while (currentNumber != 0) {
            int nextNumber = scanner.nextInt();
            if (nextNumber == currentNumber) {
                currentLength++;
            } else {
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestNumber = currentNumber;
                    longestIndex = currentIndex;
                }
                currentNumber = nextNumber;
                currentLength = 1;
                currentIndex = index;
            }
            index++;
        }
        if (longestLength > 1) {
            System.out.println("The longest same number sequence starts at index " + longestIndex + " with " + longestLength + " values of " + longestNumber);
        } else {
            System.out.println("No same number sequence found.");
        }
    }
}
