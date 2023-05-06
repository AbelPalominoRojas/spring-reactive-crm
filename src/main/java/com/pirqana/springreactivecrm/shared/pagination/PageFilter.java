package com.pirqana.springreactivecrm.shared.pagination;

import lombok.Data;

import java.util.Optional;

@Data
public class PageFilter<T> {
    private int page;

    private int size;

    // private Sort sort;

    private Optional<T> filter;
}
