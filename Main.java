import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * programa de traducción inglés a español
 */
public class Main {
    private final static String diccionario = "diccionario.txt";
    private final static String texto = "texto.txt";

    /**
     * Se asume para este programa que el diccionario de palabras viene en este formato:
     * 
     * (palabra, traducción)
     * (palabra, traducción)
     * ...
     * 
     * Se asume además que el texto de entrada no tiene símbolos especiales como puntos o comas, 
     * y que solo está separado por espacios.
     * 
     * @param args
     */

    public static void main(String[] args) {
        // diccionario
        BinarySearchTree<Association<String, String>> dictTree = new BinarySearchTree<>();

        // Lee el diccionario
        try (Scanner sc = new Scanner(new File(diccionario))) {
            Scanner scc = null;
            while (sc.hasNextLine()) {
                scc = new Scanner(sc.nextLine());
                scc.useDelimiter(", "); // se separa de en medio
                String key = scc.next(); key = key.substring(1).toLowerCase(); // Se eliminan los parentesis
                String value = scc.next(); value = value.substring(0, value.length() - 1).toLowerCase();
                dictTree.insert(new Association<String,String>(key, value));
                
            }
            scc.close();
        } catch (Exception e) {
            System.err.println("* Error al leer archivo diccionario");
            return;
        }

        // Imprime listado inOrder
        List<Association<String, String>> alfabeticList = dictTree.inOrderTraversal();
        System.out.println("Listado ordenado en inglés:");
        for (Association<String, String> association : alfabeticList) {
            System.out.println(association.getKey() + ", " + association.getValue());
        }

        //traduce la oración
        try (Scanner rd = new Scanner(new File(texto))) {
            String sentence = "";
            while (rd.hasNext())  {
                String word = rd.next().toLowerCase();
                if (dictTree.get(new Association<String,String>(word, null)) != null) {
                    sentence += dictTree.get(new Association<String,String>(word, null)).getValue() + " ";
                } else {
                    sentence += "*" + word + "* ";
                }
            }

            System.out.println("Oración final:\n" + sentence);
            
        } catch (Exception e) {
            System.err.println("* Error al leer archivo de texto");
        }
 
    }
}