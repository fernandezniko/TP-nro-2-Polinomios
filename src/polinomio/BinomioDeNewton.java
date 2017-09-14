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
	
	
	public double obtenerCoeficiente(int k){	
		
		return (factorial(this.n) / (factorial(k) * (factorial(this.n-k) ))) * Math.pow(this.ax,k) * Math.pow(this.b, this.n-k);
	
	}
}
