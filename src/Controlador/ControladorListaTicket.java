package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorListaTicket implements ActionListener{
    FrmListaTicket vista;
    CRUD_Ticket crud;
    TicketClass ti;
    
    public String consulta = "SELECT t.idTicket, t.idCita, c.FechaCita, tu.Hora"+
                            " FROM TICKET t"+
                            " INNER JOIN CITA c ON c.idCita=t.idCita"+
                            " INNER JOIN TURNO tu ON tu.idTurno=c.idTurno";

    public ControladorListaTicket(FrmListaTicket f13) {
        vista=f13;
        vista.btnBuscar.addActionListener(this);
        vista.btnLimpiarFiltro.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaTicket.Presentacion(f13);
        
        // Agregar MouseListener para detectar clic en la tabla
        vista.tblListaTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Usamos clic simple para seleccionar la fila
                    int row = vista.tblListaTicket.getSelectedRow();
                    if (row != -1) {
                        int idTicket = (int) vista.tblListaTicket.getValueAt(row, 1); // Usar índice 1 para la segunda columna
                        mostrarTicket(idTicket); // Llama al método que maneja el evento
                    }
                }
            }
        });//Fin Mouse Listener
        
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_Ticket();
        crud.MostrarTicketEnTabla(vista.tblListaTicket,query);
        ManejadorTablas.FormatoTablaListarTicket(vista.tblListaTicket);
    }//Fin funcion
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" WHERE c.idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaTicket.LimpiarEntradas(vista);
        }//fin boton
        
        if(e.getSource()==vista.btnLimpiarFiltro){
            ActualizarTabla(consulta);
        }//fin boton
        
    }//fin metodo
    
    private void mostrarTicket(int idTicket) {
        System.out.println("Doble clic en ticket con ID: " + idTicket);
        
        ImprimirTickerCita f10=new ImprimirTickerCita();
        ControladorImprimirTicketCita control10=new ControladorImprimirTicketCita(f10);
        
        f10.ticker1.lblCodigo.setText(String.valueOf(idTicket));
        
        crud=new CRUD_Ticket();
        ti=crud.DatosTicket(idTicket);
        
        if(crud==null){
            Mensajes.M1("No existe ningun ticket para la mascota "+ti);
        }else{
            f10.ticker1.lblFecha.setText(ti.getFecha().toString()); 
            f10.ticker1.lblHorarioEstablecido.setText(ti.getHora());
        }
        vista.add(f10);
    }//Fin funcion
    
}//fin clase
