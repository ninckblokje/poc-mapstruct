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
