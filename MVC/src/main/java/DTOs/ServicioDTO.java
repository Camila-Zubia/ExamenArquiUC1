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
public class ServicioDTO {
    
    private String numServicio;
    private String nomCliente;
    private double consumo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public ServicioDTO() {
    }

    public ServicioDTO(String numServicio, String nomCliente, double consumo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.numServicio = numServicio;
        this.nomCliente = nomCliente;
        this.consumo = consumo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNumServicio() {
        return numServicio;
    }

    public void setNumServicio(String numServicio) {
        this.numServicio = numServicio;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Servicio{" + "numServicio=" + numServicio + ", nomCliente=" + nomCliente + ", consumo=" + consumo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

    
}
