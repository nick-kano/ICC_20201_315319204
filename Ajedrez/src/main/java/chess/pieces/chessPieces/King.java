package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class King extends Piece{
	/**
	*constructor de la clase King
	*@param p posicion en la que va a estar la pieza
	*@param color color que va a tener la pieza
	*/
	public King(Position p,ColorEnum color){
		super(p,color);
		this.type=PiecesTypeEnum.KING;
	}
	/**
	*metodo que nos da la lista de movimientos validos de la pieza
	*@return la lista de movimientos validos
	*/
	public List<Position> getLegalMoves(){
		Board board=Board.getInstance();
		this.legalMoves=new LinkedList<Position>();
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(i!=0||j!=0){
					if(this.position.getX()+i>-1&&this.position.getX()+i<8&&this.position.getY()+j>-1&&this.position.getY()+j<8){
						Position nextLegalPosition=new Position(this.position.getX()+i, this.position.getY()+j);
						Piece piece=board.getPiece(nextLegalPosition);
						if(piece.getColor()!=this.getColor())
							this.legalMoves.add(nextLegalPosition);
					}
				}
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
		if(!(obj instanceof King))
			return false;
		King k=(King)obj;
		return (k.getColor()==this.getColor()&&this.getPosition().equals(k.getPosition()))?true:false;
	}
}