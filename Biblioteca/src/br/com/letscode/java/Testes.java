package br.com.letscode.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Testes {

    public static void main(String[] args){

        LocalDate date = LocalDate.now();

        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM")));

    }

}
