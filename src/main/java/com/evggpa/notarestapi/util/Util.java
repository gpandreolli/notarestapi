package com.evggpa.notarestapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public static Date formataData(String data) throws ParseException {
        return formater.parse(data);
    }
}
