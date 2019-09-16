import java.util.ArrayList;

public class Hero{
    private String Name;
    private String Age;
    private int Id;
    public String Power;
    public String Weakness;

    private static ArrayList<Hero> enter = new ArrayList<Hero>();

    public Hero(String name, String age, String power, String weakness){
        Name = name;
        Age = age;
        Power = power;
        Weakness = weakness;
        Id = enter.size();
        enter.add(this);
    }

    public static ArrayList<Hero> all(){
        return enter;
    }

    public static void clear(){
        enter.clear();
    }

    public String getName(){
        return Name;
    }

    public String getAge(){
        return Age;
    }

    public String getPower(){
        return Power;
    }

    public String getWeakness(){
        return Weakness;
    }

    public static ArrayList<Hero>getAll() {
        return enter;
    }

    public int getId(){
        return Id;
    }

    public static Hero search(int id){
        return enter.get(id-1);
    }

    public void update(String name, String age, String power, String weakness) {
        Name = name;
        Age = age;
        Power = power;
        Weakness = weakness;
        Id = enter.size();
        enter.add(this);
    }
}