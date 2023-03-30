package lab.dev;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public final class TeamMember {

    private String name;
    private Set<Skill> skills = new HashSet<>();
    private Set<Role> roles = new HashSet<>();

    public TeamMember(String name) {
        this.name = name;
    }

    public TeamMember(){}

    public TeamMember withSkill(Skill skill){
        skills.add(skill);
        return this;
    }

    public TeamMember withRole(Role role){
        roles.add(role);
        return this;
    }

    public void removeRole(Role role){
        roles.remove(role);
    }

    public String getName() {
        return name;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember member = (TeamMember) o;
        return getName().equals(member.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}