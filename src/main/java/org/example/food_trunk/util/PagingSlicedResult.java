package org.example.food_trunk.util;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class PagingSlicedResult<T> {


    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;


}
