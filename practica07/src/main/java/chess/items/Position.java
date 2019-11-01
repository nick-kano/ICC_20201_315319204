package chess.items;
public class Position{
	private int x;
	private int y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	* @return la coordenada x
	*/
	public int getX() {
		return x;
	}
	/**
	* @return la coordenada y
	*/
	public int getY() {
		return y;
	}
	/**
	*metodo que compara dos objetos para saber si es el mismo.
	*@param obj objeto que se va a comparar
	*@return true si son el mismo objeto, false si no lo es.
	*/
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Position))return false;
		Position p = (Position)obj;
		return (p.getX()==this.getX() && p.getY()== this.getY())? true: false;
	}
	/**
	*metodo que transforma un objeto Position en un String.
	@return el string con las cordenadas de Position
	*/
	@Override
	public String toString() {
		return "  ||x:"+this.getX()+" y:"+this.getY()+"||";
	}
	/**
	*metodo que dice si las cordenadas de la posicion esta en el tablero
	*@param board_size tamaño del tablero
	*@return true si esta en dentro de los parametros del tablero false si no
	*/
	public boolean isOutOfBoard(int board_size){
		if(this.y >= board_size)return false;
		if(this.x >= board_size)return false;
		if(this.y < 0)return false;
		if(this.x < 0)return false;
		return true;
	}
}