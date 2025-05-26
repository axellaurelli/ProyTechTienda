package gestor;

import Servicios.Producto;
import Servicios.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorTienda {
    private List<Producto> inventario = new ArrayList<>();
    private int contadorId = 1;
    private Scanner scanner = new Scanner(System.in);

    public void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.next();
        System.out.print("Precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(contadorId++, nombre, precio);
        inventario.add(producto);
        System.out.println("Producto agregado correctamente.");
    }

    public void listarProductos() {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        }
    }

    public Producto buscarProducto(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public void actualizarProducto() {
        System.out.print("ID del producto a actualizar: ");
        int id = scanner.nextInt();
        Producto producto = buscarProducto(id);

        if (producto != null) {
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.next();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();

            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);

            System.out.println("Producto actualizado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = scanner.nextInt();
        Producto producto = buscarProducto(id);

        if (producto != null) {
            inventario.remove(producto);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void crearPedido() {
        Pedido pedido = new Pedido();
        char continuar;

        if (inventario.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        do {
            listarProductos();
            System.out.print("Ingrese el ID del producto que desea agregar: ");
            int id = scanner.nextInt();

            Producto producto = buscarProducto(id);
            if (producto != null) {
                pedido.agregarProducto(producto);
                System.out.println("Producto agregado al pedido.");
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Agregar otro producto? (s/n): ");
            continuar = scanner.next().charAt(0);
        } while (continuar == 's' || continuar == 'S');

        if (pedido.getProductos().isEmpty()) {
            System.out.println("No se agregaron productos al pedido.");
        } else {
            System.out.println("Total del pedido: $" + pedido.calcularTotal());
        }
    }
}
