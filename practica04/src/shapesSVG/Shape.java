package shapesSVG;
/**
*Clase abstracta shape
*/
public abstract class Shape implements Comparable <Shape>{
	protected double area;
	/**
	*metodo observador del area
	*@return el area
	*/
	public double getArea(){
		return this.area;
	}
	/**
	*metodo abtrabto para comparar shape
	*/
	public abstract int compareTo(Shape s);
}