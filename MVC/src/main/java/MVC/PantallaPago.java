/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import DTOs.ReciboDTO;
import DTOs.ServicioDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Camila Zubia 00000244825
 */
public final class PantallaPago extends JFrame implements ISuscriptor{

    private final Controlador control;
    private final IModeloVista modelo;
    private final CampoTextoRedondeado txtBuscar = new CampoTextoRedondeado();
    BotonRedondeado boton = new BotonRedondeado();
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> listaResultados = new JList<>(listModel);
    private final JLabel lblNombreCliente = new JLabel("Cliente: ");
    private final JLabel lblConsumo = new JLabel("Consumo: $0.00");
    private final JLabel lblFechas = new JLabel("Periodo: --/--/---- al --/--/----");
    private final JLabel lblTituloTarjeta = new JLabel("Número de Tarjeta:");
    private final CampoTextoRedondeado txtTarjeta = new CampoTextoRedondeado();
    private final JLabel lblReciboExito = new JLabel("¡PAGO REALIZADO CON ÉXITO!");
    private final JLabel lblReciboDetalle = new JLabel("");
    BotonRedondeado btnLimpiar = new BotonRedondeado();
    private boolean actualizandoVista = false;
    
    public PantallaPago(Controlador control, IModeloVista modelo) {
        initComponents();
        this.control = control;
        this.modelo = modelo;
        this.modelo.agregarSuscriptor(this);
        acciones();
    }
    
