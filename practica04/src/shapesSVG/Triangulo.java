package shapesSVG;
public class Triangulo{
	private Vector2 a;
	private Vector2 b;
	private Vector2 c;
	private double perimetro;
	private double area;
	/**
	constructor del triangulo.
	*@param nA primer punto del triangulo.
	*@param nB segundo punto del triangulo.
	*@param nC tercer punto del triangulo.
	*/
	public Triangulo(Vector2 nA,Vector2 nB, Vector2 nC){
		double aux;
		this.a=nA;
		this.b=nB;
		this.c=nC;
		aux=nA.distancia(nB)+nA.distancia(nC)+nC.distancia(nB);
		this.perimetro=aux;
		aux=((nA.getX()*(nB.getY()-nC.getY()))+(nB.getX()*(nC.getY()-nA.getY()))+(nC.getX()*(nA.getY()-nB.getY())))/2;
		this.area=aux;
	}
	/**
	constructor del triangulo.
	*@param x1 cordenada x del primer punto del triangulo.
	*@param y1 cordenada y del primer punto del triangulo.
	*@param x2 cordenada x del segundo punto del triangulo.
	*@param y2 cordenada y del segundo punto del triangulo.
	*@param x3 cordenada x del tercer punto del triangulo.
	*@param y3 cordenada y del tercer punto del triangulo.
	*/
	public Triangulo(double x1,double y1,double x2,double y2,double x3,double y3){
		double aux;
		Vector2 aux1;
		Vector2 aux2;
		Vector2 aux3;
		aux1= new Vector2(x1,y1);
		aux2= new Vector2(x2,y2);
		aux3= new Vector2(x3,y3);
		this.a=aux1;
		this.b=aux2;
		this.c=aux3;
		aux=aux1.distancia(aux2)+aux1.distancia(aux3)+aux3.distancia(aux2);
		this.perimetro=aux;
		aux=((aux1.getX()*(aux2.getY()-aux3.getY()))+(aux2.getX()*(aux3.getY()-aux1.getY()))+(aux3.getX()*(aux1.getY()-aux2.getY())))/2;
		if(aux<0){
			aux=aux*(-1);
		}
		this.area=aux;
	}
	/**
	constructor del triangulo por omision.
	*/
	public Triangulo(){
		Vector2 aux;
		aux= new Vector2(0,0);
		this.a=aux;
		this.b=aux;
		this.c=aux;
		this.perimetro=0;
		this.area=0;
	}

	@Override
	public String toString(){
		String cad = "el triangulo tiene cordenadas: ";
		cad = cad+this.a.toString()+", "+this.b.toString()+", "+this.c.toString();
		cad = cad+"\nun perimetro de: "+this.perimetro+" y un area de: "+this.area;
		return cad;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Triangulo){
			Triangulo aux = (Triangulo)obj;
			if(aux.a==this.a){
				if (aux.b==this.b) {
					if (aux.c==this.c) {
						return true;
					}else return false;
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
		cad=cad+"<polygon points=\""+this.a.getX()+","+this.a.getY()+" "+this.b.getX()+","+this.b.getY()+" "+this.c.getX()+","+this.c.getY()+"\" stroke=\"#000080\" stroke-width=\""+this.a.getMag()+"\" fill=\"#0000ff\" />";
		return cad;
	}
}