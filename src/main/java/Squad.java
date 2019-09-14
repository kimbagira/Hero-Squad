import java.util.List;
        import java.util.ArrayList;

public class Squad{
    private int size;
    private String Name;
    private String Cause;
    private static List<Squad> enter = new ArrayList<Squad>();
    private int Id;
    private List<Hero> Heroes;

    public Squad(String name, String cause) {
        size=size;
        Name = name;
        Cause = cause;
        Id = enter.size();
        enter.add(this);

        Heroes = new ArrayList<Hero>();
    }

    public List<Hero> getHeroes(){
        return Heroes;
    }

    public String getName(){
        return Name;
    }

    public String getCause(){
        return Cause;
    }

    public static List<Squad> all(){
        return enter;
    }

    public static void clear(){
        enter.clear();
    }

    public int getId(){
        return Id;
    }

    public static Squad find(int id){
        return enter.get(id - 1);
    }

    public void addHero(Hero hero){
        if(Heroes.size() < 10) {
            Heroes.add(hero);
        }
        }
    }

