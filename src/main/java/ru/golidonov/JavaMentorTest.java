package main.java.ru.golidonov;

import main.java.ru.golidonov.actions.ExpressionLogic;
import main.java.ru.golidonov.actions.Symbol;
import main.java.ru.golidonov.actions.SymbolsPool;

import java.util.List;
import java.util.Scanner;

public class JavaMentorTest {
    public static void main(String[] args) {

        System.out.println("*********************************************");
        System.out.println("*Введите математическое выражение из 2х цифр*");
        System.out.println("*====Пример: 3*5 или 2+2 или 8-4 или 9/3====*");
        System.out.println("*********************************************");
        Scanner scanner = new Scanner(System.in);
        String result;
        result = scanner.next();

        Symbol symbol = new Symbol();
        List<Symbol> symbols = symbol.iterSymbol(result);
        SymbolsPool symbolsPool = new SymbolsPool(symbols);
        ExpressionLogic expressionLogic = new ExpressionLogic();
        System.out.println(expressionLogic.expression(symbolsPool));

    }
}