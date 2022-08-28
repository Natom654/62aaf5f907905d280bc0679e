package ua.ithillel.homework.race;

public class Race {
    public static void main(String[] args) {
        Human human = new Human("Human Bob", 500, 1);
        Cat cat = new Cat("cat Darsik", 1500, 10);
        Robot robot = new Robot("Robot CP1", 100, 9);

        Wall wall = new Wall("Jumping wall", 50);
        RunObstacle runobstacle = new RunObstacle("Running track", 1500);

        // task6 Создайте два массива: с участниками и препятствиями.
        Participant[] participants = new Participant[]{human, cat, robot};
        Obstacle[] obstacles = new Obstacle[]{wall, runobstacle};

        // task5 Человек пробежал беговую дорожку
        System.out.println(wall.overcome(human));
        System.out.println(wall.overcome(cat));
        System.out.println(wall.overcome(robot));
        System.out.println(runobstacle.overcome(human));
        System.out.println(runobstacle.overcome(robot));
        System.out.println(runobstacle.overcome(cat));

        // task 7 Каждый элемент из массива с участниками
        // должен пройти каждое препятствие из массива с препятствиями.
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                String race = obstacle.overcome(participant);
                System.out.println(race);
            }
        }
        // task 9
        // Например: "Участник[ИМЯ] прошел препятствие[НАЗВАНИЕ] на дистанции[ЗНАЧЕНИЕ]"
        //"Участник[ИМЯ] не прошел препятствие[НАЗВАНИЕ] на дистанции[ЗНАЧЕНИЕ]. Пройдено[ЗНАЧЕНИЕ]"
        if (runobstacle.race(cat)) {
            wall.race(cat);
        } else {
            System.out.println(cat.getName() + " can not participate in race");
        }
        if (runobstacle.race(human)) {
            wall.race(human);
        } else {
            System.out.println(human.getName() + " can not participate in race");
        }
        if (runobstacle.race(robot)) {
            wall.race(robot);
        } else {
            System.out.println(robot.getName() + " can not participate in race");
        }
    }
}

