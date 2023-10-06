package lb3;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //Task 1
        System.out.print("Task 1: Enter your string: ");
        String inputString= s.next();
        boolean endsWithEd = endsWithEd(inputString);
        System.out.println("String ends with 'ed': " + endsWithEd + "\n");

        //Task 2
        System.out.print("Task 2: Enter your string: ");
        inputString= s.next();
        int sumOfDigits = sumDigits(inputString);
        System.out.println("The sum of the numbers in the line: " + sumOfDigits + "\n");


        //Task 3
        System.out.print("Task 3: Enter your string: ");
        inputString= s.next();
        int maxLength = findLongestLength(inputString);
        System.out.println("The length of the longest block: " + maxLength + "\n");


        //Task 4
        System.out.print("Task 4: Enter your string: ");
        inputString = "NEBOHA MAX OlEGOVICH";
        System.out.println("Words in line:");
        printWordsFromString(inputString);


        //Task 5
        String A = "SUPER";
        String B = "puperrr";
        String interleaved = connectionStrings(A, B);
        System.out.println("\nTask 5: " + interleaved);

    }
    private static boolean endsWithEd(String inputString) {
        return inputString.trim().endsWith("ed");
    }


    private static int sumDigits(String inputString) {
        int sum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (Character.isDigit(currentChar)) {
                // Якщо поточний символ є цифрою, додайте його до суми.
                int digit = Character.getNumericValue(currentChar);
                sum += digit;
            }
        }
        return sum;
    }


    private static int findLongestLength(String inputString){
        if(inputString == null || inputString.isEmpty()){
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for(int i = 1; i <inputString.length(); i++){
            if(inputString.charAt(i) == inputString.charAt(i-1)){
                currentLength++;
            }
            else{
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }


    public static void printWordsFromString(String inputString){
        String[] words = inputString.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }


    public static String connectionStrings(String A, String B){
        int lenA = A.length();
        int lenB = B.length();
        int maxLength = Math.max(lenA, lenB);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            if (i < lenA) {
                result.append(A.charAt(i));
            }

            if (i < lenB) {
                result.append(B.charAt(i));
            }
        }

        return result.toString();
    }
}


