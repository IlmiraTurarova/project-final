package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.to.TaskTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.javarush.jira.login.internal.web.UserTestData.ADMIN_MAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Sql(scripts = "classpath:db/test.sql", config = @SqlConfig(encoding = "UTF-8"))
@AutoConfigureMockMvc
@ActiveProfiles("test")
class DashBoardUIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    private ResultActions perform(MockHttpServletRequestBuilder builder) throws Exception {
        return mockMvc.perform(builder);
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void updateTaskTagsWithDuplicate() throws Exception {
        TaskTo taskBeforeAdd = taskService.getTaskById(2L);

        perform(MockMvcRequestBuilders.patch( "/2")
                .content("""
                        {
                            "id":2,
                            "tags": ["Tag1", "Tag2"]
                        }
                        """).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        TaskTo taskAfterAdd = taskService.getTaskById(2L);
        assertEquals(taskBeforeAdd.getTags().size(), taskAfterAdd.getTags().size());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void updateTaskTags() throws Exception {
        perform(MockMvcRequestBuilders.patch( "/2")
                .content("""
                        {
                            "id":2,
                            "tags": ["Tag3", "Tag4", "Tag5"]
                        }
                        """).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        TaskTo taskById = taskService.getTaskById(2L);
        assertEquals(5, taskById.getTags().size());
    }

}