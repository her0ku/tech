package com.converter.tech.DAO;

import com.converter.tech.Model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
