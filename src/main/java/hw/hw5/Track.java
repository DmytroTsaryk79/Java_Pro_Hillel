package main.java.hw.hw5;

public class Track extends Obstacle {
    public Track(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean overcome(Participant participant) {
        if (participant.maxRunDistance >= value) {
            participant.run();
            return true;
        } else {
            System.out.println(participant.getName() + " не пройшов " + name + " на дистанції " + value);
            return false;
        }
    }
}