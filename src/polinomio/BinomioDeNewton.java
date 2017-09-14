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
	
	
	
	
	
	

	}///niko de la b


