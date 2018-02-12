package main;

import com.lowagie.text.DocumentException;

import parser.ReaderSingleton;

/**
 * Main application
 * 
 * @author 1A1
 *
 */
public class LoadAgents {

	public static void main(String... args) throws DocumentException {
		final LoadAgents runner = new LoadAgents();
		runner.run(args);
	}

	private void run(String... args) throws DocumentException {
		if (args.length == 0 || args[0].equals("--help"))
			showHelp();
		else if (args[0].equals("info"))
			showInfo();
		else if (args[0].equals("load")) {
			if (args.length < 2)
				System.err.println(
						"La operacion load necesita al menos otro " + "argumento con la ubicacion del fichero");
			else {
				for (int i = 1; i <= args.length - 1; i++)
					ReaderSingleton.getInstance().loadFile(args[i]);
			}
		}
	}

	private void showInfo() {
		System.out.println("Proyecto Loader 1A");
		System.out.println("El objetivo de este proyecto es actuar como modulo de carga de"
				+ "usuarios para un sistema de participacion ciudadana");
		System.out.println("Realizado por el grupo 1A1 (2016-2017) compuesto por: ");
		System.out.println("Daniel Alba Muñiz (UO245288)");
		System.out.println("Jose Luis Bugallo Gonzalez (Uo244702)");
		System.out.println("Ignacio Escribano Burgos (UO227766)");
		System.out.println("Daniel Duque Barrientos (UO245553)");
		System.out.println("Ruben de la Varga Cabero (UO246977)");
		System.out.println("(2017-2018)");
		System.out.println("Mario Del Olmo Diaz (UO251090)");
		System.out.println("Daniel Fuego San Francisco (UO251185)");
		System.out.println("Sergio Fernández Fernández (UO251408)");
		System.out.println("Pablo Baragaño Coto (UO251759)");
		System.out.println("Sergio Rodríguez Artime (UO248043)");
		System.out.println("Para mas informacion consultar el repositorio en github con la url "
				+ "https://github.com/Arquisoft/Loader_e1b");

	}

	private void showHelp() {
		System.out.println("Manual de ayuda para el uso de la aplicacion");
		System.out.println("La aplicacion tiene implementadas las operaciones info, load y help");
		System.out.println("	info: Muestra informacion relacionada con el proyecto, como los autores");
		System.out.println(
				"	load[file]: Permite cargar un conjunto de ficheros excel con usuarios " + "en la base de datos");
		System.out.println("	--help: Muestra este menu de ayuda. Si no se proporcionan parametros "
				+ "a la aplicacion se mostrara este menu");
	}
}
