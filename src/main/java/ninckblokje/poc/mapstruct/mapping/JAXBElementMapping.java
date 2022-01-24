package ninckblokje.poc.mapstruct.mapping;

import ninckblokje.mapstruct.test.FieldItem;
import ninckblokje.mapstruct.test.ObjectFactory;
import ninckblokje.poc.mapstruct.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.xml.bind.JAXBElement;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface JAXBElementMapping {

    JAXBElementMapping INSTANCE = Mappers.getMapper(JAXBElementMapping.class);

    List<Item> fromJAXB(List<JAXBElement<FieldItem>> source);

    List<JAXBElement<FieldItem>> toJAXB(List<Item> source);

    @Mapping(source = "value.field.value", target = "field")
    @Mapping(source = "name.localPart", target = "important", qualifiedByName = "mapImportant")
    Item mapFieldItem(JAXBElement<FieldItem> source);

    FieldItem mapItem(Item source);

    default JAXBElement<FieldItem> mapJAXBItem(Item source) {
        if (source.isImportant()) {
            return new ObjectFactory().createImportantFieldItem(mapItem(source));
        } else {
            return new ObjectFactory().createUnimportantFieldItem(mapItem(source));
        }
    }

    @Named("mapImportant")
    default boolean mapImportant(String localPart) {
        return "ImportantFieldItem".equals(localPart);
    }
}
