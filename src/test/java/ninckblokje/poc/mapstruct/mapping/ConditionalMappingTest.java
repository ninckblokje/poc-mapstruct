package ninckblokje.poc.mapstruct.mapping;

import ninckblokje.poc.mapstruct.dto.ConditionalDTO;
import ninckblokje.poc.mapstruct.model.Conditional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalMappingTest {

    @Test
    public void testFromDTO() {
        var pojo = ConditionalMapping.INSTANCE.fromDTO(new ConditionalDTO("value", true));
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Conditional("value", true));

        pojo = ConditionalMapping.INSTANCE.fromDTO(new ConditionalDTO("value", false));
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Conditional(null, false));
    }

    @Test
    public void testToDTO() {
        var dto = ConditionalMapping.INSTANCE.toDTO(new Conditional("value", true));
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new ConditionalDTO("value", true));

        dto = ConditionalMapping.INSTANCE.toDTO(new Conditional("value", false));
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new ConditionalDTO(null, false));
    }
}
