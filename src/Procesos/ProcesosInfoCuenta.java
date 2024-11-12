package Procesos;
//librerias
import Modelo.*;
import Vista.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ProcesosInfoCuenta {
    public static void Presentacion(FrmInfoCuenta f12){
        f12.setVisible(true);
        f12.setTitle("Frm Informacion Cuenta Usuario");
        
        f12.txtRol.setEnabled(false);
    }
    
    //metodo que lee los datos de la clase Usuarios
    public static Usuarios LeerDatos(FrmInfoCuenta f12){
         Usuarios usu =  new Usuarios();
         
         usu.setNombres(f12.txtNombre.getText());
         usu.setApellidos(f12.txtApellido.getText());
         usu.setCorreo(f12.txtCorreo.getText());
         usu.setClave(f12.txtContraseña.getText());
         
         // Leer la imagen del JLabel
        ImageIcon icono = (ImageIcon) f12.jImagen.getIcon();
        if (icono != null) {
            // Convertir el icono a un arreglo de bytes
            byte[] imagenBytes = iconoToBytes(icono);
            usu.setImagen(imagenBytes); // Asignar la imagen al usuario
        } else {
            // Manejo de caso en que no se ha seleccionado ninguna imagen
            usu.setImagen(null); // O manejarlo como prefieras
        }
        
        Usuarios usuarioActual = Usuarios.getUsuarioActual();
    
        // Establecer el ID del usuario logueado
        if (usuarioActual != null) {
            usu.setIdUsuario(usuarioActual.getIdUsuario());
        }

         return usu;
     }//Fin metodo
    
    // Método para convertir un ImageIcon a un arreglo de bytes
    private static byte[] iconoToBytes(ImageIcon icono) {
        BufferedImage bufferedImage = new BufferedImage(icono.getIconWidth(), icono.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.createGraphics();
        icono.paintIcon(null, g, 0, 0);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos); // Puedes elegir el formato que desees
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }//Fin metodo
    
}//fin clase
