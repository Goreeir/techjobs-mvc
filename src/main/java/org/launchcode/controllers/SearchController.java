package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "results")
    public  String search(@RequestParam String searchTerm, @RequestParam String searchType, Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        ArrayList<HashMap<String, String>> jobSearch;
            if (searchType.equals("all")) {
                jobSearch = JobData.findByValue(searchTerm);
            }
            else{
                jobSearch = JobData.findByColumnAndValue(searchType, searchTerm);
                }
        model.addAttribute("results", jobSearch);
        return "search";
    }
}
