import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion = 0;

        do {

            System.out.println(" MENU INVENTARIO ");
            System.out.println("1. Registrar producto");
            System.out.println("2. Agregar stock");
            System.out.println("3. Retirar stock");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Mostrar bajo stock");
            System.out.println("6. Calcular valor total");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un numero.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {

                case 1:
                    registrarProducto(scanner, inventario);
                    break;

                case 2:
                    agregarStock(scanner, inventario);
                    break;

                case 3:
                    retirarStock(scanner, inventario);
                    break;

                case 4:
                    inventario.mostrarProductos();
                    break;

                case 5:
                    inventario.mostrarBajoStock();
                    break;

                case 6:
                    double total = inventario.calcularValorTotal();
                    System.out.println("Valor total del inventario: $" + total);
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);

        scanner.close();
    }


    private static void registrarProducto(Scanner scanner, Inventario inventario) {

        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Stock inicial: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        boolean creado = inventario.registrarProducto(codigo, nombre, precio, stock);

        if (creado) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("Error: Datos invalidos o codigo repetido.");
        }
    }

    
    private static void agregarStock(Scanner scanner, Inventario inventario) {

        System.out.print("Codigo del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Cantidad a agregar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        boolean ok = inventario.agregarStock(codigo, cantidad);

        if (ok) {
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Error: Producto no existe o cantidad invalida.");
        }
    }

    
    private static void retirarStock(Scanner scanner, Inventario inventario) {

        System.out.print("Codigo del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Cantidad a retirar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        boolean ok = inventario.retirarStock(codigo, cantidad);

        if (ok) {
            System.out.println("Stock actualizado.");
        } else {
            System.out.println("Error: No se pudo retirar.");
        }
    }
}