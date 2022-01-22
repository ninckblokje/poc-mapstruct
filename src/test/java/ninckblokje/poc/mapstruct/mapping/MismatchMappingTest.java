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
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MismatchMappingTest {

    @Test
    public void testFromDTO() {
        var pojo = MismatchMapping.INSTANCE.fromDTO(new MismatchDTO(
                "name",
                MismatchDTO.MismatchTypeDTO.CONFLICT,
                42L
        ));
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Mismatch(
                        "name",
                        Mismatch.MismatchType.CONFLICT,
                        42L,
                        false
                ));
    }

    @Test
    public void testToDTO() {
        var dto = MismatchMapping.INSTANCE.toDTO(new Mismatch(
                "name",
                Mismatch.MismatchType.WIP,
                42L,
                true
        ));
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new MismatchDTO(
                        "name",
                        MismatchDTO.MismatchTypeDTO.CONFLICT,
                        42L
                ));
    }

    @Test
    public void testUpdateMismatch() {
        var pojo = new Mismatch();
        MismatchMapping.INSTANCE.updateMismatch(new MismatchDTO(
                "name",
                MismatchDTO.MismatchTypeDTO.CONFLICT,
                42L
        ), pojo);
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Mismatch(
                        "name",
                        Mismatch.MismatchType.CONFLICT,
                        42L,
                        false
                ));
    }

    @Test
    public void testUpdateMismatchDTO() {
        var dto = new MismatchDTO();
        MismatchMapping.INSTANCE.updateMismatchDTO(new Mismatch(
                "name",
                Mismatch.MismatchType.WIP,
                42L,
                true
        ), dto);
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new MismatchDTO(
                        "name",
                        MismatchDTO.MismatchTypeDTO.CONFLICT,
                        42L
                ));
    }

    @Test
    public void testMismatchTypeMismatchTypeDTO() {
        assertThat(MismatchMapping.INSTANCE.mismatchTypeMismatchTypeDTO(Mismatch.MismatchType.CONFLICT))
                .isEqualTo(MismatchDTO.MismatchTypeDTO.CONFLICT);
        assertThat(MismatchMapping.INSTANCE.mismatchTypeMismatchTypeDTO(Mismatch.MismatchType.WIP))
                .isEqualTo(MismatchDTO.MismatchTypeDTO.CONFLICT);
        assertThat(MismatchMapping.INSTANCE.mismatchTypeMismatchTypeDTO(Mismatch.MismatchType.RESOLVED))
                .isEqualTo(MismatchDTO.MismatchTypeDTO.RESOLVED);
    }
}
