
import models.CourseDAO;
import views.CourseView;
import controller.CourseController;

public class Main {
    public static void main(String[] args) {
        CourseView view = new CourseView();
        CourseDAO model = new CourseDAO();
        CourseController controller = new CourseController(view, model);
        view.setVisible(true);
    }
}
