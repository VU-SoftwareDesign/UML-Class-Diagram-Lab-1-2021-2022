package softwaredesign.projectManager;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class test {
	
   String message = "Hello World";	
   Employee testEmployee = new Employee(message);

   @Test
   public void testPrintMessage() {
      assertEquals(message,testEmployee.print());
   }
}