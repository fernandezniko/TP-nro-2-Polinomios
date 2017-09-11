package polinomio;

public class Polinomio {
	
	private int grado ;
	private double[] coeficientes;
	
	public Polinomio(int grado, double[] coeficientes){
		
		this.coeficientes=new double[grado+1]; 
		this.coeficientes=coeficientes;
		this.grado=grado;
	}
	
	public double evaluarMSucesivas (double x ) {  
		
		int longitud= this.grado;
		double acum=0;
		double auxPotencia=1;
		for(int i=0;i<=longitud;i++) {
			for(int j=0;j<longitud-i;j++) 
				auxPotencia*= x;
			auxPotencia*=(this.coeficientes[i]);
			acum += auxPotencia;
			auxPotencia=1;
		}	
		
		return acum ;
		
	}
	
	public double evaluarRecursiva (double x ) { 
		
		double resultado=0.0 ;
		
		return resultado ; 
	}   
	
	public double evaluarRecursivaPar (double x ) { 
		
		double resultado=0.0 ;
		
		return resultado ;
		
	}
	
	public double evaluarProgDinamica (double x ) {
		
		double resultado=0.0 ;
		
		return resultado ;
		
	}
	
	public double evaluarMejorada (double x ) { 
		
		double resultado=0.0 ;
		
		return resultado ;
		
	}
	
	public double evaluarPow (double x ) {
		
		double resultado=0.0 ;
		
		return resultado ;
		
	}
	
	// y a s u g e r e n c i a de Lucas P
	public double evaluarHorner ( double x ) { 
		
		double resultado=0.0 ;
		
		return resultado ;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int grado=2;
		double[] coef= new double[] {1,2,3};
		Polinomio pol=new Polinomio(grado, coef);
		double res=pol.evaluarMSucesivas(2);
		System.out.println(res);
	}

}