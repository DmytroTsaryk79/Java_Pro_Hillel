package main.java.hw.hw5;

public class Main {
    public static void   main(String[] args) {
        Participant[] participants = {
                new Human("John"),
                new Cat("Tom"),
                new Robot("R2D2")
        };

        Obstacle[] obstacles = {
                new Track("Бігова доріжка", 3000),
                new Wall("Стіна", 2),
                new Track("Бігова доріжка", 6000),
                new Wall("Стіна", 1)
        };

        for (Participant participant : participants) {
            boolean isParticipantActive = true;

            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    isParticipantActive = false;
                    break;
                }
            }

            if (isParticipantActive) {
                System.out.println(participant.getName() + " успішно пройшов усі перешкоди!");
            } else {
                System.out.println(participant.getName() + " вибув з участі.");
            }
        }
    }
}