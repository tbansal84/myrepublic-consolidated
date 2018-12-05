import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import services.interview.myrepublic.controller.PhoneNumberAddOnController;
import services.interview.myrepublic.domain.PhoneNumberAddonService;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneNumberAddOnController.class)
public class PhoneNumberAddOnControllerIntegrationTest {
 
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private PhoneNumberAddonService phoneNumberAddonService;
 
    // write test cases here
    
    
    @Test
    public void test()
      throws Exception {
         
    }
}