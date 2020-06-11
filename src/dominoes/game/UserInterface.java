package dominoes.game;

import java.util.Scanner;
import java.lang.Thread;

/**
 * @author Savvas Theofilou
 * Η κλάση αυτή αντιπροσωπεύει τη γραφική διασύνδεση του χρήστη με το πρόγραμμα.
 * Τα μηνύματα τυπώνονται σε Αγγλική γλώσσα ή Ελληνική ανάλογα με την επιλογή του χρήστη.
 */
public class UserInterface {
    private String language; //Γλώσσα του παιχνιδιού
    private final Scanner scanner;  //Αντικείμενο Scanner με το οποίο θα γίνονται εισαγωγές από τον χρήστη
    private GameVersions game_version; //Αντικείμενο GameVersions με το οποίο θα καλείται η ανάλογη μέθοδος για την ανάλογη έκδοση
    
    /**
     * Constructor της κλάσης
     */
    public UserInterface(){
        scanner=new Scanner(System.in);
        language="No language";
    }
    
    /**
     * Constructor με όρισμα γλώσσας
     * @param language η γλώσσα του παιχνιδιού
     */
    public UserInterface(java.lang.String language){
        scanner=new Scanner(System.in);
        this.language=language;
    }
    
    /**
     * Μέθοδος με την οποία θα ξεκινήσει η διασύνδεση του χρήστη με το πρόγραμμα.
     * Με αυτή τη μέθοδο θα επιλεχθεί η γλώσσα του παιχνιδιού και η εκδοχή του παιχνιδιού.
     */
    public void start(){
        short version=0,choice=0;
        showWelcomeMessage();
        do{
            System.out.print("Choose language/Διάλεξε γλώσσα (English/Greek): ");
            language=scanner.nextLine();
            if (!language.equals("English") && !language.equals("Greek") && !language.equals("english") && !language.equals("greek")){
                System.out.println("Wrong Input!/Λάθος εισαγωγή!");
                System.out.println();
            }
        }
        while(!language.equals("English") && !language.equals("Greek") && !language.equals("english") && !language.equals("greek"));
        System.out.println();
        do{if (language.equals("English") || language.equals("english")){
            System.out.printf("Versions of the game:\n1.Solo 1\n2.Hungarian\n3.Cardinal\n\n");
            do{
                System.out.print("Choose version of the game(1/2/3): ");
                version=scanner.nextShort();
                if (version!=1 && version!=2 && version!=3){
                    System.out.println("Wrong Input!");
                }
            }
            while(version!=1 && version!=2 && version!=3);
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.printf("Εκδοχές του παιχνιδιού:\n1.Solo 1\n2.Ουγγρικό\n3.Όλα 7\n\n");
            do{
                System.out.print("Διάλεξε εκδοχή του παιχνιδιού(1/2/3): ");
                version=scanner.nextShort();
                if (version!=1 && version!=2 && version!=3){
                    System.out.println("Λάθος εισαγωγή!");
                }
            }
            while(version!=1 && version!=2 && version!=3);
        }
        switch (version){
            case 1: if (language.equals("English") || language.equals("english")){
                        System.out.printf("\n\nYou chose Solo 1!\n\n");
                    }
                    else{
                        System.out.printf("\n\nΕπέλεξες Solo 1!\n\n");
                    }
                    game_version=new GameVersions("Solo 1",language);
                    game_version.startSolo1();
                    break;
            case 2: if (language.equals("English") || language.equals("english")){
                        System.out.printf("\n\nYou chose Hungarian!\n\n");
                    }
                    else{
                        System.out.printf("\n\nΕπέλεξες Ουγγρικό!\n\n");
                    }
                    game_version=new GameVersions("Hungarian",language);
                    game_version.startHungarian();
                    break;
            case 3: if (language.equals("English") || language.equals("english")){
                        System.out.printf("\n\nYou chose Cardinal!\n\n");
                    }
                    else{
                        System.out.printf("\n\nΕπέλεξες Όλα 7!\n\n");
                    }
                    game_version=new GameVersions("Cardinal",language);
                    game_version.startCardinal();
                    break;
            case 0: System.out.printf("\nError\n");
                    break;
        }
        System.out.printf("\n\n\n");
        if (language.equals("English") || language.equals("english")){
            do{
                System.out.print("How do you wish to continue?(1.Return back to main menu/2.Exit game): ");
                choice=scanner.nextShort();
                if (choice!=1 && choice!=2){
                    System.out.println("Wrong Input!");
                    System.out.println();
                }
            }
            while (choice!=1 && choice!=2);
        }
        else if (language.equals("Greek") || language.equals("greek")){
            do{
                System.out.print("Πως θα ήθελες να συνεχίσεις?(1.Επιστροφή στο κυρίως μενού/2.Έξοδος παιχνιδιού): ");
                choice=scanner.nextShort();
                if (choice!=1 && choice!=2){
                    System.out.println("Λάθος εισαγωγή!");
                    System.out.println();
                }
            }
            while (choice!=1 && choice!=2);
        }
            System.out.println();
        }
        while(choice!=2);
        System.out.printf("\n\n");
        showThankYouForPlayingMessage();
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα κατάλληλα μηνύματα και διαβάζει από το χρήστη πόσοι παίκτες θα παίξουν
     * @return αριθμός των παικτών
     */
    public short howManyPlayers(){
        short players=0;
        if (language.equals("English") || language.equals("english")){
            do{
                System.out.print("How many players?(2/3/4): ");
                players=scanner.nextShort();
                if (players!=2 && players!=3 && players!=4){
                    System.out.println("Wrong Input!");
                    System.out.println();
                }
            }
            while(players!=2 && players!=3 && players!=4);
            System.out.println();
            return players;
        }
        if (language.equals("Greek") || language.equals("greek")){
            do{
                System.out.print("Πόσοι παίκτες?(2/3/4): ");
                players=scanner.nextShort();
                if (players!=2 && players!=3 && players!=4){
                    System.out.println("Λάθος εισαγωγή!");
                    System.out.println();
                }
            }
            while(players!=2 && players!=3 && players!=4);
            System.out.println();
            return players;
        }
        return players;
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα κατάλληλα μηνύματα και διαβάζει από το χρήστη ποιο πλακίδιο θέλει να τοποθετήσει
     * @param numberOfTiles αριθμός πλακακίων που είναι διαθέσιμα
     * @return αριθμός πλακακιού που διάλεξε ο χρήστης
     */
    public int chooseTile(int numberOfTiles){
        int numberOfTile=0;
        if (language.equals("English") || language.equals("english")){
            do{
                System.out.print("Give the number of the tile you want to place: ");
                numberOfTile=scanner.nextInt();
                if (numberOfTile>numberOfTiles || numberOfTile<1){
                    System.out.println("Wrong input!");
                    System.out.println();
                }
            }
            while(numberOfTile>numberOfTiles || numberOfTile<1);
            System.out.println();
            System.out.println();
            return numberOfTile;
        }
        if (language.equals("Greek") || language.equals("greek")){
            do{
                System.out.print("Δώσε τον αριθμό του πλακιδίου που θες να τοποθετήσεις: ");
                numberOfTile=scanner.nextInt();
                if (numberOfTile>numberOfTiles || numberOfTile<1){
                    System.out.println("Λάθος εισαγωγή!");
                    System.out.println();
                }
            }
            while(numberOfTile>numberOfTiles || numberOfTile<1);
            System.out.println();
            System.out.println();
            return numberOfTile;
        }
        return numberOfTile;
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα κατάλληλα μηνύματα και επιστρέφει τον αριθμό τον πλακιδίων που διάλεξε ο παίχτης από μια συγκεκριμένη σειρά
     * @param numberOfTilesInRow πόσα πλακίδια έχει η σειρά
     * @param rowNumber αριθμός της σειράς
     * @param tilesInHand πόσα πλακίδια έχει ο παίκτης στο χέρι του
     * @return πόσα πλακίδια διάλεξε ο παίκτης από τη σειρά
     */
    public short getTilesFromRow(int numberOfTilesInRow,int rowNumber,int tilesInHand){
        short tilesSelected=0;
        boolean flag;
        if (language.equals("English") || language.equals("english")){
            do{
                flag=true;
                do{
                    System.out.printf("How many tiles do you want from row %d: ",rowNumber);
                    tilesSelected=scanner.nextShort();
                    if (tilesSelected<0){
                        System.out.println("Wrong Input!");
                        System.out.println();
                    }
                }
                while(tilesSelected<0);
                if ((tilesSelected+tilesInHand)>4){
                    System.out.printf("You can't select more than 4 tiles! (You have %d in your hand)\n\n",tilesInHand);
                    flag=false;
                }
                if (tilesSelected>numberOfTilesInRow){
                    System.out.printf("You can't take %d tiles from row %d!\n\n",tilesSelected,rowNumber);
                    flag=false;
                }
            }
            while(flag==false);
            return tilesSelected;
        }
        if (language.equals("Greek") || language.equals("greek")){
            do{
                flag=true;
                do{
                    System.out.printf("Πόσα πλακίδια θες να πάρεις από την γραμμή %d: ",rowNumber);
                    tilesSelected=scanner.nextShort();
                    if (tilesSelected<0){
                        System.out.println("Λάθος εισαγωγή!");
                        System.out.println();
                    }
                }
                while(tilesSelected<0);
                if ((tilesSelected+tilesInHand)>4){
                    System.out.printf("Δεν μπορείς να πάρεις πάνω από 4 πλακίδια! (Έχεις %d στο χέρι σου)\n\n",tilesInHand);
                    flag=false;
                }
                if (tilesSelected>numberOfTilesInRow){
                    System.out.printf("Δεν μπορείς να πάρεις %d πλακίδια από τη γραμμή %d!\n\n",tilesSelected,rowNumber);
                    flag=false;
                }
            }
            while(flag==false);
            return tilesSelected;
        }
        return tilesSelected;
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει στην οθόνη ποιά πλακίδια επέλεξε ο χρήστης
     * @param tilesToBeShown τα πλακίδια που διάλεξε ο παίκτης
     */
    public void showSelectedTiles(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("You have selected the following tiles: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Διάλεξες τα ακόλουθα πλακίδια: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            System.out.println();
            return;
        } 
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Διαθέσιμα πλακίδια"
     * Τυπώνεται στο Solo 1 όταν εμφανίζουμε τα πλακάκια από τα οποία μπορεί να επιλέξει ο παίκτης
     */
    public void showAvailableTilesMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Available tiles\n");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Διαθέσιμα πλακίδια\n");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Πρέπει να διαλέξεις 4 πλακίδια"
     * Τυπώνεται όταν ο χρήστης διαλέξει πιο λίγα από 4 πλακίδια στο Solo 1
     */
    public void showNeed4TilesMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You must select 4 tiles!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Πρέπει να διαλέξεις 4 πλακίδια!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα κατάλληλα μηνύματα, διαβάζει από το χρήστη σε ποιά πλευρά θέλει να τοποθετήσει
     * το πλακίδιο και επιστέφει τον ανάλογο ακέραιο
     * @return 1 για αριστερά, 2 για δεξιά
     */
    public int showChooseSideMessage(){
        int choice=0;
        if (language.equals("English") || language.equals("english")){
            do{
                System.out.print("Choose side(1.Left/2.Right): ");
                choice=scanner.nextInt();
                if (choice!=1 && choice!=2){
                    System.out.println("Wrong Input!");
                    System.out.println();
                }
            }
            while(choice!=1 && choice!=2);
            System.out.println();
            return choice;
        }
        if (language.equals("Greek") || language.equals("greek")){
            do{
                System.out.print("Διάλεξε πλευρά(1.Αριστερά/2.Δεξιά): ");
                choice=scanner.nextInt();
                if (choice!=1 && choice!=2){
                    System.out.println("Wrong Input!");
                    System.out.println();
                }
            }
            while(choice!=1 && choice!=2);
            System.out.println();
            return choice;
        }
        return choice;
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα στο χρήστη ότι έχασε
     */
    public void showLoseMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You can't place any more tiles! You lose!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Δεν μπορείς να τοποθετήσεις άλλα πλακίδια! Έχασες!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ποια πλακίδια μπορεί να τοποθετήσει ο χρήστης(με τη βοήθεια της showTilesList())
     * @param tilesToBeShown αντικείμενο StackTiles το οποίο περιέχει τα πλακίδια
     */
    public void showTilesCanBePlaced(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Tiles that can be placed: ");
            tilesToBeShown.showTilesList();
            System.out.printf("\n\n\n");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Πλακίδια που μπορούν να τοποθετηθούν: ");
            tilesToBeShown.showTilesList();
            System.out.printf("\n\n\n");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ποια πλακίδια έχουν τοποθετηθεί στο τραπέζι(με τη βοήθεια της showTilesList)
     * @param tilesToBeShown αντικείμενο StackTiles το οποίο περιέχει τα πλακίδια
     */
    public void showTilesPlaced(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Tiles placed on the table: ");
            tilesToBeShown.showTilesListWithoutI();
            System.out.printf("\n\n");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Πλακίδια που τοποθετήθηκαν στο τραπέζι: ");
            tilesToBeShown.showTilesListWithoutI();
            System.out.printf("\n\n");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα στο χρήστη ότι νίκησε
     */
    public void showWinMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You placed all your tiles! You Win!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Τοποθέτησες όλα τα πλακίδια σου! Κέρδισες!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα πλακίδια που παρέλαβε ο χρήστης από τη στοίβα(με τη βοήθεια της showTilesList())
     * @param tilesToBeShown τα πλακίδια που παρέλαβε
     */
    public void showReceivedTilesMessage(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("You received the following tiles: ");
            tilesToBeShown.showTilesList();
            System.out.printf("\n\n\n");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Παρέλαβες τα ακόλουθα πλακίδια: ");
            tilesToBeShown.showTilesList();
            System.out.printf("\n\n\n");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ποιος αντίπαλος παίζει.
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showOpponentPlayingMessage(int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            switch (opponentNumber){
                case 0: System.out.println("Your opponent is playing..");
                        System.out.println();
                        break;
                case 1: System.out.println("Opponent1 is playing..");
                        System.out.println();
                        break;
                case 2: System.out.println("Opponent2 is playing..");
                        System.out.println();
                        break;
                case 3: System.out.println("Opponent3 is playing..");
                        System.out.println();
                        break;
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            switch (opponentNumber){
                case 0: System.out.println("Παίζει ο αντίπαλος σου..");
                        System.out.println();
                        break;
                case 1: System.out.println("Παίζει ο αντίπαλος1..");
                        System.out.println();
                        break;
                case 2: System.out.println("Παίζει ο αντίπαλος2..");
                        System.out.println();
                        break;
                case 3: System.out.println("Παίζει ο αντίπαλος3..");
                        System.out.println();
                        break;
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Ο αντίπαλος σου σκέφτεται" και καθυστερά μερικά δευτερόλεπτα
     */
    public void showThinkingMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("Your opponent is thinking..");
            System.out.println();
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){}
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Ο αντίπαλος σου σκέφτεται..");
            System.out.println();
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){}
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι ο πρώτος που παίζει είναι ο χρήστης
     */
    public void showYouPlayFirstMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You play first!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Παίζεις πρώτος!");
            System.out.println();
            return;
        }
    }
    
    
    /**
     * Αυτή η μέθοδος τυπώνει ποιος αντίπαλος παίζει πρώτος
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showWhoPlaysFirstOpponent(int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.println("Your opponent plays first!");
                System.out.println();
            }
            else{
                System.out.println("Opponent" + opponentNumber + " plays first!");
                System.out.println();
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.println("Ο αντίπαλος σου παίζει πρώτος!");
                System.out.println();
            }
            else{
                System.out.println("Ο αντίπαλος" + opponentNumber + " παίζει πρώτος!");
                System.out.println();
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το πλακίδιο που τοποθέτησε ο αντίπαλος του χρήστη
     * @param placedTile το πλακίδιο που τοποθέτησε ο αντίπαλος του χρήστη
     */
    public void showOpponentPlaced(Tiles placedTile){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Your opponent placed ");
            placedTile.showTile();
            System.out.println();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Ο αντίπαλος τοποθέτησε το ");
            placedTile.showTile();
            System.out.println();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι ο αντίπαλος δεν μπορεί να τοποθετήσει άλλα πλακίδια
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showOpponentCantPlace(int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            switch (opponentNumber){
                case 0: System.out.println("Your opponent can't place more tiles..");
                        System.out.println();
                        System.out.println();
                        break;
                case 1: System.out.println("Opponent1 can't place more tiles..");
                        System.out.println();
                        System.out.println();
                        break;
                case 2: System.out.println("Opponent2 can't place more tiles..");
                        System.out.println();
                        System.out.println();
                        break;
                case 3: System.out.println("Opponent3 can't place more tiles..");
                        System.out.println();
                        System.out.println();
                        break;
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            switch (opponentNumber){
                case 0: System.out.println("Ο αντίπαλος σου δεν μπορεί να τοποθετήσει άλλα πλακίδια..");
                        System.out.println();
                        System.out.println();
                        break;
                case 1: System.out.println("Ο αντίπαλος1 δεν μπορεί να τοποθετήσει άλλα πλακίδια..");
                        System.out.println();
                        System.out.println();
                        break;
                case 2: System.out.println("Ο αντίπαλος2 δεν μπορεί να τοποθετήσει άλλα πλακίδια..");
                        System.out.println();
                        System.out.println();
                        break;
                case 3: System.out.println("Ο αντίπαλος3 δεν μπορεί να τοποθετήσει άλλα πλακίδια..");
                        System.out.println();
                        System.out.println();
                        break;
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι ο χρήστης δεν μπορεί να τοποθετήσει άλλα πλακίδια
     */
    public void showYouCantPlaceMore(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You can't place any more tiles!");
            System.out.println();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Δεν μπορείς να τοποθετήσεις άλλα πλακίδια!");
            System.out.println();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα πλακίδια που έχει ο χρήστης στο χέρι του
     * @param tilesToBeShown τα πλακίδια που έχει ο χρήστης στο χέρι του
     */
    public void showTilesInHand(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Tiles in your hand: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Πλακίδια που έχεις στο χέρι σου: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα πλακίδια που τοποθέτησε ο χρήστης
     * @param tilesToBeShown τα πλακίδια που τοποθέτησε ο χρήστης
     */
    public void showPlacedFollowingTiles(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("You placed the following tiles: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Τοποθέτησες τα ακόλουθα πλακίδια: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τα πλακίδια που τοποθέτησε ο αντίπαλος
     * @param tilesToBeShown τα πλακίδια που τοποθέτησε ο αντίπαλος
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showPlacedFollowingTilesOpponent(StackTiles tilesToBeShown,int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.print("Your opponent placed the following tiles: ");
            }
            else{
                System.out.print("Opponent" + opponentNumber + " placed the following tiles: ");
            }
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.print("Ο αντίπαλος σου τοποθέτησε τα ακόλουθα πλακίδια: ");
            }
            else{
                System.out.print("Ο αντίπαλος" + opponentNumber + " τοποθέτησε τα ακόλουθα πλακίδια: ");
            }
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει πόσα πλακίδια έμειναν στο χέρι του αντίπαλου
     * @param tilesToBeShown τα πλακίδια που έμειναν στο χέρι του
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showTilesInHandOpponent(StackTiles tilesToBeShown,int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.print("Tiles left in your opponent's hand: ");
            }
            else{
                System.out.print("Tiles left in opponent" + opponentNumber + " hand: ");
            }
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.print("Πλακίδια που έμειναν στο χέρι του αντίπαλου σου: ");
            }
            else{
                System.out.print("Πλακίδια που έμειναν στο χέρι του αντίπαλου" + opponentNumber + ": ");
            }
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει πόσα πλακίδια έμειναν στο χέρι του χρήστη
     * @param tilesToBeShown τα πλακίδια που έμειναν στο χέρι του
     */
    public void showTilesLeftInHand(StackTiles tilesToBeShown){
        if (language.equals("English") || language.equals("english")){
            System.out.print("Tiles left in your hand: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.print("Πλακίδια που έμειναν στο χέρι σου: ");
            tilesToBeShown.showTilesList();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει πόσους πόντους έχει στο χέρι του ο χρήστης
     * @param points οι πόντοι που έχει στο χέρι του
     */
    public void showTotalPointsInHand(int points){
        if (language.equals("English") || language.equals("english")){
            System.out.println("Total points in your hand: " + points);
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Σύνολο βαθμών που έχεις στο χέρι σου: " + points);
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει πόσους πόντους έχει στο χέρι του ο αντίπαλος
     * @param points οι πόντοι που έχει στο χέρι του
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showTotalPointsInHandOpponent(int points,int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.println("Total points in your opponent's hand: " + points);
            }
            else{
                System.out.println("Total points in opponent" + opponentNumber + " hand: " + points);
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.println("Σύνολο βαθμών που έχει ο αντίπαλος σου στο χέρι του: " + points);
            }
            else{
                System.out.println("Σύνολο βαθμών που έχει ο αντίπαλος" + opponentNumber + " στο χέρι του: " + points);
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει στο χρήστη ένα μήνυμα ότι κέρδισε το γύρο και πόσους πόντους κέρδισε
     * @param pointsWon οι πόντοι που κέρδισε 
     */
    public void showWinnerOfSetMessage(int pointsWon){
        if (language.equals("English") || language.equals("english")){
            System.out.println("You are the winner of the set! You 've earned " + pointsWon + " points!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Είσαι ο νικητής αυτού του γύρου! Κέρδισες " + pointsWon + " πόντους!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα στο χρήστη ότι ο αντίπαλος του νίκησε το γύρο και πόσους πόντους κέρδισε
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     * @param pointsWon οι πόντοι που κέρδισε
     */
    public void showWinnerOfSetOpponentMessage(int opponentNumber,int pointsWon){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.println("Your opponent is the winner of this set! Your opponent has earned " + pointsWon + " points!");
            }
            else{
                System.out.println("Opponent" + opponentNumber + " is the winner of this set! " + "Opponent" + opponentNumber + " has earned " + pointsWon + " points!");
            }
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.println("Ο αντίπαλος σου είναι ο νικητής αυτού του γύρου! Ο αντίπαλος σου κέρδισε " + pointsWon + " πόντους!");
            }
            else{
                System.out.println("Ο αντίπαλος" + opponentNumber + " είναι ο νικητής αυτού του γύρου! " + "Ο αντίπαλος" + opponentNumber + " κέρδισε " + pointsWon + " πόντους!");
            }
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Domino!" και ότι ο χρήστης τοποθέτησε όλα του τα πλακίδια
     */
    public void showDominoMessageEndOfRound(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("\"Domino!\"");
            System.out.println("You have placed all your tiles!");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("\"Domino!\"");
            System.out.println("Τοποθέτησες όλα τα πλακίδια σου!");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Domino!" και ότι ο αντίπαλος τοποθέτησε όλα του τα πλακίδια
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showDominoMessageEndOfRoundOpponent(int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            if (opponentNumber==0){
                System.out.println("\"Domino!\"");
                System.out.println("Your opponent placed all his tiles!");
            }
            else{
                System.out.println("\"Domino!\"");
                System.out.println("Opponent" + opponentNumber + " placed all his tiles!");
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            if (opponentNumber==0){
                System.out.println("\"Domino!\"");
                System.out.println("Ο αντίπαλος σου τοποθέτησε όλα τα πλακίδια του!");
            }
            else{
                System.out.println("\"Domino!\"");
                System.out.println("Ο αντίπαλος" + opponentNumber + " τοποθέτησε όλα τα πλακίδια του!");
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει τους συνολικούς βαθμούς του κάθε παίκτη
     * @param pointsOfPlayers πίνακας με τους συνολικούς βαθμούς του κάθε παίκτη
     * @param players πόσοι παίκτες παίζουν 
     */
    public void showTotalPointsOfPlayers(int pointsOfPlayers[],int players){
        if (language.equals("English") || language.equals("english")){
            System.out.println("Total points");
            System.out.println("Your points: " + pointsOfPlayers[0]);
            if (players==2){
                System.out.println("Your opponent's points: " + pointsOfPlayers[1]);
            }
            else{
                for (int i=1;i<players;i++){
                    System.out.println("Opponent" + i + " points: " + pointsOfPlayers[i]);
                }
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Συνολικοί πόντοι");
            System.out.println("Οι πόντοι σου: " + pointsOfPlayers[0]);
            if (players==2){
                System.out.println("Οι πόντοι του αντίπαλου σου: " + pointsOfPlayers[1]);
            }
            else{
                for (int i=1;i<players;i++){
                    System.out.println("Οι πόντοι του αντίπαλου" + i + " : " + pointsOfPlayers[i]);
                }
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι ξεκινά νέος γύρος
     */
    public void showNewRoundMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("New round starts in");
            for (int i=3;i>=1;i--){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){}
            }
            System.out.println();
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Νέος γύρος ξεκινά σε");
            for (int i=3;i>=1;i--){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){}
            }
            System.out.println();
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι το παιχνίδι τελείωσε και ότι νικητής είναι ο χρήστης
     */
    public void showWinnerMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("End of game!");
            System.out.println("Congratulations! You win!");
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Τέλος παιχνιδιού!");
            System.out.println("Συγχαρητήρια! Κέρδισες!");
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι το παιχνίδι τελείωσε και ότι νικητής είναι ο αντίπαλος
     * @param opponentNumber ο αριθμός του αντιπάλου(για έναν αντίπαλο ο αριθμός ισούται με μηδέν)
     */
    public void showWinnerOfGameOpponent(int opponentNumber){
        if (language.equals("English") || language.equals("english")){
            System.out.println("End of game!");
            if (opponentNumber==0){
                System.out.println("Too bad! You lose!");
            }
            else{
                    System.out.println("Too bad! You lose!");
                    System.out.println("Opponent" + opponentNumber + " wins!");
            }
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Τέλος παιχνιδιού!");
            if (opponentNumber==0){
                System.out.println("Κρίμα! Έχασες!");
            }
            else{
                    System.out.println("Κρίμα! Έχασες!");
                    System.out.println("Ο αντίπαλος" + opponentNumber + " είναι ο νικητής!");
            }
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει το μήνυμα "Welcome to Dominoes!" με ASCII χαρακτήρες
     */
    private void showWelcomeMessage(){
        System.out.println(" _       __     __                             __           ____                  _                       __");
        System.out.println("| |     / /__  / /________  ____ ___  ___     / /_____     / __ \\____  ____ ___  (_)___  ____  ___  _____/ /");
        System.out.println("| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / / / / __ \\/ __ `__ \\/ / __ \\/ __ \\/ _ \\/ ___/ / ");
        System.out.println("| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /_/ / /_/ / / / / / / / / / / /_/ /  __(__  )_/  ");
        System.out.println("|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/  /_____/\\____/_/ /_/ /_/_/_/ /_/\\____/\\___/____(_)   ");
        System.out.println("                                                                                                            ");
        System.out.println();
        System.out.println();
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα αποχαιρετιστήριο μήνυμα στο χρήστη
     */
    private void showThankYouForPlayingMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("Thank you for playing! See you soon!");
            System.out.print("Exiting..");
            try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){}
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Ευχαριστούμε που έπαιξες! Τα λέμε!");
            System.out.print("Γίνεται έξοδος..");
            try{
                    Thread.sleep(2000);
                }
                catch (InterruptedException e){}
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι η εκδοχή δεν είναι διαθέσιμη προς το παρόν(για το Όλα 7)
     */
    public void showNotAvailableVersion(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("This version is not available yet!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Αυτή η εκδοχή δεν είναι διαθέσιμη προς το παρόν!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι η εκδοχή δεν είναι διαθέσιμη προς το παρόν για συγκεκριμένους παίκτες(για το Ουγγρικό)
     */
    public void showNotAvailableVersionPlayers(short players){
        if (language.equals("English") || language.equals("english")){
            System.out.println("This version is not available for " + players +" players yet (Only for 2)!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Αυτή η εκδοχή δεν είναι διαθέσιμη για " + players +" παίκτες προς το παρόν (Μόνο για 2)!");
            System.out.println();
            return;
        }
    }
    
    /**
     * Αυτή η μέθοδος τυπώνει ένα μήνυμα ότι ο γύρος έλειξε ισοπαλία
     */
    public void showTieMessage(){
        if (language.equals("English") || language.equals("english")){
            System.out.println("The round is a tie! Nobody earns points!");
            System.out.println();
            return;
        }
        if (language.equals("Greek") || language.equals("greek")){
            System.out.println("Ο γύρος έλειξε ισοπαλία! Κανένας δεν κέρδισε πόντους!");
            System.out.println();
            return;
        }
    }
}

    

