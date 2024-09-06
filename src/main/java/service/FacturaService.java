package service;


import org.springframework.stereotype.Service;

import entity.Factura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class FacturaService {

    private final List<Factura> facturas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

   
    public Factura crearFactura(Factura factura) {
        factura.setId(idGenerator.getAndIncrement());
        factura.setFecha(LocalDate.now());  // Fecha actual
        facturas.add(factura);
        return factura;
    }

   
    public List<Factura> listarFacturas() {
        return facturas;
    }

 
    public Optional<Factura> obtenerFacturaPorId(Long id) {
        return facturas.stream().filter(factura -> factura.getId().equals(id)).findFirst();
    }

 
    public Factura actualizarFactura(Long id, Factura facturaActualizada) {
        Optional<Factura> facturaOpt = obtenerFacturaPorId(id);
        if (facturaOpt.isPresent()) {
            Factura factura = facturaOpt.get();
            factura.setClienteId(facturaActualizada.getClienteId());
            factura.setMonto(facturaActualizada.getMonto());
            factura.setFecha(facturaActualizada.getFecha());
            return factura;
        }
        return null;
    }

    
    public boolean eliminarFactura(Long id) {
        return facturas.removeIf(factura -> factura.getId().equals(id));
    }
}