package polinomio;

public class BinomioDeNewton {
	
	
	private int n;
	private double ax;
	private double b;
	
	public double factorial(int n){
		
		if(n == 0)
			return 1 ;
		else
			return n * factorial(n-1) ;
	}


	
	

	
	
	
	
	
	
	
	
	
	
	
	public BinomioDeNewton(double ax, double b, int n){
		this.ax=ax;
		this.b=b;
		this.n=n;		
	}
	/* 213*/
	
	public double obtenerCoeficiente(int k){	
		
		return (factorial(this.n) / (factorial(k) * (factorial(this.n-k) ))) * Math.pow(this.ax,k) * Math.pow(this.b, this.n-k);
	

	}
	
	
	
	public double[] desarrollarPolinomio() {
		double[] coef=new double[this.n+1];
		
		for (int i=0;i<=this.n;i++) {
			coef[this.n-i]=this.obtenerCoeficiente(i);
		}
		return coef;
	}
	
	public double[] desarrollarPolinomioConPascal() {
	
		int[][] mat = new int[this.n+1][this.n+1];
		double[] coef=new double[this.n+1];
		
		for(int i=0;i<=this.n;i++) {
			for(int j=0;j<=i;j++) {
				if(i==0||j==0||j==i)
					mat[i][j]=1;
				else
					mat[i][j]=mat[i-1][j]+mat[i-1][j-1];
			}
		}
		
		for (int i=0;i<=this.n;i++) {
			coef[this.n-i]=mat[this.n][i]*Math.pow(this.ax,i)*(Math.pow(this.b,this.n-i));
		}	
		
		return coef;
		
		
	}
	
	public double evaluarEnX(double x){
		return Math.pow(this.ax*x+this.b,this.n);
		
	}
	
	public double combinatoriaRecursiva(int n , int k){
		
		if(k > n)
			return 0 ;
		if(k == 0 || k == n)
			return 1 ;
		else
			return combinatoriaRecursiva(n - 1 , k - 1) + combinatoriaRecursiva(n - 1, k) ;
		
	}
	
	

	}///niko de la b


