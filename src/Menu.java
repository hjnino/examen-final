import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Inventario inventario = new Inventario();


    public static void menuPrincipal() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                   GESTIONAR INVENTARIO DE PRODUCTOS                                        -");
        System.out.println("-                                           HEIDY NIÑO AVILA                                                 -");
        System.out.println("-                                                 HNINO                                                      -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                            1.	Agregar producto                                                             -");
        System.out.println("-                            2.	Actualizar producto                                                          -");
        System.out.println("-                            3.	Eliminar producto                                                            -");
        System.out.println("-                            4.	Buscar producto                                                        -");
        System.out.println("-                            5.	Generar reporte                                                              -");
        System.out.println("-                            6.	Cantidad de productos por categoría                                          -");
        System.out.println("-                            7.	Producto más caro                                                            -");
        System.out.println("-                                                                                                            -");
        System.out.println("-                         8.	Salir                                                                        -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("Digite su opción: ");
    }

    public static Producto subMenuAgreProducto(Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                             AGREGAR PRODUCTO                                               -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                                                                                            -");
        System.out.print("-      Digite ID Producto:          ");
        int IdProducto = Funciones.validacionInteger();
        System.out.print("-      Digite Nombre del producto:  ");
        String nombreProducto = scanner.nextLine();
        System.out.print("-      Digite Categoria:            ");
        String categoria = scanner.nextLine();
        System.out.print("-      Digite Valor:                ");
        double valor = Funciones.validaciondoouble();
        System.out.print("-      Digite Cantidad Disponible:  ");
        int cantidadDisponible = Funciones.validacionInteger();

        Producto miNuevoProd = new Producto(IdProducto, nombreProducto, categoria, valor, cantidadDisponible);
        return miNuevoProd;

    }

    public static Producto subMenuActualizarProd(Scanner scanner) {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                             ACTUALIZAR PRODUCTO                                            -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                                                                                            -");
        System.out.print("-      Digite ID Producto para actualizar:  ");


        int idActualuzar = Funciones.validacionInteger();
        //System.out.println(Inventario.getProductosIds());

        if (!Inventario.getProductosIds().contains(idActualuzar)) {
            System.out.println("-     Producto con ID " + idActualuzar + " no encontrado.");
            return null;
        }

        System.out.print("-      Digite nuevo Nombre del producto:    ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("-      Digite nueva Categoria:              ");
        String nuevaCategoria = scanner.nextLine();
        System.out.print("-      Digite nuevo Valor:                  ");
        double nuevoValor = Funciones.validaciondoouble();
        System.out.print("-      Digite nueva Cantidad Disponible:    ");
        int nuevacantidad = Funciones.validacionInteger();

        Producto miNuevoProdActualizado = new Producto(idActualuzar, nuevoNombre, nuevaCategoria, nuevoValor, nuevacantidad);

        return miNuevoProdActualizado;
    }

    public static void subMenuBuscar() {

        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                               BUSCAR PRODUCTO                                              -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                            1.	Categoria.                                                                   -");
        System.out.println("-                            2.	Nombre de producto.                                                          -");
        System.out.println("-                            3.	ID producto.                                                                 -");
        System.out.println("-                                                                                                            -");
        System.out.println("-                         8.	Salir                         4.	Volver al Menu principal                 -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }

    public static void subMenuEliminar() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                             ELIMINAR PRODUCTOS                                             -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("-      Ingrese el ID del producto:");

    }

    public static void subMenuBuscarCategoria() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                                  CATEGORIA                                                 -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("-      Ingrese el nombre de la categoria:");

    }

    public static void subMenuIdProducto() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                             ID DEL PRODUCTO                                                -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("-      Ingrese el ID del producto:");

    }

    public static void subMenuBuscarNombre() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                         NOMBRE DEL PRODUCTO                                                -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.print("-      Ingrese el nombre del producto:");

    }

    public static void subMenuGenerarReporte() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                           GENERAR REPORTE                                                  -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-      Genera un archivo .txt del inventario de productos en la ruta D:\\ reporte_inventario.txt,            -");
        System.out.println("-                            incluyendo el valor total del inventario                                        -");

    }

    public static void subMenuCantidadDeProductos() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                   CANTIDAD DE PRODUCTOS POR CATEGORIA                                      -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");

    }

    public static void subMenuProducMasCaro() {
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        System.out.println("-                                             PRODUCTO MAS CARO                                              -");
        System.out.println("--------------------------------------------------------------------------------------------------------------");


    }

}

