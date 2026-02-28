/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

/**
 *
 * @author Usuario
 */
public class Controlador {

    private final IControlModelo modelo;
    
    public Controlador(IControlModelo modelo) {
        this.modelo = modelo;
    }
    
    public void buscarServicio(String numServicio){
        modelo.buscarServicio(numServicio);
    }
    
    public void seleccionarCliente(String numServicio){
        modelo.seleccionarCliente(numServicio);
    }
    
    public void ingresarTarjeta(String numTarjeta){
        modelo.ingresarTarjeta(numTarjeta);
    }
}
