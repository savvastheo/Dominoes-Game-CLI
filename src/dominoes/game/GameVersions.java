package dominoes.game;

/**
 * @author Savvas Theofilou
 * Η κλάση αυτή περιέχει τις διάφορες εκδοχές του παιχνιδιού
 */
public class GameVersions {
    private final String version,language;
    private final UserInterface user_interface;
    
    /**
     * Constructor της κλάσης
     * @param version Η εκδοχή του παιχνιδιού
     * @param language Η γλώσσα του παιχνιδιού
     */
    public GameVersions(String version, String language){
        this.version=version;
        this.language=language;
        user_interface=new UserInterface(this.language);
    }
    
    /**
     * Μέθοδος με την οποία θα ξεκινά η εκδοχή του παιχνιδιού "Solo 1"
     */
    public void startSolo1(){
        Solo1 play=new Solo1(language);
        play.startGame();
    }
    
    /**
     * Μέθοδος με την οποία θα ξεκινά η εκδοχή του παιχνιδιού "Ουγγρικό"
     */
    public void startHungarian(){
        short players;
        players=user_interface.howManyPlayers();
        if (players!=2){
            user_interface.showNotAvailableVersionPlayers(players);
        }
        else{
            Hungarian play=new Hungarian(language,players);
            play.startGame();
        }
        /*Hungarian play=new Hungarian(language,players);
        play.startGame();*/
        
    }
    
    /**
     * Μέθοδος με την οποία θα ξεκινά η εκδοχή του παιχνιδιού "Όλα 7"
     */
    public void startCardinal(){
        //short players;   
        //players=user_interface.howManyPlayers();
        user_interface.showNotAvailableVersion();
    }
}