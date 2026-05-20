package class4.role;

import class4.policy.SubmissionPolicy;

public abstract class Role {
    private final String name;
    private final String part;
    private final int generation;
    private final SubmissionPolicy submissionPolicy;

    protected Role(String name, String part, int generation, SubmissionPolicy submissionPolicy) {
        this.name = name;
        this.part = part;
        this.generation = generation;
        this.submissionPolicy = submissionPolicy;
    }

    public String getName() {
        return name;
    }

    public String getPart() {
        return part;
    }

    public int getGeneration() {
        return generation;
    }

    public String getSubmissionGuide() {
        return submissionPolicy.getGuideMessage();
    }

    public abstract String getRoleName();

    public String getProfile() {
        return String.format(
                "[%s] 이름: %s | 파트: %s | 기수: %d | 제출 정책: %s",
                getRoleName(),
                name,
                part,
                generation,
                getSubmissionGuide()
        );
    }
}
