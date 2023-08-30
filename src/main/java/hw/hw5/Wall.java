package main.java.hw.hw5;

public class Wall extends Obstacle {
    public Wall(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean overcome(Participant participant) {
        if (participant.maxJumpHeight >= value) {
            participant.jump();
            return true;
        } else {
            System.out.println(participant.getName() + " не пройшов " + name + " висотою " + value);
            return false;
        }
    }
}