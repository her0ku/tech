package com.converter.tech.DAO;

import com.converter.tech.Model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, String> {
}
