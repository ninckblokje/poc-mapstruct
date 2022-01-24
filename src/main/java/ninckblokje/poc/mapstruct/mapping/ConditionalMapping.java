package ninckblokje.poc.mapstruct.mapping;

import ninckblokje.poc.mapstruct.dto.ConditionalDTO;
import ninckblokje.poc.mapstruct.model.Conditional;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConditionalMapping {

    ConditionalMapping INSTANCE = Mappers.getMapper(ConditionalMapping.class);

    //    1.4 conditional implementation
    @Mapping(source = "field", target = "field", ignore = true)
    Conditional fromDTO(ConditionalDTO source);

    @InheritInverseConfiguration
    ConditionalDTO toDTO(Conditional source);

    @AfterMapping
    default void afterFromDTOMapping(ConditionalDTO source, @MappingTarget Conditional target) {
        if (source.isMapField()) {
            target.setField(source.getField());
        }
    }

    @AfterMapping
    default void afterToDTOMapping(Conditional source, @MappingTarget ConditionalDTO target) {
        if (source.isMapField()) {
            target.setField(source.getField());
        }
    }

//    1.5 conditional implementation
//    @Mapping(source = "field", target = "field", conditionQualifiedByName = "isMapField")
//    Conditional fromDTO(ConditionalDTO source);
//
//    @InheritInverseConfiguration
//    ConditionalDTO toDTO(Conditional source);
//
//    @Condition
//    @Named("isMapField")
//    default boolean isMapField(ConditionalDTO source) {
//        return source.isMapField();
//    }
//
//    @Condition
//    @Named("isMapField")
//    default boolean isMapField(Conditional source) {
//        return source.isMapField();
//    }
}
