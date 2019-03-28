package com.codegym.module2.Formatter;

import com.codegym.module2.Model.Gender;
import com.codegym.module2.Service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GenderFormatter  implements Formatter<Gender> {

    @Autowired
    private GenderService genderService;
    @Autowired
    public void GenderService(GenderService genderService) {
        this.genderService = genderService;
    }


    @Override
    public Gender parse(String text, Locale locale) throws ParseException {
        return genderService.findByid(Integer.parseInt(text));
    }

    @Override
    public String print(Gender object, Locale locale) {
        return "[" + object.getId() + ", " +object.getGender() + "]";
    }
}
