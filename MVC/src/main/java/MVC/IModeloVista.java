/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MVC;

import DTOs.ReciboDTO;
import DTOs.ServicioDTO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IModeloVista {
    
    public void agregarSuscriptor(ISuscriptor suscriptor);
    
    List<ServicioDTO> getResultadosBusqueda();
    
    ServicioDTO getServicioSeleccionado();
    
    ReciboDTO getReciboGenerado();
}
