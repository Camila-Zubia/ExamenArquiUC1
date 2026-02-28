/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import MVC.Controlador;
import MVC.Modelo;
import MVC.PantallaPago;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Controlador control = new Controlador(modelo);
        PantallaPago ventana = new PantallaPago(control, modelo);
    }
}
