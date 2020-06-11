package dominoes.game;

/**
 * @author Savvas Theofilou
 * Η κλάση Tiles αναπαριστά ένα πλακίδιο που χρησιμοποιήται για το παιχνίδι
 * Μεταβλητές: left συμβολίζει τον αριστερό αριθμό που έχει το πλακίδιο, right συμβολίζει τον δεξιό αριθμό που έχει το πλακίδιο
 */
public class Tiles {
    private int  left,right; 
      
    /**
     * Constructor της κλάσης
     * @param left Ο αριστερός αρθμός του πλακιδίου
     * @param right Ο δεξιός αριθμός του πλακιδιου
     */
    public Tiles(int left,int right){
        this.left=left;
        this.right=right;
    }
     
    /**
    * Μέθοδος που επιστρέφει τον αριστερό αριθμό του πλακιδίου
    *@return left
    */
    public int getLeft(){
        return left;
    }
      
    /**
    * Μέθοδος που επιστρέφει το δεξιό αριθμό του πλακιδίου
    *@return right
    */
    public int getRight(){
       return right;
    }
     
    /**
    * Μέθοδος που αλλάζει τον αριστερό αριθμό του πλακιδίου
    *@param leftNum νέος αριστερός αριθμός
    */
    public void setLeft(int leftNum){
        left=leftNum;
    }
     
    /**
    * Μέθοδος που αλλάζει τον δεξιό αριθμό του πλακιδίου
    *@param  rightNum νέος δεξιός αριθμός
    */
    public void setRight(int rightNum){
       right=rightNum;
    }
    
    /**
    * Μέθοδος εκτύπωσης πλακιδίου  
    */
    public void showTile(){
        System.out.print(getLeft()+ "|"+getRight());
    }
   
    /**
    * Μέθοδος που προσθέτει τον αριστερό και δεξιό αριθμό του πλακιδίου
    * @return left+right
    */
    public int tilePlusNum(){
        return (left+right);
    }
    
    /**
    * Μέθοδος που αλλάζει τη θέση του αριστερού με το δεξιό αριθμό
    */
    public void swapTile(){
        int temp;
        temp=right;
        right=left;
        left=temp;
    }
}