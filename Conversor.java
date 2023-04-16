public class Conversor {
    private static Double[] valores;

    private static Double[] valoresMonedas = {
        0.055, 0.050, 0.044, 7.42, 72.30,
        18.00, 19.80, 22.34, 0.13, 0.014
    }; 
    private static Double[] valoresTemperaturas = {
        274.15, 33.8, -272.15, -17.2222222, 
    }; 
    
    public static String convertir(Double valor, int numOpcion, int tipoConvertir) {
        if (tipoConvertir == 1){
            valores = valoresMonedas;
        }else{
            valores = valoresTemperaturas;
        }
        return "El valor es: "+ Double.toString(valor *(valores[numOpcion]/1));
    }
}
