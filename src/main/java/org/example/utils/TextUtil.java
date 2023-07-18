package org.example.utils;

import java.nio.charset.StandardCharsets;
import lombok.SneakyThrows;

public class TextUtil {

    @SneakyThrows
    public String text(String... args) {
        int i = 0;
        String good_text = "";
        for (String arg : args) {
            if (i == 0) {
                good_text = " " + arg;
            } else {
                good_text = "\n" + arg;
            }
            i++;
        }
        return "<html>" +
                new String(good_text.toString().replaceAll("\\n", "<br>").getBytes("windows-1251"), StandardCharsets.UTF_8) +
                "<html>";
    }

    @SneakyThrows
    public String textNoHTML(String... args) {
        int i = 0;
        StringBuilder good_text = new StringBuilder();
        for (String arg : args) {
            if (i == 0) {
                good_text.append(arg);
            } else {
                good_text.append(arg);
            }
            i++;
        }
        return new String(good_text.toString().getBytes("windows-1251"), StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public String removeHTML(String string) {
        String a = "";
        if (string.contains("<html>")) {
            a = string.replaceAll("<html> ","");
            a = a.replaceAll("<html>","");
        }
        return a;
    }
}
