package chess.items;
public class Position{
	private int x;
	private int y;
	/**
	*constructor de la clase Position
	*@param x coordenada x
	*@param y coordenada y
	*/
	public Position(int x, int y){
		this.x=x;
		this.y=y;
	}
	/**
	*metodo observador de X
	*@return la x
	*/
	public int getX(){
		return x;
	}
	/**
	*metodo observador de Y
	*@return la y
	*/
	public int getY(){
		return y;
	}
	/**
	*metodo que dice si una posicion es legal para el tablero
	*@return true si esta dentro de los parametros del tablero false si no
	*/
	public boolean isLegal(){
		return(this.x<8&&this.x>-1&&this.y<8&&this.y>-1)?true:false;
	}
	/**
	*metodo que compara para saber si dos posiciones son iguales
	*@param obj objeto que se va a comparar
	*@return true si son iguales false si no
	*/
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Position))return false;
		Position p=(Position)obj;
		return (p.getX()==this.getX()&&p.getY()==this.getY())?true:false;
	}
	/**
	*metodo que transforma la posicion en string
	*@return un string que representa la posicion
	*/
	@Override
	public String toString(){
		return"  ||x:"+this.getX()+" y:"+this.getY()+"||";
	}
	/**
	*metodo que checa si una posicion esta fuera del tablero
	*@param board_size el tamaño del tablero
	*false si se sale del tablero true si no
	*/
	public boolean isOutOfBoard(int board_size){
		if(this.y>=board_size)return false;
		if(this.x>=board_size)return false;
		if(this.y<0)return false;
		if(this.x<0)return false;
		return true;
	}
}	