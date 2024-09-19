package co.edu.uptc.utilities;

import java.util.Comparator;

public class VehicleComparator {

    public static Comparator<String> stateComparator = new Comparator<String>() {
        @Override
        public int compare(String vehicleOne, String vehicleTwo) {
        return vehicleTwo.compareTo(vehicleOne);
        }
    };

    public static Comparator<Integer> countComparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer one, Integer two){
            return Integer.compare(one, two);
        }
    };
}
