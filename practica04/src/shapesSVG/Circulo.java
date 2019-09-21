package shapesSVG;
public class Circulo{
	private Vector2 centro;
	private double radio;
	private double perimetro;
	private double area;

	public Circulo(Vector2 nCentro,double nRadio){
		this.centro=nCentro;
		this.radio=nRadio;
		this.perimetro=Math.PI*2*nRadio;
		this.area=Math.PI*nRadio*nRadio;
	}
	public Circulo(double x,double y,double nRadio){
		Vector2 aux;
		aux = new Vector2(x,y);
		this.centro=aux;
		this.radio=nRadio;
		this.perimetro=Math.PI*2*nRadio;
		this.area=Math.PI*nRadio*nRadio;
	}
	public Circulo(){
		Vector2 aux;
		aux = new Vector2(0,0);
		this.centro=aux;
		this.radio=0;
		this.perimetro=0;
		this.area=0;
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
	public String toSVG(){
		String cad="";
		cad=cad+"<circle cx=\""+this.centro.getX()+"\" cy=\""+this.centro.getY()+"\" r=\""+this.radio+"\" stroke=\"#ff0066\" stroke-width=\""+this.centro.getMag()+"\" fill=\"#ff99c2\" />";
		return cad;
	}
}