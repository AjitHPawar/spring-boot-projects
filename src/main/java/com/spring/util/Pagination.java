package com.spring.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class Pagination {

    public Pageable getPagination(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
        if (pageNo != null && pageSize != null) {
            if (sortBy != null && sortDir != null) {
                Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                        Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
                Pageable page = PageRequest.of(pageNo, pageSize, sort);
                return page;
            } else {
                return PageRequest.of(pageNo, pageSize);
            }
        } else return Pageable.unpaged();
    }

}
