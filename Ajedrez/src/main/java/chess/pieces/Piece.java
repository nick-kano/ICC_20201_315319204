package chess.pieces;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
public abstract class Piece{
	protected Position position;
	protected List<Position> legalMoves=null;
	protected PiecesTypeEnum type;
	protected ColorEnum color;
	protected Board board;
	/**
	*constructor de la clase Piece
	*@param p la posicion de la pieza
	*@param color color que va a tener la pieza
	*/
	public Piece(Position p, ColorEnum color) {
		this.position=p;
		this.color=color;
	}
	/**
	*metodo observador de la posicion
	*@return la posicion de la pieza
	*/
	public Position getPosition(){
		return this.position;
	}
	/**
	*metodo observador del color
	*@return el color de la pieza
	*/
	public ColorEnum getColor(){
		return this.color;
	}
	/**
	*metodo observador del tipo
	*@return el tipo de la pieza
	*/
	public PiecesTypeEnum getType(){
		return this.type;
	}
	public int isAppendable(Position p){
		Board board=Board.getInstance();
		Piece piece=board.getPiece(p);
		if(piece.getColor()==this.getColor())return -1;
		if(piece.getColor()!=ColorEnum.NONE)return 0;
		return 1;
	}
	/**
	*metodo que nos dice si la posicion de una pieza esta dentro del tablero
	*@return true si esta dentro del tablero false si no
	*/
	public boolean isLegal(){
		return (this.position.getX()<8&&this.position.getX()>-1&&this.position.getY()<8&&this.position.getY()>-1)?true:false;
	}
	/**
	*metodo que mueve la pieza a una posicion
	*@param p la nueva posicion a la que se va a mover
	*/
	public void moveTo(Position p){
		if(isLegalMove(p)){
			this.position=p;
			this.legalMoves=null;
			return;
		}else return;
	}
	public abstract List<Position> getLegalMoves();
	/**
	*metodo que revisa si una posicion esta dentro de los movimientos validos que una pieza pueda hacer
	*@param p posicion que se va a revisar
	*@return true si esta en la lista de movimientos validos, false si no
	*/
	public boolean isLegalMove(Position p){
		List<Position> moves=this.getLegalMoves();
		return(moves.contains(p))?true:false;
	}
	/**
	*metodo que convierte una pieza a string
	*@return la representacion en string de la pieza
	*/
	@Override
	public String toString(){
		return this.type.toString();
	}
	/**
	*metodo que nos dice si dos piezas son iguales
	@param obj objeto que se va a comparar con la pieza que llame al metodo
	@return true si son iguales false si no
	*/
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Piece))return false;
		Piece p=(Piece)obj;
		if(p.getType().equals(this.type)&& p.getColor().equals(this.getColor())&& p.getPosition().equals(this.position))
			return true;
		return false;
	}
}