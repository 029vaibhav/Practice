import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class City {

    int value;
    boolean special;
    LinkedList<City> cities;

    public City(int value, boolean special, LinkedList<City> cities) {
        this.value = value;
        this.special = special;
        this.cities = cities;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public LinkedList<City> getCities() {
        return cities;
    }

    public void setCities(LinkedList<City> cities) {
        this.cities = cities;
    }
}

public class ConnectionPower {


    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int cities = in.nextInt();
        int spC = in.nextInt();
        int roads = in.nextInt();

        List<City> cities1 = new ArrayList<>();
        for (int i = 0; i < cities; i++) {
            cities1.add(new City(i + 1, false, new LinkedList<City>()));
        }
        for (int i = 0; i < spC; i++) {
            int instanceID = in.nextInt();
            City city = cities1.get(instanceID - 1);
            city.setSpecial(true);
        }

        for (int i = 0; i < roads; i++) {
            int instanceID = in.nextInt();
            int instanceID1 = in.nextInt();
            City city = cities1.get(instanceID - 1);
            City city1 = cities1.get(instanceID1 - 1);
            city.getCities().add(city1);
        }

        final int[] count = {0};
        for (int i = 0; i < cities1.size(); i++) {

            City city = cities1.get(i);
            if (city.isSpecial())
                count[0]++;

            LinkedList<City> cities2 = city.getCities();
            while (cities2 != null && cities2.size() != 0) {
                City city1 = cities2.get(0);
                if (city1.isSpecial()) {
                     count[0] = count[0] + 2;
                }
                cities2 = cities2.get(0).getCities();
            }


        }


        System.out.println("" + count[0]);
    }
}
