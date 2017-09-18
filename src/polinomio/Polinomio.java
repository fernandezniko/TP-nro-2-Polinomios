
package polinomio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	
	public Polinomio(String archivoIn) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(archivoIn));
		sc.useLocale(Locale.ENGLISH);
		
		
		this.grado=sc.nextInt();
		this.coeficientes=new double[this.grado+1];
		
		for(int i=0;i<this.grado+1;i++)   //this.grado + 1 por termino indep
			this.coeficientes[i] = sc.nextDouble();
		
		sc.close();
	}

	
//	public Polinomio(int grado, double[] coeficientes) {
//
//		this.coeficientes = new double[grado + 1];
//		this.coeficientes = coeficientes;
//		this.grado = grado;
//	}

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

	public static void main(String[] args) throws IOException {

		long inicio;
		long fin;
		
		CreaArchivo archivo = new CreaArchivo(800,"polinomio1.in");
		archivo.crear();
				
		Polinomio pol=new Polinomio("polinomio1.in");
		
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<9999; i++)
			pol.evaluarRecursiva(0.0001);
		//System.out.println(pol.evaluarRecursiva(2));
		fin=System.currentTimeMillis(); 
		System.out.println("Recursiva Tardo \t"+(fin-inicio)+" milisegundos");
		//System.out.println(fin-inicio);
		
		inicio=System.currentTimeMillis();
		for(int i=0; i<9999; i++)
			pol.evaluarRecursivaPar(0.0001);	
		//System.out.println(pol.evaluarRecursivaPar(2));
		fin=System.currentTimeMillis();
		System.out.println("RecursivaPar Tardo \t"+(fin-inicio)+" milisegundos");
		//System.out.println(fin-inicio);
		
//		inicio=System.currentTimeMillis();
//		for(int i=0; i<99999; i++)
//			pol.evaluarHorner(0.001);
//		//System.out.println(pol.evaluarHorner(0.0001));
//		fin=System.currentTimeMillis();
//		System.out.println("Horner Tardo       \t"+(fin-inicio)+" milisegundos");
//		//System.out.println(fin-inicio);
		
//		inicio=System.currentTimeMillis();
//		for(int i=0; i<99999; i++)
//			pol.evaluarPow(0.001);
//		//System.out.println(pol.evaluarPow(0.0001));
//		fin=System.currentTimeMillis();
//		System.out.println("evaluarPow Tardo \t"+(fin-inicio)+" milisegundos");
//		//System.out.println(fin-inicio);
//		
//		inicio=System.currentTimeMillis();
//		for(int i=0; i<99999; i++)
//			pol.evaluarMSucesivas(0.001);
//		//System.out.println(pol.evaluarMSucesivas(0.0001));
//		fin=System.currentTimeMillis();
//		System.out.println("Msucesivas Tardo\t "+(fin-inicio)+" milisegundos");
//		//System.out.println(fin-inicio);
		
//		inicio=System.currentTimeMillis();
//		for(int i=0; i<99999; i++)
//			pol.evaluarProgDinamica(0.001);
//		//System.out.println(pol.evaluarProgDinamica(0.0001));
//		fin=System.currentTimeMillis();
//		System.out.println("eProgDinamica Tardo \t"+(fin-inicio)+" milisegundos");
//		//System.out.println(fin-inicio);
		
//		inicio=System.currentTimeMillis();
//		for(int i=0; i<99999; i++)
//			pol.evaluarMejorada(0.001);
//		//System.out.println(pol.evaluarMejorada(0.0001));
//		fin=System.currentTimeMillis();
//		System.out.println("evaluarMejorada Tardo \t"+(fin-inicio)+" milisegundos");
//		//System.out.println(fin-inicio);
//		
		
		
//		BinomioDeNewton bin=new BinomioDeNewton(1, 1, 3);
//		
//		System.out.println(bin.obtenerCoeficiente(3));
//		
//		double[] coefi;
//		
//		coefi=bin.desarrollarPolinomio();
//		for(int i=0;i<coefi.length;i++) {
//			System.out.print(coefi[i]+" ");
//		}
//		
//		BinomioDeNewton bin2=new BinomioDeNewton(2, 4, 3);
//		System.out.println();
//		coefi=bin2.desarrollarPolinomio();
//		for(int i=0;i<coefi.length;i++) {
//			System.out.print(coefi[i]+" ");
//		}
		
	}

}





