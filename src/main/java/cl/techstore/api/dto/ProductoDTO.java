package cl.techstore.api.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer stock;
    private String categoria;
    private Boolean activo;
}
