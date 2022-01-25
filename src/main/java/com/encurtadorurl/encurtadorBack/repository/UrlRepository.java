package com.encurtadorurl.encurtadorBack.repository;

import com.encurtadorurl.encurtadorBack.entity.urlEncurtadaEntity;

import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<urlEncurtadaEntity, Integer> {
    urlEncurtadaEntity findByurlEncurtada(String url);
}
