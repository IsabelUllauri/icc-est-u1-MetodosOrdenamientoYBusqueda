package Views;
import java.util.Scanner;
import Models.Person;

public class View {

    private Scanner scanner = new Scanner(System.in);

    // muestra el menú principal y devuelve la opción
    public int showMenu() {
        System.out.println("\n--- menu principal ---");
        System.out.println("1. ingresar personas");
        System.out.println("2. ordenar personas");
        System.out.println("3. buscar persona");
        System.out.println("4. salir");
        System.out.print("elige una opción: ");
        return getInt();
    }

    // pide al usuario ingresar una persona (nombre y edad)
    public Person inputPerson() {
        System.out.println("\n--- ingresar nueva persona ---");
        String nombre = inputName();
        int edad = inputAge();
        return new Person(nombre, edad);
    }

    // selecciona el método de ordenamiento
    public int selectSortingMethod() {
        System.out.println("\n--- método de ordenamiento ---");
        System.out.println("1. burbuja por nombre (a-z)");
        System.out.println("2. seleccion por nombre (z-a)");
        System.out.println("3. insercion por edad");
        System.out.println("4. insercion por nombre (a-z)");
        System.out.print("elige una opción: ");
        return getInt();
    }

    // selecciona si busca por edad o por nombre
    public int selectSearchCriterion() {
        System.out.println("\n--- criterio de búsqueda ---");
        System.out.println("1. buscar por edad");
        System.out.println("2. buscar por nombre");
        System.out.print("elige una opción: ");
        return getInt();
    }

    // muestra la lista de personas
    public void displayPersons(Person[] personas) {
        System.out.println("\n--- lista de personas ---");
        for (Person p : personas) {
            System.out.println(p);
        }
    }

    // muestra el resultado de una búsqueda
    public void displaySearchResult(Person persona) {
        if (persona != null) {
            System.out.println("\npersona encontrada:");
            System.out.println(persona);
        } else {
            System.out.println("\npersona no encontrada.");
        }
    }

    // pide la edad al usuario
    public int inputAge() {
        System.out.print("ingresa la edad: ");
        return getInt();
    }

    // pide el nombre al usuario
    public String inputName() {
        System.out.print("ingresa el nombre: ");
        return scanner.next();
    }

    // método adicional que podrías usar en el controlador
    public int inputCantidadPersonas() {
        System.out.print("¿cuantas personas desea ingresar?: ");
        return getInt();
    }

    // método auxiliar para validar enteros
    private int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("entrada invalida. intenta de nuevo: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // muestra un mensaje genérico
    public void showMessage (String mensaje) {
        System.out.println(mensaje);
    }
}

