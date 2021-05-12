package service;

import model.EmailBox;

import java.util.List;

public interface EmailBoxService {
    List<String> getLanguage ();
    List<Integer> getPageSize();
}
