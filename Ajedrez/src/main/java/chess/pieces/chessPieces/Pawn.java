package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Pawn extends Piece{
	/**
	*constructor de la clase Pawn
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public Pawn(Position p,ColorEnum color){
		super(p,color);
		this.type=PiecesTypeEnum.PAWN;	
	}
	/**
	*metodo que nos da la lista de movimientos validos de la pieza
	*@return la lista de movimientos validos
	*/
	public List<Position> getLegalMoves(){
		Board board=Board.getInstance();
		this.legalMoves=new LinkedList<Position>();
		if(this.getColor()==ColorEnum.BLACK){
			if(this.position.getY()==1){
				Position nextLegalPosition=new Position(this.position.getX(),this.position.getY()+2);
				Position aux=new Position(this.position.getX(),this.position.getY()+1);
				Piece piece=board.getPiece(nextLegalPosition);
				Piece aux2=board.getPiece(aux);
				if(aux2.getColor()==ColorEnum.NONE){
					if(piece.getColor()!=this.getColor()){
						if(piece.getColor()==ColorEnum.NONE)
							this.legalMoves.add(nextLegalPosition);
					}
				}
			}
			Position nextLegalPosition=new Position(this.position.getX(),this.position.getY()+1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()==ColorEnum.NONE)
				this.legalMoves.add(nextLegalPosition);
			if(this.position.getX()<7){
				nextLegalPosition=new Position(this.position.getX()+1,this.position.getY()+1);
				piece=board.getPiece(nextLegalPosition);
				if(piece.getColor()==ColorEnum.WHITE)
					this.legalMoves.add(nextLegalPosition);
			}
			if(this.position.getX()>0){
				nextLegalPosition=new Position(this.position.getX()-1,this.position.getY()+1);
				piece=board.getPiece(nextLegalPosition);
				if(piece.getColor()==ColorEnum.WHITE)
					this.legalMoves.add(nextLegalPosition);
			}
		}
		if(this.getColor()==ColorEnum.WHITE){
			if(this.position.getY()==6){
				Position nextLegalPosition=new Position(this.position.getX(),this.position.getY()-2);
				Piece piece=board.getPiece(nextLegalPosition);
				Position aux=new Position(this.position.getX(),this.position.getY()-1);
				Piece aux2=board.getPiece(aux);
				if(aux2.getColor()==ColorEnum.NONE){
					if(piece.getColor()!=this.getColor()){
						if(piece.getColor()==ColorEnum.NONE)
							this.legalMoves.add(nextLegalPosition);
					}
				}
			}
			Position nextLegalPosition=new Position(this.position.getX(),this.position.getY()-1);
			Piece piece=board.getPiece(nextLegalPosition);
			if(piece.getColor()!=this.getColor()){
				if(piece.getColor()==ColorEnum.NONE)
					this.legalMoves.add(nextLegalPosition);
			}
			if(this.position.getX()<7){
				nextLegalPosition=new Position(this.position.getX()+1,this.position.getY()-1);
				piece=board.getPiece(nextLegalPosition);
				if(piece.getColor()==ColorEnum.BLACK)
					this.legalMoves.add(nextLegalPosition);
			}
			if(this.position.getX()>0){
				nextLegalPosition=new Position(this.position.getX()-1,this.position.getY()-1);
				piece=board.getPiece(nextLegalPosition);
				if(piece.getColor()==ColorEnum.BLACK)
					this.legalMoves.add(nextLegalPosition);
			}
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
		if(!(obj instanceof Pawn))
			return false;
		Pawn p=(Pawn)obj;
		return (p.getColor()==this.getColor()&&this.getPosition().equals(p.getPosition()))?true:false;
	}
}