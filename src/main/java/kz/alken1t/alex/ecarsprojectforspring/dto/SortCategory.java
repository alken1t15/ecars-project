package kz.alken1t.alex.ecarsprojectforspring.dto;

import kz.alken1t.alex.ecarsprojectforspring.entity.Cars;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SortCategory {
    private List<Cars> cars;
    private List<String> strings;
    private List<Integer> count;
    private int found;
}