package co.com.LinaDev.FacturaReactiva.reactive;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
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

    // filtrar por nombre
    public static void filtrarPorNombre(){
        System.out.println("Filtrar por nombre: ");
        Mono.just(listaProducto.stream().filter(producto -> Objects.equals(producto.getNombreProducto(), "Pantalla")).collect(Collectors.toList()))
                .subscribe(p -> log.info(p.toString()));
    }

    // filtrar por fecha mayor al 2019
    public static  void filtrarPorFecha(){
        System.out.println("Filtrar por fecha mayor al 2019: ");
        Flux.fromIterable(listaProducto.stream().filter(producto -> producto.getFecha().isAfter(new MyDate("2019-12-31"))).collect(Collectors.toList()))
                .subscribe(p -> log.info(p.toString()));
    }

    // filtrar por fecha menor al 2018
    public static  void filtrarFechaMenor(){
        System.out.println("Filtrar por fecha menor al 2018: ");
        Flux.fromIterable(listaProducto.stream().filter(producto -> producto.getFecha().isAfter(new MyDate("2018-12-31"))).collect(Collectors.toList()))
                .subscribe(p -> log.info(p.toString()));
    }

    // multiplicar precio por 2
    public static void multiplicarPorDos(){
        System.out.println("Multiplicar precio por 2: ");
        Flux.fromIterable(listaProducto.stream().map(producto -> {
            producto.setPrecio(producto.getPrecio() * 2);
            return producto;
        }).collect(Collectors.toList()))
                .subscribe(p -> log.info(p.toString()));
    }

}
