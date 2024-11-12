package Modelo;
//librerias
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;


public class CarnetClass {
    private int idCarnet;
    private byte[] imagen;
    private String idMascota;
    private Image imagenComoObjeto;
    public CarnetClass(){}

    public int getIdCarnet()                    {return idCarnet;}
    public void setIdCarnet(int idCarnet)       {this.idCarnet = idCarnet;}
    public byte[] getImagen()                   {return imagen;}
    public void setImagen(byte[] imagen)        {this.imagen = imagen;this.imagenComoObjeto = convertirBytesAImagen(imagen);}
    public String getIdMascota()                {return idMascota;}
    public void setIdMascota(String idMascota)  {this.idMascota = idMascota;}
    
    // Método para convertir byte[] a Image
    private Image convertirBytesAImagen(byte[] bytes) {
        if (bytes != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
                return bufferedImage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public Image getImagenComoObjeto() {
        return imagenComoObjeto;
    }

    // Método para devolver un arreglo de objetos
    public Object[] RegistroCarnet(int numeracion) {
        return new Object[] { numeracion, idCarnet, imagenComoObjeto, idMascota };
    }
    
}//Fin clase
