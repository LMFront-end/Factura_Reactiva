package co.com.LinaDev.FacturaReactiva.reactive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

    private Integer idFactura;
    private String nombreProducto;
    private Integer precio;
    private MyDate fecha;
    private DescuentoValue descuento;
}
