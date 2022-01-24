package ninckblokje.poc.mapstruct.mapping;

import ninckblokje.poc.mapstruct.model.Item;
import ninckblokje.poc.mapstruct.test.JAXBTestUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JAXBElementMappingTest {

    @Test
    public void testToJAXB() {
        var jaxb = JAXBElementMapping.INSTANCE.toJAXB(List.of(
                new Item("not important", false),
                new Item("important", true)
        ));
        assertThat(jaxb)
                .usingRecursiveComparison()
                .isEqualTo(List.of(
                        JAXBTestUtil.createUnimportantFieldItem(),
                        JAXBTestUtil.createImportantFieldItem()
                ));
    }

    @Test
    public void testFromJAXB() {
        var model = JAXBElementMapping.INSTANCE.fromJAXB(List.of(
                JAXBTestUtil.createUnimportantFieldItem(),
                JAXBTestUtil.createImportantFieldItem()
        ));
        assertThat(model)
                .usingRecursiveComparison()
                .isEqualTo(List.of(
                        new Item("not important", false),
                        new Item("important", true)
                ));
    }
}
