package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Knight extends Piece{
	/**
	*constructor de la clase Knight
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public Knight(Position p,ColorEnum color){
		super(p,color);
		this.type=PiecesTypeEnum.KNIGHT;	
	}
	/**
	*metodo que nos da la lista de movimientos validos de la pieza
	*@return la lista de movimientos validos
	*/
	public List<Position> getLegalMoves(){
		Board board=Board.getInstance();
		this.legalMoves=new LinkedList<Position>();
		if(this.position.getX()>1&&this.position.getY()>0){
			Position nextLegalPosition = new Position(this.position.getX()-2,this.position.getY()-1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()>1&&this.position.getY()<7){
			Position nextLegalPosition = new Position(this.position.getX()-2,this.position.getY()+1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()<6&&this.position.getY()>0){
			Position nextLegalPosition = new Position(this.position.getX()+2,this.position.getY()-1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()<6&&this.position.getY()<7){
			Position nextLegalPosition = new Position(this.position.getX()+2,this.position.getY()+1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()>0&&this.position.getY()>1){
			Position nextLegalPosition = new Position(this.position.getX()-1,this.position.getY()-2);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()<7&&this.position.getY()>1){
			Position nextLegalPosition = new Position(this.position.getX()+1,this.position.getY()-2);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()>0&&this.position.getY()<6){
			Position nextLegalPosition = new Position(this.position.getX()-1,this.position.getY()+2);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		if(this.position.getX()<7&&this.position.getY()<6){
			Position nextLegalPosition = new Position(this.position.getX()+1,this.position.getY()+2);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor())
				this.legalMoves.add(nextLegalPosition);
		}
		return this.legalMoves;
	}
	/**
	*metodo que nos dice si otra pieza es igual a la que llama al metodo
	*@param obj objeto con el que vamos a comparar la pieza
	*@return true si son iguales false si no
	*/
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Knight))
			return false;
		Knight k=(Knight)obj;
		return (k.getColor()==this.getColor()&&this.getPosition().equals(k.getPosition()))?true:false;
	}
}