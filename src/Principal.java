import javax.swing.*; // Importación para usar JOptionPane

public class Principal {
    public static void main(String[] args) {
        // Objeto ConsultarMoneda para realizar consultas de valores de monedas
        ConsultarMoneda consulta = new ConsultarMoneda();

        boolean option = true; // Variable de control para el ciclo del menú
        int opc; // Variable para almacenar la opción seleccionada por el usuario

        // Ciclo que mantiene el programa ejecutándose mientras 'option' sea verdadero
        while (option) {
            // Muestra el menú al usuario y lee la opción seleccionada usando JOptionPane
            String entrada = JOptionPane.showInputDialog(
                    "*************************\n" +
                            "Bienvenidos al conversor de moneda GlobalCash\n" +
                            "Elija una de las siguientes opciones\n\n" +
                            "1 - Dollar a Peso Colombiano\n" +
                            "2 - Peso Colombiano a Dollar\n" +
                            "3 - Dollar a Real Brasilero\n" +
                            "4 - Real Brasilero a Dollar\n" +
                            "5 - Dollar a Peso Argentino\n" +
                            "6 - Peso Argentino a Dollar\n" +
                            "7 - Convertir otra Moneda\n" +
                            "8 - Salir de la Aplicación\n\n" +
                            "*************************\n");

            try {
                // Convertir la entrada a un número entero
                opc = Integer.parseInt(entrada);

                // Evaluar la opción ingresada por el usuario
                switch (opc) {
                    case 1:
                        // Convertir de USD a COP y mostrar el resultado
                        ConvertirMoneda.convertir("USD", "COP", consulta);
                        break;
                    case 2:
                        // Convertir de COP a USD
                        ConvertirMoneda.convertir("COP", "USD", consulta);
                        break;
                    case 3:
                        // Convertir de USD a BRL
                        ConvertirMoneda.convertir("USD", "BRL", consulta);
                        break;
                    case 4:
                        // Convertir de BRL a USD
                        ConvertirMoneda.convertir("BRL", "USD", consulta);
                        break;
                    case 5:
                        // Convertir de USD a ARS
                        ConvertirMoneda.convertir("USD", "ARS", consulta);
                        break;
                    case 6:
                        // Convertir de ARS a USD
                        ConvertirMoneda.convertir("ARS", "USD", consulta);
                        break;
                    case 7:
                        // Convertir entre monedas personalizadas
                        ConvertirMoneda.convertirOtraMoneda(consulta);
                        break;
                    case 8:
                        // Mensajes de salida y finalización del programa
                        JOptionPane.showMessageDialog(null, "Saliendo....");
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestros servicios.");
                        option = false; // Salir del ciclo
                        break;
                    default:
                        // Mensaje para opciones no válidas
                        JOptionPane.showMessageDialog(null,
                                "Ingresa una opción válida de las que se mencionan.\n" +
                                        "*************************\n");
                        break;
                }
            } catch (NumberFormatException e) {
                // Manejo de error si el usuario no ingresa un número válido
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }
        }
    }
}