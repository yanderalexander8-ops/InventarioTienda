import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    
    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    
    public boolean registrarProducto(String codigo, String nombre, double precio, int stock) {

        if (buscarProducto(codigo) != null) {
            return false; 
        }

        if (precio < 0 || stock < 0) {
            return false;
        }

        Producto nuevo = new Producto(codigo, nombre, precio, stock);
        productos.add(nuevo);

        return true;
    }

    
    public boolean agregarStock(String codigo, int cantidad) {

        Producto p = buscarProducto(codigo);

        if (p == null || cantidad <= 0) {
            return false;
        }

        p.aumentarStock(cantidad);
        return true;
    }

    
    public boolean retirarStock(String codigo, int cantidad) {

        Producto p = buscarProducto(codigo);

        if (p == null) {
            return false;
        }

        return p.disminuirStock(cantidad);
    }

    
    public void mostrarProductos() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto p : productos) {
            System.out.println(
                "Codigo: " + p.getCodigo() +
                " | Nombre: " + p.getNombre() +
                " | Precio: " + p.getPrecio() +
                " | Stock: " + p.getStock()
            );
        }
    }

    
    public void mostrarBajoStock() {

        boolean hay = false;

        for (Producto p : productos) {

            if (p.getStock() < 5) {
                System.out.println(
                    p.getNombre() + " - Stock: " + p.getStock()
                );
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay productos con bajo stock.");
        }
    }

    
    public double calcularValorTotal() {

        double total = 0;

        for (Producto p : productos) {
            total += p.calcularValor();
        }

        return total;
    }
}