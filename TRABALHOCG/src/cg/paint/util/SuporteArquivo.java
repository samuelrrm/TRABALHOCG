package cg.paint.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cg.paint.geometria.Geometria;



public class SuporteArquivo {

	public static void gravar(File file, List <Geometria> desenhos){
		// cria um arquivo
		ObjectOutputStream arq;
		try {
			arq = new ObjectOutputStream(new FileOutputStream(file));
			// grava um objeto
			arq.writeObject(desenhos);
			// descarrega os dados pendentes no buffer para o arquivo
			arq.flush();
			// fecha o arquivo
			arq.close();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Geometria> abrir(File file){
		// Lê um objeto
		List <Geometria> desenhos = new ArrayList<Geometria>();
		try {
			ObjectInputStream arq = new ObjectInputStream(new FileInputStream(file));
			desenhos = (List<Geometria>)arq.readObject();
			arq.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Fechamento do arquivo:
		return desenhos;
	}

	public static List <String> listaArquivosPastaTrabalho(File file){
		if (file.isDirectory()) {
			String directory[] = file.list();
			System.out.println( "\n\nConteúdo do diretório:\n" );
			for ( String nomeArq : directory )
				System.out.println("  " + nomeArq );
			return Arrays.asList( directory );
		}
		else {
			return null;
		}
	}

	public static String abrirCodigo(File file){
		// Lê um objeto
		String arquivoCorrente = new String("");
		if (file.exists()){
			try {
				ObjectInputStream arq = new ObjectInputStream(new FileInputStream(file));
				arquivoCorrente = (String) arq.readObject();
				arq.close();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Fechamento do arquivo:
		return arquivoCorrente;
	}	

	public static void gravarCodigo(File file, String arquivoCorrente){
		// cria um arquivo
		ObjectOutputStream arq;
		try {
			arq = new ObjectOutputStream(new FileOutputStream(file));
			// grava um objeto
			arq.writeObject(arquivoCorrente);
			// descarrega os dados pendentes no buffer para o arquivo
			arq.flush();
			// fecha o arquivo
			arq.close();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
