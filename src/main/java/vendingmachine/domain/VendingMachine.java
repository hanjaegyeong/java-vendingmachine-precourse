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
}
