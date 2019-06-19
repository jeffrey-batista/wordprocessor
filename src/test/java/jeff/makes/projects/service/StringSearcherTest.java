package jeff.makes.projects.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import java.util.Map;

import static jeff.makes.projects.util.ProjectConstants.MINIMUM_WORD_LENGTH_KEY;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class StringSearcherTest {
    @InjectMocks
    StringSearcher searcher;
    @Mock
    private Map<String, Integer> keyWords;
    @Mock
    private Environment env;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testStringTooSmall() {
        when(env.getProperty(MINIMUM_WORD_LENGTH_KEY, Integer.class)).thenReturn(3);

        assertEquals(Integer.valueOf(-9), searcher.findWithinGivenString("aa"));
    }

    @Test
    public void testValidKeyWordsFound() {
        when(env.getProperty(MINIMUM_WORD_LENGTH_KEY, Integer.class)).thenReturn(3);
        when(keyWords.get("aaa")).thenReturn(1);
        when(keyWords.get("aba")).thenReturn(2);

        assertEquals(Integer.valueOf(12), searcher.findWithinGivenString("aaaanjkabanb"));
    }

    @Test
    public void testNoValidKeyWordsFound() {
        when(env.getProperty(MINIMUM_WORD_LENGTH_KEY, Integer.class)).thenReturn(3);
        when(keyWords.get("aaa")).thenReturn(1);
        when(keyWords.get("aba")).thenReturn(2);

        assertEquals(Integer.valueOf(-8), searcher.findWithinGivenString("bahboon"));
    }


}
