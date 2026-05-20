package class4.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public String getGuideMessage() {
        return "운영진은 과제 제출 현황을 확인하고 피드백합니다.";
    }
}
