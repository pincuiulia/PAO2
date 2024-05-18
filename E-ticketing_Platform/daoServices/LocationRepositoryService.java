package daoServices;

import dao.LocationDao;
import model.Location;

import java.sql.SQLException;


public class LocationRepositoryService {

    private LocationDao locationDao;

    public LocationRepositoryService() throws SQLException {
        this.locationDao = new LocationDao();
    }

    public void addLocation(String city, String address, Integer capacity) throws SQLException {
        Location location = new Location(city, address, capacity);
        locationDao.addLocation(location);
        System.out.println("Location added: " + location);
    }

    public void removeLocation(Location location) throws SQLException {
        locationDao.removeLocation(location);
        System.out.println("Location removed: " + location);
    }

    public Location getLocationByCity(String city) throws SQLException {
      Location location = locationDao.read(city);
        if (location != null)
            System.out.println(location);
        else
            System.out.println("No locations found for city: " + city);

        return location;
    }
}
