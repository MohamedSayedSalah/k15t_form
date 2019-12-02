package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.k15t.pat.ApplicationBootstrap;
import com.k15t.pat.JerseyConfig;
import com.k15t.pat.StaticContentConfig;
import com.k15t.pat.registration.controllers.RegistrationController;
import com.k15t.pat.registration.models.User;
import com.k15t.pat.registration.services.UserService;
import com.sun.research.ws.wadl.Application;
import io.swagger.model.UserDetails;
import org.apache.velocity.Template;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.ws.rs.core.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration

public class RegistrationControllerTest {
    private MockMvc mockMvc;


//    @Autowired
//    private Template template;

    @Mock
    private UserService userService ;


    private RegistrationController registrationController;


    /**
     * mocks before run actual tests
     *
     *
     */

    @Before
    public void setup() {
        registrationController = new RegistrationController();
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
 }


    /**
     * test get request to registration page
     */
    @Test
    public void testHomePage() throws Exception {

        mockMvc.perform(get("/registration.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }


    /**
     *  test post request to /register
     *  with body sent as json
     */
    @Test
    public void createUser() throws Exception {
        String body = "{\"name\":\"test\",\"mail\":\"mmmmm@test.com\",\"password\":\"123\",\"phoneNumber\":\"122344444\"}";

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andReturn();

    }


}
