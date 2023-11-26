package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.useVendingMachine();
    }
}
