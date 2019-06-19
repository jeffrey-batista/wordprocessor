package jeff.makes.projects.controller;

import jeff.makes.projects.service.StringSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static jeff.makes.projects.util.ProjectConstants.CHECK_STRING_METHOD_ENDPOINT;
import static jeff.makes.projects.util.ProjectConstants.STRING_PROCESS_CONTROLLER_ENDPOINT;

@RestController
@RequestMapping(value = STRING_PROCESS_CONTROLLER_ENDPOINT)
public class StringProcessorController {

    @Autowired
    StringSearcher searcher;



    @GetMapping(value = CHECK_STRING_METHOD_ENDPOINT)
    public Integer checkString(@PathVariable String originalString) {
        return searcher.findWithinGivenString(originalString);
    }
}