package chess.items;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.chessPieces.*;
public class Board{
	public int SIZE=8;
	public Piece[][] matrix;
	private static Board instance=null;
	/**
	*constructor de la clase Board
	*/
	private Board(){
		this.matrix=new Piece[SIZE][SIZE];
		for (int i=0;i<SIZE;i++){
			for (int j=0;j<SIZE;j++){
				this.matrix[i][j]=new Empty(new Position(i, j), ColorEnum.NONE);
			}
		}
		this.matrix[0][0]=new Rook(new Position(0,0),ColorEnum.BLACK);
		this.matrix[7][0]=new Rook(new Position(7,0),ColorEnum.BLACK);
		this.matrix[0][7]=new Rook(new Position(0,7),ColorEnum.WHITE);
		this.matrix[7][7]=new Rook(new Position(7,7),ColorEnum.WHITE);
		for (int i=0;i<8;i++){
			this.matrix[i][1]=new Pawn(new Position(i,1),ColorEnum.BLACK);
			this.matrix[i][6]=new Pawn(new Position(i,6),ColorEnum.WHITE);
		}
		this.matrix[1][0]=new Knight(new Position(1,0),ColorEnum.BLACK);
		this.matrix[6][0]=new Knight(new Position(6,0),ColorEnum.BLACK);
		this.matrix[1][7]=new Knight(new Position(1,7),ColorEnum.WHITE);
		this.matrix[6][7]=new Knight(new Position(6,7),ColorEnum.WHITE);
		this.matrix[2][0]=new Bishop(new Position(2,0),ColorEnum.BLACK);
		this.matrix[5][0]=new Bishop(new Position(5,0),ColorEnum.BLACK);
		this.matrix[2][7]=new Bishop(new Position(2,7),ColorEnum.WHITE);
		this.matrix[5][7]=new Bishop(new Position(5,7),ColorEnum.WHITE);
		this.matrix[3][0]=new Queen(new Position(3,0),ColorEnum.BLACK);
		this.matrix[3][7]=new Queen(new Position(3,7),ColorEnum.WHITE);
		this.matrix[4][0]=new King(new Position(4,0),ColorEnum.BLACK);
		this.matrix[4][7]=new King(new Position(4,7),ColorEnum.WHITE);
	}
	/**
	*metodo que crea el tablero una sola vez
	*@return el tablero
	*/
	public static Board getInstance(){
		if(instance==null)
			instance=new Board();
		return instance;
	}
	/**
	*metodo que observador del tamaño
	*@return el tamaño del tablero
	*/
	public int getSize(){
		return this.SIZE;
	}
	/**
	*metodo que mueve una pieza a una nueva posicion
	*@param p posicion actual de la pieza
	*@param q posicion a la que se va a mover la pieza
	*/
	public void move(Position p, Position q){
		if(!p.isLegal()||!q.isLegal())return;
		Piece piece=this.getPiece(p);
		if(!piece.isLegalMove(q))return;
		piece.moveTo(q);
		this.matrix[p.getX()][p.getY()]=new Empty(p,ColorEnum.NONE);
		this.matrix[q.getX()][q.getY()]=piece; 
	}
	/**
	*metodo que regresa una la pieza que se encuentra en una posicion del tablero
	*@param p la posicion de la que se quiere obtener la pieza
	*@return la pieza que se encuentra en esa posicion
	*/
	public Piece getPiece(Position p){
		return this.matrix[p.getX()][p.getY()];
	}
	/**
	*metodo que convierte el tablero a string
	*@return la representacion en string del tablero
	*/
	public String toString(){
		var result="";
		for (int i=0;i<SIZE;i++) {
			for (int j=0;j<SIZE; j++) {
				result+=" "+ this.matrix[i][j]+" ";
			}
			result+='\n';
		}
		return result;
	}
}