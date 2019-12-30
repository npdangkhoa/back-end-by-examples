package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo01.config.DemoApplication;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class SecureBasicServiceTestsWithMockMvc {
		
	private String url = "http://localhost:8080/greet/";
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", password = "admin")
    public void withMockUser() throws Exception {
        this.mockMvc.perform(get(url)).andExpect(status().isOk());
    }
}
