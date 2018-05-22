import sample.Main;

public class Game {


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

    public String compareChoices(Main.Player player1, Main.Computer computer1) {

        String result = "";
        int choice1 = player1.getPlayerChoice();
        int choice2 = computer1.getPlayerChoice();

        if (choice1 == choice2) {

            result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so it is a tie!\n";
        } else if ((choice1 == 1 && choice2 == 2) || (choice1 == 2 && choice2 == 3) || (choice1 == 3 && choice2 == 1)) {

            result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so " + player1.getName() + " is winner!\n";
        } else if ((choice1 == 1 && choice2 == 3) || (choice1 == 2 && choice2 == 1) || (choice1 == 3 && choice2 == 2)) {

            result = "Computer choice was - " + choice2 + "\n" + "Your choice was - " + choice1 + "\n" + " - so computer is winner!\n";
        }
        return result;
    }





}



