package shapesSVG;
public class Rectangulo{
	private Vector2 a;
	private double ancho;
	private double alto;
	private double perimetro;
	private double area;
	/**
	constructor del Rectangulo.
	*@param nA vector con las cordenadas del punto inferior izquierdo del rectangulo.
	*@param nAncho tamaño del ancho del rectangulo.
	*@param nAlto tamaño del alto del rectangulo.
	*/
	public Rectangulo(Vector2 nA,double nAncho, double nAlto){
		double aux;
		this.a=nA;
		this.ancho=nAncho;
		this.alto=nAlto;
		aux = (2*nAncho)+(2*nAlto);
		this.perimetro= aux;
		aux= (nAncho*nAlto);
		this.area = aux;
	}
	/**
	constructor del Rectangulo.
	*@param x cordenada x del punto inferior izquierdo del rectangulo.
	*@param y cordenada y del punto inferior izquierdo del rectangulo.
	*@param nAncho tamaño del ancho del rectangulo.
	*@param nAlto tamaño del alto del rectangulo.
	*/
	public Rectangulo(double x, double y, double nAncho, double nAlto){
		double aux;
		Vector2 aux1;
		aux1=new Vector2(x,y);
		this.a=aux1;
		this.ancho=nAncho;
		this.alto=nAlto;
		aux = (2*nAncho)+(2*nAlto);
		this.perimetro= aux;
		aux= (nAncho*nAlto);
		this.area = aux;
	}
	/**
	constructor por omision del rectangulo
	*/
	public Rectangulo(){
		Vector2 aux1;
		aux1=new Vector2(0,0);	
		this.a=aux1;
		this.ancho=0;
		this.alto=0;
		this.perimetro=0;
		this.area=0;
	}

	@Override
	public String toString(){
		String cad = "el rectangulo tiene un punto en:";
		cad = cad+this.a.toString()+"con una anchura de: "+this.ancho+" y una altura de: "+this.alto;
		cad = cad+".\nTiene un perimetro de: "+this.perimetro+" y un area de: "+this.area;
		return cad;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Rectangulo){
			Rectangulo aux = (Rectangulo)obj;
			if(aux.a==this.a){
				if (aux.ancho==this.ancho) {
					if (aux.alto==this.alto) {
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
		cad=cad+"<rect x=\""+this.a.getX()+"\" y=\""+this.a.getY()+"\" width=\""+this.ancho+"\" height=\""+this.alto+"\" stroke=\"#00995c\" stroke-width=\""+this.a.getMag()+"\" fill=\"#00ff99\" />";
		return cad;
	}
}