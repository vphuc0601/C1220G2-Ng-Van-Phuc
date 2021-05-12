package service.impl;

import org.springframework.stereotype.Service;
import service.EmailBoxService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxServiceImpl implements EmailBoxService {

    public static List<String> listLanguage=new ArrayList<>();
    public static List<Integer> listPageSize=new ArrayList<>();

    static {
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japan");
        listLanguage.add("Chinese");
    }

    static {
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
    }
    @Override
    public List<String> getLanguage() {
        return listLanguage;
    }

    @Override
    public List<Integer> getPageSize() {
        return listPageSize;
    }
}
