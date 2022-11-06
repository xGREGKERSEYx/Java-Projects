import javax.swing.*;

public class tictactoe
{
    public static void main(String[] args){
        ImageIcon tictactoe = new ImageIcon("tictactoe.jpg");//Creates the ImageIon for the game board

     
         int SIZE = 9;//Declares the size of the rows


        char[][] ticTacToe = new char[3][3];//Creates the array ticTacToe

        ticTacToe[0][0] = '1';//Assigns the value of the array at this spot to '1'
        ticTacToe[0][1] = '2';//Assigns the value of the array at this spot to '2'
        ticTacToe[0][2] = '3';//Assigns the value of the array at this spot to '3'
        ticTacToe[1][0] = '4';//Assigns the value of the array at this spot to '4'
        ticTacToe[1][1] = '5';//Assigns the value of the array at this spot to '5'
        ticTacToe[1][2] = '6';//Assigns the value of the array at this spot to '6'
        ticTacToe[2][0] = '7';//Assigns the value of the array at this spot to '7'
        ticTacToe[2][1] = '8';//Assigns the value of the array at this spot to '8'
        ticTacToe[2][2] = '9';//Assigns the value of the array at this spot to '9'
        
        
        int row = 0;//Creates the variable row and itnitalizes it to 0
        int column = 0;//Creates the variable column and itnitalizes it to 0
        int playerSelection;//Creates the variable playerSelection, to be used across methods
        String string = "";
        String playerName;//Creates the variable playerName, to be used across methods
        boolean pointFound;
        boolean isOver = false;
        boolean playerTurn;
        
        playerName = JOptionPane.showInputDialog(null, "What is your player name?", "Tic Tac Toe", 
                JOptionPane.PLAIN_MESSAGE);//Initializes playerName to whatever the player inputs
        
        String gameBoard = buildGameBoard(ticTacToe); //Introduces player to the game
        
        JOptionPane.showMessageDialog(null, playerName + ", welcome to a game of"
                + "\n TIC TAC TOE!!", "Tic Tac Toe", JOptionPane.PLAIN_MESSAGE, tictactoe);
        
        JOptionPane.showMessageDialog(null, playerName + ", you must get three in a row"
                + "\n-- Horizontally, Diagonally, or Vertically -- "
                + "\nto win the game." , "Tic Tac Toe", JOptionPane.PLAIN_MESSAGE, tictactoe);
        
       
      
        while(!isOver)
        {
            playerTurn = true;
            while(playerTurn)
            { 
                playerSelection = Integer.valueOf(JOptionPane.showInputDialog(null,
                        string + playerName + "\nEnter the space you would like to play ", JOptionPane.PLAIN_MESSAGE));
                
                if(playerSelection <= 3){
                    row = 0;}
                else
                if(playerSelection <= 6){
                    row = 1;}
                else{
                    row = 2;}
                if(playerSelection % 3 == 1){
                    column = 0;}
                else
                if(playerSelection % 3 == 2){
                    column = 1;}
                else{
                    column = 2;}
                if(!Character.isDigit(ticTacToe[row][column])){
                    string = playerName + " , that spot is occupied";}
                else
                {
                    ticTacToe[row][column] = 'X';
                    string = "";
                    playerTurn = false;
                }
            }
            gameBoard = buildGameBoard(ticTacToe);

            isOver = checkWinner(ticTacToe);
            string = "";
            if(isOver)
            {
                string = playerName + "\nYou Win!";
            }
            else
            if(!spaceLeft(ticTacToe))
            {
                isOver = true;
                string = playerName + "\nTied game";
            }
            if(isOver)
                JOptionPane.showMessageDialog(null, playerName + ", Game Over" + "\n" + string + gameBoard);
            else
            {
                JOptionPane.showMessageDialog(null, playerName + ", now it's the computer's turn" +
                        gameBoard);
                pointFound = false;
                while(!pointFound)
                {
                    pointFound = true;
                    playerSelection = (int)((Math.random() * 100) % SIZE);
                    row = playerSelection /3;
                    column = playerSelection % 3;
                    if(!Character.isDigit(ticTacToe[row][column]))
                        pointFound = false;
                }
                ticTacToe[row][column] = 'O';
                gameBoard = buildGameBoard(ticTacToe);
                JOptionPane.showMessageDialog(null, "the computer has played\n" + gameBoard);
                isOver = checkWinner(ticTacToe);
                if(isOver)
                    JOptionPane.showMessageDialog(null, playerName + ", you lost :((" );
            }

        }
    }


    public static String buildGameBoard(char[][] grid) // method for the game board
    {
        String msg = "\n";
        int x;
        int i;
        for(x = 0; x < 3; ++x)
        {
            for(i = 0; i < 3; ++i)
            {
                msg = msg + grid[x][i] + "  ";
            }
            msg = msg + "\n";

        }
        return msg;
    }
    
    public static boolean checkWinner(char [][] gameBoard) //checks whichever player has 3 in a row
    {
        boolean isOver = false;
        int i;
        for(i = 0; i < 3; ++i) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) {
                isOver = true;
            }
        }
        for(i = 0; i < 3; ++i) {
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i]) {
                isOver = true;
            }
        }
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) {
            isOver = true;
        }
        if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]) {
            isOver = true;
        }
        return isOver;
    }
    public static boolean spaceLeft(char board[][]) //this is for the spaces that are left over
    {
        int x, y;
        boolean leftOver = false;
        for(x = 0; x < 3; ++x) {
            for(y = 0; y < 3; ++y) {
                if(Character.isDigit(board[x][y]))
                    leftOver = true;
            }
        }
        return leftOver;
    }

}