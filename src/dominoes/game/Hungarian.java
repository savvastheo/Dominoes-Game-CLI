package dominoes.game;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author Savvas Theofilou
 * Αυτή η μέθοδος περιέχει την λογική της έκδοσης "Ουγγρικό"
 */
public class Hungarian {
    private final String language;
    private final UserInterface user_interface;
    private final int players;
    
    /**
     * Ο constructor της κλάσης
     * @param language η γλώσσα του παιχνιδιού
     * @param players πόσοι παίκτες θα παίξουν
     */
    public Hungarian(String language,int players){
        this.language=language;
        user_interface=new UserInterface(this.language);
        this.players=players;
    }
    
    /**
     * Με αυτή τη μέθοδο θα ξεκινά το παιχνίδι
     */
    public void startGame(){
        int pointsOfPlayers[]=null;     //Πίνακας που περιέχει τους πόντους του κάθε παίκτη
        int winner;
        Rules check=new Rules();
        switch (players){
            case 2: pointsOfPlayers=new int[2];
                    check.setRounds(4);
                    break;
            case 3: pointsOfPlayers=new int[3];
                    check.setRounds(8);
                    break;
            case 4: pointsOfPlayers=new int[4];
                    check.setRounds(12);
                    break;
        }
        for (int i=0;i<players;i++){
            pointsOfPlayers[i]=0;
        }
        do{
            check.reduceRounds();
            user_interface.showNewRoundMessage();
            startRound(pointsOfPlayers);
        }
        while (!check.endOfGame(pointsOfPlayers));
        winner=check.winnerOfGame(pointsOfPlayers)-1;
        if (winner==0){
            user_interface.showWinnerMessage();
        }
        else{
            if (players==2){
                user_interface.showWinnerOfGameOpponent(0);
            }
            else{
                user_interface.showWinnerOfGameOpponent(winner);
            }
        }
    }
    
