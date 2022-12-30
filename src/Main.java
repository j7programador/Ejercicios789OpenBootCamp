import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

    private static String[] strings = {"Hola", "Mundo", "Java"};
    private static int[][] ints = {{1, 2}, {3, 4}, {5, 6}};

    private static Vector<String> vector = new Vector<String>();
    private static String[] elementos = {"Hola", "Mundo", "Java", "Desde un", "Vector"};
    private static ArrayList<Integer> arrayList = new ArrayList<>();



    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverse("Hola mundo"));

        main.recorrerString(strings);
        main.recorrerEnteros(ints);
        vector.addElement("Hola");
        vector.addElement("Mundo");
        vector.addElement("Java");
        vector.addElement("Desde un");
        vector.addElement("Vector");
        main.mostrarVectorModificado(vector);
        /**
         * El problema de utilizar vectores con capacidad por defecto es que estos
         * pueden ocacionar inconvenientes de rendimiento por redimensionamiento o también
         * se puede hacer un uso ineficiente de la memoria.
         */
        main.agregarArregloLinkedList(strings);
        main.rellenarArregloDeEnteros();

        main.dividePorCero(5, 0);
        try {
            main.copiarFichero();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);

        StringBuilder reverse = stringBuilder.reverse();

        return reverse.toString();

    }

    public void recorrerString(String[] strings) {
        for(String string : strings) {
            System.out.println(string);
        }
    }

    public void recorrerEnteros(int[][] ints) {
        for(int i = 0; i < ints.length; i++) {
            for(int j = 0; j < ints[i].length; j++) {
                System.out.printf("Posicion x: %s, y: %s con el valor: %s%n",i,j,ints[i][j]);
            }
        }
    }

    public void mostrarVectorModificado(Vector<String> vector) {
        vector.remove(1);
        vector.remove(2);
        for(String string: vector) {
            System.out.printf(string + " ");
        }
        System.out.println();
    }

    public void agregarArregloLinkedList(String[] strings) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        for(String string : strings) {
            stringLinkedList.add(string);
        }

        System.out.println("Elementos desde la linkedlist");
        for(String string : stringLinkedList) {
            System.out.println(string);
        }

        System.out.println("Elementos desde el arreglo");
        for(String string : strings) {
            System.out.println(string);
        }
    }

    public void rellenarArregloDeEnteros() {
        for(int i = 1; i <=10; i++) {
            arrayList.add(i);
        }
        for(int j = 0; j < arrayList.size(); j++) {
            if(arrayList.get(j) % 2 == 0) {
                arrayList.remove(j);
            }
        }
        arrayList.forEach(x -> System.out.println(x));
    }

    public void dividePorCero(int i, int j) {
        try {
            double dividido = i / j;
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        }
    }

    public void copiarFichero() throws FileNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("ficheroOrigen.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("ficheroSalida.txt");

            byte[] bytes = new byte[1024];
            int tamanio;

            while((tamanio = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, tamanio);
            }

            fileInputStream.close();
            fileOutputStream.close();
            System.out.println("Copia realizada con exito");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}