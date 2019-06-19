package jeff.makes.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

import static jeff.makes.projects.util.ProjectConstants.ENV_PROP_STRINGS_TO_SEARCH_FOR_KEY;
import static jeff.makes.projects.util.ProjectConstants.MINIMUM_WORD_LENGTH_KEY;
import static jeff.makes.projects.util.ProjectConstants.NO_KEY_WORDS_FOUND_ERROR;
import static jeff.makes.projects.util.ProjectConstants.TOO_SMALL_ERROR;

@Service
public class StringSearcher {
    @Value((ENV_PROP_STRINGS_TO_SEARCH_FOR_KEY))
    private Map<String, Integer> keyWords;

    @Autowired
    private Environment env;


    public Integer findWithinGivenString(String userString) {
        int minimumWordLength= env.getProperty(MINIMUM_WORD_LENGTH_KEY, Integer.class);
        if (userString.length() < minimumWordLength)
            return TOO_SMALL_ERROR;

        int output = 0;
        int currentStringStartPosition = 0;
        int currentStringEndPosition = minimumWordLength;
        Integer validStringValue = null;

        while (currentStringEndPosition <= userString.length()) {
            String currentSubString = userString.substring(currentStringStartPosition, currentStringEndPosition);

            validStringValue = keyWords.get(currentSubString);
            if (validStringValue == null) {
                ++currentStringEndPosition;
                ++currentStringStartPosition;
                continue;
            }
            output = output * 10 + validStringValue;
            validStringValue = null;
            currentStringStartPosition += minimumWordLength;
            currentStringEndPosition += minimumWordLength;

        }
        if (output == 0)
            return NO_KEY_WORDS_FOUND_ERROR;

        return output;
    }

}
