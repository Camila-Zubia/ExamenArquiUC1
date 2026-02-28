/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import MVC.Controlador;
import MVC.Modelo;
import MVC.PanelPrincipal;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Controlador control = new Controlador(modelo);
        PanelPrincipal ventana = new PanelPrincipal(control, modelo);
    }
}
