package jeff.makes.projects.controller;

import jeff.makes.projects.service.StringSearcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StringProcessorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private StringProcessorController controller;
    @Mock
    private StringSearcher searcher;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testcheckStringValidUrl() throws Exception {
        when(searcher.findWithinGivenString(ArgumentMatchers.anyString())).thenReturn(121);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/string-functions/search-for-substring-in-string/aaaaa")
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

    }

    @Test
    public void testcheckString() throws Exception {
        when(searcher.findWithinGivenString(ArgumentMatchers.anyString())).thenReturn(121);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("an-incorrect-endpoint/string-functions/search-for-substring-in-string/aaaaa")
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound()).andReturn();

    }

}
