package controllers;

import models.UnaryOperation;
import views.UnaryOperationView;
import views.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainController {
    private UnaryOperation model;
    private View view;

    public MainController(
            UnaryOperation model,
            View view
    ) {
        this.model = model;
        this.view = view;
    }

    public void doTask() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Created manually:");
        view.display();

        invokeConstructorDynamically();
        System.out.println("Created with reflection:");
        view.display();

        changeFieldDynamically();
        System.out.println("Value changed with reflection:");
        view.display();

        invokeMethodDynamically();
        System.out.println("Protected method invoked with reflection:");
        view.display();

        invokeDefaultConstructorDynamically();
        System.out.println("Default constructor invoked with reflection:");
        view.display();
    }

    private void invokeDefaultConstructorDynamically() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        model = UnaryOperation.class.getConstructor().newInstance();
        view = new UnaryOperationView(model);
    }

    private void invokeMethodDynamically() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method protectedMethod = model.getClass().getDeclaredMethod("setValue", double.class);
        protectedMethod.setAccessible(true);
        protectedMethod.invoke(model, 30);
        protectedMethod.setAccessible(false);
    }

    private void changeFieldDynamically() throws NoSuchFieldException, IllegalAccessException {
        Field valueField = model.getClass().getDeclaredField("value");
        valueField.setAccessible(true);
        valueField.set(model, -20);
        valueField.setAccessible(false);
    }

    private void invokeConstructorDynamically() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        model = UnaryOperation.class.getConstructor(double.class).newInstance(10);
        view = new UnaryOperationView(model);
    }
}
