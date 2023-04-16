
import javax.swing.JOptionPane;

public class Menu{
    String[] opciones;
    String[] opcionesConversor = {
        "------------", 
        "1: Monedas", 
        "2: Temperaturas",
    };
    String[] opcionesMoneda ={
        "1: Peso a Dolar", 
        "2: Peso a Euro",
        "3: Peso a Libras Esterlinas", 
        "4: Peso a Yen Japones", 
        "5: Peso a Won sul-coreano", 
        "6: Dolar a peso", 
        "7: Euro a peso", 
        "8: Libras Esterlinas a peso", 
        "9: Yen Japones a peso", 
        "10: Won surcoreano a peso", 
    };
    String[] opcionesTemperatura ={
        "1: Celsius a Kelvin", 
        "2: Celsius a Farenheit",
        "3: Kelvin a Celsius", 
        "4: Farenheit a Celsius",  
    };
    
    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String[] getOpciones() {
        return this.opciones;
    }

    public String menuDesplegable() {
        return (String) JOptionPane.showInputDialog(
            null, 
            "Seleccione lo que quiere convertir: ",
            "Conversor", 
            JOptionPane.QUESTION_MESSAGE,
            null, 
            opciones, 
            opciones[0]);
    }

    public Double menuInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir: "));
            } catch (NumberFormatException e) {
                menuMessage("Valor no valido.");
            }
        }
    }

    public void menuMessage(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public int menuConfirmacion() {
        return JOptionPane.showConfirmDialog(null, "¿Desea continuar?");
    }

    public void index(){
        String seleccion, seleccion2;
        Double cantidad;
        int seleccion3;
        while (true) {
            try {
                setOpciones(opcionesConversor);
                seleccion = menuDesplegable();
                if(seleccion == "1: Monedas"){
                    setOpciones(opcionesMoneda);
                }else if (seleccion == "2: Temperaturas"){
                    setOpciones(opcionesTemperatura);
                }else{
                    break;
                }
                seleccion2 = menuDesplegable();
                seleccion2 = seleccion2.substring(0, 1);
                cantidad = menuInputDouble();
                
                menuMessage(Conversor.convertir(cantidad, Integer.parseInt(seleccion2)-1,Integer.parseInt(seleccion.substring(0, 1))));
                seleccion3 = menuConfirmacion();
                if (seleccion3 == JOptionPane.NO_OPTION || seleccion3 == JOptionPane.CANCEL_OPTION){
                    menuMessage("Programa terminado");
                    break;
                }
            } catch (Exception e) {
                seleccion3 = menuConfirmacion();
                if (seleccion3 == JOptionPane.NO_OPTION || seleccion3 == JOptionPane.CANCEL_OPTION){
                    menuMessage("Programa terminado");
                    break;
                }
                
            }
        }
    }
}