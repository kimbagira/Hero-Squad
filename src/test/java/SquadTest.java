import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest{

    @Test
    public void squadInstantiatesCorrectly_true() {
        Squad theSquad = new Squad("Worker", "never give up" );
        assertEquals(true, theSquad instanceof Squad);
    }

    @Test
    public void getName_squadInstantiatesWithNameAndCause_strings(){
        Squad theSquad = new Squad("Worker", "never give up");
        assertEquals("never give up", theSquad.getCause());
        assertEquals("Worker", theSquad.getName());
    }

    @Test
    public void all_returnAllInstancesOfSquad_true(){
        Squad firstSquad = new Squad("Worker", "never give up");
        Squad secondSquad = new Squad("peace-maker", "giving peace to everyone");
        assertEquals(true, Squad.all().contains(firstSquad));
        assertEquals(true, Squad.all().contains(secondSquad));
    }

    @Test
    public void getId_squadInstantiateWithAnId_1(){
        Squad.clear();
        Squad testSquad = new Squad("worker", "never give up");
        assertEquals(1, testSquad.getId());
    }

    @Test
    public void clear_emptiesAllSquadsFromInstances_0(){
        Squad theSquad = new Squad("worker", "never give up");
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }

    @Test
    public void getHeroes_returnsEmptyList_ArrayList(){
        Squad.clear();
        Squad theSquad = new Squad("worker", "never give up");
        assertEquals(0, theSquad.getHeroes().size());
    }

    @Test
    public void addHero_addsHeroToList_true(){
        Squad theSquad = new Squad("worker", "never give up");
        Hero theHero = new Hero("sylvie", "24", "always active", "always active");
        theSquad.addHero(theHero);
        assertTrue(theSquad.getHeroes().contains(theHero));
    }

    @Test
    public void search_returnsSquadWithSameId_secondSquad(){
        Squad.clear();
        Squad firstSquad= new Squad("worker", "never give up");
        Squad secondSquad= new Squad("peace-maker", "giving peace to everyone");
        assertEquals(Squad.search(secondSquad.getId()), secondSquad);
    }

}