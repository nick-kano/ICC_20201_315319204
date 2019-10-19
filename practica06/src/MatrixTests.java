public class MatrixTests{
	public static void scalarProduct_test(Matrix m,int a,double ar[][]){
		m.scalarProduct(a);
		if(m.equals(new Matrix(ar))){
			System.out.println("scalar product succeded");
		}
		else System.out.println("scalar product failed");
	}
	public static void add_test(Matrix m, Matrix n,double ar[][]){
		m.add(n);
		if(m.equals(new Matrix(ar))){
		System.out.println("addition succeded");
		}
		else System.out.println("addition failed");
	}
	public static void matrixProduct_test(Matrix m,Matrix n,double ar[][]){
		m.matrixProduct(n);
		if(m.equals(new Matrix(ar))){
			System.out.println("matrix product succeded");
		}
		else System.out.println("matrix product failed");
	}
	public static void setElement_test(Matrix m,int i, int j,double k){
		m.setElement(i,j,k);
		if(m.getElement(i,j)==k){
			System.out.println("setElement succeded");	
		}
		else System.out.println("setElement failed");
	}
	public static void getElement_test(Matrix m,int i,int j,double k){
		if (m.getElement(i,j)==k){
			System.out.println("Get Element succeded");
		}
		else System.out.println("Get element failed");
	}
	public static void determinant_test(Matrix m, double a){
		if(m.determinant()==a){
			System.out.println("Determinant succeded");
		}
		else System.out.println("Determinant failed");
	}
	public static void equals_test(Matrix m, Matrix n){
		if (m.equals(n)){
			System.out.println("equals succeded");
		}
		else System.out.println("equals failed");
	}

	public static void main(String[] args){
		double[][] ar = new double [][]{{1,2},{3,4},{5,6}};
		double[][] ar2 = new double [][]{{2,4},{6,8},{10,12}};
		double[][] ar3 = new double [][]{{4,8},{12,16},{20,24}};
		double[][] ar4 = new double [][]{{1,2,3},{4,5,6}};
		double[][] ar5 = new double [][]{{18,24,30},{38,52,66},{58,80,102}};
		double[][] ar6 = new double [][]{{7,8,9,4},{4,5,6,7},{1,7,6,3},{2,2,2,2}};
		Matrix mat = new Matrix(ar);
		Matrix mat2 = new Matrix(ar2);
		Matrix mat3 = new Matrix(ar4);
		Matrix mat4 = new Matrix(ar6);
		double det=-84;
		scalarProduct_test(mat,2,ar2);
		add_test(mat,mat2,ar3);
		matrixProduct_test(mat2,mat3,ar5);
		setElement_test(mat,1,1,1);
		getElement_test(mat3,1,1,5);
		determinant_test(mat4,det);
		equals_test(mat,mat);
	}	
}