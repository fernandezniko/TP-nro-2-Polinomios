package polinomio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class CreaArchivo {
	
	private int grado;
	private String archivoOut;
		
	public CreaArchivo(int grado, String archivoOut) {

		this.grado = grado;
		this.archivoOut=archivoOut;
						
	}
		
	public void crear() throws IOException {
			
		double ini = -100;
		double fin = 100;
			
		PrintWriter salida = new PrintWriter(new FileWriter(this.archivoOut));

			
		salida.println(this.grado);
		
		for(int i=0;i<this.grado;i++) {
				
			double random = new Random().nextDouble();
			double res = ini + (random * (fin - ini));
			salida.println(Math.floor(res * 100)/100);
				
		}
		

		salida.println(5); //termino independiente
		salida.close();
			
			
	}
		

}
