package polinomio;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {

		this.coeficientes = new double[grado + 1];
		this.coeficientes = coeficientes;
		this.grado = grado;
	}

	public double evaluarMSucesivas(double x) {

		int longitud = this.grado;
		double acum = 0;
		double auxPotencia = 1;
		for (int i = 0; i <= longitud; i++) {
			for (int j = 0; j < longitud - i; j++)
				auxPotencia *= x;
			auxPotencia *= (this.coeficientes[i]);
			acum += auxPotencia;
			auxPotencia = 1;
		}

		return acum;

	}

	public double evaluarRecursiva(double x) {

		double resultado = 0.0;
		int longitud = this.grado;
		int aux = this.grado;

		for (int i = 0; i < longitud; i++) {

			resultado += this.coeficientes[i] * potencia(x, aux);
			aux--;
		}
		resultado += this.coeficientes[this.grado];

		return resultado;
	}

	public double potencia(double x, int grado) {

		double r;

		if (grado == 1)
			return x;

		r = x * potencia(x, grado - 1);

		return r;
	}

	public double evaluarRecursivaPar(double x) {

		double resultado = 0.0;
		int longitud = this.grado;
		int aux = this.grado;

		for (int i = 0; i < longitud; i++) {

			resultado += this.coeficientes[i] * potencia(x, aux);
			aux--;
		}
		resultado += this.coeficientes[this.grado];

		return resultado;

	}

	public double potenciaP(double x, int grado) {

		double r;

		if (grado == 1)
			return x;

		if (grado % 2 == 0)
			r = potenciaP(x, grado / 2);
		else
			r = x * potenciaP(x, grado - 1);

		return r;
	}

	public double evaluarProgDinamica(double x) {

		double resultado = 0.0;

		return resultado;

	}

	public double evaluarMejorada(double x) {

		double resultado = 0.0;

		return resultado;

	}

	public double evaluarPow(double x) {

		double resultado = 0.0;

		return resultado;

	}

	// y a s u g e r e n c i a de Lucas P
	public double evaluarHorner(double x) {

		double resultado = 0;

		for (int i =0 ; i <=this.grado ; i++) {
			resultado = this.coeficientes[i] + (x * resultado);
		}
		return resultado;

	}

	public static void main(String[] args) {

		int grado = 18;
		long inicio;
		long fin;
		
		double[] coef = new double[] { 4, 2, 8, 6, 12, 3, 2.6, 4, 0, 1,3,-5,9 ,14 ,0 , 12 ,-1, 4 , 3   };
		Polinomio pol = new Polinomio(grado, coef);
		
		inicio=System.currentTimeMillis();
		
		for(int i=0; i<9999; i++)
			pol.evaluarMSucesivas(2);
		System.out.println(pol.evaluarMSucesivas(2));
		fin=System.currentTimeMillis();
		System.out.println("10000 veces Sumas sucesivas Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<9999; i++)
			pol.evaluarRecursiva(2);
		System.out.println(pol.evaluarRecursiva(2));
		fin=System.currentTimeMillis();
		System.out.println("10000 veces Recursiva Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<9999; i++)
			pol.evaluarRecursivaPar(2);	
		System.out.println(pol.evaluarRecursivaPar(2));
		fin=System.currentTimeMillis();
		System.out.println("10000 veces RecursivaPar Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<9999; i++)
			pol.evaluarHorner(2);
		System.out.println(pol.evaluarHorner(2));
		fin=System.currentTimeMillis();
		System.out.println("10000 veces Algoritmo de Horner Tardo "+(fin-inicio)+" milisegundos");
	}

}





