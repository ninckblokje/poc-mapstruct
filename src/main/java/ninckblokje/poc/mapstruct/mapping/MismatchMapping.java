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

import ninckblokje.poc.mapstruct.dto.MismatchDTO;
import ninckblokje.poc.mapstruct.model.Mismatch;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MismatchMapping {

    MismatchMapping INSTANCE = Mappers.getMapper(MismatchMapping.class);

    @Mapping(source = "name", target = "mismatchName")
    @Mapping(source = "rating", target = "mismatchRating")
    @Mapping(target = "resolvable", ignore = true)
    Mismatch fromDTO(MismatchDTO source);

    @InheritInverseConfiguration(name = "fromDTO")
    MismatchDTO toDTO(Mismatch source);

    @InheritConfiguration(name = "fromDTO")
    void updateMismatch(MismatchDTO source, @MappingTarget Mismatch target);

    @InheritInverseConfiguration(name = "fromDTO")
    void updateMismatchDTO(Mismatch source, @MappingTarget MismatchDTO target);

    @ValueMappings(
            @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CONFLICT")
    )
    MismatchDTO.MismatchTypeDTO mismatchTypeMismatchTypeDTO(Mismatch.MismatchType source);
}
