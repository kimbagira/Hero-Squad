//import java.util.HashMap;
//import spark.ModelAndView;
//import spark.template.handlebars.HandlebarsTemplateEngine;
//import java.util.Map;
//
//import static spark.Spark.*;
//
//public class App {
//    public static void main(String[] args) {
//        staticFileLocation("/public");
//        get("/", (request, response) -> "Hero-Squad");
//        return new ModelAndView(new HashMap(), " ");
//
//    }, new HandlebarsTemplateEngine());
//}


import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
//import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args){

        staticFileLocation("/public");
        String layout = "templates/layout.hbs";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads/:id/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad-heroes-form.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.search(Integer.parseInt(request.params(":id")));
            model.put("hero", hero);
            model.put("template", "templates/hero.hbs");
            return new ModelAndView(model, layout);
        }, new  HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", Hero.all());
            model.put("template", "templates/heroes.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();

            Squad squad = Squad.search(Integer.parseInt(request.queryParams("squadId")));


            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            squad.addHero(newHero);



            model.put("squad", squad);
            model.put("template", "templates/squad-heroes-success.hbs");
            return new ModelAndView(model, layout);
        }, new  HandlebarsTemplateEngine());

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template","templates/squads-form.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int size= request.queryParams("size");
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(name, cause);
            model.put("template", "templates/squad-success.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.all());
            model.put("template", "templates/squads.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.search(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

    }
}