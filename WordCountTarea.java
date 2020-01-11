
//import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class WordCountTarea {

	public static void main(String[] args) {
		// NOTA: falta el tratamiento de las excepciones

		String word = args[0];
		String host = args[1];
		int port = Integer.parseInt(args[2]);
		int nPool = Integer.parseInt(args[3]);
		int apariciones = 0;

		ExecutorService ex = Executors.newFixedThreadPool(nPool);

		ArrayList<Future<Integer>> f = new ArrayList<Future<Integer>>();

		for (int i = 1; i < 12; i++) {
			CountTarea c = new CountTarea(host, port, i, word);
			f.add(ex.submit(c));
		}

		try {
			for (Future<Integer> result : f) {
				apariciones += (Integer) result.get();

			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Total apariciones de '%s': %d", word, apariciones);
		ex.shutdown();

		// Obtener el ExecutorService
		// Crear una lista de Future<Integer> para almacenar lo que devuelva el método
		// submit
		// Para cada fichero
		// Crear una tarea (instancia de CountTarea)
		// Ejecutar la tarea en el ExecutorService y obtener el Future<Integer> que
		// devuelve
		// Almacenar el Future<Integer> en la lista

		// Para cada Future<Integer> de la lista
		// Obtener el resultado y acumularlo en apariciones

		// Mostrar el numero de apariciones
	}
}
