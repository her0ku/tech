package com.converter.tech.Service;

import com.converter.tech.DAO.HistoryRepository;
import com.converter.tech.Model.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void saveHistory(History history) {
        historyRepository.save(history);
    }

    @Override
    public List<History> getAllHistory() {
        List<History> histories = historyRepository.findAll();
        return histories;
    }
}
