package hw12;

import java.util.Scanner;

public class BankApplication {

    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.nextLine();

            switch (selectNo) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    accountList();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    withdraw();
                    break;
                case "5":
                    run = false;
                    System.out.println("프로그램 종료");
                    break;
            }
        }
    }

    // 계좌 생성하기
    private static void createAccount() {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("계좌주: ");
        String owner = scanner.nextLine();

        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scanner.nextLine());

        Account newAccount = new Account(ano, owner, balance);

        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = newAccount;
                System.out.println("결과: 계좌가 생성되었습니다.");
                break;
            }
        }
    }

    // 계좌 목록 보기
    private static void accountList() {
        System.out.println("--------");
        System.out.println("계좌목록");
        System.out.println("--------");

        for (Account account : accountArray) {
            if (account != null) {
                System.out.println(
                        account.getAno() + "   " +
                        account.getOwner() + "   " +
                        account.getBalance()
                );
            }
        }
    }

    // 예금하기
    private static void deposit() {
        System.out.println("--------");
        System.out.println("예금");
        System.out.println("--------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("예금액: ");
        int money = Integer.parseInt(scanner.nextLine());

        Account account = findAccount(ano);

        if (account != null) {
            account.setBalance(account.getBalance() + money);
            System.out.println("결과: 예금이 성공되었습니다.");
        } else {
            System.out.println("결과: 계좌를 찾을 수 없습니다.");
        }
    }

    // 출금하기
    private static void withdraw() {
        System.out.println("--------");
        System.out.println("출금");
        System.out.println("--------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("출금액: ");
        int money = Integer.parseInt(scanner.nextLine());

        Account account = findAccount(ano);

        if (account != null) {
            account.setBalance(account.getBalance() - money);
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            System.out.println("결과: 계좌를 찾을 수 없습니다.");
        }
    }

    // 계좌 검색
    private static Account findAccount(String ano) {
        for (Account account : accountArray) {
            if (account != null && account.getAno().equals(ano)) {
                return account;
            }
        }
        return null;
    }
}
