import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<Item> ItemList(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    @Test
    void everyBranch_Test() {

        RuntimeException runtimeException;

        //1
        assertTrue(SILab2.checkCart( ItemList(new Item("ItemA", "0013", 320, 0.3f)),200));

        //2
        runtimeException = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 500));
        assertTrue(runtimeException.getMessage().contains("allItems list can't be null!"));


        //3
        runtimeException = assertThrows(RuntimeException.class, () -> SILab2.checkCart(ItemList(new Item("", null, 90, 0)), 500));
        assertTrue(runtimeException.getMessage().contains("No barcode!"));

        //4
         runtimeException = assertThrows(RuntimeException.class, () -> SILab2.checkCart(ItemList(new Item("ItemE", "0AAA", 200, 0)), 80));
            assertTrue(runtimeException.getMessage().contains("Invalid character in item barcode!"));

        //5
      assertFalse(SILab2.checkCart(ItemList(new Item("ItemE", "059", 100, 0)), 70));


    }

    @Test
    void multipleCondition_Test(){
        RuntimeException ex;

        //FXX
        assertFalse(SILab2.checkCart( ItemList(new Item("ItemA", "123", 110, 0.9f)),50));

        //TFX
        assertFalse(SILab2.checkCart( ItemList(new Item("ItemB", "225", 380, 0)),50));

        //TTF
        assertFalse(SILab2.checkCart( ItemList(new Item("ItemC", "777", 400, 0.5f)),50));

        //TTT
        assertFalse(SILab2.checkCart( ItemList(new Item("ItemD", "099", 350, 0.5f)),50));

    }
}
