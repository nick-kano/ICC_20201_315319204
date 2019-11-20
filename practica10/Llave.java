public class Par<T,E>{
	private T llave;
	private E valor;

	public E get(T key){
		if(key.equals(this.llave))
			return valor;
		return null;
	}
}