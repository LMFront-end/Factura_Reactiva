package co.com.LinaDev.FacturaReactiva.reactive;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FacturaService {

    static Data data = new Data();
    static List<Factura> listaProducto = data.listaProducto;

    private static final Logger log = LoggerFactory.getLogger(FacturaService.class);

    // mostrar todos los elementos de la lista
    public static void mostrarListaProductos(){
        System.out.println("Mostrar todos los productos: ");
        Flux.fromIterable(listaProducto)
                .subscribe(producto -> log.info(producto.toString()));

    }

    //mostrar elemento por id
    public static void mostrarPorId(){
        System.out.println("Mostrar elementos por id: ");
        Mono.just(listaProducto.stream().filter(producto -> producto.getIdFactura() == 2).collect(Collectors.toList()))
                .subscribe(p -> log.info(p.toString()));
    }

}
