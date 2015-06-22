package ua.hulenkoOleg;

import org.junit.Test;
import static org.junit.Assert.*;

public class hulenkoOlegT {
@Test
    public void testMain(){
        String dt = new java.text.SimpleDateFormat(("hh:mm aaa")).format(java.util.Calendar.getInstance().getTime());
    assertNotNull(dt);
}

}
