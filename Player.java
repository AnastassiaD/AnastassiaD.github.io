public class Player {

    public int playerPoints = 0;
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

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(int playerChoice) {
        this.playerChoice = playerChoice;
    }
}

