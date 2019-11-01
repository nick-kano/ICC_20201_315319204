package chess;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.chessPieces.Rook;
import chess.pieces.chessPieces.Queen;
public class Game{
	public static void main(String[] args) {
		Rook t=new Rook(new Position(4, 4),ColorEnum.BLACK);
		Queen q=new Queen(new Position(3,6),ColorEnum.WHITE);
		System.out.println("movimientos torre");
		System.out.println(t.getLegalMoves());
		System.out.println("\nmovimientos reina");
		System.out.println(q.getLegalMoves());
	}
}