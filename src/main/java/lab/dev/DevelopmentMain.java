package lab.dev;

import lab.zoo.Animal;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DevelopmentMain {

    public static void main(String[] args) {

        System.out.println("Let's develop!");
        Team team = constructTeam("A Team");
        List<TeamMember> members = team.getMembers();

        // TODO 1: sort by skills count

        Collections.sort(members, (m1, m2) -> m1.getSkills().size() - m2.getSkills().size());
        System.out.println("members = " + members);

        // TODO 2: remove technical writer

        members.removeIf(m -> m.getRoles().contains(Role.TECHNICAL_WRITER));
        System.out.println(members);

        // TODO 3: find all java developers

        Set<TeamMember> nextList = members.stream()
                .filter(m -> m.getSkills().equals(Skill.JAVA))
                .filter(m -> m.getRoles().equals(Role.DEVELOPER))
                .collect(Collectors.toSet());

        // TODO 4: count all javascript developers

        Long wynik = members.stream()
                .filter(m -> m.getSkills().contains(Skill.JAVASCRIPT))
                .filter(m -> m.getRoles().contains(Role.DEVELOPER))
                .count();
        System.out.println("count of javascript developers is " + wynik);

        // druga opcja rozwiązania
        long count = 0;
        for (TeamMember m : members) {
            if (m.getSkills().contains(Skill.JAVASCRIPT) && m.getRoles().contains(Role.DEVELOPER)) {
                count = count + 1;
            }
        }

        System.out.println("here");


        //  Consumer<TeamMember> consumer = System.out::println;

        // TODO 11: get all skills
        System.out.println("get all skills");

        // nie spłaszczyłam flatMap
        List<Set<Skill>> membersStream = members.stream()
                .map(m -> m.getSkills())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(membersStream);

        // TODO 12: get all members except technical writer

        System.out.println("bez writera");
        Stream<TeamMember> stream = members.stream();
        stream
                .filter(m -> !m.getRoles().contains(Role.TECHNICAL_WRITER))
                //  .forEach(System.out::println);
                .collect(Collectors.toSet());


        // TODO 13: get all developers names sorted by roles count

//        var result13 = members.stream()
//                .filter(m -> m.getRoles().contains(Role.DEVELOPER))
//                .sorted(m1,m2)-> m1.getRoles().size()-m2.getRoles().size())
//                .peek(m -> System.out.println("peek: " + m))
//                .map(TeamMember::getName)
//                .count();
//        System.out.println("result13 " + result13);


        // TODO 14: get any java developer

        System.out.println("any java developer - czy takowy jest w ogóle -> nie do końca si rozwiązanie");
        boolean anyJavaDev = members.stream()
                .anyMatch(role -> role.getRoles().contains(Role.DEVELOPER) && role.getSkills().contains(Skill.JAVA));
        System.out.println(anyJavaDev);

        System.out.println("a to dobre rozwiąznie");
        var toDo14 = members.stream()
                .filter(m -> m.getSkills().contains(Skill.JAVA))
                .filter(m->m.getRoles().contains(Role.DEVELOPER))
                .findAny();
        System.out.println("AnyJavaDev = " + toDo14);


        // TODO 15: calculate average skills count

        System.out.println("calculate avg skills count");
        OptionalDouble averageSkillsCount = members.stream().mapToInt(m -> m.getSkills().size())
                .average();
        System.out.println("averageSkillsCount = " + averageSkillsCount);

        Integer averageSkillCount = members.stream()
                .map(m->m.getSkills().size())
                .reduce(0, (i1,i2)->i1+i2);
        System.out.println("averageSkillCount = " + ((double)averageSkillCount/ members.size()));


        System.out.println("done.");
    }

    public static Team constructTeam(String name) {
        Team team = new Team(name);

        TeamMember joe = new TeamMember("Joe")
                .withSkill(Skill.JAVA)
                .withSkill(Skill.JPA)
                .withSkill(Skill.SQL)
                .withSkill(Skill.SPRING)
                .withRole(Role.DEVELOPER);

        TeamMember joeBis = new TeamMember("Joe")
                .withSkill(Skill.JAVA)
                .withSkill(Skill.JPA)
                .withSkill(Skill.SQL)
                .withSkill(Skill.SPRING)
                .withRole(Role.DEVELOPER);

        team.addMember(joeBis);

        team.addMember(new TeamMember("Jane")
                .withSkill(Skill.ANGULAR)
                .withSkill(Skill.JAVASCRIPT)
                .withSkill(Skill.JAVA)
                .withSkill(Skill.PYTHON)
                .withSkill(Skill.SPRING)
                .withRole(Role.DEVELOPER)
                .withRole(Role.SCRUM_MASTER));

        team.addMember(new TeamMember("Bob")
                .withSkill(Skill.JAVASCRIPT)
                .withSkill(Skill.REACT_JS)
                .withSkill(Skill.PYTHON)
                .withSkill(Skill.SQL)
                .withSkill(Skill.SPRING)
                .withRole(Role.QA));

        team.addMember(new TeamMember("Betty")
                .withSkill(Skill.PYTHON)
                .withSkill(Skill.SQL)
                .withRole(Role.QA));

        team.addMember(joe);

        team.addMember(new TeamMember("Billy")
                .withSkill(Skill.SQL)
                .withRole(Role.TECHNICAL_WRITER)
                .withRole(Role.PRODUCT_OWNER));

        return team;
    }
}
