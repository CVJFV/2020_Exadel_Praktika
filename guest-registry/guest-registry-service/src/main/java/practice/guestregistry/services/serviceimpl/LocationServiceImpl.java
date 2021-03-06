package practice.guestregistry.services.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import practice.guestregistry.data.api.dao.LocationDao;
import practice.guestregistry.domain.Location;
import practice.guestregistry.exceptions.InvalidDocumentStateException;
import practice.guestregistry.exceptions.ResourceNotFoundException;
import practice.guestregistry.services.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationDao dao;

    @Autowired
//    public LocationServiceImpl(@Qualifier("h2repository") LocationDao dao) {
    public LocationServiceImpl(LocationDao dao) {
        this.dao = dao;
    }

    @Override
    public Location getLocationById(String id) {
        if (dao.existById(id)) {
            return dao.findById(id);
        }
        else {
            throw new ResourceNotFoundException("Location with this id doesn't exist");
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return dao.findAll();
    }

    @Override
    public void addLocation(Location location) {
        if (locationIsValid(location)) {
            if (dao.existById(location.getId())) {
                throw new InvalidDocumentStateException("A location with this id already exists");
            }
            else {
                dao.add(location);
            }
        }
    }

    @Override
    public void updateLocation(Location location) {
        if (locationIsValid(location)) {
            if (dao.existById(location.getId())) {
                dao.update(location);
            } else {
                throw new ResourceNotFoundException("Location with this id doesn't exist");
            }
        }
    }

    @Override
    public void deleteLocationById(String id) {
        if (dao.existById(id)) {
            dao.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Location with this id doesn't exist");
        }
    }

    @Override
    public void deleteAllLocations() {
        dao.deleteAll();
    }

    @Override
    public boolean locationExist(Location location) {
        return dao.exist(location);
    }

    @Override
    public boolean locationExistById(String id) {
        return dao.existById(id);
    }

    public boolean locationIsValid(Location location) {
        if (location.getCity() != null) {
            if (location.getAddress() != null) {
                if (location.getPhoneNumber().matches("^[\\+\\d]+(?:[\\d-.\\s()]*)$") ||
                        location.getPhoneNumber() == null) {
                    return true;
                } else {
                    throw new InvalidDocumentStateException("Location doesn't match phone number field requirements");
                }
            }
            else {
                throw new InvalidDocumentStateException("Location doesn't match address field requirements");
            }
        }
        else {
            throw new InvalidDocumentStateException("Location doesn't match city field requirements");
        }
    }
}
