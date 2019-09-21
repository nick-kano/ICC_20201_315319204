import shapesSVG.*;
public class Main{
	public static void main(String[] args) {
		String inicio = "<svg height='700' width='700'>";
		String fin = "</svg>";
		Vector2 dot1 = new Vector2(50,20);
		Vector2 dot2 = new Vector2(600,20);
		Linea line1 = new Linea (dot1,dot2);
		Rectangulo rect = new Rectangulo(new Vector2(150,150),100,100);
		Triangulo tr = new Triangulo(new Vector2(275,275),new Vector2(630,60),new Vector2(550,550));
		Circulo cr = new Circulo(new Vector2(200,500), 50);

		System.out.println(inicio);
		System.out.println(line1.toSVG());
		System.out.println(rect.toSVG());
		System.out.println(tr.toSVG());
		System.out.println(cr.toSVG());
		System.out.println(fin);
	}
}