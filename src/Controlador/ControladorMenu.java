package Controlador;
//librerias
import Formatos.Mensajes;
import Modelo.Usuarios;
import Principal.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorMenu implements ActionListener{
    FormularioMenu vista;
    Usuarios u=new Usuarios();
    private JPopupMenu jPopupMenu1; // Definir el JPopupMenu
    
    public ControladorMenu(FormularioMenu f1){
        vista=f1;
        
         // Crear el JPopupMenu
        jPopupMenu1 = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Configuración cuenta");
        menuItem1.addActionListener(e -> {
            FrmInfoCuenta f12 = new FrmInfoCuenta();
            ControladorInfoCuenta control12 = new ControladorInfoCuenta(f12);
            vista.jdpnContenedor.add(f12);
        });
        JMenuItem menuItem2 = new JMenuItem("Cerrar Sesión");
        menuItem2.addActionListener(e -> {
            int m=Mensajes.M3("Cerrar Cesion", "¿Desea cerrar la sesión?");
            if(m==0){
                vista.dispose(); // Ejemplo: cerrar la ventana actual
                FrmLogin f12 = new FrmLogin(); // Ejemplo: abrir el formulario de login
                ControladorLogin control12 = new ControladorLogin(f12);
            }else{
                Mensajes.M1("Cierre de sesión cancelado");
            }//Fin if
        });
        
        jPopupMenu1.add(menuItem1);
        jPopupMenu1.add(menuItem2);

        //hacer que los botones funcionen
        vista.mitemMantenimientoDueño.addActionListener(this);
        vista.mitemMantenimientoCitas.addActionListener(this);
        vista.mitemMantenimientoMascota.addActionListener(this);
        vista.mitemMantenimientoServicioMascotas.addActionListener(this);
        vista.mitemMantenimientoTiposMascota.addActionListener(this);
        vista.mitemMantenimientoVeterinarios.addActionListener(this);
        vista.mitemImprimirCarnet.addActionListener(this);
        vista.mitemListarCarnet.addActionListener(this);
        vista.mitemListarCitas.addActionListener(this);
        vista.mitemListarTicket.addActionListener(this);
        vista.mitemListarRecibo.addActionListener(this);
        vista.mitemTurnosCita.addActionListener(this);
        vista.mitemMantenimientoUsuarios.addActionListener(this);
        vista.mitemVeterinaria.addActionListener(this);
        vista.mitemReportesGraficos.addActionListener(this);
        
        vista.btnConfiguracion.addActionListener(this);
        
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f1.setTitle("Aplicación de Veterinaria");
        f1.setVisible(true);
    }//fin constructor
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== vista.mitemMantenimientoDueño){
            Main.f1 = new FrmDueñosdeMascota();
            Main.controlf1 = new ControladorDueñosDeMascota(Main.f1);          
            vista.jdpnContenedor.add(Main.f1); 
        }
        
        if(e.getSource()==vista.mitemMantenimientoMascota){
            FrmDeMascotas f2=new FrmDeMascotas();
            ControladorDeMascota control2=new ControladorDeMascota(f2);          
            vista.jdpnContenedor.add(f2);
        }
        
        if(e.getSource()==vista.mitemMantenimientoCitas){
            ReservarCita f3=new ReservarCita();
            ControladorReservarCita control3=new ControladorReservarCita(f3);          
            vista.jdpnContenedor.add(f3);
        }
        
        if(e.getSource()==vista.mitemListarCitas){
            FrmListaDeCitas f4=new FrmListaDeCitas();
            ControladorListaCitas control4=new ControladorListaCitas(f4);          
            vista.jdpnContenedor.add(f4);
        }
        
        if(e.getSource()==vista.mitemImprimirCarnet){
            ImprimirCarnetMascota f5=new ImprimirCarnetMascota();
            ControladorImprimirCarnetMascota control5=new ControladorImprimirCarnetMascota(f5);          
            vista.jdpnContenedor.add(f5);
        }
        
        if(e.getSource()==vista.mitemTurnosCita){
            FrmTurnosCita f6=new FrmTurnosCita();
            ControladorTurnosCita control6=new ControladorTurnosCita(f6);          
            vista.jdpnContenedor.add(f6);
        }
        
        if(e.getSource()==vista.mitemMantenimientoVeterinarios){
            FrmVeterinarios f7=new FrmVeterinarios();
            ControladorVeterinarios control7=new ControladorVeterinarios(f7);          
            vista.jdpnContenedor.add(f7);
        }
        
        if(e.getSource()==vista.mitemMantenimientoServicioMascotas){
            FrmServiciosVeterinaria f8=new FrmServiciosVeterinaria();
            ControladorServiciosVeterinaria control8=new ControladorServiciosVeterinaria(f8);          
            vista.jdpnContenedor.add(f8);
        }
        
        if(e.getSource()==vista.mitemMantenimientoTiposMascota){
            FrmTiposMascota f9=new FrmTiposMascota();
            ControladorTiposMascota control9=new ControladorTiposMascota(f9);          
            vista.jdpnContenedor.add(f9);
        }
        
        if(e.getSource()==vista.mitemMantenimientoUsuarios){
            FrmUsuarios f10=new FrmUsuarios();
            ControladorUsuarios control10=new ControladorUsuarios(f10);          
            vista.jdpnContenedor.add(f10);
        }
        
        if(e.getSource()==vista.mitemVeterinaria){
            FrmEmpresa f11=new FrmEmpresa();
            ControladorEmpresa control11=new ControladorEmpresa(f11);          
            vista.jdpnContenedor.add(f11);
        }
        
        if(e.getSource()==vista.mitemListarCarnet){
            FrmListaCarnet f12=new FrmListaCarnet();
            ControladorListaCarnet control12=new ControladorListaCarnet(f12);          
            vista.jdpnContenedor.add(f12);
        }
        
        if(e.getSource()==vista.mitemListarTicket){
            FrmListaTicket f13=new FrmListaTicket();
            ControladorListaTicket control13=new ControladorListaTicket(f13);          
            vista.jdpnContenedor.add(f13);
        }
        
        if(e.getSource()==vista.mitemListarRecibo){
            FrmListaRecibo f14=new FrmListaRecibo();
            ControladorListaRecibo control14=new ControladorListaRecibo(f14);          
            vista.jdpnContenedor.add(f14);
        }
        
        if(e.getSource()==vista.mitemReportesGraficos){
            FrmGraficos f15=new FrmGraficos();
            ControladorReportes control15=new ControladorReportes(f15);          
            vista.jdpnContenedor.add(f15);
        }
        
        if (e.getSource() == vista.btnConfiguracion) {
            // Mostrar el JPopupMenu
            jPopupMenu1.show(vista.btnConfiguracion, 0, vista.btnConfiguracion.getHeight());
        }
    
    }//fin ActionListener
    
}//fin clase
