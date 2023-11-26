package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.PurchaseProcessor;
import vendingmachine.domain.VendingMachineCoin;
import vendingmachine.domain.VendingMachineProduct;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.EnumMap;

public class VendingMachineController {

    public void useVendingMachine() {
        generateMachineCoins();
        VendingMachineProduct vendingMachineProduct = generateMachineItems();
        PurchaseProcessor purchaseProcessor = generateInputAmount();
        PurchaseProduct(vendingMachineProduct, purchaseProcessor);
        // 잔돈 반환
        VendingMachineCoin vendingMachineCoin = new VendingMachineCoin();
        EnumMap<Coin, Integer> change = vendingMachineCoin.calculateChange(purchaseProcessor.getMachineInputAmount());
        OutputView.printChange(vendingMachineCoin.formatChangeOutput(change));
    }

    private static void PurchaseProduct(VendingMachineProduct vendingMachineProduct, PurchaseProcessor purchaseProcessor) {
        try {
            performProductPurchase(vendingMachineProduct, purchaseProcessor);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            PurchaseProduct(vendingMachineProduct, purchaseProcessor);
        }
    }

    private static void performProductPurchase(VendingMachineProduct vendingMachineProduct, PurchaseProcessor purchaseProcessor) {
        while (true) {
            String itemName = InputView.inputPurchaseItem();
            purchaseProcessor.purchaseProduct(itemName, vendingMachineProduct);
            OutputView.printMachineInputAmount(purchaseProcessor.formatMachineInputAmountOutput());
            if (!purchaseProcessor.isPossiblePurchase(itemName, vendingMachineProduct)) {
                break;
            }
        }
    }

    private static PurchaseProcessor generateInputAmount() {
        try {
            // 투입 금액
            int machineInputAmount = InputView.inputMachineInputAmount();
            PurchaseProcessor purchaseProcessor = new PurchaseProcessor(machineInputAmount);
            OutputView.printMachineInputAmount(purchaseProcessor.formatMachineInputAmountOutput());
            return purchaseProcessor;
        }catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return generateInputAmount();
        }
    }

    private static VendingMachineProduct generateMachineItems() {
        try {
            // 상품명과 가격, 수량
            String items = InputView.inputItemHeld();
            VendingMachineProduct vendingMachineProduct = new VendingMachineProduct();
            vendingMachineProduct.addProducts(items);
            return vendingMachineProduct;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return generateMachineItems();
        }
    }

    private static void generateMachineCoins() {
        try {
            int amountHeld = InputView.inputAmountHeld();
            // 자판기가 보유한 동전
            VendingMachineCoin vendingMachineCoin = new VendingMachineCoin();
            vendingMachineCoin.generateVendingMachineCoins(amountHeld);
            OutputView.printVendingMachineCoins(vendingMachineCoin.formatVendingMachineCoinsOutput());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            generateMachineCoins();
        }
    }
}
