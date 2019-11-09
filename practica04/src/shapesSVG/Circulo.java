package shapesSVG;
public class Circulo extends Shape{
	private Vector2 centro;
	private double radio;
	private double perimetro;
	/**
	constructor del Circulo.
	*@param nCentro el vector donde se encuentra el centro del circulo.
	*@param nRadio la distancia entre el centro y la orilla del circulo.
	*/
	public Circulo(Vector2 nCentro,double nRadio){
		this.centro=nCentro;
		this.radio=nRadio;
		this.perimetro=Math.PI*2*nRadio;
		this.area=Math.PI*nRadio*nRadio;
	}
	/**
	constructor del Circulo.
	*@param x cordenada x del centro del circulo.
	*@param y cordenada y del centro del circulo.
	*@param nRadio la distancia entre el centro y la orilla del circulo.
	*/
	public Circulo(double x,double y,double nRadio){
		Vector2 aux;
		aux = new Vector2(x,y);
		this.centro=aux;
		this.radio=nRadio;
		this.perimetro=Math.PI*2*nRadio;
		this.area=Math.PI*nRadio*nRadio;
	}
	/**
	constructor por omision del circulo.
	*/
	public Circulo(){
		Vector2 aux;
		aux = new Vector2(0,0);
		this.centro=aux;
		this.radio=0;
		this.perimetro=0;
		this.area=0;
	}
	/**
	*metodo observador del area
	*@return el area
	*/
	public double getArea(){
		return this.area;
	}
	/**
	*Metodo que compara una figura con un
	*@param c figura con la que se va a comparar
	*@return -1 si el area de esta figura es menor a la que se compara, 0 si es igual y 1 si es mayor
	*/
	@Override
	public int compareTo(Shape c){
		if(this.area<c.getArea())return -1;
		if(this.area==c.getArea())return 0;
		else return 1;
	}
	@Override
	public String toString(){
		String cad = "el circulo tiene su centro en: ";
		cad = cad+this.centro.toString()+" con un radio de "+this.radio;
		cad = cad+"\nel circulo tiene un perimetro de: "+this.perimetro+" y un area de: "+this.area;
		return cad;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Circulo){
			Circulo aux = (Circulo)obj;
			if(aux.centro==this.centro){
				if (aux.radio==this.radio) {
					return true;
				}else return false;
			}else return false;
		}else return false;
	}
	/**
	metodo que convierte un objeto en formato SVG
	@return el string para imprimir la figura en SVG.
	*/
	public String toSVG(){
		String cad="";
		cad=cad+"<circle cx=\""+this.centro.getX()+"\" cy=\""+this.centro.getY()+"\" r=\""+this.radio+"\" stroke=\"#ff0066\" stroke-width=\""+this.centro.getMag()+"\" fill=\"#ff99c2\" />";
		return cad;
	}
}