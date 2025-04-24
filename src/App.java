import Controllers.Controller;
import Views.View;
import Controllers.SearchingMethods;
import Controllers.SortingMethods;


public class App {

    public static void main(String[] args) {
        // se crean los objetos 
        View vista = new View();
        SortingMethods metodosOrdenamiento = new SortingMethods();
        // aunque no haya arreglo, se asigna luego en el controlador
        SearchingMethods metodosBusqueda = new SearchingMethods(); 

        // se crea el controlador pasandole las clases 
        Controller controlador = new Controller(vista, metodosOrdenamiento, metodosBusqueda);

        // se ejecuta el programa
        controlador.start();
    }
}

