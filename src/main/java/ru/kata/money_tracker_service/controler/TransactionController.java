package ru.kata.money_tracker_service.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.money_tracker_service.model.TypeOfTransation;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;

import static ru.kata.money_tracker_service.model.TypeOfTransation.values;

@Controller
@RequestMapping("/transaction")
public class TransactionController {



    @GetMapping
    public String toTransaction() {
        return "/text1";
    }


}
