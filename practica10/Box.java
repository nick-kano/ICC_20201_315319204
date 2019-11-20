
public class Box<T>{
	private T contenido;
	public void setContenido(T element){
		this.contenido=element;
	}
	public T getContenido(){
		return this.contenido;
	}
	@Override
	public String toString(){
		return "Caja contiene "+this.contenido.toString();
	}
	public static void main(String[] args){
		Box<Integer> caja=new Box<>();
		caja.setContenido(5);
		System.out.println(caja);
	}
}