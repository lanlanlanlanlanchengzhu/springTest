package x.test.model.po;

import lombok.Data;

@Data
public class PropertiesPair {

    private String propertyType;

    private String propertyValue;

    public PropertiesPair(String propertyType, String propertyValue) {
        this.propertyType = propertyType;
        this.propertyValue = propertyValue;
    }
}
