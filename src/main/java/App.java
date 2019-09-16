
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import models.hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        get("/Hero/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new hero form
        post("/Hero/new", (req, res) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();

            String name = req.queryParams("name");
            String age=req.params("age");
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");

            Hero newHero = new Hero(name, age, power, weakness);
            model.put("Hero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAll();
            model.put("Hero", hero);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual hero
        get("/Hero/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Hero foundHero = Hero.search(idOfHeroToFind); //use it to find hero
            model.put("Hero", foundHero); //add it to model for template to display
            return new ModelAndView(model, "detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a post
        get("/hero/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.search(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process a form to update a post
        post("/Hero/:id/update", (req, res) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String age=req.params("age");
            String power = req.queryParams("power");
            String weakness = req.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.search(idOfHeroToEdit);
            editHero.update( name, age, power, weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual post
        get("/Hero/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Hero deleteHero = Hero.search(idOfHeroToDelete); //use it to find post
            deleteHero.clear();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all posts
        get("/hero/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.clear();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
