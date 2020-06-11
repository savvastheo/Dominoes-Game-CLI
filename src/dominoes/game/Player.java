package dominoes.game;

/**
 * @author Savvas Theofilou
 * Η κλάση αυτή αναπαριστά τον παίκτη
 * η μεταβλητή StackTiles stackOfTiles αναπαριστούν τα πλακίδια του παίκτη
 */
public class Player {
    public StackTiles stackOfTiles;
    
    /**
     * Constructor της κλάσης
     */
    public Player(){
        stackOfTiles=new StackTiles();
    }
}
