package kz.alken1t.alex.ecarsprojectforspring.helpers;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import kz.alken1t.alex.ecarsprojectforspring.entity.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarFilterPredicateHelper {
    private final List<Predicate> predicates = new ArrayList<>();
    private final CriteriaBuilder builder;
    private final Root<Cars> root;

    public CarFilterPredicateHelper(CriteriaBuilder builder, Root<Cars> root) {
        this.builder = builder;
        this.root = root;
    }

    public CarFilterPredicateHelper createPredicateEqualsJoinList(List<Long> values,
                                               String name,
                                               Join<Cars, City> join) {
        List<Predicate> predicateList = new ArrayList<>();
        for(Long value : values) {
            predicateList.add(builder.equal(join.get(name), value));
        }

        if (!predicateList.isEmpty()) {
            Predicate predicate = builder.or(predicateList.toArray(new Predicate[predicateList.size()]));
            predicates.add(predicate);
        }

        return this;
    }

    public CarFilterPredicateHelper createPredicateEquals(String value,
                                       String name) {
        if (hasParam(value))
            predicates.add(builder.equal(root.get(name), value));

        return this;
    }

    public CarFilterPredicateHelper createPredicateBetween(Integer max,
                                        Integer min,
                                        String name) {
        if (hasParam(min) && hasParam(max) ) {
            predicates.add(builder.between(root.get(name), min, max));
        } else if (hasParam(min)) {
            predicates.add(builder.greaterThanOrEqualTo(root.get(name), min));
        } else if (hasParam(max)) {
            predicates.add(builder.between(root.get(name), 0, max));
        }

        return this;
    }

    public CarFilterPredicateHelper createPredicateEqualsList(List<String> values,
                                           String name) {
        List<Predicate> predicateList = new ArrayList<>();
        for(String value : values) {
            predicateList.add(builder.equal(root.get(name), value));
        }

        if (!predicateList.isEmpty()) {
            Predicate predicate = builder.or(predicateList.toArray(new Predicate[predicateList.size()]));
            predicates.add(predicate);
        }

        return this;
    }

    public List<Predicate> build() {
        return predicates;
    }

    private boolean hasParam(String param) {
        return Objects.nonNull(param) && !param.equals("All");
    }

    private boolean hasParam(List<?> param) {
        return param != null && !param.isEmpty();
    }

    private boolean hasParam(Integer param) {
        return param != null;
    }
}
