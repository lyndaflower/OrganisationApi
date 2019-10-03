
import models.DepartmentOrg;
import models.New;
import models.UserOrg;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/users-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "users-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/department-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "department-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/news-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "news-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<UserOrg> user = UserOrg.all();
            model.put("user", user);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        post("/userCreate", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String role = request.queryParams("role");
            String position = request.queryParams("position");
            int departmentId = Integer.parseInt(request.queryParams("departmentId"));
            UserOrg newUserOrg = new UserOrg( name,  role,  position, departmentId);
            newUserOrg.save();
            model.put("name", name);
            model.put("role", role);
            model.put("position", position);
            model.put("departmentId", departmentId);

            response.redirect("/success");
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/department-view",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<DepartmentOrg> organisation = DepartmentOrg.all();
            model.put("organisation",organisation);
            return new ModelAndView(model, "department-view.hbs");
        }, new HandlebarsTemplateEngine());


        post("/department", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            String numemployees = request.queryParams("numemployees");

            DepartmentOrg newDepartmentOrg = new DepartmentOrg( name, description, numemployees);

            model.put("name", name);
            model.put("description", description);
            model.put("numemployees", numemployees);

            newDepartmentOrg.save();
            response.redirect("/department-view");
            return new ModelAndView(model, "department-view.hbs");
        }, new HandlebarsTemplateEngine());

        
        get("/news-view",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<New>  newsOrg =New.all();
            model.put(" newsOrg", newsOrg);
            return new ModelAndView(model, "news-view.hbs");
        }, new HandlebarsTemplateEngine());

        post("/view", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String author = request.queryParams("author");
            String news = request.queryParams("news");
            New newNew = new New(author, news);

            model.put("author", author);
            model.put("news", news);

            newNew.save();
            response.redirect("/news-view");
            return new ModelAndView(model, "news-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
