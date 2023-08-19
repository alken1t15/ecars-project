package kz.alken1t.alex.ecarsprojectforspring.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarFilterDescriptionHelper {
    private final List<String> description = new ArrayList<>();

    public CarFilterDescriptionHelper createDescription(String param) {
        if (hasParam(param))
            description.add(param);
        return this;
    }

    public CarFilterDescriptionHelper createDescription(Integer max, Integer min, String name) {
        if (min != null && max != null) {
            description.add(min + "-" + max + " " + name);
        } else if (min != null) {
            description.add(min + " " + name);
        } else if (max != null) {
            description.add(max + " " + name);
        }
        return this;
    }

    public CarFilterDescriptionHelper createDescription(List<String> values) {
        description.addAll(values);
        return this;
    }

    public List<String> build() {
        return description;
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
