package vendingmachine.view;

public class OutputView {
    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String CHANGE_AMOUNT = "잔돈";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    // view가 담당하는 권한 어디까지? Map 객체를 받아서 처리하는 로직을 view에서 해도 될까?
    public static void printVendingMachineCoins(String outputText) {
        System.out.print(LINE_SEPARATOR);
        System.out.println(VENDING_MACHINE_COINS);
        System.out.println(outputText);
    }

    public static void printMachineInputAmount(String outputText) {
        System.out.print(LINE_SEPARATOR);
        System.out.println(outputText);
    }

    public static void printChange(String outputText) {
        System.out.println(CHANGE_AMOUNT);
        System.out.println(outputText);
    }
}
