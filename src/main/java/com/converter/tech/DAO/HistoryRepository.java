package com.converter.tech.DAO;

import com.converter.tech.Model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, String>{
}
