package Controlador;
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ControladorEmpresa implements ActionListener{
    FrmEmpresa vista;
    CRUD_Empresa crud;
    Empresa vet;
    
    public ControladorEmpresa(FrmEmpresa f11) {
        vista=f11;
        vista.btnSeleccionarImagen.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        
        Procesos.ProcesosEmpresa.Presentacion(f11);
        
        mostrarDatosEmpresa();
    }//fin constructor

    private void mostrarDatosEmpresa() {
        crud = new CRUD_Empresa();
        vet = crud.RecuperarEmpresa();
        
        if (vet != null) {
            vista.lblID.setText(""+vet.getIdEmpresa());
            vista.txtNombre.setText(vet.getNombre());
            vista.txtDireccion.setText(vet.getDireccion());
            vista.txtTelefono.setText(vet.getTelefono());
            vista.txtRUC.setText(vet.getRUC());
            // Mostrar la imagen
            if (vet.getImagen() != null) {
                vista.jImagen.setIcon(new ImageIcon(vet.getImagen()));
            } else {
                vista.jImagen.setIcon(null); // O una imagen predeterminada si no hay imagen
            }
        }//fin if
        
    }//Fin metodo
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnSeleccionarImagen){
           seleccionarImagen();
       }//Fin boton
        
        if(e.getSource()==vista.btnActualizar){
           crud = new CRUD_Empresa();
           vet = Procesos.ProcesosEmpresa.LeerDatos(vista);
           crud.ActualizarEmpresaImagen(vet); // Actualizar en la base de datos
       }
        
    }//fin metodo
    
    private void seleccionarImagen() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar Imagen");
        int resultado = chooser.showOpenDialog(vista);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            // Mostrar la imagen en el JLabel
            vista.jImagen.setIcon(new ImageIcon(archivoSeleccionado.getAbsolutePath()));
        }
    }//fin metodo
    
}//fin clase
