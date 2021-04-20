package main.java.ru.golidonov.actions;

import java.util.List;

public class SymbolsPool {

    private int position;

    private List<Symbol> symbols;

    public SymbolsPool(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public Symbol nextSymbol() {
        return symbols.get(position++);
    }

    public void back() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}