import java.util.ArrayList;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Activity1 {
	
	static ArrayList<String> list;
	
	@BeforeEach
	 void setUp() throws Exception{
	// Initialize a new ArrayList
    list = new ArrayList<String>();
    // Add values to the list
	list.add("alpha"); // at index 0
	list.add("beta"); // at index 1
	}
	
	@Test
	public void insertTest() {
	// Assert size of list
	assertEquals(2, list.size(), "Wrong size");
	list.add(2,"gamma");
	assertEquals(3, list.size(), "Wrong size");
	
	// Assert individual elements
	assertEquals("alpha", list.get(0), "Wrong element");
	assertEquals("beta", list.get(1), "Wrong element");
	assertEquals("gamma", list.get(2), "Wrong element");
	}
	
	@Test
	public void replaceTest() {
		//Replace
		list.set(1, "delta");
		//asser size
		assertEquals(2, list.size(), "Wrong size");
		//assert elements
		assertEquals("alpha", list.get(0), "Wrong element");
		assertEquals("delta", list.get(1), "Wrong element");
		
	}
}
