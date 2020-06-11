package dominoes.game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Savvas Theofilou
 * Η κλάση αναπαριστά μια δομή ArrayList η οποία θα αποθηκέυει τα πλακίδια που θα χρησιμοποιούνται για το παιχνίδι
 * To ArrayList<Tiles> tilesList είναι η δομή που θα αποθηκεύονται τα πλακίδια
 */
public class StackTiles{
    ArrayList<Tiles> tilesList;
    
    /**
    * Constructor της κλάσης
    */
    public StackTiles(){
        tilesList=new ArrayList<>();
    }
    
    /**
    Η μέθοδος που δημιουργεί τα 28 πλακίδια για το Solo1 και τα προσθέτει στην ArrayList<Tiles> tilesList
    */
    public void createTableSolo1(){
        for(int i=0;i<7;i++)
            for(int j=i;j<7;j++){
                Tiles temp=new Tiles(i,j);
                tilesList.add(temp);
            }         
    }
    
    /**
    Η μέθοδος που ανακατεύει τυχαία τα 28 πλακίδια μέσα στη λίστα
    */
    public void shuffleTiles(){
        Collections.shuffle(tilesList);
    }
    
    /**
    * Η μέθοδος που προσθέτει ένα πλακίδιο στη λίστα
    * @param choiceTile το πλακάκι που θα προστεθεί
    */
    public void addTile(Tiles choiceTile){
       tilesList.add(choiceTile);
    }
      
    /**
    * Η μέθοδος που αφαιρεί ένα πλακίδιο από τη λίστα
    * @param index η θέση που βρίσκεται το πλακίδιο
    */
    public void removeTile(int index){
        if(index>=0 && index<tilesList.size())
            tilesList.remove(index);
    }
    
    /**
    * Η μέθοδος που ελέγχει αν η λίστα είναι άδεια
    * @return TRUE αν είναι άδεια, αλλιώς return FALSE
    */
    public boolean isEmpty(){
        if (tilesList.isEmpty())
            return true;
        else
            return false;
    }
    
    /**
    * Η μέθοδος που εκτυπώνει τα πλακίδια της λίστας  με αρίθμηση
    */
    public void showTilesList(){
        short i=1;
        for(Tiles x: tilesList){
            System.out.print(i+".");
            x.showTile();
            System.out.print("\t");
            i++;
        }
    }
    
    /**
    * Η μέθοδος που εκτυπώνει τα πλακίδια της λίστας χωρίς αρίθμηση  
    */ 
    public void showTilesListWithoutI(){
        for (Tiles x: tilesList){
            x.showTile();
            System.out.print(" ");
        }
    }
    
    /**
    * Η μέθοδος που εκτυπώνει τα πλακίδια κάθε γραμμής του τραπεζιού
    * @param r1 ο αριθμός των πλακιδίων που έχει η πρώτη γραμμή
    * @param r2 ο αριθμός των πλακιδίων που έχει η δεύτερη γραμμή
    * @param r3 ο αριθμός των πλακιδίων που έχει η τρίτη γραμμή
    * @param r4 ο αριθμός των πλακιδίων που έχει η τέταρτη γραμμή
    */
    public void showTableTiles(int r1,int r2, int r3, int r4){
        int [] rows=new int[4];
        rows[0]=r1;
        rows[1]=r2;
        rows[2]=r3;
        rows[3]=r4;
        int index=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<rows[i];j++){
                tilesList.get(index).showTile();
                System.out.print("\t");
                index++;
            }
            System.out.println();
        }
    }
}