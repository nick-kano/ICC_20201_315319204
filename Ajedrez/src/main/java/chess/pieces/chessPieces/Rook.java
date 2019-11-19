package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Rook extends Piece{
	/**
	*constructor de la clase Rook
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public Rook(Position p,ColorEnum color){
		super(p, color);
		this.type=PiecesTypeEnum.ROOK;
	}
	/**
	*metodo que nos da la lista de movimientos validos de la pieza
	*@return la lista de movimientos validos
	*/
	public List<Position> getLegalMoves(){
		Board board=Board.getInstance();
		this.legalMoves=new LinkedList<Position>();
		for(int i=this.position.getX()+1;i<8;i++){
			Position nextLegalPosition=new Position(i,this.position.getY());
			if(this.isAppendable(nextLegalPosition)==-1)
				break;
			if(this.isAppendable(nextLegalPosition)==0){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getX()-1;i>-1;i--){
			Position nextLegalPosition=new Position(i,this.position.getY());
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())
				break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getY()+1;i<8;i++){
			Position nextLegalPosition=new Position(this.position.getX(),i);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())
				break;
			if(piece.getColor()!=ColorEnum.NONE){
				this.legalMoves.add(nextLegalPosition);
				break;
			}
			this.legalMoves.add(nextLegalPosition);
		}
		for(int i=this.position.getY()-1;i>-1;i--){
			Position nextLegalPosition=new Position(this.position.getX(),i);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==this.getColor())
				break;
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
	public boolean equals(Object obj){
		if(!(obj instanceof Rook))
			return false;
		Rook r=(Rook) obj;
		return (r.getColor()==this.getColor()&&this.getPosition().equals(r.getPosition()))?true:false;
	}
}