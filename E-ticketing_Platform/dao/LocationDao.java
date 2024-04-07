package dao;

import model.Location;
import java.util.HashSet;
import java.util.Set;

public class LocationDao {
    private static Set<Location> locations = new HashSet<>();

    public Location read(String city){
        for(Location l : locations){
            if(l.getCity().equals(city)){
                return l;
            }
        }
        return null;
    }

    public void removeLocation(Location location){
        locations.remove(location);
    }

    public void addLocation(Location location){
        locations.add(location);
    }
}
