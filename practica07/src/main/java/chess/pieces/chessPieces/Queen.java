package chess.pieces.chessPieces;
import java.util.LinkedList;
import java.util.List;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;
public class Queen extends Rook{
	/**
	*constructor de la clase Queen
	*@param p posicion en la que comienza la pieza.
	*@param color color que se le asigna a la pieza.
	*/
	public Queen(Position p,ColorEnum color){
		super(p,color);
		this.type = PiecesTypeEnum.QUEEN;
	}
	/**
	*metodo que regresa la lista de movimientos validos de la pieza.
	*@return la lista con los movimientos validos.
	*/
	@Override
	public List<Position> getLegalMoves(){
		if(this.legalMoves == null){
			super.getLegalMoves();
			for(int i=this.position.getX()+1,j=this.position.getY()+1;i<8&&j<8;i++,j++){
				this.legalMoves.add(new Position(i,j));
			}
			for(int i=this.position.getX()+1,j=this.position.getY()-1;i<8&&j>=0;i++,j--){
				this.legalMoves.add(new Position(i,j));
			}
			for(int i=this.position.getX()-1,j=this.position.getY()-1;i>=0&&j>=0;i--,j--){
				this.legalMoves.add(new Position(i,j));
			}
			for(int i=this.position.getX()-1,j=this.position.getY()+1;i>=0&&j<8;i--,j++){
				this.legalMoves.add(new Position(i,j));
			}
		}
		return this.legalMoves;
	}
	/**
	*metodo que compara dos objetos para saber si es el mismo.
	*@param obj objeto que se va a comparar
	*@return true si son el mismo objeto, false si no lo es.
	*/
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Queen))
			return false;
		Queen q=(Queen)obj;
		return(q.getColor()==this.getColor()&&this.getPosition().equals(q.getPosition()))?true:false;
	}
}