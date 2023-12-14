package hw.hw15Generics;

class Apple extends Fruit {
    private String variety;
    public Apple(String variety) {
        super("Apple", 1.0f);
        this.variety = variety;
         }

    public String getVariety() {
        return variety;
    }
   }
