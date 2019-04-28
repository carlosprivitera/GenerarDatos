package datos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla {
    private SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
    private Random rndX = new Random();
    private JTable tabla = null;
    private DefaultTableModel modelo = null;
    private Object[] col = {"ID","Nombre","Apellido","DNI","Fecha nacimiento","Correo","Soltedes S/N"};
    private Object[][] fil = {{"1","Juan", "Perez", "47765689", "03/02/2007", "juan@ser02.com", "S"},
                              {"2","María", "Perez", "44678932", "06/01/2005", "maria@ser01.com", "N"}};
    private Object[] dat = {"1","Juan", "Perez", "47765689", "03-02-2007", "juan@ser02.com", "S"};

    /**
     * @aggregation shared
     */
    private GuardarArchivoTXT guardarArchivoTXT;

    /**
     * @aggregation shared
     */
    private GuardarPortaPapeles guardarPortaPapeles;

    /**
     * @aggregation shared
     */
    private GenerarErrores generarErrores;

    public Tabla(JTable tabla) {
        super();
        this.tabla = tabla;
        modelo = new DefaultTableModel(fil, col);
        tabla.setModel(modelo); 
        guardarArchivoTXT = new GuardarArchivoTXT(tabla);
        guardarPortaPapeles = new GuardarPortaPapeles(tabla);
        generarErrores = new GenerarErrores(tabla);
    }
    public void borrarDatos(){
        for(int c=modelo.getRowCount()-1; c>=0; c--) {
            modelo.removeRow(c);
        }
    }
    public void generarDatos(int nDatos, int errores){
        for(int c=1; c <= nDatos; c++) {
            dat[0] = "" +  c;
            dat[1] = generarCadenaLetras();
            dat[2] = generarCadenaLetras();
            dat[3] = generarCadenaNumeros();
            dat[4] = generarFecha();
            dat[5] = generarCadenaLetras() + "@" + generarCadenaLetras() + ".com";
            dat[6] = "S";
            modelo.addRow(dat);
        }
    }
    private String generarCadenaLetras() {
        String salida = "";
        int n = rndX.nextInt(10)+10;
        for(int c=0; c < n; c++) {
            salida = salida + (char)(rndX.nextInt(26)+97);
        }
        return salida;
    }
    private String generarCadenaNumeros() {
        return "" + (rndX.nextInt(20000000)+20000000);
    }
    private String generarFecha(){
        Calendar c = Calendar.getInstance();
        Date dateX = null;
        try {
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH));
            String annio = Integer.toString(c.get(Calendar.YEAR));
            dateX = d.parse(dia + "-" + mes + "-" + annio);
            dateX = restarDiasFecha(dateX, rndX.nextInt(1000)+1);
        } catch (ParseException e) {
        }
        return DateFormat.getDateInstance().format(dateX);
    }
    public Date restarDiasFecha(Date fecha, int dias){
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); 
      calendar.add(Calendar.DAY_OF_YEAR, -dias);  
      return calendar.getTime(); 
    }
    public void guardarTXT(){
        this.guardarArchivoTXT.guardaTabla();
    }
    public void guardarPortaPapeles() {
       this.guardarPortaPapeles.guardaTabla();
    }
    public void generarErrores(String ch1, String ch2, int porVista) {
       this.generarErrores.generarErrores(ch1, ch2, porVista);
    }    
}
