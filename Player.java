public class Player {


    public int playerChoice;
    public String name;


    public Player(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + '\n';
    }


    public String getName() {
        return name;
    }


    public int getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(int playerChoice) {
        this.playerChoice = playerChoice;
    }
}


