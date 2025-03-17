package spring.security_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import spring.security_demo.controllers.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)

//TODO add security configuration and pipelines
public class HelloControllerApiTests {

  private static final Logger log = LoggerFactory.getLogger(HelloControllerApiTests.class);

  @Autowired
  public MockMvc mockMvc;

  @Test
  public void hello_get_unauthorized(TestInfo testInfo) throws Exception {
    log.info("Starting {}", testInfo.getDisplayName());
    mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isUnauthorized());
    log.info("Finishing {}", testInfo.getDisplayName());
  }

  @Test
  @WithMockUser("user")
  public void hello_get_ok(TestInfo testInfo) throws Exception {
    log.info("Starting {}", testInfo.getDisplayName());
    mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk());
    log.info("Finishing {}", testInfo.getDisplayName());
  }


}
