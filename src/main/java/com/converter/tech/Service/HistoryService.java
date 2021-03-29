package com.converter.tech.Service;

import com.converter.tech.Model.History;

import java.util.List;

public interface HistoryService {
    void saveHistory(History history);
    List<History> getAllHistory();
}
