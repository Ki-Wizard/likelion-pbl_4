package class4.role;

import class4.policy.StaffSubmissionPolicy;

public class Staff extends Role {
    public Staff(String name, String part, int generation) {
        super(name, part, generation, new StaffSubmissionPolicy());
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }
}
