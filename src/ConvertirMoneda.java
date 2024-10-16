import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner teclado) {
        double cantidad;
        double cantidadConvertida;

        Moneda moneda = consulta.buscarMoneda(monedaBase, monedaTarget);
        System.out.println("La tasa de conversión para hoy es:\n1 " + monedaBase + " = " + moneda.getConversionRate() + " " + monedaTarget);
        System.out.println("Ingrese la cantidad a convertir desde " + monedaBase + ":");

        try {
            cantidad = Double.parseDouble(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor ingrese un número válido.");
            return;
        }

        cantidadConvertida = cantidad * moneda.getConversionRate();
        System.out.println(cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + moneda.getTargetCode());
    }

    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner teclado) {
        System.out.println("Ingrese el código de la moneda que quiere convertir (ejem. COP para Peso Colombiano, USD para Dólar, etc.):");
        String monedaBase = teclado.nextLine().toUpperCase();

        System.out.println("Ingrese la moneda objetivo:");
        String monedaObjetivo = teclado.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, teclado);
    }
}

