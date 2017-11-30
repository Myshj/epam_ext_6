import controllers.MainController;
import models.UnaryOperation;
import views.UnaryOperationView;

import java.lang.reflect.InvocationTargetException;

public class Main_3 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        UnaryOperation model = new UnaryOperation(1);
        new MainController(
                model,
                new UnaryOperationView(model)
        ).doTask();
    }

}
