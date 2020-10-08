package code;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		//Creo un hilo secundario que contiene la clase ShowTime que implementa la interfaz Runnable
		//y la asigno a una variable de tipo Thread
		Thread timeThread = new Thread(new ShowTime(), "MostrarHora");
		timeThread.start();	//Se inicia el hilo y ejecuta el contenido de su metodo run()
		
		try {
			//Mando a dormir el hilo principal antes de interrumpir el hilo secundario.
			TimeUnit.SECONDS.sleep(12);	
			timeThread.interrupt();
			//Muestro por pantalla que el hilo secundario ha terminado
			System.out.println("-" + Thread.currentThread().getName() + ": El hilo secundario ha terminado de ejecutarse");
		} catch (InterruptedException e) {
			// -- Nada --
			//Esta parte se ejecuta en caso de que el hilo principal sea interrumpido, aunque en este caso no deberia ocurrir
			System.out.println("-" + Thread.currentThread().getName() + "quien ha sido? que soy el hilo principal cachoburro!");
		}
	}

}
