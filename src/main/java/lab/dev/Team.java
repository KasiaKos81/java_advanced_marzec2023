package lab.dev;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<TeamMember> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addMember(TeamMember member){
        members.add(member);
    }

    public void removeMember(TeamMember member){
        members.remove(member);
    }

    public String getName() {
        return name;
    }

    public List<TeamMember> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
