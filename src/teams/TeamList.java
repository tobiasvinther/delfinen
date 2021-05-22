package teams;

import java.util.ArrayList;

//@author Tobias Vinther
public class TeamList {

    private static final ArrayList<Team> listOfTeams = new ArrayList<>();

    public static void addToListOfTeams(Team team) {
        listOfTeams.add(team);
    }

    public static void printListOfTeams() {
        for(Team team : listOfTeams) {
            System.out.println(team);
        }
    }
}
