package com.tts;
public class TicTacToeClass
{
    // Instance Variables
    private char[][] board;
    private int turns;

    // Constructors
    public TicTacToeClass()
    {
        board = new char[3][3];
        turns = 0;

        for ( int r=0; r<3; r++ )
            for ( int c=0; c<3; c++ )
                board[r][c] = ' ';
    }

    // Accessor Methods

    public boolean isWinner( char p )
    {
        boolean pWonRow;
        boolean pWonCol;
        boolean pWonDiagLeft;
        boolean pWonDiagRight;
        for ( int r=0; r<3; r++ ) {
            pWonCol = true;
            pWonRow = true;
            pWonDiagLeft = true;
            pWonDiagRight = true;
            for (int c = 0; c < 3; c++) {
                if (board[r][c] != p) {
                    pWonCol = false;
                }
                if (board[c][r] != p) {
                    pWonRow = false;
                }
                if (board[c][c] != p) {
                    pWonDiagLeft = false;
                }
                if (board[2 - c][c] != p) {
                    pWonDiagRight = false;
                }
            }
            if (pWonCol || pWonRow || pWonDiagLeft || pWonDiagRight) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        if (numTurns()==9) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCat()
    {
        if (!isWinner('X') && !isWinner('O') && isFull()) {
            return true;
        }

        return false;
    }

    public boolean isValid( int r, int c ) {
        if ( 0 <= r && r <= 2 && 0 <= c && c <= 2 ) {
            if (board[r][c] == ' ') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int numTurns()
    {
        return turns;
    }

    public char playerAt( int r, int c )
    {
        if ( isValid(r,c) )
            return board[r][c];
        else
            return '@';
    }

    public void displayBoard()
    {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove( char p, int r, int c )
    {
        this.turns +=1;
        board[r][c] = p;
    }

}