package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Empty extends Piece{
	/**
	*constructor de la clase Empty
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public Empty(Position p, ColorEnum color){
		super(p,color);
		this.type = PiecesTypeEnum.EMPTY;
	}
	/**
	*constructor de la clase por omision
	*/
	public Empty(){
		super(new Position(0,0),ColorEnum.NONE);
		this.type = PiecesTypeEnum.EMPTY;
	}
	/**
	*metodo que regresa la lista de movimientos validos
	*@return la lista de movimientos validos
	*/
	@Override
	public List<Position> getLegalMoves(){
		return new LinkedList<>();
	}
	/**
	*metodo que nos dice si otro objeto igual al que llama al metodo
	*@param obj objeto que se va a comparar
	*@return true si son iguales false si no
	*/
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Empty)? true: false;
	}
}