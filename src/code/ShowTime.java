package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ShowTime implements Runnable {

	DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");	//Formato de hora para mostrarlo mejor por pantalla
	
	@Override
	public void run() {
		//El hilo secundario se mantiene activo hasta que el hilo principal mande su interrupcion
		while (!Thread.currentThread().isInterrupted()) {
			//Muestro la hora actual con formato
			System.out.println(Thread.currentThread().getName() + "--> " + LocalTime.now().format(format));
			
			try {
				//Antes de mostrar otra vez la hora el hilo espera 1 segundo
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				//Si recibe la orden de interrumpirse mientras esta dormido, muestra un mensaje por pantalla y termino su ejecucion
				System.out.println("-" + Thread.currentThread().getName() +": Estaba dormido. Ya termino");
				return;
			} 
		}
		
	}

}
