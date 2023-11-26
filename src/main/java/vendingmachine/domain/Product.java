package vendingmachine.domain;

public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product decreaseQuantityByOne() {
        if (this.quantity == 0) {
            return this; // TODO: 남은 수량 0되면 반복 종료 로직 넣기
        }
        return new Product(this.name, this.price, this.quantity - 1);
    }
}
