import java.util.ArrayList;
import java.util.Arrays;
/**
	@author Nicolas Kano.
*/
public class Control{
	/**
	*@param frase recibe un string para revisar si es un palindromo.
	*@return true si es un palindromo, false sino lo es.
	*/
	public static boolean problema1(String frase){
			char aux[]=new char[frase.length()];
		for (int i=0;i<frase.length();i++){
			aux[i]=frase.charAt(frase.length()-1-i);
		}
		for (int i=0;i<frase.length();i++){
			if(aux[i]!=frase.charAt(i)){
				return false;
			}
		}
		return true;
	}
	/**
	*@param ar recibe un array de enteros para daterminar si tiene dos elementos que sumen n
	*@param n recibe un entero n para ver si hay dos enteros en el array que su suma de n
	*@return true si existen los elementos del array que sumados den n, false sino los hay.
	*/
	public static boolean problema2(int[] ar, int n){
		for (int i=0;i<ar.length;i++){
			for (int j=0;j<ar.length;j++){
				if(ar[i]!=ar[j]){
					if (ar[i]+ar[j]==n){
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	*@param ar recibe un array para ser ordenado de menor a mayor.
	*/	
	public static void problema3(int[] ar){
		int aux,check;
		for(int k=0;k<ar.length-1;k++){
			check=0;
			for(int i=0;i<ar.length-1;i++){
				if(ar[i]>ar[i+1]){
					aux=ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=aux;
					check++;
				}
			}
			if(check==0){
				return;
			}
		}
	}
	/**
	*@param ar recibe un array de enteros en el cual se buscara el entero n
	*@param n recibe un entero n el cual se buscara en el array n.
	*@return true si está en el array, false sino lo está.
	*/
	public static boolean problema4(int[] ar, int n){
		int aux[]=new int[ar.length];
		for (int i=0;i<ar.length;i++){
			aux[i]=ar[i];			
		}
		problema3(aux);
		int i=0;
		while(aux[i]<n){
			i++;
			if(i==aux.length){
				return false;
			}
		}
		if(aux[i]==n){
			return true;
		}
		else return false;
	}
	/**
	*@param n recibe un entero n el cual se evaluara si es un primo.
	*@return true si es un primo, false sino lo es.
	*/
	public static boolean problema5(int n){
		if(n<2){
			return false;
		}
		for (int i=2;i<n;i++){
			if ((n%i)==0){
				return false;
			}
		}
		return true;
	}
	/**
	*@param n recibe un entero n sobre el cual se encontraran todos los primos menores a este numero.
	*@return un array con todos los primos menores a n.
	*/
	public static int[] problema6(int n){
		int aux[]=new int[10000];
		int ind=0;
		for (int i=0;i<n;i++){
			if (problema5(i)){
				aux[ind]=i;
				ind++;
			}           
		}
		int aux2[]=new int [ind];
		for (int i=0;i<ind;i++){
			aux2[i]=aux[i];            
		}
		return aux2;
	}


	public static void main(String[] args) {
		String resultado = "";
		int[] desordenado = {9,8,7,6,5,4,3,2,1};
		int[] ordenado    = {1,2,3,4,5,6,7,8,9};
		int[] primos10 = {2,3,5,7};
		if(problema1("oso")==true && problema1("palabra")==false)resultado+="P1 bien\n";else resultado+="P1 mal\n";
		if(problema2(desordenado, 17)==true) resultado+="P2 bien\n";else resultado+="P2 mal\n";
		problema3(desordenado);
		if(Arrays.equals(desordenado,ordenado) == true)resultado+="P3 bien\n";else resultado+="P3 mal\n";
		if(problema4(desordenado,2)== true && problema4(desordenado,18)== false)resultado+="P4 bien\n";else resultado+="P4 mal\n";
		if(problema5(7)==true && problema5(6)==false)resultado+="P5 bien\n";else resultado+="P5 mal\n";
		if(Arrays.equals(problema6(10), primos10) == true)resultado+="P6 bien\n";else resultado+="P6 mal\n";
		System.out.println(resultado);   
	}
}