    private void initComponents(){
        //detalles frame
        setSize(1075, 860);
        setBackground(Color.decode("#F6F6F8"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //especificaiones panelPrincipal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setSize(1075, 860);
        panelPrincipal.setBackground(Color.decode("#F6F6F8"));
        
        //Titulo del panel principal
        JLabel titulo = new JLabel();
        panelPrincipal.add(titulo);
        titulo.setSize(805, 45);
        titulo.setBackground(Color.decode("#0F172A"));
        titulo.setText("Búsqueda de Servicio");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.decode("#0F172A"));
        titulo.setLocation(134, 33);
        
        //panel interno donde se encuentran los componentes de busqueda
        PanelRedondeado panelBuscar = new PanelRedondeado(10);
        panelBuscar.setLayout(null);
        panelPrincipal.add(panelBuscar);
        panelBuscar.setSize(390, 268);
        panelBuscar.setBackground(Color.white);
        panelBuscar.setLocation(134, 100);
        
        //titulo del panel buscar 
        JLabel lblBuscar = new JLabel();
        panelBuscar.add(lblBuscar);
        lblBuscar.setSize(300, 28);
        lblBuscar.setBackground(Color.white);
        lblBuscar.setText("Número de Servicio:");
        lblBuscar.setFont(new Font("Arial", Font.BOLD, 18));
        lblBuscar.setForeground(Color.decode("#0F172A"));
        lblBuscar.setLocation(20, 20);
        
        //text field del panel buscar donde se ingresa numero de servicio/tarjeta
        panelBuscar.add(txtBuscar);
        txtBuscar.setSize(350, 54);
        txtBuscar.setLocation(20, 60);
        
        // panel interno donde se mostraran los resultados de búsqueda
        PanelRedondeado panelInfo = new PanelRedondeado(10);
        panelInfo.setLayout(null);
        panelPrincipal.add(panelInfo);
        panelInfo.setSize(390, 268);
        panelInfo.setBackground(Color.decode("#F6F6F8"));
        panelInfo.setLocation(550, 100);
        
        //lista del lado derecho donde aparecen los resultados
        listaResultados.setFont(new Font("Arial", Font.PLAIN, 14));
        listaResultados.setBackground(Color.decode("#F6F6F8"));
        listaResultados.setSelectionBackground(Color.decode("#1C64F2"));
        listaResultados.setSelectionForeground(Color.WHITE);

        JScrollPane scrollLista = new JScrollPane(listaResultados);
        scrollLista.setSize(350, 190);
        scrollLista.setLocation(20, 60);
        scrollLista.setBorder(BorderFactory.createEmptyBorder());
        scrollLista.getViewport().setBackground(Color.decode("#F6F6F8"));
        scrollLista.setBackground(Color.decode("#F6F6F8"));

        panelInfo.add(scrollLista);
        
        
        //titulo del panel info
        JLabel lblResultados = new JLabel();
        panelInfo.add(lblResultados);
        lblResultados.setSize(300, 28);
        lblResultados.setBackground(Color.decode("#F6F6F8"));
        lblResultados.setText("Resultados:");
        lblResultados.setFont(new Font("Arial", Font.BOLD, 18));
        lblResultados.setForeground(Color.decode("#0F172A"));
        lblResultados.setLocation(20, 20);
        
        //panel interno en la parte baja donde se mostrara consumo/recibo
        PanelRedondeado panelDatos = new PanelRedondeado(10);
        panelDatos.setLayout(null);
        panelPrincipal.add(panelDatos);
        panelDatos.setSize(780, 300);
        panelDatos.setBackground(Color.white);
        panelDatos.setLocation(134, 407);
        
        lblNombreCliente.setSize(350, 30);
        lblNombreCliente.setLocation(30, 30);
        lblNombreCliente.setFont(new Font("Arial", Font.BOLD, 16));
        lblConsumo.setSize(350, 30);
        lblConsumo.setLocation(30, 80);
        lblConsumo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFechas.setSize(350, 30);
        lblFechas.setLocation(30, 130);
        lblFechas.setFont(new Font("Arial", Font.PLAIN, 16));

        panelDatos.add(lblNombreCliente);
        panelDatos.add(lblConsumo);
        panelDatos.add(lblFechas);
        
        lblTituloTarjeta.setSize(300, 30);
        lblTituloTarjeta.setLocation(400, 30);
        lblTituloTarjeta.setFont(new Font("Arial", Font.BOLD, 16));
        lblTituloTarjeta.setVisible(false);

        txtTarjeta.setSize(300, 50);
        txtTarjeta.setLocation(400, 70);
        txtTarjeta.setVisible(false);
        
        boton.setSize(200, 50);
        boton.setLocation(400, 130);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setText("✔");
        boton.setVisible(false);
        panelDatos.add(boton);

        
        panelDatos.add(lblTituloTarjeta);
        panelDatos.add(txtTarjeta);

        lblReciboExito.setSize(700, 40);
        lblReciboExito.setLocation(30, 30);
        lblReciboExito.setFont(new Font("Arial", Font.BOLD, 22));
        lblReciboExito.setForeground(new Color(34, 197, 94));
        lblReciboExito.setVisible(false);
        
        lblReciboDetalle.setSize(700, 150);
        lblReciboDetalle.setLocation(30, 80);
        lblReciboDetalle.setFont(new Font("Arial", Font.PLAIN, 16));
        lblReciboDetalle.setVisible(false);

        panelDatos.add(lblReciboExito);
        panelDatos.add(lblReciboDetalle);

        btnLimpiar.setSize(200, 50);
        btnLimpiar.setLocation(30, 230);
        btnLimpiar.setText("Salir");
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 16));
        btnLimpiar.setVisible(false);

        panelDatos.add(btnLimpiar);
        
        add(panelPrincipal);
        setVisible(true);
        
