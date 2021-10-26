package es.florida.AE_T2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;

public class probabilidad {
	
	//Constructor/método: main
	//Descripción: Calculamos el porcentaje, sacamos solo dos decimales de este, mostramos la alarma y creamos el archivo.
	//Parametros de entrada: argumentos
	//Parametros de salida: ninguno
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreNeo = args[0];
		double posicionNEO = Double.parseDouble(args[1]);
		double velocidadNEO = Double.parseDouble(args[2]);
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		//Mostrar solo los dos decimales
		DecimalFormat formato1 = new DecimalFormat("#.00");
		String resultadoFormateado = formato1.format(resultado);

		//Mostrar alarma por el porcentaje
		if (resultado > 10) {
			System.err.println(nombreNeo + " ALARMA MUNDIAL... " + resultadoFormateado);
		}else {
			System.out.println(nombreNeo + " CALMA... " + resultadoFormateado);
		}
		
		
		File f2 = new File(nombreNeo + ".txt");
		
		try {
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(resultado+"");
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
