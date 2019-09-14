//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class HeroTest {
//    @Test
//    public void Hero_instantiatesCorrectly_true() {
//        Hero theHero = new Hero("sylvie", "24", "always active", "Easily forget");
//        assertEquals(true, theHero instanceof Hero);
//    }
//
//    @Test
//    public void getId_heroInstantiatesWithId_1() {
//        Hero.clear();
//        Hero theHero = new Hero("sylvie", "24", "always active", "Easily forget");
//        assertEquals(1, theHero.getId());
//    }
//
//    @Test
//    public void clear_emptiesAllHeroesFromArrayList_0(){
//        Hero theHero = new Hero("sylvie", "24", "always active", "Easily forget");
//        Hero.clear();
//        assertEquals(Hero.all().size(), 0);
//    }
//
//    @Test
//    public void search_returnsHeroWithSameId_HeroTwo() {
//        Hero theHero = new Hero("sylvie", "24", "always active", "Easily forget");
//        Hero HeroTwo = new Hero("elise", "63", "hardworker", "forgive easly");
//        assertEquals(Hero.search(HeroTwo.getId()), HeroTwo);
//    }
//
//}