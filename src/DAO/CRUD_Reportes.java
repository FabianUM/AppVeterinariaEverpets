package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class CRUD_Reportes extends ConectarBD{
    public CRUD_Reportes(){}
    
    // Método para generar un gráfico circular de los tipos de mascotas
    public DefaultPieDataset obtenerDistribucionTiposMascotas() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            String sql = "SELECT tm.Nombre_TipoMascota, COUNT(m.idMascota) AS cantidad " +
                         "FROM MASCOTA m " +
                         "JOIN TIPO_MASCOTA tm ON m.idTipoMascota = tm.idTipoMascota " +
                         "GROUP BY tm.Nombre_TipoMascota";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String tipo = rs.getString("Nombre_TipoMascota");
                int cantidad = rs.getInt("cantidad");
                dataset.setValue(tipo, cantidad);
            }

            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }//Fin metodo
    
    // Método para generar un gráfico de barras: Número de mascotas por dueño
    public DefaultCategoryDataset obtenerNumeroMascotasPorDueno() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            String sql = "SELECT p.Nombres, COUNT(m.idMascota) AS cantidad " +
                         "FROM PROPIETARIO p " +
                         "LEFT JOIN MASCOTA m ON p.idPropietario = m.idPropietario " +
                         "GROUP BY p.Nombres";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String dueno = rs.getString("Nombres");
                int cantidad = rs.getInt("cantidad");
                dataset.addValue(cantidad, "Mascotas", dueno);  // Datos para el gráfico de barras
            }

            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }//Fin metodo

    
    // Método para generar un gráfico de líneas: Número de visitas por mes
    public DefaultCategoryDataset obtenerNumeroVisitasPorMes() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Nueva consulta: número de citas por mes
            String sql = "SELECT MONTHNAME(c.FechaCita) AS MES, COUNT(c.IdCita) AS CantidadCitas " +
                         "FROM CITA c " +
                         "GROUP BY MONTHNAME(c.FechaCita) " +
                         "ORDER BY MONTHNAME(c.FechaCita) ASC";

            rs = st.executeQuery(sql);

            while (rs.next()) {
                String mes = rs.getString("MES");
                int cantidad = rs.getInt("CantidadCitas");
                dataset.addValue(cantidad, "Citas", mes);  // Datos para el gráfico de líneas
            }

            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }//Fin método

    
    // Método para generar un gráfico circular: Distribución de edad de las mascotas
    public DefaultPieDataset obtenerDistribucionEdadMascotas2() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            String sql = "SELECT CASE " +
                     "   WHEN m.Edad_mascota < 1 THEN 'Menos de 1 año' " +
                     "   WHEN m.Edad_mascota BETWEEN 1 AND 5 THEN '1 a 5 años' " +
                     "   ELSE 'Más de 5 años' END AS rango_edad, " +
                     "   COUNT(m.idMascota) AS cantidad " +
                     "FROM MASCOTA m " +
                     "GROUP BY rango_edad";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String rangoEdad = rs.getString("rango_edad");
                int cantidad = rs.getInt("cantidad");
                dataset.setValue(rangoEdad, cantidad);  // Datos para el gráfico de pastel
            }

            con.close();//el ultimo metodo del crud cierra la conexion
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataset;
    }//Fin metodo
    
    
    
    
}//fin clase
