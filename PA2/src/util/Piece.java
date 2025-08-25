package util;

import java.util.ArrayList;

public class Piece {

    private boolean color; // true  mean white and false means black

    public Piece(String color) {
        this.color = color.toLowerCase().startsWith("b");
    }

    public boolean getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color ? ("" + '\u25C9') : ("" + '\u25CE');
    }

    public boolean isLegalMove(int from, int to, int die, ArrayList<Piece>[] board) {
        //main method for islegalMove
        //has the constraints that apply to all pieces
        // Check if the move distance is legal
        int distance = Math.abs(to - from);
        boolean currentColor = board[from].get(0).getColor();

        // Return false if the distance does not match die*1, die*2, or die*3
        if (!(distance == die || distance == die * 2 || distance == die * 3)) {
            return false; // Return false if the move is not legal
        }

        //direction of movement check
        if((!currentColor && from < to ) || (currentColor && from > to)) {
            return false;

        }

        // l move if there is a different color in the destination slot
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


        return true; // Return true if all checks pass
    }
}
