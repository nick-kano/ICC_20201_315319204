package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Bishop extends Piece{
	/**
	*constructor de la clase Bishop
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public Bishop(Position p,ColorEnum color){
		super(p,color);
		this.type=PiecesTypeEnum.BISHOP;	
	}
	/**
	*metodo que nos da la lista de movimientos validos de la pieza
	*@return la lista de movimientos validos
	*/
	public List<Position> getLegalMoves(){
		Board board=Board.getInstance();
		this.legalMoves=new LinkedList<Position>();
		for(int i=this.position.getX()+1,j=this.position.getY()+1;i<8&&j<8;i++,j++){
			Position nextLegalPosition=new Position(i,j);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getX()+1,j=this.position.getY()-1;i<8&&j>=0;i++,j--){
			Position nextLegalPosition=new Position(i,j);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getX()-1,j=this.position.getY()-1;i>=0&&j>=0;i--,j--){
			Position nextLegalPosition=new Position(i,j);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getX()-1,j=this.position.getY()+1;i>=0&&j<8;i--,j++){
			Position nextLegalPosition=new Position(i,j);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
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
		if(!(obj instanceof Bishop))
			return false;
		Bishop b=(Bishop) obj;
		return (b.getColor()==this.getColor()&&this.getPosition().equals(b.getPosition()))?true:false;
	}
}