package main.java.ru.golidonov.actions;

import java.util.ArrayList;
import java.util.List;

public class Symbol {
    private SymbolTypes types;
    private String value;

    public SymbolTypes getTypes() {
        return types;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "types=" + types +
                ", value='" + value + '\'' +
                '}';
    }

    private Symbol(SymbolTypes types, String value) {
        this.types = types;
        this.value = value;
    }

    private Symbol(SymbolTypes types, Character value) {
        this.types = types;
        this.value = value.toString();
    }

    public Symbol() {
    }

    public List<Symbol> iterSymbol(String str) {
        ArrayList<Symbol> symbols = new ArrayList<>();
        int position = 0;

        while (position < str.length()) {
            char c = str.charAt(position);
            switch (c) {
                case '+':
                    symbols.add(new Symbol(SymbolTypes.PLUS, c));
                    position++;
                    continue;
                case '-':
                    symbols.add(new Symbol(SymbolTypes.MINUS, c));
                    position++;
                    continue;
                case '*':
                    symbols.add(new Symbol(SymbolTypes.MULTIPLE, c));
                    position++;
                    continue;
                case '/':
                    symbols.add(new Symbol(SymbolTypes.DIVIDE, c));
                    position++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder stBuild = new StringBuilder();
                        do {
                            stBuild.append(c);
                            position++;
                            if (position >= str.length()) {
                                break;
                            }
                            c = str.charAt(position);
                        } while (c <= '9' && c >= '0');
                        symbols.add(new Symbol(SymbolTypes.NUMBER, stBuild.toString()));
                    } else {
                        if (c != ' ') {
                            throw new RuntimeException("Символ не подлежит математическому исчеслению: " + c);
                        }
                        position++;
                    }
            }
        }
        symbols.add(new Symbol(SymbolTypes.END_OF_LINE, ""));
        return symbols;
    }
}