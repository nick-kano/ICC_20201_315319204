package shapesSVG;
public class Rectangulo{
	private Vector2 a;
	private double ancho;
	private double alto;
	private double perimetro;
	private double area;

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
	public String toSVG(){
		String cad="";
		cad=cad+"<rect x=\""+this.a.getX()+"\" y=\""+this.a.getY()+"\" width=\""+this.ancho+"\" height=\""+this.alto+"\" stroke=\"#00995c\" stroke-width=\""+this.a.getMag()+"\" fill=\"#00ff99\" />";
		return cad;
	}
}