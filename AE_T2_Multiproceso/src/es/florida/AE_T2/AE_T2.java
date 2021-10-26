package es.florida.AE_T2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AE_T2 {

	public static void main(String[] args) {
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
			 System.out.println(contingutFitxer.get(i));
		 }
	}
}
