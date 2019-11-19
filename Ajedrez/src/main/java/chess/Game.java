package chess;
import chess.items.Board;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.Rook;
import chess.items.*;
public class Game{
	public static void main(String[] args) {
		Board board = Board.getInstance();
		System.out.println(board.toString());
		Piece p = new Rook(new Position(0,0), ColorEnum.BLACK);
		System.out.println(p.getLegalMoves());
	}
}