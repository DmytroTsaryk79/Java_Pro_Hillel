package hw.hw15Generics;

class Apple extends Fruit {
    private String variety;
    public Apple(String variety) {
        this.variety = variety;
        super("Apple", 1.0f);
    }

    public String getVariety() {
        return variety;
    }
   }
