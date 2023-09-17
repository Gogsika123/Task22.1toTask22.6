import java.util.Scanner;//task 22.3

public class SubstringChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        double startTime = System.currentTimeMillis();
        String firstString = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();
        if (isSubstring(firstString, secondString)) {
            System.out.println("The second string is a substring of the first string.");
        } else {
            System.out.println("The second string is not a substring of the first string.");
        }
        double endTime = System.currentTimeMillis();
        double time = endTime - startTime;
        System.out.println("Estimated time for operation is " + time + " millisecond");
    }

    public static boolean isSubstring(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        if (str2Length > str1Length) {
            return false;
        }
        for (int i = 0; i <= str1Length - str2Length; i++) {
            boolean isMatch = true;
            for (int j = 0; j < str2Length; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return true;
            }
        }

        return false;
    }
}
