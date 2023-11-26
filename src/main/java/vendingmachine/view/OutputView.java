package vendingmachine.view;

public class OutputView {
    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";

    // view가 담당하는 권한 어디까지? Map 객체를 받아서 처리하는 로직을 view에서 해도 될까?
    public static void printVendingMachineCoins(String outputText) {
        System.out.println(VENDING_MACHINE_COINS);
        System.out.println(outputText);
    }
}
