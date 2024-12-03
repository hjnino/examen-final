import java.io.*;
import java.util.*;

public class Inventario {

    private ArrayList<Producto> listaProductos;
    private static final String nombreArchivo = "productosA.txt";
    Scanner scanner = new Scanner(System.in);


    public Inventario() {
        listaProductos = new ArrayList<>();
    }

    public void cargueArchivotexto() {

        String ruta = "D://";

        try (FileReader fr = new FileReader(ruta + nombreArchivo)) {
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String primeraLinea = br.readLine(); // Excluimos la primera línea

            while ((linea = br.readLine()) != null) {

                String[] list = linea.split(";");

                int idProducto = Integer.parseInt(list[0]);
                String nomProducto = list[1];
                String categoria = list[2];
                double precio = Double.parseDouble(list[3]);
                int cantDisponible = Integer.parseInt(list[4]);

                Producto producto = new Producto(idProducto, nomProducto, categoria, precio, cantDisponible);

                listaProductos.add(producto);
            }

        } catch (IOException e) {
            System.out.println("El archivo no se encuentra o no se puede crear.");
            e.printStackTrace();
        }
    }

    public static ArrayList getProductosIds() {
        ArrayList<Integer> idsProd = new ArrayList<>();
        int idProducto = 0;
        String ruta = "D://";

        try (FileReader fr = new FileReader(ruta + nombreArchivo)) {
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String primeraLinea = br.readLine(); // Excluimos la primera línea

            while ((linea = br.readLine()) != null) {
                String[] list = linea.split(";");
                idProducto = Integer.parseInt(list[0]);
                idsProd.add(idProducto);
            }
            return  idsProd;
        } catch (IOException e) {
            e.printStackTrace();
            return  new ArrayList<>();
        }
    }

    public void agregarProductoArchivo(Producto nuevProdcuto) {
        String ruta = "D://";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + nombreArchivo, true))) {
            bw.write("\n");
            bw.write(nuevProdcuto.getIdProducto() + ";" + nuevProdcuto.getNomProducto() + ";" + nuevProdcuto.getCategoria().toLowerCase() + ";" + nuevProdcuto.getPrecio() + ";" + nuevProdcuto.getCantDisponible());
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public boolean actualizarProductos (Producto pActualizado){

        cargueArchivotexto();

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);

            if (p.getIdProducto() == (pActualizado.getIdProducto())) {
                listaProductos.set(i, pActualizado);
            } else {
                    System.out.println("Producto no encontrado.");
                }

            agregarProductosActulizadoAArchivo();
            return true;

            }

        System.out.println(listaProductos);
        return false;

    }
    public boolean agregarProductosActulizadoAArchivo () {

        String ruta = "D://";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            bw.write("IdProducto;NombreProducto;Categoría;Precio;CantidadDisponible");
            for (Producto producto : listaProductos){
                bw.write("\n");
                bw.write(producto.getIdProducto() + ";" + producto.getNomProducto() + ";" + producto.getCategoria().toLowerCase() + ";" + producto.getPrecio() + ";" + producto.getCantDisponible());
            }

            System.out.println("Datos guardados en " + nombreArchivo);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProductoPorId(){
        String inputId = scanner.nextLine();
        Integer id = null;

        try{
            id = Integer.parseInt((inputId));
        }catch (NumberFormatException e){
            System.out.println("El ID ingresado no es valido. Debe ser un número entero.");
            return false;
        }

        listaProductos = new ArrayList<>();

        cargueArchivotexto();

        for (Producto producto:listaProductos){
            if(producto.getIdProducto() == id) {
                listaProductos.remove(producto);
                System.out.println("Producto eliminado.");
                agregarProductosActulizadoAArchivo();
                return true;
            }
        }
        System.out.println("Producto no encontrado");
        return false;

    }


    public void buscarProductoPorNombre() {
        String nombre = scanner.nextLine();

        cargueArchivotexto();

        System.out.println("Buscandooooooooo................");
        for (Producto producto : listaProductos) {
            if (producto.getNomProducto().equalsIgnoreCase(nombre)) {
                System.out.println(producto);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void buscarProductoPorCategoria(){
        String categoria = scanner.nextLine().trim();// trim() para eliminar espacios innecesarios

        listaProductos = new ArrayList<>();

        cargueArchivotexto();

        boolean encontrado = false;
        System.out.println("Buscando productos en la categoria...");

        for (Producto producto : listaProductos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(producto);
                encontrado = true;
                }
            }
        if (!encontrado){
            System.out.println("No se encontraron productos en la categoría: "+ categoria);
        }

    }

    public void buscarProductoPorID(){
        String inputId = scanner.nextLine();
        Integer id = null;

        try{
            id = Integer.parseInt((inputId));
        }catch (NumberFormatException e){
            System.out.println("El ID ingresado no es valido. Debe ser un número entero.");
            return;
        }

        cargueArchivotexto();

        System.out.println("Buscandooooooooo................");
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == id) {
                System.out.println(producto);
                return;
            }
        }
        System.out.println("Producto no encontrado con el ID: " + id);

    }

    public Producto productoMasCaro(){

        cargueArchivotexto();

        if(listaProductos.isEmpty()) return null;
        Producto mayor = listaProductos.get(0);

        for(Producto p: listaProductos) {
            if (p.getPrecio() > mayor.getPrecio()){
                mayor = p;
            }
        }
        return mayor;
    }

    public Map<String, Integer> cantidadPorCategoria() {

        listaProductos = new ArrayList<>();
        cargueArchivotexto();

        Map<String, Integer> categoriaCount = new HashMap<>();// Crear un mapa para contar las categorías
        for (Producto p : listaProductos) {

            //String categoria = p.getCategoria().toLowerCase();// Convertir la categoría a minúsculas (puedes usar toUpperCase() si prefieres)

            categoriaCount.put(p.getCategoria(),// Agregar o actualizar el conteo de la categoría
                    categoriaCount.getOrDefault(p.getCategoria(), 0) + p.getCantDisponible());
        }
        return categoriaCount;

    }

    public void generarReporte() {

        String ruta = "D://";
        double valorTotal = 0;

        listaProductos = new ArrayList<>();
        cargueArchivotexto();


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta + "reporte_inventario.txt"))) {
            bw.write("Nombre del Producto|Categoría|Precio|Unidades Disponible|Total por producto|\n");

            for (Producto p : listaProductos) {
                bw.write((p.getNomProducto() + "|" + p.getCategoria() + "|" + p.getCantDisponible()+ "|" + "$"+p.getPrecio()+"|"+"$"+p.getPrecio()*p.getCantDisponible()+"\n"));
                valorTotal += p.getPrecio() * p.getCantDisponible();
            }
            bw.write("\n");
            bw.write("Valor Total del Inventario: "+ "$"+ valorTotal + "\n");

            //System.out.println("Reporte generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al generar el reporte.");
            e.printStackTrace();
        }

    }

}

