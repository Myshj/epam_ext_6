package views;

import models.UnaryOperation;

public class UnaryOperationView extends View {
    private static String PREFIX = "Value: ";

    private final UnaryOperation model;

    public void display() {
        System.out.println(PREFIX + model.getValue());
    }

    public UnaryOperationView(UnaryOperation model) {
        this.model = model;
    }
}
