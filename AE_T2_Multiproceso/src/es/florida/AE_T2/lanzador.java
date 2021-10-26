package es.florida.AE_T2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class lanzador {
	
	//Constructor/método: lanzarProbabilidad
	//Descripción: Hacemos que lea del archivo tanto la posición, velocidad y el nombre
	//Parametros de entrada: nombreNEO, posicionNEO, velicidadNEO
	//Parametros de salida: ninguno
	public void lanzarProbabilidad(String nombreNEO,String posicionNEO, String velocidadNEO){
        
		String clase = "es.florida.AE_T2.probabilidad";
		try {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;

		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(nombreNEO.toString());
		command.add(posicionNEO.toString());
		command.add(velocidadNEO.toString());

		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.inheritIO().start();
		process.waitFor();
		//System.out.println(process.exitValue());

		} catch (Exception e) {
		e.printStackTrace();}
		}


	//Constructor/método: main
	//Descripción: Creamos el cronómetro y leemos y escribimos en los archivos y ejecutamos lanzarProbabilidad
	//Parametros de entrada: argumentos
	//Parametros de salida: ninguno
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		lanzador l = new lanzador();
		// TODO Auto-generated method stub
		ArrayList<String> contingutFitxer = new ArrayList<String>();
		 File f = new File("NEOs.txt");
		 try {
			 FileReader fr = new FileReader(f);
			 BufferedReader br = new BufferedReader(fr);
			 String linea = br.readLine();
			 while (linea != null) {
				 contingutFitxer.add(linea);
				 linea = br.readLine();
			 }
			 br.close();
			 fr.close();
		 }catch (Exception e) {
			 JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			 
		 }
		
		 int cores = Runtime.getRuntime().availableProcessors();
		 
		 for (int i = 0; i < cores; i++) {
			 String[] contenido = contingutFitxer.get(i).split(",");
			 l.lanzarProbabilidad(contenido[0], contenido[1], contenido[2]);
			 long fin2 = System.currentTimeMillis();
		 }
		 
		 long fin = System.currentTimeMillis();
		 
		 double tiempo = (double) ((fin - inicio)/1000);
		 
		 System.out.println("Tiempo medio NEOs: "+ tiempo/cores +" segundos");
		 System.out.println("Tiempo aplicacion: "+ tiempo +" segundos");
	}

}
