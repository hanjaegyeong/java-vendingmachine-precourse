package vendingmachine.domain;

// 메인 자판기 로직
// 정팩매?
public class PurchaseProcessor {
    private int machineInputAmount;

    public PurchaseProcessor(int machineInputAmount) {
        this.machineInputAmount = machineInputAmount;
    }

    // 투입 금액 출력
    public String formatMachineInputAmountOutput() {
        return String.format("투입 금액: %d원", this.machineInputAmount);
    }
    

}
