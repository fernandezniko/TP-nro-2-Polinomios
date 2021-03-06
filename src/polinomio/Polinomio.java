
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

	
	
	public double evaluarPow(double x) {

		int longitud = this.grado;
		double acum = 0;
		double auxPotencia = 1;
		for (int i = 0; i <= longitud; i++) {
			auxPotencia=Math.pow(x, longitud-i);
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

			resultado += this.coeficientes[i] * potenciaP(x, aux);
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
			r = potenciaP(x*x, grado / 2);
		else
			r = x * potenciaP(x, grado - 1);

		return r;
	}

	public double evaluarProgDinamica(double x) {///metodo buttom up

		double[] vect=new double[this.grado+1];
		vect[0]=1;
		for (int i=1;i<this.grado+1;i++){
			vect[i]=vect[i-1]*x;
		}
		int longitud = this.grado;
		double acum = 0;
		double auxPotencia = 1;
		for (int i = 0; i <= longitud; i++) {
			auxPotencia=vect[this.grado-i];
			auxPotencia *= (this.coeficientes[i]);
			acum += auxPotencia;
			auxPotencia = 1;
		}

		return acum;
	}

	public double evaluarMejorada(double x) {

		double[] vect=new double[this.grado+1];
		vect[0]=1;
		for (int i=1;i<this.grado+1;i++)
			vect[i]=vect[i-1]*x;
		double acum = 0;
		for (int i = 0; i <= this.grado; i++)
			acum+=vect[this.grado-i]* (this.coeficientes[i]);
		return acum;
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
		
		double[] coef = new double[] { 4, 2, 8, 6, 12, 3, 2.6, 4, 0, 1, 3, -5, 9, 14, 0, 12 ,-1, 4 , 3   };
		Polinomio pol = new Polinomio(grado, coef);
		
	
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarRecursiva(10000);
		System.out.println(pol.evaluarRecursiva(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces Recursiva Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarRecursivaPar(10000);	
		System.out.println(pol.evaluarRecursivaPar(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces RecursivaPar Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarHorner(10000);
		System.out.println(pol.evaluarHorner(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces Algoritmo de Horner Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarPow(10000);
		System.out.println(pol.evaluarPow(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces evaluarPow Tardo "+(fin-inicio)+" milisegundos");
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarMSucesivas(10000);
		System.out.println(pol.evaluarMSucesivas(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces Multiplicaciones sucesivas Tardo "+(fin-inicio)+" milisegundos");
	
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarProgDinamica(10000);
		System.out.println(pol.evaluarProgDinamica(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces evaluarProgDinamica Tardo "+(fin-inicio)+" milisegundos");
	
		inicio=System.currentTimeMillis();
		for(int i=0; i<999999; i++)
			pol.evaluarMejorada(10000);
		System.out.println(pol.evaluarMejorada(10000));
		fin=System.currentTimeMillis();
		System.out.println("1000000 veces evaluarMejorada Tardo "+(fin-inicio)+" milisegundos");
	
		BinomioDeNewton bin=new BinomioDeNewton(1, 1, 3);
		
		System.out.println(bin.obtenerCoeficiente(3));
		
		double[] coefi;
		
		coefi=bin.desarrollarPolinomio();
		for(int i=0;i<coefi.length;i++) {
			System.out.print(coefi[i]+" ");
		}
		
		
		double[] coefi2;
		
		
		BinomioDeNewton bin2=new BinomioDeNewton(2, 4, 3);
		System.out.println();
		coefi=bin2.desarrollarPolinomio();
		for(int i=0;i<coefi.length;i++) {
			System.out.print(coefi[i]+" ");
		}
		
		System.out.println();
		
		coefi2=bin2.desarrollarPolinomioConPascal();
		for(int i=0;i<coefi.length;i++) {
			System.out.print(coefi2[i]+" ");
		}
		
		
		
		
		Polinomio pol32=new Polinomio(3, coef);
		pol32.coeficientes=bin2.desarrollarPolinomio();
		System.out.println("\n"+bin2.evaluarEnX(5));
		System.out.println(pol32.evaluarHorner(5));
		
		
		bin2=new BinomioDeNewton(2, 4, 9);
		
		pol32.coeficientes=bin2.desarrollarPolinomio();
		System.out.println(pol32.evaluarHorner(5));
		
		pol32.coeficientes=bin2.desarrollarPolinomioConPascal();
		System.out.println(pol32.evaluarHorner(5));
		

		
		
		
	}

}





