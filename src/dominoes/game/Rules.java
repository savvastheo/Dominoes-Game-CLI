package dominoes.game;

import java.util.ArrayList;

/**
 * @author Savvas Theofilou
 * Η κλάση  που περιέχει όλους τους ελέγχους για τους κανόνες του παιχνιδιού
 * Μεταβλητές: rounds συμβολίζει τον αριθμό των γυρών που θα παικτούν στο Ουγγρικό
 */
public class Rules {
 
    private int rounds;

    /**
     * Ο constructor της κλάσης που θέτει τη rounds=0 
     */
    public Rules(){
        rounds=0;
    }
    
    /**
    * Η μέθοδος που θέτει πόσους γύρους θα έχει το Ουγγρικό 
    *@param rounds συμβολίζει τον αριμό γυρών του παιχνιδιού
    */
    public void setRounds(int rounds){
        this.rounds=rounds;
    }

    /**
    * Η μέθοδος που επιστρέφει πόσοι γύροι έχουν απομήνει στο παιχνιδι
    * @return rounds
    */
    public int getRounds(){
        return rounds;
    }


    /**
    * Η μέθοδος που επιστρέφει true/false αν υπάρχουν διαθέσιμα πλακίδια στο Solo1
    * @param playerTiles  η λίστα με τα πλακίδια που έχει πάνω του ο παίκτης
    * @param tableTiles είναι οι αριθμοί των 2 άκρων του τραπεζιού με τα πλακίδια που έχουν τοποθετηθεί, που είναι
    * αποθηκευμένα σε δομή Tiles
    * @return true/false
    */
    public boolean areAvailableTiles(ArrayList<Tiles> playerTiles,Tiles tableTiles){
        for(Tiles x: playerTiles){
            if(x.getLeft()==tableTiles.getLeft() || x.getRight()==tableTiles.getLeft() || x.getLeft()==tableTiles.getRight() || x.getRight()==tableTiles.getRight()){
               return true;
           }
        }
        return false;
    }
    
    /**
     * Η μέθοδος που επιστρέφει μια λίστα με τα διαθέσιμα πλακίδια που μπορεί να παίξει ο παίκτης
     * @param playerTiles η λίστα με τα πλακίδια που έχει πάνω του ο παίκτης
     * @param tableTiles είναι οι αριθμοί των 2 άκρων του τραπεζιού με τα πλακίδια που έχουν τοποθετηθεί, που είναι
     * αποθηκευμένα σε δομή Tiles
     * @return ArrayList<Tiles> availableTiles η λίστα με τα πλακίδια που μπορεί να τοποθετήσει ο παίκτης στο τραπέζι
     */
    public ArrayList<Tiles> FindTilesSolo1(ArrayList<Tiles> playerTiles,Tiles tableTiles){
        ArrayList<Tiles> availableTiles;     // edo tha apothikefso ta diathesima plakidia pou mpori na peksi o pektis;
        availableTiles=new ArrayList<>();
        for(Tiles x: playerTiles){
            if(x.getLeft()==tableTiles.getLeft() || x.getRight()==tableTiles.getLeft() || x.getLeft()==tableTiles.getRight() || x.getRight()==tableTiles.getRight()){
                availableTiles.add(x);
            }   
        }
        return availableTiles;
    }
    
    /**
     * Η μέθοδος που επιστρέφει true/false αν ένα πλακίδιο μπαίνει και από τις 2 πλευρές του τραπεζιού
     * @param playerTile το πλακίδιο που θέλει να τοποθετήσει ο παίκτης στο τραπέζι
     * @param table οι δύο αριθμοί στις άκρες του τραπεζιού
     * @return true/false
     */
    public boolean bothSide(Tiles playerTile,Tiles table){
        if((playerTile.getLeft()==table.getLeft() && playerTile.getLeft()==table.getRight())|| (playerTile.getRight()==table.getLeft() && playerTile.getRight()==table.getRight())|| (playerTile.getLeft()==table.getLeft() && playerTile.getRight()==table.getRight())|| (playerTile.getLeft()==table.getRight() && playerTile.getRight()==table.getLeft())  )
            return true;
        else
            return false;
    }
   
    /**
     * Η μέθοδος που ελέγχει από ποια πλευρα μπαίνει το πλακίδιο και αν χρειάζεται να γυριστεί για να τοποθετηθεί σωστά
     * @param table οι δύο αριθμοί στις άκρες του τραπεζιού
     * @param player το πλακίδιο που θέλει να τοποθετήσει ο παίκτης στο τραπέζι
     * @return 1 αν το πλακίδιο μπαίνει αριστερά, 2 αν το πλακίδιο μπαίνει δεξιά
     */
    public int whoSide(Tiles table,Tiles player){
        if(player.getLeft()==table.getLeft()){
            player.swapTile();
            return 1;
        }
        if(player.getRight()==table.getRight()){
            player.swapTile();
            return 2;
        }
        if(player.getLeft()==table.getRight())
            return 2;
        else 
            return 1;
    }
    
