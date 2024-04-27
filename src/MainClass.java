import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        int possibleStrongNumbers = 7;
        int numberOfRegularNumbers = 6;
        int possibleRegularNumbers = 37;
        int numberOfLines = 10;
        createLines(possibleStrongNumbers, numberOfRegularNumbers, possibleRegularNumbers, numberOfLines);
    }

    private static void createLines(int possibleStrongNumbers,
                                    int numberOfRegularNumbers, int possibleRegularNumbers, int numberOfLines) {
        for (int i = 0; i < numberOfLines; i++) {
            int lineNumber = i + 1;
            System.out.print("Line " + lineNumber + ": ");
            int[] blankArrayOfRegularNumbers = createBlankArray(numberOfRegularNumbers);
            int[] filledRegularNumbersArray = fillArray(blankArrayOfRegularNumbers, numberOfRegularNumbers, possibleRegularNumbers);
            sortArray(filledRegularNumbersArray);
            int strongNumber = createStrongNumber(possibleStrongNumbers);
            presentNumbers(filledRegularNumbersArray, strongNumber);
        }
        System.out.print("Maybe this time...");
    }

    private static int[] sortArray(int[] filledRegularNumbersArray) {
        Arrays.sort(filledRegularNumbersArray);
        return filledRegularNumbersArray;
    }

    private static void presentNumbers(int[] filledRegularNumbersArray, int strongNumber) {
        for (int i = 0; i < filledRegularNumbersArray.length; i++) {
            System.out.print(filledRegularNumbersArray[i] + " ");
        }
        System.out.print("  ");
        System.out.print("Strong number: " + strongNumber);
        System.out.println();
    }

    private static int createStrongNumber(int possibleStrongNumbers) {
        return (int) (Math.random() * possibleStrongNumbers) + 1;
    }

    private static int[] fillArray(int[] blankArrayOfRegularNumbers, int numberOfRegularNumbers,
                                   int possibleRegularNumbers) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < numberOfRegularNumbers; i++) {
            blankArrayOfRegularNumbers[i] = (int) (Math.random() * possibleRegularNumbers) + 1;
            checkIfNumberAlreadyExistInArray(blankArrayOfRegularNumbers, possibleRegularNumbers,
                    intList.contains(blankArrayOfRegularNumbers[i]), i, intList);
            intList.add(blankArrayOfRegularNumbers[i]);
        }
        return blankArrayOfRegularNumbers;
    }

    private static void checkIfNumberAlreadyExistInArray(int[] blankArrayOfRegularNumbers, int possibleRegularNumbers,
                                                         boolean contains, int i, List<Integer> intList) {
        while (contains) {
            blankArrayOfRegularNumbers[i] = (int) (Math.random() * possibleRegularNumbers) + 1;
            contains = intList.contains(blankArrayOfRegularNumbers[i]);
        }
    }

    private static int[] createBlankArray(int numberOfRegularNumbers) {
        return new int[numberOfRegularNumbers];
    }


}
