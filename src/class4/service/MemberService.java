package class4.service;

import class4.role.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberService {
    private final List<Role> members = new ArrayList<>();
    private final Map<String, Role> membersByName = new HashMap<>();
    private final Map<String, List<Role>> membersByPart = new HashMap<>();

    public boolean register(Role member) {
        if (existsByName(member.getName())) {
            return false;
        }

        members.add(member);
        membersByName.put(member.getName(), member);
        addMemberToPartMap(member);
        return true;
    }

    public boolean existsByName(String name) {
        return membersByName.containsKey(name);
    }

    public Role findByName(String name) {
        return membersByName.get(name);
    }

    public List<Role> findAll() {
        return new ArrayList<>(members);
    }

    public Set<String> findPartNames() {
        return membersByPart.keySet();
    }

    public List<Role> findByPart(String part) {
        if (!membersByPart.containsKey(part)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(membersByPart.get(part));
    }

    public boolean hasMembers() {
        return !members.isEmpty();
    }

    public boolean hasParts() {
        return !membersByPart.isEmpty();
    }

    public int countMembers() {
        return members.size();
    }

    private void addMemberToPartMap(Role member) {
        String part = member.getPart();

        if (!membersByPart.containsKey(part)) {
            membersByPart.put(part, new ArrayList<Role>());
        }

        membersByPart.get(part).add(member);
    }
}
