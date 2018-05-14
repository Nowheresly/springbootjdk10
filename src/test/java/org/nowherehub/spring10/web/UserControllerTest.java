package org.nowherehub.spring10.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nowherehub.spring10.Spring10Application;
import org.nowherehub.spring10.domain.User;
import org.nowherehub.spring10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Spring10Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void getUser() throws Exception {


        User user = new User();
        user.setName("guetta");

        given(userRepository.findById(1L)).willReturn(Optional.of(user));

        mvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("guetta"));


    }

    @Test
    public void create() {
    }
}