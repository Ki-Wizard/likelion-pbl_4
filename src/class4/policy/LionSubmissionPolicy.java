package class4.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public String getGuideMessage() {
        return "아기사자는 과제를 마감일까지 제출합니다.";
    }
}
