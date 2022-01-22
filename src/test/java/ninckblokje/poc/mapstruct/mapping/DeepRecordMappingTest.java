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

import ninckblokje.poc.mapstruct.dto.DeepRecordDTO;
import ninckblokje.poc.mapstruct.model.DeepRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeepRecordMappingTest {

    @Test
    public void testFromDTO() {
        var pojo = DeepRecordMapping.INSTANCE.fromDTO(
                new DeepRecordDTO.ParentDTO(
                        new DeepRecordDTO.ChildDTO("child"),
                        List.of(
                                new DeepRecordDTO.ItemDTO(1),
                                new DeepRecordDTO.ItemDTO(2)
                        )
                )
        );
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new DeepRecord.Parent(
                        new DeepRecord.Child("child"),
                        List.of(
                                new DeepRecord.Item(1),
                                new DeepRecord.Item(2)
                        )
                ));
    }

    @Test
    public void testToDTO() {
        var dto = DeepRecordMapping.INSTANCE.toDTO(
                new DeepRecord.Parent(
                        new DeepRecord.Child("child"),
                        List.of(
                                new DeepRecord.Item(1),
                                new DeepRecord.Item(2)
                        )
                )
        );
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new DeepRecordDTO.ParentDTO(
                        new DeepRecordDTO.ChildDTO("child"),
                        List.of(
                                new DeepRecordDTO.ItemDTO(1),
                                new DeepRecordDTO.ItemDTO(2)
                        )
                ));
    }
}
