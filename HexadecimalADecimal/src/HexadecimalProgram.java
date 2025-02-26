import java.util.Scanner;


public class HexadecimalProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n---------MENÜ--------:");
            System.out.println("1. Convertir de Hexadecimal a Decimal");
            System.out.println("2. Convertir de Decimal a Hexadecimal");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            while (!scan.hasNextInt()) {
                System.out.println("\nEl número no es válido. Ingrese un número válido (1-3).\n");
                scan.next();
            }
            opcion = scan.nextInt();
            scan.nextLine(); 

            switch (opcion) {
                case 1:
                    covertToDecimal(scan);
                    break;
                case 2:
                    convertToHexadecimal(scan);
                    break;
                case 3:
                    System.out.println("---");
                    break;
                default:
                    System.out.println("\nLa opción ingresada no es válida.");
            }
        } while (opcion != 3);
    }

    private static void covertToDecimal(Scanner scan) {
        String numHexadecimal;
        int decimal;
        boolean numValido;

        do {
            System.out.print("\nIngrese un número hexadecimal de 3 dígitos: ");
            numHexadecimal = scan.nextLine().toUpperCase();
            
            numValido = numHexadecimal.matches("[0-9A-F]{1,3}");
            
            if (!numValido) {
                System.out.println("\nEl número no es válido. Ingrese un número hexadecimal (Ejemplo: 2FA).\n");
            }
        } while (!numValido);
        
        decimal = Integer.parseInt(numHexadecimal, 16);
        System.out.println("\n  - El número en decimal es: " + decimal);
    }

    private static void convertToHexadecimal(Scanner scan) {
        int decimal;
        String numHexadecimal;
        
        do {
            System.out.print("\nIngrese un número decimal (entre 0-4095): ");
            while (!scan.hasNextInt()) {
                System.out.println("\nEl número no es válido. Ingrese un número entre 0 y 4095.");
                scan.next();
            }
            decimal = scan.nextInt();
            scan.nextLine();
            
            if (decimal < 0 || decimal > 4095) {
                System.out.println("\nEl número debe estar entre 0 y 4095.\n");
            }
        } while (decimal < 0 || decimal > 4095);
        
        numHexadecimal = Integer.toHexString(decimal).toUpperCase();
        System.out.println("\n  - El número en hexadecimal es: " + numHexadecimal);
    }
}



