package br.com.alura.challend.financialtransactions.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ImportTransactionsController {

    @GetMapping
    public ModelAndView getView(){
        return new ModelAndView("ImportTransactions.html");
    }

    @PostMapping
    public String postTransaction(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        String fileName = file.getOriginalFilename();
        long size = file.getSize();

        System.out.println(fileName + " - " + size);


        InputStream inputStream = file.getInputStream();
        new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .forEach(System.out::println);


        return "redirect:/importTransactions";

    }
}
