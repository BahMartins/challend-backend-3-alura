package br.com.alura.challend.financialtransactions.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ImportTransactionsController {

    @GetMapping
    public String getView(){
        return "ImportTransactions";
    }

    @PostMapping
    public String postTransaction(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        String fileName = file.getOriginalFilename();

        long size = file.getSize();

        System.out.println(fileName + size);

        return "redirect:ImportTransactions";

    }
}
