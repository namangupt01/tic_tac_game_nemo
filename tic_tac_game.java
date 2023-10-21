import java.util.Scanner;

public class tic_tac_game {

    public static void main(String[] args) {

        char[][] arr = new char[3][3]; // definf the 2-d array of the tic tac board

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';// initializing the board as the empty one
            }

        }

        char player = 'X';
        boolean gamefinish = false;

        Scanner sc = new Scanner(System.in);

        while (!gamefinish) // runs until the game gets finished
        {
            printBoard(arr); // for the printing the board on the console
            System.out.print("player :" + player + "Enter:");
            int i = sc.nextInt(); // inputting the board indices
            int j = sc.nextInt();

            if (arr[i][j] == ' ') // checking the board element to be empty else it will throw the invalid choice
            {
                arr[i][j] = player; // place the element on the block
                gamefinish = hasWon(arr, player);

                if (gamefinish) {
                    System.out.println("PLayer" + player + "has Won");
                } else {
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("invalid choice, please try again ");

            }

        }
        printBoard(arr);
        sc.close();

    }

    public static void printBoard(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();
        }

    }

    public static boolean hasWon(char[][] arr, char player) {

        // check the rows
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player) {
                return true;
            }

        }

        if (arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) {
            return true;
        }
        if (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player) {
            return true;
        }
        return false;

    }
}
