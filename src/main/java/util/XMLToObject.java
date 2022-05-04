package util;

import model.SearchFilter;
import model.SearchFilterTemp;
import model.SearchFilters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToObject {
    public static SearchFilter useSearchFilter() {

        try {
            File file = new File("src\\main\\resources\\searchFilter.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(SearchFilter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SearchFilter searchFilter = (SearchFilter) unmarshaller.unmarshal(file);
            return searchFilter;

        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
