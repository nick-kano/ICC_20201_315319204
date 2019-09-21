package shapesSVG;
public class Vector2{
	private double x;
	private double y;
	private double mag;

	public Vector2(){
		this.x=0;
		this.y=0;
		this.mag=3;
	}
	public Vector2(double nX, double nY){ 
		this.x=nX;
		this.y=nY;
		this.mag=3;
	}

	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getMag(){
		return this.mag;
	}
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