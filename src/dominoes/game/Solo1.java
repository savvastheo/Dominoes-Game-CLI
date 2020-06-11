package dominoes.game;

/**
 * @author Savvas Theofilou
 * Αυτή η μέθοδος περιέχει την λογική της έκδοσης "Solo 1"
 */
public class Solo1 {
    private final String language;
    private final UserInterface user_interface;
    
    /**
     * Ο constructor της κλάσης
     * @param language η γλώσσα του παιχνιδιού
     */
    public Solo1(String language){
        this.language=language;
        user_interface=new UserInterface(this.language);
    }
    
    /**
     * Με αυτή τη μέθοδο θα ξεκινά το παιχνίδι
     */
    public void startGame(){
        Tiles table=new Tiles(0,0);     //Με το table θα γίνεται ο έλεγχος αν μπορεί να τοποθετήσει πλακίδια ο παίκτης
        int choice,amountOfTiles=28; 
        int row[]=new int[4]; //Πίνακας που περιέχει πόσα πλακίδια έχει κάθε γραμμή(βοηθά για έλεγχο)
        short takenFromRow[]=new short[4]; //Πίνακας που περιέχει πόσα πλακίδια διάλεξε ο χρήστης από κάθε γραμμή(βοηθά για έλεγχο)
        short tilesInHand=0,tilesTakenTemp=0;
        Rules check=new Rules();      //Το αντικείμενο με το οποίο θα γίνονται οι έλεγχοι
        boolean flag=false,firstTile=true,win=false,lose=false;
        for (int i=0;i<4;i++){
            row[i]=amountOfTiles/4;
            takenFromRow[i]=0;
        }
        Player player=new Player(); //Το αντικείμενο-χρήστης
        StackTiles availableTiles=new StackTiles();     //Τα πλακίδια τα οποία θα μπορεί να τοποθετήσει ο χρήστης
        StackTiles stackOfTilesInTable=new StackTiles();        //Τα 28 πλακίδια από τα οποία θα παίρνει ο χρήστης
        stackOfTilesInTable.createTableSolo1();
        stackOfTilesInTable.shuffleTiles();
        StackTiles stackOfTilesPlaced=new StackTiles();     //Τα πλακίδια που τοποθέτησε ο χρήστης
        do{
            user_interface.showAvailableTilesMessage();
            stackOfTilesInTable.showTableTiles(row[0],row[1],row[2],row[3]);
            System.out.println();
            while(flag==false){
                for (int i=0;i<4;i++){ //Επιλογή πλακιδίων από κάθε γραμμή
                    short tilesTaken=user_interface.getTilesFromRow(row[i],i+1,tilesInHand);
                    takenFromRow[i]=tilesTaken;
                    tilesInHand+=tilesTaken;
                    if (tilesInHand==4){
                        break;
                    }
                }
                if ((takenFromRow[0]+takenFromRow[1]+takenFromRow[2]+takenFromRow[3])<4){ //Έλεγχος αν διάλεξε πιο λίγα από 4 πλακίδια
                    System.out.println();
                    user_interface.showNeed4TilesMessage();
                    user_interface.showAvailableTilesMessage();
                    stackOfTilesInTable.showTableTiles(row[0],row[1],row[2],row[3]);
                    System.out.println();
                    for (int i=0;i<4;i++){
                        takenFromRow[i]=0;
                    }
                }
                else{
                    flag=true;
                }
                tilesInHand=0;
            }
            tilesTakenTemp=takenFromRow[0];
            for (int j=0;j<tilesTakenTemp;j++){ //Στα επόμενα 4 for γίνεται ανάλογα από που πήρε πλακίδια ο χρήστης η κατάλληλη προσθήκη και αφαίρεση
                player.stackOfTiles.tilesList.add(stackOfTilesInTable.tilesList.get(row[0]-takenFromRow[0]));
                stackOfTilesInTable.tilesList.remove(row[0]-takenFromRow[0]);
                takenFromRow[0]--;
                row[0]--;
            }
            tilesTakenTemp=takenFromRow[1];
            for (int j=0;j<tilesTakenTemp;j++){
                player.stackOfTiles.tilesList.add(stackOfTilesInTable.tilesList.get(row[0]+row[1]-takenFromRow[1]));
                stackOfTilesInTable.tilesList.remove(row[0]+row[1]-takenFromRow[1]);
                takenFromRow[1]--;
                row[1]--;
            }
            tilesTakenTemp=takenFromRow[2];
            for (int j=0;j<tilesTakenTemp;j++){
                player.stackOfTiles.tilesList.add(stackOfTilesInTable.tilesList.get(row[0]+row[1]+row[2]-takenFromRow[2]));
                stackOfTilesInTable.tilesList.remove(row[0]+row[1]+row[2]-takenFromRow[2]);
                takenFromRow[2]--;
                row[2]--;
            }
            tilesTakenTemp=takenFromRow[3];
            for (int j=0;j<tilesTakenTemp;j++){
                player.stackOfTiles.tilesList.add(stackOfTilesInTable.tilesList.get(row[0]+row[1]+row[2]+row[3]-takenFromRow[3]));
                stackOfTilesInTable.tilesList.remove(row[0]+row[1]+row[2]+row[3]-takenFromRow[3]);
                takenFromRow[3]--;
                row[3]--;
            }
            System.out.println();
            user_interface.showSelectedTiles(player.stackOfTiles);
            for (int i=0;i<4;i++){
                takenFromRow[i]=0;
            }
            flag=false;
            int bothside=0,side=0;
                for(int i=0;i<4 && lose==false;i++){
                    if (firstTile==true){ //Αν τοποθετά το πρώτο πλακίδιο 
                        choice=user_interface.chooseTile(4);
                        table.setLeft(player.stackOfTiles.tilesList.get(choice-1).getLeft());
                        table.setRight(player.stackOfTiles.tilesList.get(choice-1).getRight());
                        player.stackOfTiles.removeTile(choice-1);
                        Tiles temp=new Tiles(table.getLeft(),table.getRight());
                        stackOfTilesPlaced.addTile(temp);
                        user_interface.showTilesPlaced(stackOfTilesPlaced);
                        firstTile=false;
                        i++;
                    }
                    if (check.areAvailableTiles(player.stackOfTiles.tilesList, table)){
                        availableTiles.tilesList=check.FindTilesSolo1(player.stackOfTiles.tilesList, table);
                        user_interface.showTilesCanBePlaced(availableTiles);
                        choice=user_interface.chooseTile(availableTiles.tilesList.size());
                        if (check.bothSide(availableTiles.tilesList.get(choice-1), table)){ 
                            bothside=user_interface.showChooseSideMessage();
                            if (bothside==1){
                                check.whoBothSide(table, availableTiles.tilesList.get(choice-1), bothside);
                            }
                            else{
                                check.whoBothSide(table, availableTiles.tilesList.get(choice-1), bothside);
                            }
                        }
                        else{
                            side=check.whoSide(table, availableTiles.tilesList.get(choice-1));
                        }
                        if (bothside==1 || side==1){
                            table.setLeft(availableTiles.tilesList.get(choice-1).getLeft());
                            stackOfTilesPlaced.tilesList.add(0, availableTiles.tilesList.get(choice-1));
                        }
                        else{
                            table.setRight(availableTiles.tilesList.get(choice-1).getRight());
                            stackOfTilesPlaced.tilesList.add(availableTiles.tilesList.get(choice-1));
                        }
                        check.deletePlacedTile(availableTiles.tilesList.get(choice-1), player.stackOfTiles.tilesList);
                        availableTiles.tilesList.clear();
                        user_interface.showTilesPlaced(stackOfTilesPlaced);
                    }
                    else{
                        lose=true;
                        user_interface.showLoseMessage();
                    }
                }
                if (stackOfTilesInTable.isEmpty() && player.stackOfTiles.isEmpty()){
                    win=true;
                    user_interface.showWinMessage();
                }
        }
        while(lose==false && win==false);
    }
}
