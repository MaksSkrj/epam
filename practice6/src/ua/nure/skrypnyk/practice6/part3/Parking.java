package ua.nure.skrypnyk.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<String> parkingList;

    public Parking(int parkingPlaces) {
        parkingList = new ArrayList<>();
        for (int i = 0; i < parkingPlaces; i++) {
            parkingList.add("empty");
        }
    }

    public String add(String carName) {
        for (int i = 0; i < parkingList.size(); i++) {
            if (!parkingList.contains("empty")) {
                return "All parking places is busy";
            }
            if (parkingList.get(i).equals("empty")) {
                parkingList.set(i, carName);
                return ("Your car: " + carName + " parked at " + i + " place");
            }
        }
        return null;
    }

    public String remove(String carName){
        if(!parkingList.contains(carName)) return "This car is not parked yet";
        parkingList.set(parkingList.indexOf(carName), "empty");
        return (carName + " left parking");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : parkingList) {
            sb.append(s + " ");
        }
        return sb.toString();
    }
}
