public class Matrix{
	private double[][] matriz;
	/**
	*Construye una matriz vacia de n por m
	*@param n numero de filas que tendra la matriz
	*@param m numero de columnas que tendra la matriz
	*/
	public Matrix(int n, int m){
		this.matriz = new double[n][m];
	}
	/**
	*Construye una matriz dado un arreglo
	*@param array es el arreglo con el cual se construye la clase
	*/
	public Matrix(double[][] array){
		this.matriz=array;
	}
	/**
	*Función que calcula producto escalar
	*@param scalar es el numero por el cual se va a multiplicar la matriz
	*/
	public void scalarProduct(double scalar){
		for (int i=0;i<this.matriz.length;i++){
			for (int j=0;j<this.matriz[0].length;j++){
				this.matriz[i][j]=this.matriz[i][j]*scalar;
			}	
		}
	}
	/**
	*Función que calcula suma de matrices
	*@param m matriz con la cual se va sumar el objeto que llame a la funcion
	*/
	public void add(Matrix m){
		for (int i=0;i<this.matriz.length;i++){
			for (int k=0;k<this.matriz[0].length;k++){
				this.matriz[i][k]=this.matriz[i][k]+m.matriz[i][k];
			}
		}
	}
	/**
	*Función que calcula producto de matrices
	*@param m matriz por la cual se va a multiplicar el objeto que llame a la funcion
	*/
	public void matrixProduct(Matrix m){
		int tamCol=m.matriz[0].length,tamRen=this.matriz.length;
		double aux[][]=new double[tamRen][tamCol];
		for(int i=0;i<this.matriz.length;i++){
			for(int j=0;j<m.matriz[0].length;j++){
				for(int k=0;k<m.matriz.length;k++){
					aux[i][j]+=this.matriz[i][k]*m.matriz[k][j];
				}
			}
		}
		this.matriz=aux;
	}
	/**
	*Función que obtiene el elemento de la fila i columna j
	*@param i fila de la cual se quiere obtener el elemento
	*@param j columna de la cual se quiere obtener el elemento
	*@return el elemento de la fila i columna j
	*/
	public double getElement(int i, int j){
		return this.matriz[i][j];
	}
	/**
	*Función que cambia el valor de una casilla de la matriz
	*@param i fila de la cual se quiere cambiar el elemento
	*@param j columna de la cual se quiere cambiar el elemento
	*@param e valor por el cual se va a remplazar la casilla
	*/
	public void setElement(int i, int j,double e){
		this.matriz[i][j]=e;
	}
	/**
	*Función que crea una matriz de un tamaño menor en filas y columnas
	*@param m matriz que se va a recortar
	*@param ind columna que se va a recortar de la matriz
	*@return una matriz recortada sin la columna ind y sin la primera fila
	*/
	private double[][] matPeq(double[][] m,int ind){
		double aux[][] = new double[m.length-1][m.length-1];
		int aux1=0;
		for (int i=0;i<m.length-1;i++){
			for (int k=0;k<m.length;k++){
				if(k!=ind){
					aux[i][aux1]=m[i+1][k];
					aux1++;
				}
			}
			aux1=0;
		}
		return aux;
	}
	/**
	*Función que calcula el determinante si es nxn
	*@return regresa el determinante de la matriz
	*/
	public double determinant(){
		double aux=0;
		if(this.matriz.length==2){
			aux=(this.matriz[0][0]*this.matriz[1][1])-(this.matriz[1][0]*this.matriz[0][1]);
		}else{
			for (int i=0;i<this.matriz.length;i++){
				Matrix aux1= new Matrix(matPeq(this.matriz,i));
				if (i%2==0){
					aux+=(this.matriz[0][i]*aux1.determinant());
				}
				else aux-=(this.matriz[0][i]*aux1.determinant());
			}
		}
		return aux;
	}
	/**
	*Función que te dice si 2 matrices son iguales
	*@param o objeto que se va a comparar con la matriz
	*@return true si son iguales false si no lo son
	*/
	@Override
	public boolean equals(Object o){
		if(o instanceof Matrix){
			Matrix aux = (Matrix)o;
			if(aux.matriz.length==this.matriz.length){
				if (aux.matriz[0].length==this.matriz[0].length){
					for (int i=0;i<aux.matriz.length;i++){
						for (int j=0;j<aux.matriz[0].length;j++){
							if(aux.matriz[i][j]!=this.matriz[i][j]){
								return false;
							}
						}	
					}
					return true;
				}
			}
		}
		return false;
	}
}