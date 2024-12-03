import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String entersubMenu = "Ingrese Enter para volver al menu anterior...";
    public static String enterMenu = "Presione enter para continuar...";

    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        Scanner menuscanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);


        int menu;
        int submenu;

        do{
            Menu.menuPrincipal();
            while (!menuscanner.hasNextInt()) {
                Funciones.funcionOpcionNoValida();
                menuscanner.next();
            }
            menu = menuscanner.nextByte();

            switch (menu) {
                case 1:
                    Producto productoAgregar = Menu.subMenuAgreProducto(scanner);
                    inventario.agregarProductoArchivo(productoAgregar);
                    Funciones.funcionScannerEnter(menuscanner, entersubMenu);

                    break;
                case 2:
                    Producto productoActualizar = Menu.subMenuActualizarProd(scanner);
                    if (productoActualizar != null) {
                        inventario.actualizarProductos(productoActualizar);
                        Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                    }

                    break;

                case 3:
                    Menu.subMenuEliminar();
                    inventario.eliminarProductoPorId();
                    Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                    break;

                case 4:
                    boolean volverAlMenuPrincipal = false;

                    while (!volverAlMenuPrincipal) {
                        Menu.subMenuBuscar();
                        Funciones.funcionDigiteSuOpcion();

                        while (!menuscanner.hasNextInt()) {
                            Funciones.funcionOpcionNoValida();
                            menuscanner.next();
                        }


                        submenu = menuscanner.nextInt();

                        switch (submenu) {

                        case 1:
                            Menu.subMenuBuscarCategoria();
                            inventario.buscarProductoPorCategoria();
                            Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                            break;

                        case 2:
                            Menu.subMenuBuscarNombre();
                            inventario.buscarProductoPorNombre();
                            Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                            break;

                        case 3:
                            Menu.subMenuIdProducto();
                            inventario.buscarProductoPorID();
                            Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                            break;

                        case 4:
                            Funciones.volviendoAlMenuPrincipal();
                            volverAlMenuPrincipal = true;
                            break;

                        case 8:
                            Funciones.funcionSalir();
                            break;

                        default:
                            Funciones.numeroNoValido();
                            break;

                        }
                    }

                    break;

                case 5:
                    Menu.subMenuGenerarReporte();
                    inventario.generarReporte();
                    Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                    break;

                case 6:
                    Menu.subMenuCantidadDeProductos();
                    Map<String, Integer> cantidadCategoria = inventario.cantidadPorCategoria();
                    for (String categoriaReporte : cantidadCategoria.keySet()) {
                        System.out.println("-         Categoria: " + categoriaReporte + " -   Cantidad total: " + cantidadCategoria.get(categoriaReporte));
                    }

                    Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                    break;

                case 7:
                    Menu.subMenuProducMasCaro();
                    Producto masCaro = inventario.productoMasCaro();
                    if (masCaro != null) {
                        System.out.println("- El producto más caro es: \n"  + masCaro);
                    } else {
                        System.out.println("- No hay productos en el inventario.");
                    }
                    Funciones.funcionScannerEnter(menuscanner, entersubMenu);
                    break;

                case 8:
                    Funciones.funcionSalir();
                    break;

                default:
                    Funciones.numeroNoValido();
                    break;
            }
            Funciones.funcionScannerEnter(menuscanner,enterMenu);
        }while (menu !=8);
        menuscanner.close();
    }
}