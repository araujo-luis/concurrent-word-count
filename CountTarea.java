/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class CountTarea implements Callable<Integer> {
	private int fichero;
	private String word;
	private String host;
	private int port;

	/**
	 * Constructor
	 * 
	 * @param ip host donde se ejecuta el servidor
	 * @param p  puerto donde escucha el servidor en el host
	 * @param f  numero de fichero a solicitar
	 * @param w  palabra a buscar
	 */
	CountTarea(String ip, int p, int f, String w) {
		host = ip;
		port = p;
		fichero = f;
		word = w;
	}
	// 192.168.255.128

	/**
	 * @returns el numero de apariciones de la palabra en el fichero
	 */
	@Override
	public Integer call() {
		// NOTA: falta el tratamiento de las excepciones
		long start = System.currentTimeMillis();
		
		
		Socket s;
		int contador = 0;
		try {
			s = new Socket(host, port);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeInt(fichero);
			dout.flush();
			
			String cad;
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));

			while ((cad = br.readLine()) != null) {
				String[] palabras = WordUtils.clean(cad);
				for (String p : palabras) {
					if (p.equals(word)) {
						contador++;
					}
				}
			}
			
			br.close();
			s.close();
			System.out.printf("Apariciones: %d \n",contador);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.printf("Tiempo (ms): %d \n\n", end-start);
		return contador;

	}
}

// EN el Main
// nPool es el argumento de hilos

//recorrer el arrayList para sumar los resultados.
