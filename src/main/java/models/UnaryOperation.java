package models;

public class UnaryOperation {
    private double value;

    public UnaryOperation(double value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void negate() {
        value = -value;
    }

    public double getValue() {
        return value;
    }

    public UnaryOperation() {

    }

    protected void setValue(double value) {
        this.value = value;
    }
}
