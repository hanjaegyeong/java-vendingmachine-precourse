package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

// 일급컬렉션?
public class VendingMachine {
    // 동전종류-개수 map
    private static final EnumMap<Coin, Integer> vendingMachineCoins = new EnumMap<>(Coin.class);
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void generateVendingMachineCoins(int vendingMachineAmount) {
        validateVendingMachineCoins(vendingMachineAmount);

        List<Integer> coinTypes = Arrays.asList(500, 100, 50, 10);
        int remainingAmount = vendingMachineAmount;

        while (remainingAmount > 0) {
            int randomCoin = Randoms.pickNumberInList(coinTypes);
            if (remainingAmount >= randomCoin) {
                Coin coin = Coin.findByAmount(randomCoin);
                vendingMachineCoins.put(coin, vendingMachineCoins.getOrDefault(coin, 0) + 1);
                remainingAmount -= randomCoin;
            }
        }
    }

    private void validateVendingMachineCoins(int vendingMachineAmount) {
        validatePositiveNumber(vendingMachineAmount);
        validateMultipleOfTen(vendingMachineAmount);
    }

    // 10의 배수이면 자동으로 양수 처리되는지 확인
    private void validatePositiveNumber(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("ERROR: 양수를 입력하여 주세요.");
        }
    }

    private void validateMultipleOfTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("ERROR: 10의 배수를 입력하여 주세요.");
        }
    }

    public String formatVendingMachineCoinsOutput() {
        return vendingMachineCoins.entrySet().stream() // vendingMachineCoins Map에 담긴 객체 집합을 스트림화 해서
                .map(entry -> formatVendingMachineCoinOutput(entry.getKey(), entry.getValue())) // 각 줄 포맷
                .collect(Collectors.joining(LINE_SEPARATOR)); // 엔터로 각 output join
    }

    private String formatVendingMachineCoinOutput(Coin coin, int coinQuantity) {
        return String.format("%d원 - %d개", coin.getAmount(), coinQuantity);
    }
}
