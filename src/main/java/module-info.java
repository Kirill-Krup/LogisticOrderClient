module com.courcach.corsewww {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.courcach.corsewww to javafx.fxml;
    opens com.courcach.corsewww.Controllers to javafx.fxml;
    opens com.courcach.corsewww.Controllers.Admin to javafx.fxml;
    opens com.courcach.corsewww.Controllers.Client to javafx.fxml;
    opens com.courcach.corsewww.Controllers.Employee to javafx.fxml;

    exports com.courcach.corsewww;
    exports com.courcach.corsewww.Controllers;
    exports com.courcach.corsewww.Controllers.Admin;
    exports com.courcach.corsewww.Controllers.Client;
    exports com.courcach.corsewww.Controllers.Employee;

    exports com.courcach.corsewww.Models;
    exports com.courcach.corsewww.Views;
}