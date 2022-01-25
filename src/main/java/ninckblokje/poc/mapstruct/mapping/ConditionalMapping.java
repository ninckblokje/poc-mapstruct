/*
 * Copyright (c) 2022, ninckblokje
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
