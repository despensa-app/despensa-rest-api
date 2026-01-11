package dev.nmarulo.despensa_app.commons.algolia;

import org.springframework.data.domain.Pageable;

public record ProductSearchAlgoliaReq(String query, Pageable pageable) {}
