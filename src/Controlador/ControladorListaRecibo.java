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

public class ControladorListaRecibo implements ActionListener{
    FrmListaRecibo vista;
    CRUD_Recibo crud;
    ReciboClass re;
    
    public String consulta = "SELECT r.idRecibo, r.idCita, c.Precio, c.Descripcion"+
                            " FROM RECIBO r"+
                            " INNER JOIN CITA c ON c.idCita=r.idCita";

    public ControladorListaRecibo(FrmListaRecibo f14) {
        vista=f14;
        vista.btnBuscar.addActionListener(this);
        vista.btnLimpiarFiltro.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaRecibo.Presentacion(f14);
        
        // Agregar MouseListener para detectar clic en la tabla
        vista.tblListaRecibo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Usamos clic simple para seleccionar la fila
                    int row = vista.tblListaRecibo.getSelectedRow();
                    if (row != -1) {
                        int idRecibo = (int) vista.tblListaRecibo.getValueAt(row, 1); // Usar índice 1 para la segunda columna
                        mostrarRecibo(idRecibo); // Llama al método que maneja el evento
                    }
                }
            }
        });//Fin Mouse Listener
        
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_Recibo();
        crud.MostrarReciboEnTabla(vista.tblListaRecibo,query);
        ManejadorTablas.FormatoTablaReciboTicket(vista.tblListaRecibo);
    }//Fin funcion
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" WHERE c.idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaRecibo.LimpiarEntradas(vista);
        }//fin boton
        
        if(e.getSource()==vista.btnLimpiarFiltro){
            ActualizarTabla(consulta);
        }//fin boton
        
    }//fin metodo
    
    private void mostrarRecibo(int idRecibo) {
        System.out.println("Doble clic en Recibo con ID: " + idRecibo);
        
        ImprimirReciboDeCita f11=new ImprimirReciboDeCita();
        ControladorImprimirReciboCita control11=new ControladorImprimirReciboCita(f11);
        
        crud=new CRUD_Recibo();
        re=crud.DatosRecibo(idRecibo);
        
        if(crud==null){
            Mensajes.M1("No existe ningun ticket para la mascota "+re);
        }else{
            f11.reciboCita1.lblCodigo.setText(re.getIdCita());
            f11.reciboCita1.lblNombres.setText(re.getNombre()+" "+re.getApellido());
            f11.reciboCita1.lblDNI.setText(re.getDni());
            f11.reciboCita1.lblCodMascota.setText(re.getIdMascota());
            f11.reciboCita1.lblMascota.setText(re.getNombreMascota());
            f11.reciboCita1.lblServicio.setText(re.getNombreServicio());
            f11.reciboCita1.lblVeterinario.setText(re.getNombreVeterinario()+" "+re.getApellidoVeterinario());
            f11.reciboCita1.lblFecha.setText(re.getFecha().toString()); 
            f11.reciboCita1.lblHora.setText(re.getHora());
            f11.reciboCita1.lblPrecio.setText(String.valueOf(re.getPrecio()));
        }
        vista.add(f11);
    }//Fin funcion
    
}//fin clase
