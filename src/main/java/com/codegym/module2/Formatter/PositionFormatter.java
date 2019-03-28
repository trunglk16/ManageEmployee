//package com.codegym.module2.Formatter;
//
//import com.codegym.module2.Model.Position;
//import com.codegym.module2.Service.PositionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//
//public class PositionFormatter implements Formatter<Position> {
//    @Autowired
//    private PositionService positionService;
//    @Autowired
//    public void PositionService(PositionService positionService) {
//        this.positionService = positionService;
//    }
//
//
//    @Override
//    public Position parse(String text, Locale locale) throws ParseException {
//        return positionService.findByid(Integer.parseInt(text));
//    }
//
//    @Override
//    public String print(Position object, Locale locale) {
//        return "[" + object.getId() + ", " +object.getPosition() + "]";
//    }
//
//}
