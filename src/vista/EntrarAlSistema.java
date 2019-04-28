package vista;

public class EntrarAlSistema {
    public EntrarAlSistema() {
        super();
    }

    /**
     * @aggregation composite
     * @label ejecuta
     */
    private static VentanaPrincipal vp = new VentanaPrincipal();
    public static void main(String[] args) {
        EntrarAlSistema entrarAlSistema = new EntrarAlSistema();
        vp.setDefaultCloseOperation(vp.EXIT_ON_CLOSE);
        vp.setLocationRelativeTo(null);
        vp.setExtendedState(vp.MAXIMIZED_BOTH);
        vp.setVisible(true);
        
    }
}
