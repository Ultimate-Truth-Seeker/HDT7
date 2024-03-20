import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class tests {
    @Test
    public void testInsert() {
        BinarySearchTree<Association<String, String>> dict = new BinarySearchTree<>();
        Association<String, String> hello = new Association<String,String>("hello", "hola");
        Association<String, String> goodbye = new Association<String,String>("goodbye", "adios");
        dict.insert(hello);
        dict.insert(goodbye);
        List<Association<String, String>>  list = dict.inOrderTraversal();
        assertTrue(list.indexOf(hello) > list.indexOf(goodbye));
        
    }

    @Test 
    public void testGet() {
        BinarySearchTree<Association<String, String>> dict = new BinarySearchTree<>();
        Association<String, String> hello = new Association<String,String>("hello", "hola");
        Association<String, String> goodbye = new Association<String,String>("goodbye", "adios");
        dict.insert(hello);
        dict.insert(goodbye);
        assertEquals("hola", dict.get(hello).getValue());
        assertEquals("adios", dict.get(goodbye).getValue());
    }
}
