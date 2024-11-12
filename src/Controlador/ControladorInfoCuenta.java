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

public class ControladorInfoCuenta implements ActionListener{
    FrmInfoCuenta vista;
    CRUD_Usuarios crud;
    Usuarios usu;
    AdministrarClaves ac;
    
    public ControladorInfoCuenta(FrmInfoCuenta f12) {
        vista=f12;
        vista.btnActualizar.addActionListener(this);
        vista.btnActualizarImagen.addActionListener(this);
        
        Procesos.ProcesosInfoCuenta.Presentacion(f12);
        
        mostrarDatosUsuario();
    }//fin constructor
    
    private void mostrarDatosUsuario() {
        int id = Usuarios.usuarioActual.getIdUsuario();
        crud = new CRUD_Usuarios();
        Usuarios usuarioActual = crud.RecuperarUsuario2(id);
        
        if (usuarioActual != null) {
            vista.txtNombre.setText(usuarioActual.getNombres());
            vista.txtApellido.setText(usuarioActual.getApellidos());
            vista.txtCorreo.setText(usuarioActual.getCorreo());
            vista.txtContraseña.setText(usuarioActual.getClave());

            ac = new AdministrarClaves();
            vista.txtRol.setText(ac.RecuperarNombre(ac.queryRol, usuarioActual.getIdRol()));

            // Mostrar la imagen
            if (usuarioActual.getImagen() != null) {
                vista.jImagen.setIcon(new ImageIcon(usuarioActual.getImagen()));
            } else {
                vista.jImagen.setIcon(null); // O una imagen predeterminada si no hay imagen
            }
        }
        
    }//Fin metodo
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnActualizar){
            crud = new CRUD_Usuarios();
            usu = Procesos.ProcesosInfoCuenta.LeerDatos(vista);
            crud.ActualizarUsuarioImagen(usu); // Actualizar en la base de datos
        }
        
        if(e.getSource()==vista.btnActualizarImagen){
           seleccionarImagen();
        }
    }//Fin ActionListener
    
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
