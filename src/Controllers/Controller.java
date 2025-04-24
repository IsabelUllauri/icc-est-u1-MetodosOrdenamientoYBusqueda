package Controllers;
import Models.Person;
import Views.View;
import Controllers.SearchingMethods;
import Controllers.SortingMethods;

public class Controller {

    private View view;
    private Person[] personas;
    private SortingMethods metodosOrdenamiento;
    private SearchingMethods metodosBusqueda;

    // constructor que recibe las clases view, ordenamiento y búsqueda
    public Controller(View view, SortingMethods metodosOrdenamiento, SearchingMethods metodosBusqueda) {
        this.view = view;
        this.metodosOrdenamiento = metodosOrdenamiento;
        this.metodosBusqueda = metodosBusqueda;
    }

    // método principal que llama a todo
    public void start() {
        inputPersons();       // ingreso de personas
        sortPersons();        // ordenamiento
        searchPerson();       // búsqueda
    }

    // ingresar las personas desde consola
    public void inputPersons() {
        int cantidad = view.inputCantidadPersonas();
        personas = new Person[cantidad];

        for (int i = 0; i < cantidad; i++) {
            personas[i] = view.inputPerson(); // pide nombre y edad
        }
    }

    // método adicional si se quisiera agregar más personas luego (opcional)
    public void addPersons() {
        // se puede implementar si es necesario añadir personas después
    }

    // ordena las personas según la opción que el usuario elija
    public void sortPersons() {
        int opcion = view.selectSortingMethod();

        switch (opcion) {
            case 1:
                metodosOrdenamiento.ordenarPorNombreBurbuja(personas);
                break;
            case 2:
                metodosOrdenamiento.ordenarPorNombreSeleccionDescendente(personas);
                break;
            case 3:
                metodosOrdenamiento.ordenarPorEdadInsercion(personas);
                break;
            case 4:
                metodosOrdenamiento.ordenarPorNombreInsercion(personas);
                break;
            default:
                view.showMessage("Opción inválida.");
                return;
        }

        view.displayPersons(personas); // muestra el resultado ordenado
    }

    // realiza la búsqueda según criterio del usuario
    public void searchPerson() {
        int opcion = view.selectSearchCriterion();

        if (opcion == 1) { // búsqueda por edad
            int edad = view.inputAge();
            if (metodosBusqueda.isSortedByAge(personas)) {
                Person p = metodosBusqueda.binarySearchByAge(personas, edad);
                view.displaySearchResult(p);
            } else {
                view.showMessage("El arreglo no está ordenado por edad.");
            }
        } else if (opcion == 2) { // búsqueda por nombre
            String nombre = view.inputName();
            if (metodosBusqueda.isSortedByName(personas)) {
                Person p = metodosBusqueda.binarySearchByName(personas, nombre);
                view.displaySearchResult(p);
            } else {
                view.showMessage("El arreglo no está ordenado por nombre.");
            }
        } else {
            view.showMessage("Criterio inválido.");
        }
    }
}