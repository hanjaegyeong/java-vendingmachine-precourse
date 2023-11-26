package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 상품 존재하는지 검증하는 기능 추가
public class ProductProcessor {
    private List<Product> products;

    public ProductProcessor() {
        this.products = new ArrayList<>();
    }

    public void decreaseQuantityOfProduct(String name) {
        products = products.stream()
                .map(product -> {
                    if (product.getName().equals(name)) {
                        return product.decreaseQuantityByOne();
                    }
                    return product;
                })
                .collect(Collectors.toList());
    }

    // TODO: 전체 상수화!
    // 모든 예외 제대로 처리되는지 테스트
    public void addProducts(String input) {
        Stream.of(input.split(";"))
                .map(this::removeBracketsAndSplit)
                .peek(this::validateProductDetails)
                .map(this::createProductFromDetails)
                .forEach(this::addProduct);
        products.forEach(System.out::println); //나중에 이부분 제거
    }

    private String[] removeBracketsAndSplit(String productString) {
        return productString.replaceAll("[\\[\\]]", "").split(",");
    }

    // 제품 세부 정보 검증 및 Product 객체로 변환
    private Product createProductFromDetails(String[] details) {
        int price = Integer.parseInt(details[1].trim());
        int quantity = Integer.parseInt(details[2].trim());

        return new Product(details[0].trim(), price, quantity);
    }

    // 예외처리 추가 - 마지막에 세미콜론으로 끝나는 경우 등
    private void validateProductDetails(String[] details) {
        if (details.length != 3) {
            throw new IllegalArgumentException("[ERROR] 입력 형식을 지켜 제대로 입력해 주십시오.");
        }
        validatePrice(details[1].trim());
    }

    // Product 객체를 리스트에 추가
    private void addProduct(Product product) {
        products.add(product);
    }
    
    // 가격검증 - 정수인지, 100 이상인지, %10==0인지
    private void validatePrice(String inputPrice) {
        validateInteger(inputPrice);
        int price = Integer.parseInt(inputPrice);
        validateOverOneHundred(price);
        validateMultipleOfTen(price);
    }

    private void validateInteger(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[Error] 정수만 입력해 주십시오.");
        }
    }

    private void validateOverOneHundred(int price) {
        if (price < 100) {
            throw new IllegalArgumentException("[ERROR] 투입금액은 100원 이상이어야 합니다.");
        }
    }

    private void validateMultipleOfTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10의 배수를 입력하여 주세요.");
        }
    }
}