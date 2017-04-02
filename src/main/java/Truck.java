import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Truck {

    static int maxPetrol = 0;
    static List<Resul> resuls = new ArrayList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {

            int x = s.nextInt();
            List<Petrol> petrol = new ArrayList<>();


            for (int j = 0; j < x; j++) {
                Petrol petrol1 = new Petrol();
                petrol1.setLitre(s.nextInt());
                petrol.add(petrol1);
            }
            for (int j = 0; j < x; j++) {
                Petrol petrol1 = petrol.get(j);
                petrol1.setDistance(s.nextInt());
                petrol.set(j, petrol1);
            }
            int instanceID = -1;
            for (int j = 0; j < x; j++) {
                if (instanceID+1 > petrol.size()-1)
                    instanceID = instanceID - petrol.size();
                instanceID = getStartPoint(petrol, instanceID + 1);
                resuls.add(new Resul(instanceID, maxPetrol));

            }

            int index = 0;
            int min = 999999999;
            for (Resul resul : resuls) {
                if (resul.max < min) {
                    index = resul.index;
                    min = resul.max;
                }
            }

            System.out.println(index + " " + min);

        }


    }

    static int getStartPoint(List<Petrol> petrol, int start) {
        // Consider first petrol pump as a starting point

        int end = 1;

        int currPetrol = petrol.get(start).litre - petrol.get(start).distance;
        maxPetrol = currPetrol;

        while (end != start || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                currPetrol -= petrol.get(start).litre - petrol.get(start).distance;
                maxPetrol = currPetrol;
                start = start + 1;
                if (start > petrol.size() - 1)
                    start = start - petrol.size();

                if (start == 0)
                    return -1;
            }

            currPetrol = currPetrol + petrol.get(end).litre;
            if (currPetrol > maxPetrol) maxPetrol = currPetrol;

            currPetrol = currPetrol - petrol.get(end).distance;

            end = end + 1;
            if (end > petrol.size() - 1)
                end = end - petrol.size();
        }

        // Return starting point
        return start;
    }

    static class Resul {

        int index;
        int max;

        public Resul(int index, int max) {
            this.index = index;
            this.max = max;
        }
    }

    static class Petrol {

        int litre;
        int distance;

        public int getLitre() {
            return litre;
        }

        public void setLitre(int litre) {
            this.litre = litre;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
