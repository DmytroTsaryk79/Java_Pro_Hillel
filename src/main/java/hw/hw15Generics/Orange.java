package hw.hw15Generics;

class Orange extends Fruit {
    private String origin;

    public Orange(String origin) {
        super("Orange", 1.5f);
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }


}