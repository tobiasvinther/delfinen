package teams;

import members.Member;
import java.util.ArrayList;

//@author Tobias Vinther
public class Team implements Comparable<Team> {

    private String teamType; //junior or senior
    private int teamID; //team
    private String trainingDay;
    //private Coach coach;
    private final ArrayList<Member> teamMemberList = new ArrayList<>();
    public final int MAX_SIZE = 20;

    private static int teamCounter = 0;

    public Team(String teamType, String trainingDay) {
        teamCounter++;
        this.teamType = teamType;
        this.trainingDay = trainingDay;
        this.teamID = teamCounter;
        TeamList.addToListOfTeams(this);
    }

    public void addMemberToTeam(Member member) {
        if(teamMemberList.size() < MAX_SIZE) {
            teamMemberList.add(member);
        } else System.out.println("Holdet er fyldt. Medlemmet kunne ikke tilføjes.");
    }

    public void removeMemberFromTeam(Member member) {
        if(teamMemberList.contains(member)) {
            teamMemberList.remove(member);
        } else System.out.println("Medlemmet var ikke på holdet");
    }

    public void printTeamMemberList() {
        for(Member member : teamMemberList) {
            System.out.println(member.getName());
        }
    }

    @Override
    public String toString() {
        return "Hold: " + teamType + " " + teamID + "\n" + "Antal svømmere: " + teamMemberList.size();
    }

    @Override
    public int compareTo(Team otherTeam) {
        //natural order is the biggest team compares as bigger
        return teamMemberList.size() - otherTeam.teamMemberList.size();
    }

}
