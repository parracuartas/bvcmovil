package com.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hans Parra, Juan Cuartas
 */
public class Util {

    public static boolean matchRegex(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static String readFile(String nameFile) throws IOException {
        StringBuilder sb = new StringBuilder("");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nameFile));
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
        return sb.toString();
    }
}