package Controllers;

import Models.Person;

public class SortingMethods {

    // ordena por nombre con burbuja de forma ascendente a-z
    public void ordenarPorNombreBurbuja(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - i - 1; j++) {
                String nombreActual = personas[j].getName();
                String nombreSiguiente = personas[j + 1].getName();

                // si el nombre actual es mayor al siguiente, se intercambian
                if (nombreActual.compareTo(nombreSiguiente) > 0) {
                    Person temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    // ordena por nombre usando selección descendente z-a
    public void ordenarPorNombreSeleccionDescendente(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            int indiceMayor = i;
            for (int j = i + 1; j < personas.length; j++) {
                // busca el nombre mayor (más cercano a z)
                if (personas[j].getName().compareTo(personas[indiceMayor].getName()) > 0) {
                    indiceMayor = j;
                }
            }

            // si se encontro un nombre mayor se intercambia
            if (indiceMayor != i) {
                Person temp = personas[i];
                personas[i] = personas[indiceMayor];
                personas[indiceMayor] = temp;
            }
        }
    }

    // ordena por edad con inserción de menor a mayor
    public void ordenarPorEdadInsercion(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Person actual = personas[i];
            int j = i - 1;

            // mueve hacia la derecha los mayores que actual
            while (j >= 0 && personas[j].getAge() > actual.getAge()) {
                personas[j + 1] = personas[j];
                j--;
            }

            // coloca el elemento actual en su lugar
            personas[j + 1] = actual;
        }
    }

    // ordena por nombre con insercin ascendente (a-z)
    public void ordenarPorNombreInsercion(Person[] personas) {
        for (int i = 1; i < personas.length; i++) {
            Person actual = personas[i];
            int j = i - 1;

            // mueve a la derecha los nombres mayores que actual
            while (j >= 0 && personas[j].getName().compareTo(actual.getName()) > 0) {
                personas[j + 1] = personas[j];
                j--;
            }

            // coloca el nombre actual en su posición correcta
            personas[j + 1] = actual;
        }
    }
}