    /**
     * Με αυτή τη μέθοδο θα ξεκινά και θα τελειώνει ένας γύρος του παιχνιδιού
     * @param pointsOfPlayers οι πόντοι του κάθε παίκτη σε ένα πίνακα ακεραίων
     */
    private void startRound(int pointsOfPlayers[]){
        Player playersOfGame[]=null;        //Πίνακας που περιέχει τους παίκτες που θα παίζουν
        ArrayList<Tiles> tilesOfPlayers[]=null;        //Πίνακας που περιέχει τα πλακίδια που έχει ο κάθε παίκτης
        StackTiles tilesOfPlayersPlaced[]=null;     //Πίνακας που περιέχει τα πλακίδια που τοποθέτησε ο κάθε παίκτης
        StackTiles availableTiles=new StackTiles();     //Τα πλακίδια τα οποία θα μπορεί να τοποθετήσει ο παίκτης
        StackTiles stackOfTilesInTable=new StackTiles();        //Τα 28 πλακίδια από τα οποία θα παίρνουν τα πλακίδια οι παίκτες
        stackOfTilesInTable.createTableSolo1();
        stackOfTilesInTable.shuffleTiles();
        StackTiles stackOfTilesPlacedOnTable=new StackTiles(); //Η "στοίβα" από τα πλακίδια που τοποθέτησαν οι παίκτες
        Rules check=new Rules();      //Το αντικείμενο με το οποίο θα γίνονται οι έλεγχοι
        int index,winnerOfSet=-1,startingPoint,playersPlayed=0,pointsWon=0;
        boolean first=true,foundWinner=false;
        Tiles tileToAdd,table;
        table=new Tiles(0,0);
        Random random=new Random();
        switch (players){ //Εδώ δεσμεύουμε χώρο ανάλογα με τους παίκτες και ανάλογα γίνεται η κατανομή των πλακιδίων
            case 2: playersOfGame=new Player[2];
                    tilesOfPlayers=new ArrayList[2];
                    tilesOfPlayersPlaced=new StackTiles[2];
                    for (int i=0;i<2;i++){
                        playersOfGame[i]=new Player();
                        for (int j=0;j<12;j++){
                            index=random.nextInt(stackOfTilesInTable.tilesList.size());
                            tileToAdd=new Tiles(stackOfTilesInTable.tilesList.get(index).getLeft(),stackOfTilesInTable.tilesList.get(index).getRight());
                            playersOfGame[i].stackOfTiles.addTile(tileToAdd);
                            stackOfTilesInTable.removeTile(index);
                        }
                    }
                    for (int i=0;i<2;i++){
                        tilesOfPlayers[i]=playersOfGame[i].stackOfTiles.tilesList;
                        tilesOfPlayersPlaced[i]=new StackTiles();
                    }
                    break;
            case 3: playersOfGame=new Player[3];
                    tilesOfPlayers=new ArrayList[3];
                    tilesOfPlayersPlaced=new StackTiles[3];
                    for (int i=0;i<3;i++){
                        playersOfGame[i]=new Player();
                        for (int j=0;j<8;j++){
                            index=random.nextInt(stackOfTilesInTable.tilesList.size());
                            tileToAdd=new Tiles(stackOfTilesInTable.tilesList.get(index).getLeft(),stackOfTilesInTable.tilesList.get(index).getRight());
                            playersOfGame[i].stackOfTiles.addTile(tileToAdd);
                            stackOfTilesInTable.removeTile(index);
                        }
                    }
                    for (int i=0;i<3;i++){
                        tilesOfPlayers[i]=playersOfGame[i].stackOfTiles.tilesList;
                        tilesOfPlayersPlaced[i]=new StackTiles();
                    }
                    break;
            case 4: playersOfGame=new Player[4];
                    tilesOfPlayers=new ArrayList[4];
                    tilesOfPlayersPlaced=new StackTiles[4];
                    for (int i=0;i<4;i++){
                        playersOfGame[i]=new Player();
                        for (int j=0;j<6;j++){
                            index=random.nextInt(stackOfTilesInTable.tilesList.size());
                            tileToAdd=new Tiles(stackOfTilesInTable.tilesList.get(index).getLeft(),stackOfTilesInTable.tilesList.get(index).getRight());
                            playersOfGame[i].stackOfTiles.addTile(tileToAdd);
                            stackOfTilesInTable.removeTile(index);
                        }
                    }
                    for (int i=0;i<4;i++){
                        tilesOfPlayers[i]=playersOfGame[i].stackOfTiles.tilesList;
                        tilesOfPlayersPlaced[i]=new StackTiles();
                    }
                    break;
        }
        startingPoint=check.startFirtst(tilesOfPlayers)-1; //Ποιός παίκτης ξεκινά πρώτος
        user_interface.showReceivedTilesMessage(playersOfGame[0].stackOfTiles);
        if (startingPoint==0){
            user_interface.showYouPlayFirstMessage();
        }
        else{
            if (players==2){
                user_interface.showWhoPlaysFirstOpponent(0);
            }
            else{
                user_interface.showWhoPlaysFirstOpponent(startingPoint);
            }
        }
        for (int i=startingPoint;i<players && playersPlayed<players && foundWinner==false;i++){
            playersPlayed++;
            int tilesInHand=playersOfGame[i].stackOfTiles.tilesList.size(),choice=0;
            boolean lose=false;
            if (i==0){      // Εάν παίζει ο χρήστης
                for (int j=0;j<tilesInHand && lose==false;j++){
                    int bothside=0,side=0;
                    if (j==0 && first){
                        choice=user_interface.chooseTile(playersOfGame[i].stackOfTiles.tilesList.size());
                        table.setLeft(playersOfGame[i].stackOfTiles.tilesList.get(choice-1).getLeft());
                        table.setRight(playersOfGame[i].stackOfTiles.tilesList.get(choice-1).getRight());
                        playersOfGame[i].stackOfTiles.removeTile(choice-1);
                        Tiles temp=new Tiles(table.getLeft(),table.getRight());
                        tilesOfPlayersPlaced[i].addTile(temp);
                        stackOfTilesPlacedOnTable.addTile(temp);
                        user_interface.showTilesPlaced(stackOfTilesPlacedOnTable);
                        j++;
                        first=false;
                    }
                    if (check.areAvailableTiles(playersOfGame[i].stackOfTiles.tilesList, table)){
                        availableTiles.tilesList=check.FindTilesSolo1(playersOfGame[i].stackOfTiles.tilesList, table);
                        user_interface.showTilesInHand(playersOfGame[i].stackOfTiles);
                        user_interface.showTilesCanBePlaced(availableTiles);
                        choice=user_interface.chooseTile(availableTiles.tilesList.size());
                        if (check.bothSide(playersOfGame[i].stackOfTiles.tilesList.get(choice-1), table)){
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
                            tilesOfPlayersPlaced[i].tilesList.add(0, availableTiles.tilesList.get(choice-1));
                            stackOfTilesPlacedOnTable.tilesList.add(0, availableTiles.tilesList.get(choice-1));
                        }
                        else{
                            table.setRight(availableTiles.tilesList.get(choice-1).getRight());
                            tilesOfPlayersPlaced[i].tilesList.add(availableTiles.tilesList.get(choice-1));
                            stackOfTilesPlacedOnTable.tilesList.add(availableTiles.tilesList.get(choice-1));
                        }
                        check.deletePlacedTile(availableTiles.tilesList.get(choice-1), playersOfGame[i].stackOfTiles.tilesList);
                        availableTiles.tilesList.clear();
                        user_interface.showTilesPlaced(stackOfTilesPlacedOnTable);
                    }
                    else{
                        lose=true;
                        user_interface.showYouCantPlaceMore();
                    }
                }   
            }
            else{       //Εάν παίζει bot
                if (players==2){
                    user_interface.showOpponentPlayingMessage(0);
                }
                else{
                    user_interface.showOpponentPlayingMessage(i);
                }
                for (int j=0;j<tilesInHand && lose==false;j++){
                    user_interface.showThinkingMessage();
                    int bothside=0,side=0;
                    if (j==0 && first){
                        table.setLeft(playersOfGame[i].stackOfTiles.tilesList.get(j).getLeft());
                        table.setRight(playersOfGame[i].stackOfTiles.tilesList.get(j).getRight());
                        playersOfGame[i].stackOfTiles.removeTile(j);
                        Tiles temp=new Tiles(table.getLeft(),table.getRight());
                        tilesOfPlayersPlaced[i].addTile(temp);
                        stackOfTilesPlacedOnTable.addTile(temp);
                        j++;
                        user_interface.showOpponentPlaced(temp);
                        user_interface.showTilesPlaced(stackOfTilesPlacedOnTable);
                        System.out.println();
                        user_interface.showThinkingMessage();
                        first=false;
                    }
                    if (check.areAvailableTiles(playersOfGame[i].stackOfTiles.tilesList, table)){
                        availableTiles.tilesList=check.FindTilesSolo1(playersOfGame[i].stackOfTiles.tilesList, table);
                        Tiles temp=new Tiles(availableTiles.tilesList.get(0).getLeft(),availableTiles.tilesList.get(0).getRight());
                        if (check.bothSide(availableTiles.tilesList.get(0), table)){
                            bothside=random.nextInt(2)+1;
                            if (bothside==1){
                                check.whoBothSide(table, availableTiles.tilesList.get(0), bothside);
                            }
                            else{
                                check.whoBothSide(table, availableTiles.tilesList.get(0), bothside);
                            }
                        }
                        else{
                            side=check.whoSide(table, availableTiles.tilesList.get(0));
                        }
                        if (bothside==1 || side==1){
                            table.setLeft(availableTiles.tilesList.get(0).getLeft());
                            tilesOfPlayersPlaced[i].tilesList.add(0, availableTiles.tilesList.get(0));
                            stackOfTilesPlacedOnTable.tilesList.add(0, availableTiles.tilesList.get(0));
                        }
                        else{
                            table.setRight(availableTiles.tilesList.get(0).getRight());
                            tilesOfPlayersPlaced[i].tilesList.add(availableTiles.tilesList.get(0));
                            stackOfTilesPlacedOnTable.tilesList.add(availableTiles.tilesList.get(0));
                        }
                        check.deletePlacedTile(availableTiles.tilesList.get(0), playersOfGame[i].stackOfTiles.tilesList);
                        user_interface.showOpponentPlaced(temp);
                        availableTiles.tilesList.clear();
                        user_interface.showTilesPlaced(stackOfTilesPlacedOnTable);
                        System.out.println();
                    }
                    else{
                        lose=true;
                        if (players==2){
                            user_interface.showOpponentCantPlace(0);
                        }
                        else{
                            user_interface.showOpponentCantPlace(i);
                        }
                    }
                }
            }
            if (playersOfGame[i].stackOfTiles.isEmpty()){ //Έλεγχος αν κάποιος παίκτης τοποθέτησε όλα τα πλακίδια του
                winnerOfSet=i;
                foundWinner=true;
                if (winnerOfSet==0){
                    user_interface.showDominoMessageEndOfRound();
                }
                else{
                    if (players==2){
                        user_interface.showDominoMessageEndOfRoundOpponent(0);
                    }
                    else{
                        user_interface.showDominoMessageEndOfRoundOpponent(winnerOfSet);
                    }
                }
            }  //Τα επόμενα 3 if μας βοηθούν να ελέξουμε ποιοι παίζουν ανάλογα ποιος παίζει πρώτος και πόσοι παίκτες παίζουν
            if (players==4){
                switch (playersPlayed){
                    case 1: if (startingPoint==3){
                                i=-1;
                            }
                            break;
                    case 2: if (startingPoint==2){
                                i=-1;
                            }
                            break;
                    case 3: if (startingPoint==1){
                                i=-1;
                            }
                            break;
                }
            }
            if (players==3){
                switch (playersPlayed){
                    case 1: if (startingPoint==2){
                                i=-1;
                            }
                            break;
                    case 2: if (startingPoint==1){
                                i=-1;
                            }
                            break;
                }
            }
            if (players==2){
                switch (playersPlayed){
                    case 1: if (startingPoint==1){
                                i=-1;
                            }
                            break;
                }
            }
        }
        System.out.println();
        user_interface.showTilesPlaced(stackOfTilesPlacedOnTable);
        user_interface.showPlacedFollowingTiles(tilesOfPlayersPlaced[0]);
        for (int i=1;i<players;i++){
            if (players==2){
                user_interface.showPlacedFollowingTilesOpponent(tilesOfPlayersPlaced[i], 0);
            }
            else{
                user_interface.showPlacedFollowingTilesOpponent(tilesOfPlayersPlaced[i], i);
            }
        }
        System.out.println();
        user_interface.showTilesLeftInHand(playersOfGame[0].stackOfTiles);
        for (int i=1;i<players;i++){
            if (players==2){
                user_interface.showTilesInHandOpponent(playersOfGame[i].stackOfTiles, 0);
            }
            else{
                user_interface.showTilesInHandOpponent(playersOfGame[i].stackOfTiles, i);
            }
        }
        System.out.println();
        user_interface.showTotalPointsInHand(check.calculatePointsOfTiles(playersOfGame[0].stackOfTiles.tilesList));
        pointsWon+=check.calculatePointsOfTiles(playersOfGame[0].stackOfTiles.tilesList);
        for (int i=1;i<players;i++){
            if (players==2){
                user_interface.showTotalPointsInHandOpponent(check.calculatePointsOfTiles(playersOfGame[i].stackOfTiles.tilesList),0);
            }
            else{
                user_interface.showTotalPointsInHandOpponent(check.calculatePointsOfTiles(playersOfGame[i].stackOfTiles.tilesList),i);
            }
            pointsWon+=check.calculatePointsOfTiles(playersOfGame[i].stackOfTiles.tilesList);
        }
        System.out.println();
        if (foundWinner==false){
            winnerOfSet=check.winnerSet(tilesOfPlayers)-1;
        }
        if (winnerOfSet!=-1){
            if (winnerOfSet==0){
                user_interface.showWinnerOfSetMessage(pointsWon);
            }
            else{
                if (players==2){
                    user_interface.showWinnerOfSetOpponentMessage(0,pointsWon);
                }
                else{
                    user_interface.showWinnerOfSetOpponentMessage(winnerOfSet,pointsWon);
                }
            }
            System.out.println();
            check.addPoints(winnerOfSet+1, pointsOfPlayers, tilesOfPlayers);
        }
        else{
            System.out.println();
            user_interface.showTieMessage();
        }
        user_interface.showTotalPointsOfPlayers(pointsOfPlayers, players);
        System.out.println();
        System.out.println();
    }
}