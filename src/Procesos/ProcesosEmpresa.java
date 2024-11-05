package Procesos;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Vista.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ProcesosEmpresa {
    public static void Presentacion(FrmEmpresa f11){
        f11.setVisible(true);
        f11.setTitle("Frm De Nuestra Empresa");
    }
    
    public static void LimpiarEntradas(FrmEmpresa f11){
        f11.txtRUC.setText("");
        f11.txtNombre.setText("");
        f11.txtTelefono.setText("");
        f11.txtDireccion.setText("");
        f11.txtRUC.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Empresa LeerDatos(FrmEmpresa f11){
         Empresa vet =  new Empresa();
         
         vet.setIdEmpresa(Integer.parseInt(f11.lblID.getText()));
         vet.setRUC(f11.txtRUC.getText());
         vet.setNombre(f11.txtNombre.getText());
         vet.setTelefono(f11.txtTelefono.getText());
         vet.setDireccion(f11.txtDireccion.getText());
         
         // Leer la imagen del JLabel
        ImageIcon icono = (ImageIcon) f11.jImagen.getIcon();
        if (icono != null) {
            // Convertir el icono a un arreglo de bytes
            byte[] imagenBytes = iconoToBytes(icono);
            vet.setImagen(imagenBytes); // Asignar la imagen al usuario
        } else {
            // Manejo de caso en que no se ha seleccionado ninguna imagen
            vet.setImagen(null); // O manejarlo como prefieras
        }
         
         return vet;
     }
    
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
