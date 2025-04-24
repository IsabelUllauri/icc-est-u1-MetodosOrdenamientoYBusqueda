package Controllers;

import Models.Person;

public class SearchingMethods {

    // búsqueda binaria por edad
    public Person binarySearchByAge(Person[] personas, int edadBuscada) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            int edadCentro = personas[medio].getAge();

            if (edadCentro == edadBuscada) {
                return personas[medio];
            } else if (edadCentro < edadBuscada) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return null;
    }

    // búsqueda binaria por nombre
    public Person binarySearchByName(Person[] personas, String nombreBuscado) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            String nombreCentro = personas[medio].getName();
            int comparacion = nombreCentro.compareToIgnoreCase(nombreBuscado);

            if (comparacion == 0) {
                return personas[medio];
            } else if (comparacion < 0) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }
        return null;
    }

    // verifica si el arreglo está ordenado por edad (ascendente)
    public boolean isSortedByAge(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getAge() > personas[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }

    // verifica si el arreglo está ordenado por nombre (ascendente a-z)
    public boolean isSortedByName(Person[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            if (personas[i].getName().compareToIgnoreCase(personas[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }
}
