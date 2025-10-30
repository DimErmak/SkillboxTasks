package org.tasks.one;

public class Main {
    public static void main(String[] args) {

        int size = 31;
        char[][] twoDimensionalArray = new char[size][size];
        for (int i = 0; i < size; i++) {
            System.out.println(" ");
            for (int j = size - 1; j >= 0; j--) {
                if ((j == (size - (i + 1))) || (i == j)) twoDimensionalArray[i][j] = 'X';
                else twoDimensionalArray[i][j] = ' ';
                System.out.print(twoDimensionalArray[i][j]);

            }
        }
    }
}