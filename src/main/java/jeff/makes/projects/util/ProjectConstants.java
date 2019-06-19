package jeff.makes.projects.util;

public interface ProjectConstants {

    String ENV_PROP_STRINGS_TO_SEARCH_FOR_KEY = "#{${string.maps}}";
    String MINIMUM_WORD_LENGTH_KEY = "min.length";
    String STRING_PROCESS_CONTROLLER_ENDPOINT ="string-functions";
    String CHECK_STRING_METHOD_ENDPOINT= "search-for-substring-in-string/{originalString}";

    int TOO_SMALL_ERROR = -9;
    int NO_KEY_WORDS_FOUND_ERROR = -8;

}
