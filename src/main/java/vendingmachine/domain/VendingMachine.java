package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

// 일급컬렉션?
public class VendingMachine {
    // 동전종류-개수 map
    private static EnumMap<Coin, Integer> vendingMachineCoins = new EnumMap<>(Coin.class);

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
    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("ERROR: 양수를 입력하여 주세요.");
        }
    }

    private void validateMultipleOfTen(int number) {
        if (number % 10 != 0) {
            throw new IllegalArgumentException("ERROR: 10의 배수를 입력하여 주세요.");
        }
    }
}
