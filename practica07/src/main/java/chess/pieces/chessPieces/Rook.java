package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Rook extends Piece {
	/**
	*constructor de la clase Rook
	*@param p posicion en la que comienza la pieza.
	*@param color color que se le asigna a la pieza.
	*/
	public Rook(Position p, ColorEnum color) {
		this.position=p;
		this.color=color;
		this.type=PiecesTypeEnum.ROOK;
	}
	/**
	*metodo que regresa la posicion de la pieza
	*@return la posicion de la pieza
	*/
	public Position getPosition(){
		return this.position;
	}
	/**
	*metodo que regresa el color de la pieza
	*@return el color de la pieza
	*/
	public ColorEnum getColor(){
		return this.color;
	}
	/**
	*metodo que regresa la lista de movimientos validos de la pieza.
	*@return la lista con los movimientos validos.
	*/
	public List<Position> getLegalMoves() {
		if(this.legalMoves==null){
			this.legalMoves=new LinkedList<Position>();
			for(int i=this.position.getX()+1;i<8;i++){
				this.legalMoves.add(new Position(i, this.position.getY()));
			}
			for(int i=this.position.getX()-1;i>=0;i--){
				this.legalMoves.add(new Position(i, this.position.getY()));
			}
			for(int i=this.position.getY()+1;i<8;i++){
				this.legalMoves.add(new Position(this.position.getX(),i));
			}
			for(int i=this.position.getY()-1;i>=0;i--){
				this.legalMoves.add(new Position(this.position.getX(),i));
			}
		}
		return this.legalMoves;
	}
	/**
	*metodo que mueve una pieza a una posicion
	*@param p posicion a la que se va a mover la pieza
	*/
	@Override
	public void moveTo(Position p) {
		if(isLegalMove(p)){
			this.position=p;
			this.legalMoves=null;
			return;
		} else
			return;
	}
	/**
	*metodo que te dice si la pieza puede realizar un movimiento
	*@param p movimiento que se va a revisar si es valido
	*@return true si el movimiento es valido, false si no es un movimiento valido
	*/
	@Override
	public boolean isLegalMove(Position p){
		List<Position> moves=this.getLegalMoves();
		return(moves.contains(p))?true:false;
	}
	/**
	*metodo que compara dos objetos para saber si es el mismo.
	*@param obj objeto que se va a comparar
	*@return true si son el mismo objeto, false si no lo es.
	*/
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Rook))
			return false;
		Rook t=(Rook)obj;
		return(t.getColor()==this.getColor()&&this.getPosition().equals(t.getPosition()))?true:false;
	}
}