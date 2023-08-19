package kz.alken1t.alex.ecarsprojectforspring.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import kz.alken1t.alex.ecarsprojectforspring.dto.CarFilter;
import kz.alken1t.alex.ecarsprojectforspring.dto.CarForPage;
import kz.alken1t.alex.ecarsprojectforspring.dto.SortCategory;
import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.entity.City;
import kz.alken1t.alex.ecarsprojectforspring.helpers.CarFilterDescriptionHelper;
import kz.alken1t.alex.ecarsprojectforspring.helpers.CarFilterPredicateHelper;
import kz.alken1t.alex.ecarsprojectforspring.repository.CarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CarsService {
    private final CarsRepository carsRepository;
    private final EntityManager entityManager;
    private final CityService cityService;

    public List<Cars> findAll() {
        return carsRepository.findAll();
    }

    public List<Cars> findAllByOrderByAddDate() {
        return carsRepository.findAllByOrderByAddDateDesc();
    }

    public List<Cars> findAllByOrderByPriceAsc() {
        return carsRepository.findAllByOrderByPriceAsc();
    }

    public List<Cars> findAllByOrderByPriceDesc() {
        return carsRepository.findAllByOrderByPriceDesc();
    }

    public Cars findById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }

    public List<Cars> getFoursCar() {
        Pageable pageable = PageRequest.of(0, 4);
        return carsRepository.findAll(pageable).getContent();
    }

    public List<String> getAllBrand() {
        return carsRepository.findBrand();
    }

    public List<String> getAllModels() {
        return carsRepository.findModel();
    }

    public List<String> getAllVehicleTypes() {
        return carsRepository.getAllVehicleTypes();
    }

    public List<Integer> getAllCylinders() {
        return carsRepository.getAllCylinders();
    }

    public List<String> getAllColor() {
        return carsRepository.getAllColor();
    }

    public List<Integer> getAllSeats() {
        return carsRepository.getAllSeats();
    }

    public List<String> getAllFuelType() {
        return carsRepository.getAllFuelType();
    }

    public List<String> getAllTransmission() {
        return carsRepository.getAllTransmission();
    }

    public SortCategory findBySort(CarFilter filter) {
        SortCategory sortCategory = new SortCategory();

        if (!StringUtils.isEmpty(filter.getSort())){
            List<Cars> cars;
            switch (filter.getSort()){
                case "add" -> cars = carsRepository.findAllByOrderByAddDateDesc();
                case "max" -> cars = carsRepository.findAllByOrderByPriceDesc();
                default -> cars = carsRepository.findAllByOrderByPriceAsc();
            }

            CarForPage carForPage = getCarForPage(cars,filter.getPage());
            sortCategory.setCars(carForPage.getCars());
            sortCategory.setCount(carForPage.getCount());
            sortCategory.setFound(cars.size());
            return sortCategory;
        }

        if (isEmpty(filter)){
            List<Cars> cars = findAll();
            CarForPage carForPage = getCarForPage(cars, filter.getPage());
            sortCategory.setCars(carForPage.getCars());
            sortCategory.setCount(carForPage.getCount());
            sortCategory.setFound(cars.size());
        }

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cars> query = builder.createQuery(Cars.class);
        Root<Cars> root = query.from(Cars.class);

        List<Predicate> predicates = createPredicate(filter, builder, root);
        Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[predicates.size()]));
        query.where(finalPredicate);

        List<String> description = createDescription(filter);
        sortCategory.setStrings(description);


        List<Cars> cars = entityManager.createQuery(query).getResultList();
        CarForPage carForPage = getCarForPage(cars, filter.getPage());
        sortCategory.setFound(cars.size());
        sortCategory.setCars(carForPage.getCars());
        sortCategory.setCount(carForPage.getCount());
        return sortCategory;
    }

    private List<String> createDescription(CarFilter filter) {
        return new CarFilterDescriptionHelper()
                .createDescription(filter.getBrand())
                .createDescription(filter.getModel())
                .createDescription(filter.getMinKm(), filter.getMaxKm(), "km")
                .createDescription(filter.getMinYear(), filter.getMaxYear(), "year")
                .createDescription(filter.getMinPrice(), filter.getMaxPrice(), "USD")
                .createDescription(filter.getVehicleType())
                .createDescription(filter.getCylinder())
                .createDescription(filter.getColor())
                .createDescription(filter.getSeat())
                .createDescription(filter.getFuelType())
                .createDescription(filter.getTransmission())
                .createDescription(filter.getCity())
                .build();
    }

    private List<Predicate> createPredicate(CarFilter filter, CriteriaBuilder builder, Root<Cars> root) {
        List<Long> cityIds = new ArrayList<>();
        for (String cityName: filter.getCity()){
            City city = cityService.findByName(cityName);
            cityIds.add(city.getId());
        }

        return new CarFilterPredicateHelper(builder, root)
                .createPredicateEquals(filter.getBrand(), "brand")
                .createPredicateEquals(filter.getModel(), "model")
                .createPredicateBetween(filter.getMinKm(), filter.getMaxKm(), "kilometers")
                .createPredicateBetween(filter.getMinYear(), filter.getMaxYear(), "year")
                .createPredicateBetween(filter.getMinPrice(), filter.getMaxPrice(), "price")
                .createPredicateEqualsList(filter.getVehicleType(), "vehicleType")
                .createPredicateEqualsList(filter.getCylinder(), "cylinders")
                .createPredicateEqualsList(filter.getColor(), "color")
                .createPredicateEqualsList(filter.getSeat(), "seats")
                .createPredicateEqualsList(filter.getFuelType(), "fuel")
                .createPredicateEqualsList(filter.getTransmission(), "gearbox")
                .createPredicateEqualsJoinList(cityIds, "id", root.join("city")).build();
    }


    private boolean isEmpty(CarFilter filter) {
        return !(hasParam(filter.getBrand())) || hasParam(filter.getModel()) || hasParam(filter.getMinKm()) || hasParam(filter.getMaxKm()) || hasParam(filter.getMinYear())
                || hasParam(filter.getMaxYear()) || hasParam(filter.getMinPrice()) || hasParam(filter.getMaxPrice()) || hasParam(filter.getCountry()) || hasParam(filter.getVehicleType())
                || hasParam(filter.getCity()) || hasParam(filter.getCylinder()) || hasParam(filter.getColor()) || hasParam(filter.getSeat()) || hasParam(filter.getFuelType()) || hasParam(filter.getTransmission());
    }



    public CarForPage getCarForPage(List<Cars> cars, Integer page) {
        if (page == null) {
            page = 0;
        }
        CarForPage carForPage = new CarForPage();
        final int number = 11;
        List<List<Cars>> carsList = new ArrayList<>();
        if (cars.size() <= number) {
            carForPage.setCars(cars);
            carForPage.setCount(new ArrayList<>());
            return carForPage;
        }
        for (int i = 0; i < cars.size(); i += number) {
            if (i + number > cars.size()) {
                carsList.add(cars.subList(i, cars.size()));
            } else {
                carsList.add(cars.subList(i, i + number));
            }
        }
        carForPage.setCars(carsList.get(page));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < carsList.size(); i++) {
            list.add(i);
        }
        carForPage.setCount(list);
        return carForPage;
    }


    private boolean hasParam(String param) {
        return Objects.nonNull(param) && !param.equals("All");
    }

    private boolean hasParam(List<?> param) {
        return param!=null && !param.isEmpty();
    }

    private boolean hasParam(Integer param) {
        return param!=null;
    }
}