package class4.package1;

import class4.role.Lion;
import class4.role.Role;
import class4.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Role> members = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    registerMember();
                    break;
                case "2":
                    printAllMembers();
                    break;
                case "3":
                    searchMemberByName();
                    break;
                case "0":
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Step 1 멤버 관리 =====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 멤버 검색");
        System.out.println("0. 종료");
        System.out.print("메뉴 선택: ");
    }

    private static void registerMember() {
        System.out.println();
        System.out.println("[멤버 등록]");
        System.out.println("1. 아기사자");
        System.out.println("2. 운영진");
        System.out.print("역할 선택: ");
        String roleType = scanner.nextLine().trim();

        if (!roleType.equals("1") && !roleType.equals("2")) {
            System.out.println("등록할 수 없는 역할입니다.");
            return;
        }

        String name = readRequiredText("이름: ");

        if (existsByName(name)) {
            System.out.println("이미 등록된 이름입니다. 등록에 실패했습니다.");
            return;
        }

        String part = readRequiredText("파트: ");
        int generation = readGeneration();

        Role member = createMember(roleType, name, part, generation);
        members.add(member);
        System.out.println("멤버 등록이 완료되었습니다.");
    }

    private static Role createMember(String roleType, String name, String part, int generation) {
        if (roleType.equals("1")) {
            return new Lion(name, part, generation);
        }

        return new Staff(name, part, generation);
    }

    private static void printAllMembers() {
        System.out.println();
        System.out.println("[전체 멤버 조회]");

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        System.out.println("총 " + members.size() + "명의 멤버가 등록되어 있습니다.");
        for (Role member : members) {
            System.out.println(member.getProfile());
        }
    }

    private static void searchMemberByName() {
        System.out.println();
        System.out.println("[이름으로 멤버 검색]");
        String name = readRequiredText("검색할 이름: ");

        for (Role member : members) {
            if (member.getName().equals(name)) {
                System.out.println(member.getProfile());
                return;
            }
        }

        System.out.println("해당 이름의 멤버를 찾을 수 없습니다.");
    }

    private static boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private static String readRequiredText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("빈 값은 입력할 수 없습니다.");
        }
    }

    private static int readGeneration() {
        while (true) {
            System.out.print("기수: ");
            String input = scanner.nextLine().trim();

            try {
                int generation = Integer.parseInt(input);
                if (generation > 0) {
                    return generation;
                }
                System.out.println("기수는 1 이상의 숫자로 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
