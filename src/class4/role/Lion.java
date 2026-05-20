package class4.role;

import class4.policy.LionSubmissionPolicy;

public class Lion extends Role {
    public Lion(String name, String part, int generation) {
        super(name, part, generation, new LionSubmissionPolicy());
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }
}
