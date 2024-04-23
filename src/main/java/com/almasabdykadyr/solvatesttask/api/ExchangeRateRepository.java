package com.almasabdykadyr.solvatesttask.api;

import com.almasabdykadyr.solvatesttask.api.enitity.ExchangeRate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableRedisRepositories(basePackageClasses = ExchangeRateRepository.class)
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    public ExchangeRate findOneByTargetCurrency(String code);
}
