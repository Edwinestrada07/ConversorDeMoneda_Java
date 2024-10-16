import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int option = 0;

        while(option != 8) {
            System.out.println("*************************\n" +
                    "Bienvenidos al conversor de moneda GlobalCash\n" +
                    "Elija una de las siguientes opciones\n\n" +
                    "1 - Dollar a Peso Colombiano\n" +
                    "2 - Peso Colombiano a Dollar\n" +
                    "3 - Dollar a Real Brasilero\n" +
                    "4 - Real Brasilero a Dollar\n" +
                    "5 - Dollar a Peso Argentino\n" +
                    "6 - Peso Argentino a Dollar\n" +
                    "7 - Convetir otra Moneda\n" +
                    "8 - Salir de la Aplicación\n\n" +
                    "*************************\n");
            option = teclado.nextInt();
                     teclado.nextLine();

            switch (option) {
                case 1:
                    ConvertirMoneda.convertir("USD", "COP", consulta, teclado);
                    break;
                case 2:
                    ConvertirMoneda.convertir("COP", "USD", consulta, teclado);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, teclado);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, teclado);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, teclado);
                    break;
                case 6:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, teclado);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta, teclado);
                    break;
                case 8:
                    System.out.println("Saliendo.......");
                    System.out.println("Gracias por utilizar nuestros servicios.");
                    break;

                default:
                    System.out.println("Ingresa una opción de las que se mencionan a continuación\n" +
                            "*************************\n");
                    break;
            }
        }
    }
}
