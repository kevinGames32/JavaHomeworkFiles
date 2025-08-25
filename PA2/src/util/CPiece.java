package util;

import java.util.ArrayList;

public class CPiece extends Piece {
    public CPiece(String color) {
        super(color);

    }
    //Override the toString method... use '\u2776' for black CPiece and '\u2780' for white CPiece!
    @Override
    public String toString(){
        return getColor() ? ("" +'\u2776') : (""+'\u2780');
    }
    //Override the isLegalMove method... check if it is legal for the CPiece to move from board[from]
    //to board[to] with a given die withing a given board\

    @Override
    public boolean isLegalMove(int from, int to, int die, ArrayList<Piece>[] board) {
        int pieceCount = 0;
        int distance = Math.abs(to - from);
        boolean currentColor = board[from].get(0).getColor();
        //check ammount of pieces of different color between from and to
        //if the move is compound
        //check for white if any intermediate cells have an ammount of pieces greater than 2
        if (!currentColor && (distance > die)) {
            for (int i = from; i >= to; i--) {
                if (board[i].size() > 2 && board[i].get(0).getColor() != currentColor) {
                    pieceCount = pieceCount + board[i].size();
                }
            }
        }

        //check for black if any intermediate cells have an ammount of pieces greater than 2
        //if the move is compound
        if(currentColor && (distance>die)) {
            for (int i = from; i <= to; i++) {
                if (board[i].size() > 2 && board[i].get(0).getColor() != currentColor) {

                    pieceCount = pieceCount + board[i].size();

                }
            }
        }

        //# of different color pieces between from and to check (if count > 1 move is illegal)
        if(pieceCount > 1){
            return false;
        }

        //check if movement is between permitted die multiplicity for this piece
        if (!(distance == die)) {
            return false; // Return false if the move is not legal
        }
        //illegal move if there is a different color in the destination slot
        if (to >= 0 && to < board.length && board[to] != null) {

            if (!currentColor) { // If current piece is white
                if (board[to].size() > 1 && board[to].get(0).getColor() != currentColor) {
                    return false; // More than one opposing piece
                }
            } else { // If current piece is black
                if (board[to].size() > 1 && board[to].get(0).getColor() != currentColor) {
                    return false; // More than one opposing piece
                }
            }

        }

        //direction of movement check
        if((!currentColor && from < to ) || (currentColor && from > to)) {
            return false;

        }
        return true;
    }

}