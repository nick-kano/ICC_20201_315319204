package shapesSVG;
/**
	@author Nicolas Kano.
*/
public class Vector2{
	private double x;
	private double y;
	private double mag;
	/**
	constructor vacio
	*/
	public Vector2(){
		this.x=0;
		this.y=0;
		this.mag=3;
	}
	/**
	constructor del vector.
	*@param nX valor x del punto.
	*@param nY valor y del punto.
	*/
	public Vector2(double nX, double nY){ 
		this.x=nX;
		this.y=nY;
		this.mag=3;
	}
	/**
	metodo get del parametro X;
	*/
	public double getX(){
		return this.x;
	}
	/**
	metodo get del parametro Y;
	*/
	public double getY(){
		return this.y;
	}
	/**
	metodo get del parametro mag;
	*/
	public double getMag(){
		return this.mag;
	}
	/**
	*@param otroV vector a el cual se va a calcular la distancia.
	*@return la distancia entre los dos vectores
	*/
	public double distancia(Vector2 otroV){
		double auxX, auxY;
		auxX=this.x-otroV.x;
		auxY=this.y-otroV.y;
		return Math.sqrt((auxX*auxX)+(auxY*auxY));
	}

	@Override
	public String toString(){
		String cad = "";
		cad = cad+"("+this.x+","+this.y+")";
		return cad;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Vector2){
			Vector2 aux = (Vector2)obj;
			if(aux.x==this.x){
				if (aux.y==this.y) {
					return true;
				}else return false;
			}else return false;
		}else return false;
	}
}