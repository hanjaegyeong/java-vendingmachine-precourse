package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_AMOUNT_HELD_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_ITEM_HELD_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_MACHINE_INPUT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_ITEM_MESSAGE = "구매할 상품명을 입력해 주세요.";
    private static final String INVALID_AMOUNT_HELD_INPUT_MESSAGE = "[ERROR] 정수만을 입력해 주세요.";

    // inputVendingMachineAmount 로 리팩토링
    public static int inputAmountHeld() {
        System.out.println(INPUT_AMOUNT_HELD_MESSAGE);
        return inputInt();
    }

    private static int inputInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(INVALID_AMOUNT_HELD_INPUT_MESSAGE);
        }
    }

    public static String inputItemHeld() {
        System.out.println(INPUT_ITEM_HELD_MESSAGE);
        return readLine();
    }

    public static int inputAmount() {
        System.out.println(INPUT_MACHINE_INPUT_AMOUNT_MESSAGE);
        return inputInt();
    }

    public static String inputPurchaseItem() {
        System.out.println(INPUT_PURCHASE_ITEM_MESSAGE);
        return readLine();
    }
}
