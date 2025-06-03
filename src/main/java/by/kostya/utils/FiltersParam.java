package by.kostya.utils;


import lombok.Builder;
import lombok.Value;



@Value
@Builder
public class FiltersParam {
    String statusFilter;
    String priorityFilter;
    String sortedParam;
}
