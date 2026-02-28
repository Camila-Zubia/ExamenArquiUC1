/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import DTOs.ReciboDTO;
import DTOs.ServicioDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Modelo implements IControlModelo, IModeloVista{
    
    private final List<ISuscriptor> suscriptores = new ArrayList<>();
    private final List<ServicioDTO> baseDeDatos;
    private final List<ServicioDTO> resultadosBusqueda;
    private ServicioDTO servicioSeleccionado;
    private ReciboDTO reciboGenerado;
    
    public Modelo() {
        baseDeDatos = new ArrayList<>();
        resultadosBusqueda = new ArrayList<>();
        baseDeDatos.add(new ServicioDTO("12345", "Juan Perez", 550.50, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1)));
        baseDeDatos.add(new ServicioDTO("12388", "Maria Lopez", 890.00, LocalDate.of(2023, 1, 15), LocalDate.of(2023, 2, 15)));
        baseDeDatos.add(new ServicioDTO("98765", "Carlos Slim", 1500.20, LocalDate.of(2023, 2, 1), LocalDate.of(2023, 3, 1)));
    }
    
    @Override
    public void agregarSuscriptor(ISuscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    @Override
    public void buscarServicio(String numServicio) {
        resultadosBusqueda.clear();
        servicioSeleccionado = null;
        reciboGenerado = null;

        if (numServicio != null && !numServicio.isEmpty()) {
            for (ServicioDTO s : baseDeDatos) {
                if (s.getNumServicio().startsWith(numServicio)) {
                    resultadosBusqueda.add(s);
                }
            }
        }
        this.notificar();
    }

    @Override
    public void seleccionarCliente(String numServicio) {
        for (ServicioDTO s : baseDeDatos) {
            if (s.getNumServicio().equals(numServicio)) {
                servicioSeleccionado = s;
                reciboGenerado = null;
                break;
            }
        }
        this.notificar();
    }

    @Override
    public void ingresarTarjeta(String numTarjeta) {
        if (servicioSeleccionado != null) {
            reciboGenerado = new ReciboDTO(servicioSeleccionado, numTarjeta, LocalDate.now());
        }
        this.notificar();
    }
    
    private void notificar() {
        for (ISuscriptor s : suscriptores) {
            s.update();
        }
    }

    @Override
    public List<ServicioDTO> getResultadosBusqueda() {
        return resultadosBusqueda;
    }

    @Override
    public ServicioDTO getServicioSeleccionado() {
        return servicioSeleccionado;
    }

    @Override
    public ReciboDTO getReciboGenerado() {
        return reciboGenerado;
    }
}