        add(panelPrincipal);
        setVisible(true);
    }
    
    private void acciones() {
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String num = txtBuscar.getText();
                control.buscarServicio(num);
            }
        });
        
        boton.addActionListener(e -> {
            String tarjeta = txtTarjeta.getText();
            if (!tarjeta.trim().isEmpty()) {
                control.ingresarTarjeta(tarjeta);
            }
        });
        
        listaResultados.addListSelectionListener((ListSelectionEvent e) -> {
            if (!actualizandoVista && !e.getValueIsAdjusting() && listaResultados.getSelectedValue() != null) {
                String seleccion = listaResultados.getSelectedValue();
                String idServicio = seleccion.split(" - ")[0];
                control.seleccionarCliente(idServicio);
            }
        });
        
        btnLimpiar.addActionListener(e -> {
            txtBuscar.setText("");
            txtTarjeta.setText("");
            control.buscarServicio("");
        });
    }

    @Override
    public void update() {
        actualizandoVista = true;
        List<ServicioDTO> resultados = modelo.getResultadosBusqueda();
        listModel.clear();
        if (resultados != null) {
            for (ServicioDTO res : resultados) {
                listModel.addElement(res.getNumServicio() + " - " + res.getNomCliente());
            }
        }
        ServicioDTO servicio = modelo.getServicioSeleccionado();
        if (servicio != null) {
            lblNombreCliente.setVisible(true);
            lblConsumo.setVisible(true);
            lblFechas.setVisible(true);
            listaResultados.setSelectedValue(servicio.getNumServicio() + " - " + servicio.getNomCliente(), true);
            lblNombreCliente.setText("Cliente: " + servicio.getNomCliente());
            lblConsumo.setText("Consumo Total: $" + servicio.getConsumo());
            lblFechas.setText("Periodo: " + servicio.getFechaInicio() + " al " + servicio.getFechaFin());
            lblTituloTarjeta.setVisible(true);
            txtTarjeta.setVisible(true);
            boton.setVisible(true);
            lblReciboExito.setVisible(false);
            lblReciboDetalle.setVisible(false);
            btnLimpiar.setVisible(false);

        } else {
            lblNombreCliente.setVisible(true);
            lblConsumo.setVisible(true);
            lblFechas.setVisible(true);
            lblNombreCliente.setText("Cliente: ");
            lblConsumo.setText("Consumo: $0.00");
            lblFechas.setText("Periodo: --/--/---- al --/--/----");
            lblTituloTarjeta.setVisible(false);
            txtTarjeta.setVisible(false);
            boton.setVisible(false);
            lblReciboExito.setVisible(false);
            lblReciboDetalle.setVisible(false);
            btnLimpiar.setVisible(false);
        }
        
        ReciboDTO recibo = modelo.getReciboGenerado();
        if (recibo != null) {
            lblNombreCliente.setVisible(false);
            lblConsumo.setVisible(false);
            lblFechas.setVisible(false);
            lblTituloTarjeta.setVisible(false);
            txtTarjeta.setVisible(false);
            boton.setVisible(false);
            lblReciboExito.setVisible(true);
            lblReciboDetalle.setVisible(true);
            btnLimpiar.setVisible(true);

            String detalleHtml = "<html>"
                    + "<b>Servicio Pagado:</b> " + recibo.getServicio().getNumServicio() + "<br><br>"
                    + "<b>Monto Pagado:</b> $" + recibo.getServicio().getConsumo() + "<br><br>"
                    + "<b>Tarjeta terminación:</b> ****" + recibo.getTarjeta().substring(Math.max(0, recibo.getTarjeta().length() - 4)) + "<br><br>"
                    + "<b>Fecha de transacción:</b> " + recibo.getFecha()
                    + "</html>";

            lblReciboDetalle.setText(detalleHtml);
        }

        actualizandoVista = false;
        repaint();
    }
    

    
    
    //classe interna para crear paneles con esquinas redondeadas
    public class PanelRedondeado extends JPanel{
        private int radio = 0;

        public PanelRedondeado(int radio) {
            super();
            this.radio = radio;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
        }
    }
    
    
    // clase interna donde se crea textfields con esquinas redondeadas
    public class CampoTextoRedondeado extends JTextField {
        private final Color colorFondo = Color.decode("#F8FAFC");
        private final Color colorBorde = Color.decode("#E2E8F0");
        private final int radio = 10;

        public CampoTextoRedondeado() {
            setOpaque(false);
            setBorder(new EmptyBorder(15, 20, 15, 60));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(colorFondo);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);

            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(colorBorde);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio);

            g2.dispose();
        }
    }
    
    // clase interna para crear botones con esquinas redondeadas
    public class BotonRedondeado extends JButton {
        private final int radio = 10;
        private final Color colorFondo = Color.decode("#1C64F2");

        public BotonRedondeado() {
            super();
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            setForeground(Color.WHITE);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (getModel().isArmed()) {
                g2.setColor(colorFondo.darker());
            } else {
                g2.setColor(colorFondo);
            }
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
            super.paintComponent(g);
            g2.dispose();
        }
    }
    
}
