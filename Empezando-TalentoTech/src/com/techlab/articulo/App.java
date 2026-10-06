package com.techlab.articulo;

import com.techlab.articulo.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList articulos = new ArrayList<>();
    private static ArrayList categorias = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarDatos();

        int opcion;
        do {
            System.out.println("\n--- CRUD DE ARTÍCULOS ---");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar artículo por código");
            System.out.println("4 - Modificar artículo");
            System.out.println("5 - Eliminar artículo");
            System.out.println("0 - Salir");
            System.out.print("Elija una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> ingresarArticulo();
                case 2 -> listarArticulos();
                case 3 -> consultarArticulo();
                case 4 -> modificarArticulo();
                case 5 -> eliminarArticulo();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void precargarDatos() {
        categorias.add(new Categoria(1, "Electrónica", "Dispositivos tecnológicos"));
        categorias.add(new Categoria(2, "Alimentos", "Comestibles y bebidas"));

        articulos.add(new ArticuloElectronico(101, "Teclado Mecánico", 45000.0, categorias.get(0), 12));
        articulos.add(new ArticuloAlimenticio(102, "Leche Entera", 1200.0, categorias.get(1), 5));
    }

    private static void ingresarArticulo() {
        System.out.print("Ingrese código del artículo: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        if (buscarArticuloPorCodigo(codigo) != null) {
            System.out.println("Error: Ya existe un artículo con ese código.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.println("Categorías disponibles:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + " - " + categorias.get(i).getNombre());
        }
        System.out.print("Seleccione categoría: ");
        int catIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Categoria categoria = categorias.get(catIndex);

        System.out.println("Tipo de artículo:");
        System.out.println("1 - Electrónico");
        System.out.println("2 - Alimenticio");
        System.out.print("Opción: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        Articulo nuevoArticulo;
        if (tipo == 1) {
            System.out.print("Ingrese meses de garantía: ");
            int garantia = Integer.parseInt(scanner.nextLine());
            nuevoArticulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantia);
        } else {
            System.out.print("Ingrese días para vencimiento: ");
            int dias = Integer.parseInt(scanner.nextLine());
            nuevoArticulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, dias);
        }

        articulos.add(nuevoArticulo);
        System.out.println("Artículo registrado con éxito.");
    }

    private static void listarArticulos() {
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }
        System.out.println("\n--- Lista de Artículos ---");
        for (Articulo a : articulos) {
            System.out.println(a);
        }
    }

    private static void consultarArticulo() {
        System.out.print("Ingrese código a buscar: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Articulo encontrado = buscarArticuloPorCodigo(codigo);

        if (encontrado != null) {
            System.out.println("Resultado: " + encontrado);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private static void modificarArticulo() {
        System.out.print("Ingrese código del artículo a modificar: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Articulo art = buscarArticuloPorCodigo(codigo);

        if (art == null) {
            System.out.println("Artículo no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (actual: " + art.getNombre() + "): ");
        art.setNombre(scanner.nextLine());

        System.out.print("Nuevo precio (actual: " + art.getPrecio() + "): ");
        art.setPrecio(Double.parseDouble(scanner.nextLine()));

        if (art instanceof ArticuloElectronico) {
            ArticuloElectronico electronico = (ArticuloElectronico) art;
            System.out.print("Nueva garantía en meses (actual: " + electronico.getGarantiaMeses() + "): ");
            electronico.setGarantiaMeses(Integer.parseInt(scanner.nextLine()));
        } else if (art instanceof ArticuloAlimenticio) {
            ArticuloAlimenticio alimenticio = (ArticuloAlimenticio) art;
            System.out.print("Nuevos días para vencimiento (actual: " + alimenticio.getDiasParaVencimiento() + "): ");
            alimenticio.setDiasParaVencimiento(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println("Artículo actualizado con éxito.");
    }

    private static void eliminarArticulo() {
        System.out.print("Ingrese código del artículo a eliminar: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Articulo art = buscarArticuloPorCodigo(codigo);

        if (art != null) {
            articulos.remove(art);
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("No se encontró el artículo.");
        }
    }

    private static Articulo buscarArticuloPorCodigo(int codigo) {
        for (Articulo a : articulos) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }
}