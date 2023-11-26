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

    public int getMachineInputAmount() {
        return this.machineInputAmount;
    }

    // 구입 가능한지 검증부터 해야 함 - while(true) 안에서 돌도록
    // 금액 검증, 수량 검증
    public boolean isPossiblePurchase(String productName, VendingMachineProduct vendingMachineProduct) {
        if (machineInputAmount < vendingMachineProduct.getProductPriceByName(productName)) {
            return false;
        }
        // 수량검증 못함ㅜ
        return true;
    }

    // 구매 - 투입 금액 갱신 && 해당상품 -1
    public void purchaseProduct(String productName, VendingMachineProduct vendingMachineProduct) {
        machineInputAmount -= vendingMachineProduct.getProductPriceByName(productName);
        vendingMachineProduct.decreaseQuantityOfProduct(productName);
    }
}
