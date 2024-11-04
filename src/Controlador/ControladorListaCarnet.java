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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ControladorListaCarnet implements ActionListener{
    FrmListaCarnet vista;
    CRUD_Carnet crud;
    ConsultarCarnet car;
    
    public String consulta = "SELECT idCarnet, idMascota, imagen FROM CARNET_MASCOTA";

    public ControladorListaCarnet(FrmListaCarnet f12) {
        vista=f12;
        vista.btnBuscar.addActionListener(this);
        vista.btnLimpiarFiltro.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaDeCarnet.Presentacion(f12);
        
        // Agregar MouseListener para detectar clic en la tabla
        vista.tblListaCarnet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Usamos clic simple para seleccionar la fila
                    int row = vista.tblListaCarnet.getSelectedRow();
                    if (row != -1) {
                        String idMascota = (String) vista.tblListaCarnet.getValueAt(row, 3); // Usar índice 3 para la cuarta columna
                        registrarEvento(idMascota); // Llama al método que maneja el evento
                    }
                }
            }
        });//Fin Mouse Listener
        
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_Carnet();
        crud.MostrarCarnetEnTabla(vista.tblListaCarnet,query);
        ManejadorTablas.FormatoTablaListarCarnet(vista.tblListaCarnet);
    }//Fin funcion
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" where idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaDeCarnet.LimpiarEntradas(vista);
        }//fin boton
        
        if(e.getSource()==vista.btnLimpiarFiltro){
            ActualizarTabla(consulta);
        }//fin boton
        
    }//fin metodo
    
    // Método para convertir byte[] a Image
    public BufferedImage convertirBytesAImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        return ImageIO.read(bis);
    }//Fin metodo
    
    private void registrarEvento(String idMascota) {
        System.out.println("Doble clic en mascota con ID: " + idMascota);
        
        ImprimirCarnetMascota f5=new ImprimirCarnetMascota();
        ControladorImprimirCarnetMascota control5=new ControladorImprimirCarnetMascota(f5);
        
        f5.txtCodigo.setText(idMascota);
        
        Procesos.ProcesosImprimirCarnetMascota.BotonesAlRecuperar(f5);
        
        
        crud=new CRUD_Carnet();
        car=crud.RecuperarDatosCarnet(idMascota);
        if(car==null){
            Mensajes.M1("No existe ningun carnet para la mascota "+car);
        }else{
            
            if (car.getImagen() != null) {
                try {
                    BufferedImage img = convertirBytesAImagen(car.getImagen());
                    ImageIcon imageIcon = new ImageIcon(img);
                    f5.carnet1.lblImagenMascota.setIcon(imageIcon);
                } catch (IOException e) {
                    e.printStackTrace(); // Maneja la excepción según lo necesites
                }
            } else {
                f5.carnet1.lblImagenMascota.setIcon(null); // O muestra una imagen por defecto
            }
            
            f5.carnet1.lblCodigo.setText(car.getIdMascota());
            f5.carnet1.lblMascota.setText(car.getNombreMascota());
            f5.carnet1.lblDNI.setText(car.getDNI());
            f5.carnet1.lblTipo.setText(car.getTipoMascota());
            f5.carnet1.lblSexo.setText(car.getSexoMascota());
            f5.carnet1.lblDueño.setText(car.getNombreDueño()+" "+car.getApellidoDueño());
            f5.carnet1.lblDireccion.setText(car.getDireccion());
            f5.carnet1.lblTelefono.setText(car.getTelefono());
        }
        vista.add(f5);
    }//Fin funcion
    
}//fin clase
