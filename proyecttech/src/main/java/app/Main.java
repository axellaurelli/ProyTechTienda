package app;

import gestor.GestorTienda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTienda gestor = new GestorTienda();
        int opcion;

        System.out.println("Tienda Ecommerce");

        do {
            System.out.println("""
                1. Agregar producto
                2. Listar productos
                3. Buscar/Actualizar producto
                4. Eliminar producto
                5. Crear un pedido
                6. Salir
                """);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> gestor.agregarProducto();
                case 2 -> gestor.listarProductos();
                case 3 -> gestor.actualizarProducto();
                case 4 -> gestor.eliminarProducto();
                case 5 -> gestor.crearPedido();
                case 6 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }
}
