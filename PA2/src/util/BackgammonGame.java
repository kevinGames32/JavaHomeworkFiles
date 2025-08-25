package util;

import java.util.ArrayList;

public class BackgammonGame {
    //board is made of 24 points (+ an extra point at index 0 for captured pieces)
//each point is either empty, Or holds one or
//more white pieces, Or holds one or
//more black pieces. Indices 1-6 are part of
//white's home board, 7-18 are part of the outer
//board, and 19-24 are part of black's home board

    private ArrayList<Piece>[] board;
    private String player1;
    private String player2;
    public BackgammonGame(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
        board = new ArrayList[25];// Index zero reserved for captured pieces
        //Initializing the board
        for(int i = 0; i < 25;i++){
            board[i] = new ArrayList<>();
            if(i == 1)
                for(int c = 0; c < 2;c++)
                    board[i].add(new APiece("B"));
            else if(i == 24)
                for(int c = 0; c < 2;c++)
                    board[i].add(new APiece("W"));
            else if(i == 6)
                for(int c = 0; c < 5;c++)
                    board[i].add(new CPiece("W"));
            else if(i == 19)
                for(int c = 0; c < 5;c++)
                    board[i].add(new CPiece("B"));
            else if(i == 8)
                for(int c = 0; c < 3;c++)
                    board[i].add(new CPiece("W"));
            else if(i == 17)
                for(int c = 0; c < 3;c++)
                    board[i].add(new CPiece("B"));
            else if(i == 13)
                for(int c = 0; c < 5;c++)
                    board[i].add(new BPiece("W"));
            else if(i == 12)
                for(int c = 0; c < 5;c++)
                    board[i].add(new BPiece("B"));
        }
    }
    public boolean makeMove(String move, boolean turn, int die){
        //move: string in the format "n-m"
        //where n and m are numbers in the range 1,2,...24
        //turn is true if black pieces must move in this round
        //turn is false if white pieces must move in this round
        //die is one of two dice that the player uses in this move
        //return value is true if the move is legal and false o.w.
        String[] tokens = move.split("-");
        if(tokens.length != 2)
            return false;
        for(String token: tokens)
            for(char c: token.toCharArray())
                if(!Character.isDigit(c))
                    return false;
        int from = Integer.parseInt(tokens[0]);
        int to = Integer.parseInt(tokens[1]);
        if(!isLegalMove(from, to, turn, die))
            return false;
        //Making the move
        Piece movedPiece = null;
        if(from == 0) {//releasing a captured piece
            for (Piece piece : board[0])
                if (piece.getColor() == turn) {
                    movedPiece = piece;
                    break;
                }
            board[0].remove(movedPiece);//remove it from the list of captured pieces...
        }else{//remove a peice from src (board[from])
            int len = board[from].size();
            movedPiece = board[from].remove(len-1);
        }
        if(from != 0) {//not releasing a captured piece
            for (int index = Math.min(from, to) + die; index < Math.max(from, to); index += die)//en route (A/B-class)
                if (board[index].size() == 1 && board[index].get(0).getColor() != turn)//if opponent pieces are alone!
                    board[0].add(board[index].remove(0));//capture opponent's piece
        }
        if(board[to].size() == 1 && board[to].get(0).getColor() != turn)//if opponent pieces are alone!
            board[0].add(board[to].remove(0));//capture opponent's piece
        board[to].add(movedPiece);//place the piece at the destination (board[to])
        return true;
    }

    private boolean isLegalMove(int from, int to, boolean turn, int die) {
        //is it legal in this game to move a piece from board[from] to board[to] given die and turn?
        // turn is true iff black pieces can move
        if(from < 0 || from > 24 || to < 1 || to > 24)//index out of bound!
            return false;
        if(board[from].size() == 0)//no piece to move!
            return false;
        Piece pickedPiece = null;//placeholder for picked piece
        for(Piece piece: board[0])//look into the list of captured pieces
            if(piece.getColor() == turn){//if found a captured piece with matching color
                pickedPiece = piece;
                break;
            }
        if(pickedPiece != null)//there is a captured piece that must be released before moving other pieces!
            if(from != 0)//captured piece must be released...
                return false;
            else
                return pickedPiece.isLegalMove(from, to, die, board);
        if(turn != board[from].get(0).getColor())//can't move opponent pieces
            return false;
        int lastPieceIndex = board[from].size()-1;
        pickedPiece = board[from].get(lastPieceIndex);//last piece on board[from] is the only piece that you can move!
        return pickedPiece.isLegalMove(from, to, die, board);//check the legality of move for that certain piece!

    }
    @Override
    public String toString(){
        int topLen = 0;
        for (int i = 13; i <= 24; i++)
            if(topLen < board[i].size())
                topLen = board[i].size();
        int bottomLen = 0;
        for (int i = 1; i <= 12; i++)
            if(bottomLen < board[i].size())
                bottomLen = board[i].size();
        StringBuilder result = new StringBuilder();
        result.append("Player1: ");
        result.append(player1);
        for(Piece piece: board[0])
            if(piece.getColor())
                result.append("\t" + piece);
        result.append('\n');
        result.append(" ------------------------\n");
        for(int row = 0; row <= Math.max(topLen + 1, 6);row++) {//top half of board
            result.append('|');//left border
            for (int i = 13; i <= 24; i++) {
                if (board[i].size() >= row)
                    if (row == 0)
                        result.append("-");
                    else
                        result.append(board[i].get(row-1).toString());
                else
                    result.append(' ');
                if(i!= 18)
                    result.append('\t');
                if(i == 18) //middle line of the board
                    result.append(("\t|\t"));
            }
            result.append('|');//right border
            result.append('\n');
        }
        for(int row = Math.max(bottomLen + 1, 6); row >= 0;row--) {//bottom half of board
            result.append('|');//left border
            for (int i = 12; i >= 1; i--) {
                if(board[i].size() >= row)
                    if (row == 0)
                        result.append("-");
                    else
                        result.append(board[i].get(row-1).toString());
                else
                    result.append(' ');
                if(i != 7)
                    result.append('\t');
                if(i == 7)//middle line of the board
                    result.append("\t|\t");
            }
            result.append('|');//right border
            result.append('\n');
        }
        result.append(" ------------------------\n");
        result.append("Player 2: " + player2);
        for(Piece piece: board[0])
            if(!piece.getColor())
                result.append("\t" + piece);
        result.append('\n');
        return result.toString();
    }
}
