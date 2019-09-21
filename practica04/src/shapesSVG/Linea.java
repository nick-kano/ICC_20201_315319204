package shapesSVG;
public class Linea{
	private Vector2 a;
	private Vector2 b;
	private double longitud;

	public Linea(Vector2 nA, Vector2 nB){
		double aux;
		this.a=nA;
		this.b=nB;
		aux=nA.distancia(nB);
		this.longitud=aux;
	}
	public Linea(double x1,double y1,double x2,double y2){
		double aux;
		Vector2 aux1,aux2;
		aux1= new Vector2(x1,y1);
		aux2= new Vector2(x2,y2);
		aux=aux1.distancia(aux2);
		this.a=aux1;
		this.b=aux2;
		this.longitud=aux;
	}
	public Linea(){
		Vector2 aux;
		aux= new Vector2(0,0);
		this.a=aux;
		this.b=aux;
		this.longitud=0;
	}

	@Override
	public String toString(){
		String cad = "";
		cad = cad+this.a.toString()+this.b.toString();
		return cad;
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Linea){
			Linea aux = (Linea)obj;
			if(aux.a==this.a){
				if (aux.b==this.b) {
					if (aux.longitud==this.longitud) {
						return true;
					}else return false;
				}else return false;
			}else return false;
		}else return false;
	}
	public String toSVG(){
		String cad="";
		cad=cad+"<line x1=\""+this.a.getX()+"\" y1=\""+this.a.getY()+"\" x2=\""+this.b.getX()+"\" y2=\""+this.b.getY()+"\" stroke=\"#990099\" stroke-width=\""+this.a.getMag()+"\"/>";
		return cad;
	}
}