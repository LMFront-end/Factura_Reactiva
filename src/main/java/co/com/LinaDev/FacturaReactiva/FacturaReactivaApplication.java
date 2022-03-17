package co.com.LinaDev.FacturaReactiva;

import co.com.LinaDev.FacturaReactiva.reactive.FacturaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturaReactivaApplication implements CommandLineRunner {

	// revisar a modo de debug
	private static final Logger log = LoggerFactory.getLogger(FacturaReactivaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FacturaReactivaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// se prueban los codigos
		// mostrar lista
		FacturaService.mostrarListaProductos();
		FacturaService.mostrarPorId();
		FacturaService.filtrarPorNombre();
		FacturaService.filtrarPorFecha();
		FacturaService.multiplicarPorDos();

	}

}
