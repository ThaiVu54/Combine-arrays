import java.util.Scanner;

public class combine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Remove element from array");
            System.out.println("2. Add element to array");
            System.out.println("3. Merge array");
            System.out.println("4. Find the largest element in a two- dimensional array");
            System.out.println("5. Find minimum value in array");
            System.out.println("6. Sum the number in a column");
            System.out.println("7. Sum the number on the main diagonal of a square matrix");
            System.out.println("8. Count the number of occurrences of a character in a string");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice){
                case 1: removeElementfromArray(input); break;
                case 2: addElementToArray(input); break;
                case 3: mergeArray(input); break;
                case 4: findLargestElementArray(input); break;
                case 5: findMinimumValueInArray(input); break;
                case 6: sumNumberInColumn(input); break;
                case 7: sumNumberMainDiagonal(input); break;
                case 8: coutNumberCharacterInString(input); break;
            }
        }while (choice != 0);
    }
    public static void removeElementfromArray(Scanner input){
        boolean check = false;
        int[]array = {1, 2, 3, 3, 4, 5, 6, 7, 7};
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        System.out.println("Enter the number to delete in the array: ");
        int delNumber = input.nextInt();
        for (int i = 0; i < array.length; i++){
            if (array[i] == delNumber){
                check = true;
            }
        }
        if (check){
            int[]newArray = delElementOfArray(array, delNumber);
            System.out.println("Array after deleted "+delNumber);
            for (int i = 0; i < newArray.length; i++){
                System.out.print(newArray[i]+"\t");
            }
            System.out.println();
        }else{
            System.out.println("Couldn't find the element to be deleted\n");
            System.out.println();
        }

    }
    public static int[] delElementOfArray(int[]array, int delNumber){
        int numberElement = 0;
        int count = 0;
        int newSize = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == delNumber){
                count++;
            }
        }
        newSize = array.length - count;
        int[]newArray = new int[newSize];
        for (int i = 0; i < array.length; i++){
            if (array[i] != delNumber){
                newArray[numberElement] = array[i];
                numberElement++;
            }
        }
        return newArray;
    }
    public static void addElementToArray(Scanner input){
        int[]array = {1, 2, 3, 4, 5, 6};
        System.out.println("The initial array is: ");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println("\nEnter value add");
        int value = input.nextInt();
        System.out.println("Enter index add");
        int index = input.nextInt();
        if (index <= -1 || index >= array.length-1){
            System.out.println("Unable to insert element into array");
        }
        else{
            System.out.println("Array after add is: ");
            int[]newArray = addValueToArray(array, value, index);
            for (int i = 0; i < newArray.length; i++){
                System.out.print(newArray[i]+"\t");
            }
            System.out.println();
        }
    }
    public static int[] addValueToArray(int[]array, int value, int index){
        int[]newArray = new int[array.length+1];
        int j = 0;
        for (int i = 0; i < array.length; i++){
            if (i == index){
                newArray[index] = value;
                newArray[index+1] = array[i];
                j+=2;
            }else {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }
    public static void mergeArray(Scanner input){
        int[]array1 = new int[5];
        int[]array2 = new int[5];
        for (int i = 0; i < array1.length; i++){
            System.out.printf("Enter array1[%d]: ",i+1);
            array1[i] = input.nextInt();
        }
        for (int i = 0; i < array2.length; i++){
            System.out.printf("Enter array2[%d]: ",i+1);
            array2[i] = input.nextInt();
        }
        System.out.println("Array after merged is: ");
        int[]array3 = mergeTwoArray(array1, array2);
        for (int i = 0; i < array3.length; i++){
            System.out.print(array3[i]+"\t");
        }
        System.out.println();
    }
    public static int[] mergeTwoArray(int[]array1, int[]array2){
        int[]newArray = new int[array1.length+array2.length];
        for (int i = 0; i < array1.length; i++){
            newArray[i] = array1[i];
        }
        int index = newArray.length - array1.length;
        for (int i = 0; i < array2.length; i++){
            newArray[index] = array2[i];
            index++;
        }
        return newArray;
    }
    public static void findLargestElementArray(Scanner input){
        System.out.println("Enter columns number");
        int columns = input.nextInt();
        System.out.println("Enter rows number");
        int rows = input.nextInt();
        if (columns <= 0 && rows <= 0){
            System.out.println("Invalid length");
        }
        else{
            double[][]array = new double[columns][rows];
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    System.out.printf("Enter element array[%d][%d]: ",i,j);
                    array[i][j] = input.nextDouble();
                }
            }
            largestElementTwoDimensionalArray(array);
        }
        System.out.println();
    }
    public static void largestElementTwoDimensionalArray(double[][]array){
        double largestNumber = array[0][0];
        int col = 0, row = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] > largestNumber){
                    largestNumber = array[i][j];
                    col = i;
                    row = j;
                }
            }
        }
        System.out.printf("The largest element is %f at position array[%d][%d]",largestNumber, col, row);
    }
    public static void findMinimumValueInArray(Scanner input){
        int[]array = new int[10];
        for (int i = 0; i < array.length; i++){
            System.out.printf("Enter element array[%d]: ", i+1);
            array[i] = input.nextInt();
        }
        int minElement = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < minElement){
                minElement = array[i];
            }
        }
        System.out.println("Minimum value in array is: "+minElement);
    }
    public static void sumNumberInColumn(Scanner input){
        double total = 0.0;
        System.out.println("Enter columns number");
        int columns = input.nextInt();
        System.out.println("Enter rows number");
        int rows = input.nextInt();
        if (columns <= 0 && rows <= 0){
            System.out.println("Invalid length");
        }
        else{
            double[][]array = new double[columns][rows];
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    System.out.printf("Enter element array[%d][%d]: ",i,j);
                    array[i][j] = input.nextDouble();
                }
            }
            int numberColumn = input.nextInt();
            if (numberColumn < 0 || numberColumn > array.length - 1){
                System.out.println("Invalid number column");
            }
            else{
                total = totalNumberInColumnArray(array, numberColumn);
                System.out.printf("Total numbers in column %d is %f", numberColumn, total);
            }
        }
        System.out.println();
    }
    public static double totalNumberInColumnArray(double[][]array, int numberColumn){
        double total = 0.0;
        for (int i = 0; i < array[numberColumn].length; i++){
            total += array[numberColumn][i];
        }
        return total;
    }
    public static void sumNumberMainDiagonal(Scanner input){
        double total = 0.0;
        System.out.println("Enter columns number");
        int columns = input.nextInt();
        System.out.println("Enter rows number");
        int rows = input.nextInt();
        if (columns <= 0 && rows <= 0){
            System.out.println("Invalid length");
        }
        else{
            double[][]array = new double[columns][rows];
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    System.out.printf("Enter element array[%d][%d]: ",i,j);
                    array[i][j] = input.nextDouble();
                }
            }
            total = sumNumberMainDiagonalSquareMatrix(array);
            System.out.printf("total number main diaginal square matrix is %f", total);
        }
        System.out.println();
    }
    public static double sumNumberMainDiagonalSquareMatrix(double[][]array){
        double total = 0.0;
        for (int i = 0; i < array.length; i++){
            total += array[i][i];
        }
        return total;
    }
    public static void coutNumberCharacterInString(Scanner input){
        System.out.println("Enter a string");
        Scanner scanner = new Scanner(System.in);
        String getString = scanner.nextLine();
        System.out.println("Enter a character to count");
        char c = input.next().charAt(0);
        int count = 0;
        for (int i = 0; i < getString.length(); i++){
            if (getString.charAt(i) == c){
                count++;
            }
        }
        System.out.printf("The total number of characters %c in the string %s is: %d", c, getString, count);
        System.out.println();
    }
}