import java.util.Scanner;//task 22.4

public class SubstringIndexFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String firstString = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String secondString = scanner.nextLine();
        int index = findSubstringIndex(firstString, secondString);
        if (index != -1) {
            System.out.println("The second string is a substring of the first string.");
            System.out.println("Matched at index " + index);
        } else {
            System.out.println("The second string is not a substring of the first string.");
        }
    }
    public static int findSubstringIndex(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        if (str2Length > str1Length) {
            return -1;
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
                return i;
            }
        }
        return -1;
    }
}
