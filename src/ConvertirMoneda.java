import javax.swing.*; // Importación para usar JOptionPane

public class ConvertirMoneda {

    /**
     * Método para realizar la conversión entre dos monedas específicas.
     * @param monedaBase Código de la moneda de origen (ejemplo: USD para Dólar).
     * @param monedaTarget Código de la moneda destino (ejemplo: COP para Peso Colombiano).
     * @param consulta Objeto de tipo ConsultarMoneda para obtener la tasa de conversión.
     */
    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta) {
        double cantidad; // Cantidad ingresada por el usuario a convertir
        double cantidadConvertida; // Resultado de la conversión

        // Buscar la moneda y la tasa de conversión entre las monedas base y objetivo
        Moneda moneda = consulta.buscarMoneda(monedaBase, monedaTarget);

        // Mostrar al usuario la tasa de conversión actual
        JOptionPane.showMessageDialog(null, "La tasa de conversión para hoy es:\n1 "
                + monedaBase + " = " + moneda.getConversionRate() + " " + monedaTarget);

        // Solicitar al usuario la cantidad a convertir desde la moneda base
        String entradaCantidad = JOptionPane.showInputDialog("Ingrese la cantidad a convertir desde " + monedaBase + ":");

        try {
            // Intentar convertir la entrada a tipo double
            cantidad = Double.parseDouble(entradaCantidad);

            // Realizar la conversión
            cantidadConvertida = cantidad * moneda.getConversionRate();

            // Mostrar el resultado
            JOptionPane.showMessageDialog(null, cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + moneda.getTargetCode());
        } catch (NumberFormatException e) {
            // Manejo de error si el usuario ingresa algo que no es un número
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor ingrese un número válido.");
        }
    }

    /**
     * Método para realizar la conversión entre monedas personalizadas.
     * @param consulta Objeto de tipo ConsultarMoneda para buscar tasas de conversión.
     */
    public static void convertirOtraMoneda(ConsultarMoneda consulta) {
        // Solicitar al usuario ingresar el código de la moneda base
        String monedaBase = JOptionPane.showInputDialog("Ingrese el código de la moneda que quiere convertir (ejem. COP para Peso Colombiano, USD para Dólar, etc.):").toUpperCase();

        // Solicitar al usuario ingresar el código de la moneda objetivo
        String monedaObjetivo = JOptionPane.showInputDialog("Ingrese la moneda objetivo:").toUpperCase();

        // Llamar al método convertir para realizar la conversión entre las monedas personalizadas
        convertir(monedaBase, monedaObjetivo, consulta);
    }
}


