public class Game {

    private int countOfRound = 0;
    private String userChoice;
    private String pcChoice;


    @Override
    public String toString() {
        return "user choice= " + userChoice + '\'' +
                ", computer choice=" + pcChoice;
    }


    public Game(String userChoice, String pcChoice) {
        this.userChoice = userChoice;
        this.pcChoice = pcChoice;
    }

    public String compareChoices(Player player1, Player player2){
        countOfRound++;
        String result="";
        int choice1 = player1.getPlayerChoice();
        int choice2 = player2.getPlayerChoice();
        System.out.println(choiceForPrint(choice1,player1.getName()));
        System.out.println(choiceForPrint(choice2,player2.getName()));

        if (choice1 == choice2) {
            result = "It is a tie!\n";
        }else if ((choice1 == 1 && choice2 == 2) || (choice1 == 2 && choice2 == 3) || (choice1 == 3 && choice2 == 1)) {
            player1.playerPoints = player1.playerPoints + 10;
            result = "The " + player1.getName() + " is winner!\n";
        }else if ((choice1 == 1 && choice2 == 3) || (choice1 == 2 && choice2 == 1) || (choice1 == 3 && choice2 == 2)) {
            player2.playerPoints = player2.playerPoints + 10;
            result = "The " + player2.getName() + " is winner!\n";
        }return result;
    }

    public String comparePoints(Player player1, Player player2){
        String result;
        if (player1.playerPoints==player2.playerPoints) {
            result = "IT IS A TIE!\n";
        } else if (player2.playerPoints<player1.playerPoints) {
            result = player2.getName()+" - YOU LOOSING SO FAR! :(\n";
        } else {result = player2.getName() + " - YOU ARE WINNING SO FAR! :)\n";}
        return result;
    }

    public String choiceForPrint(int a,String b){

        String res;
        if (a==1){ res="STONE.";
        }
        else if (a==2){ res="SCISSORS.";
        }
        else{ res="PAPER.";
        }
        String result= b + "\'s choice: " + res;
        return result;
    }

}

