/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class ReciboDTO {
    
    private ServicioDTO servicio;
    private String tarjeta;
    private LocalDate fecha;

    public ReciboDTO() {
    }

    public ReciboDTO(ServicioDTO servicio, String tarjeta, LocalDate fecha) {
        this.servicio = servicio;
        this.tarjeta = tarjeta;
        this.fecha = fecha;
    }

    public ServicioDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Recibo{" + "servicio=" + servicio + ", tarjeta=" + tarjeta + ", fecha=" + fecha + '}';
    }
    
}
