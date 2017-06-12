package ru.roza.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class MainController {

    @Value("${python.interpreter.path}")
    private String python;

    @Value("${python.script.path}")
    private String script;

    @Value("${papers.path}")
    private String papersFolder;

    @Value("${temp.path}")
    private String temp;

    @Value("${result.path}")
    private String result;

    @Value("${corpus.path}")
    private String corpus;

    @PostMapping("/query_paper")
    public String queryPaper(@ModelAttribute("model") ModelMap model, @ModelAttribute("paper_text") String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
            writer.write(text);
            writer.close();

            String command = python + " " + script + " " + papersFolder + " " + " " + temp + " " + result;
            System.out.println(command);
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

            BufferedReader reader = new BufferedReader(new FileReader(result));
            String resultFile = reader.readLine();
            model.addAttribute("paper", resultFile);

            byte[] encoded = Files.readAllBytes(Paths.get(resultFile));
            text = new String(encoded);
            model.addAttribute("text", text);
            return "result_sim";
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @PostMapping("/add_paper_to_corpus")
    public String addPaperToCorpus(@ModelAttribute("paper_text") String text,
                                   @ModelAttribute("file_name") String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(corpus + "/" + fileName));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return "welcome";
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/sim_paper")
    public String simPaper() {
        return "sim_paper";
    }

    @GetMapping("/add_paper")
    public String addPaper() {
        return "add_paper";
    }
}
