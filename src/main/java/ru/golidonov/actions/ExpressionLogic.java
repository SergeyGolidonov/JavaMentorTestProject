package main.java.ru.golidonov.actions;

public class ExpressionLogic {

    private int number(SymbolsPool numbers) {
        Symbol symbol = numbers.nextSymbol();
        switch (symbol.getTypes()) {
            case NUMBER:
                return Integer.parseInt(symbol.getValue());
            default:
                    throw new RuntimeException("Символ не подлежит математическому исчислению: " + symbol.getValue()
                    + " его местоположение: " + numbers.getPosition());
        }
    }

    private int multDivision(SymbolsPool numbers) {
        int value = number(numbers);
        while (true) {
            Symbol symbol = numbers.nextSymbol();
            switch (symbol.getTypes()) {
                case MULTIPLE:
                    value *= number(numbers);
                    break;
                case DIVIDE:
                    value /= number(numbers);
                    break;
                default:
                    numbers.back();
                    return value;
            }
        }
    }

    private int plusMinus(SymbolsPool numbers) {
        int value = multDivision(numbers);
        while (true) {
            Symbol symbol = numbers.nextSymbol();
            switch (symbol.getTypes()) {
                case PLUS:
                    value += multDivision(numbers);
                    break;
                case MINUS:
                    value -= multDivision(numbers);
                    break;
                default:
                    numbers.back();
                    return value;
            }
        }
    }

    public int expression(SymbolsPool numbers) {
        Symbol symbol = numbers.nextSymbol();
        if (symbol.getTypes() == SymbolTypes.END_OF_LINE) {
            return 0;
        } else {
            numbers.back();
            return plusMinus(numbers);
        }
    }
}