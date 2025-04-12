/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;


public class NotasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            Double nota1 = null, nota2 = null, nota3 = null;
            boolean salir = false;
            while (!salir) {
                System.out.println("\nMenu de Opciones");
                System.out.println("1. Digitar Nota 1");
                System.out.println("2. Digitar Nota 2");
                System.out.println("3. Digitar Nota 3");
                System.out.println("4. Calcular Nota Final");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1 -> nota1 = pedirNota(scanner, "Nota 1");
                    case 2 -> nota2 = pedirNota(scanner, "Nota 2");
                    case 3 -> nota3 = pedirNota(scanner, "Nota 3");
                    case 4 -> {
                        if (nota1 == null || nota2 == null || nota3 == null) {
                            System.out.println("No se puede calcular la nota final, Faltan las siguientes notas:");
                            if (nota1 == null) {
                                System.out.println("- Nota 1");
                                nota1 = pedirNota(scanner, "Nota 1");
                            }
                            if (nota2 == null) {
                                System.out.println("- Nota 2");
                                nota2 = pedirNota(scanner, "Nota 2");
                            }
                            if (nota3 == null) {
                                System.out.println("- Nota 3");
                                nota3 = pedirNota(scanner, "Nota 3");
                            }
                            double notaFinal = (nota1 + nota2 + nota3) / 3;
                            System.out.println("La Nota Final es: " + notaFinal);
                        } else {
                            double notaFinal = (nota1 + nota2 + nota3) / 3;
                            System.out.println("La Nota Final es: " + notaFinal);
                        }
                    }
                    case 5 -> {
                        salir = true;
                        System.out.println("Saliendo del programa...");
                    }
                    default -> System.out.println("Opción invalida. Intente nuevamente.");
                }
            }
        }
    }

    public static double pedirNota(Scanner scanner, String nombreNota) {
        double nota = -1;
        boolean notaValida = false;

        while (!notaValida) {
            System.out.print("Ingrese " + nombreNota + " (0.0 - 5.0): ");
            String entrada = scanner.nextLine().trim();
            entrada = entrada.replace(',', '.');

            try {
                nota = Double.parseDouble(entrada);
                if (nota >= 0.0 && nota <= 5.0) {
                    notaValida = true;
                } else {
                    System.out.println("Nota invalida. Debe estar entre 0.0 y 5.0 , Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato invalido. Por favor ingrese un número valido.");
            }
        }
        return nota;
    }
}
    
    