    /**
     * Η μέθοδος που ελέγχει αν το πλακίδιο πρέπει να αντιστραφεί για να τοποθετηθεί σωστά σύμφωνα με την επιλογη 
     * του παίκτη
     * @param table οι δύο αριθμοί στις άκρες του τραπεζιού
     * @param player το πλακίδιο που θέλει να τοποθετήσει ο παίκτης στο τραπέζι
     * @param choice αριστερά ή δεξιά σύμφωνα με τον παίκτη
     */
    public void whoBothSide(Tiles table,Tiles player,int choice){
        if(choice==1){
            if(player.getLeft()==table.getLeft())
                player.swapTile();
        }
        else{
            if(player.getRight()==table.getRight())
                player.swapTile();
        }    
    }

    /**
     * Η μέθοδος που διαγράφει από την λίστα των πλακιδίων που έχει ο παίκτης πάνο του, το πλακίδιο που 
     * έχει τοποθετήσει
     * @param choice το πλακίδιο που έχει τοποθετήσει ο παίκτης
     * @param hand τα πλακίδια που έχει ο παίξτης στο χέρι του
     */
    public void deletePlacedTile(Tiles choice, ArrayList<Tiles> hand){
    for(Tiles x: hand)
        if(x.getLeft()==choice.getLeft() && x.getRight()==choice.getRight()){
            hand.remove(x);
            break;
        }  
    }

    /**
     * Η μέθοδος που βρίσκει ποιος θα αρχίσει πρώτος στο Ουγγρικό
     * @param players[]  πίνακας με τα πλακίδια των παικτών
     * @return int index ο παίκτης που θα αρχίσει πρώτος
     */
    public int startFirtst(ArrayList<Tiles> players[]){
        int index=0,max=0;
        for(int i=0;i<players.length;i++){
            for(Tiles x:players[i]){
                if((x.getRight()==x.getLeft())){
                    if(x.getRight()>max){
                        max=x.getRight();
                        index=i+1;
                    }  
                }
            }
        }
        return index;
    }
    
   /**
    * H μέθοδος που ελέγχει ποιος είναι ο νικητής του Ουγγρικού
    *@param players[] τα πλακίδια που δεν μπόρεσαν να τοποθετήσουν οι παίκτες στο τραπέζι
    *@return int index ποιος παίκτης κέρδισε το γύρο, για ισοβαθμία επιστρέφει 0
    */
    public int winnerSet(ArrayList<Tiles> players[]){
        int numPlayers=players.length;
        int index=1,min;
        int[] sum=new int[numPlayers];
        for(int i=0;i<numPlayers;i++){
            for(Tiles x:players[i]){
                sum[i]=sum[i]+x.tilePlusNum();
            }
        }
        min=sum[0];
        for(int i=1;i<numPlayers;i++){
            if(min>sum[i]){
                min=sum[i];
                index=i+1;
            }
        }
        for (int i=0;i<numPlayers;i++){
            if (i!=(index-1)){
                if (sum[i]==min){
                    return 0;
                }
            }
        }
        return index;
    }

    /**
    * Η μέθοδος που προσθέτει τους πόντους των υπολοίπων, στους πόντους του νικητή του γύρου 
    * @param winner ο νικητής του γύρου
    * @param playersPoints[] ο πίνακας με τους πόντους όλων των παικτών
    * @param tilesPlayers[] τα πλακίδια που απέμειναν στο χέρι του κάθε παίκτη
    */
    public void addPoints(int winner,int playersPoints[], ArrayList<Tiles> [] tilesPlayers){
        int newpoints=0;
        for(int i=0;i<playersPoints.length;i++){
            for(Tiles x: tilesPlayers[i])
                newpoints+=x.tilePlusNum();
        }
        playersPoints[winner-1]+=newpoints;
    }
    
    /**
     * Η μέθοδος που μειώνει τους γύρους του παιχνιδιού
     */
    public void reduceRounds(){
        rounds--;
    }

    /**
     * Η μέθοδος που ελέγχει αν έχει τελειώσει το παιχνίδι
     * @param arrayPoints οι πόντοι των παικτών
     * @return true/false σχετικά με το αν έχει τελειώσει το παιχνίδι
     */
    public boolean endOfGame(int arrayPoints []){
        for(int x: arrayPoints){
            if(x>=100)
                return true;
        }
        if(rounds==0)
            return true;
        return false;
    }

    /**
    * Η μέθοδος που βρίσκει τον νικητή του παιχνιδιού
    *@param arrayPoints[] οι πόντοι των παικτών
    *@return int winner ο παίκτης με τους υψηλότερος πόντους
    */
    public int winnerOfGame(int[] arrayPoints){
        int winner=0,max;
        max=arrayPoints[0];
        for(int i=1;i<arrayPoints.length;i++){
            if(max<arrayPoints[i])
                winner=i;
        }
        return winner+1;
    }
    
    /**
    * Η μέθοδος που υπολογίζει τους βαθμούς όλων των πλακιδίων ενώς  ArrayList<Tiles
    * @param ArrayListOfTiles  η λίστα με τα πλακίδια
    * @return int sum το άθροισμα των πλακιδίων 
    */
    public int calculatePointsOfTiles(ArrayList<Tiles> ArrayListOfTiles){
        int sum=0;
        for (Tiles x: ArrayListOfTiles){
            sum+=x.tilePlusNum();
        }
        return sum;
    }
}


