package kz.alken1t.alex.ecarsprojectforspring.dto;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SortCategory {
    List<Cars> cars;
    List<String> strings;
}
