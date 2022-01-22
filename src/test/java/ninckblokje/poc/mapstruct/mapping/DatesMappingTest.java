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

import ninckblokje.poc.mapstruct.dto.DatesDTO;
import ninckblokje.poc.mapstruct.model.Dates;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DatesMappingTest {

    @Test
    public void testFromDTO() throws ParseException {
        var sdf = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ssX");

        var pojo = DatesMapping.INSTANCE.fromDTO(new DatesDTO(
                sdf.parse("2022-01-22T20:15:00+01:00"),
                sdf.parse("2022-01-22T20:30:00+01:00"),
                sdf.parse("2022-01-22T20:45:00+01:00")
        ));
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Dates(
                        LocalDateTime.parse("2022-01-22T19:15:00"),
                        OffsetDateTime.parse("2022-01-22T20:30:00+01:00"),
                        ZonedDateTime.parse("2022-01-22T20:45:00+01:00[Europe/Amsterdam]")
                ));
    }

    @Test
    public void testToDTO() throws ParseException {
        var sdf = new SimpleDateFormat("yyyy-MM-d'T'HH:mm:ssX");

        var dto = DatesMapping.INSTANCE.toDTO(new Dates(
                LocalDateTime.parse("2022-01-22T19:15:00"),
                OffsetDateTime.parse("2022-01-22T20:30:00+01:00"),
                ZonedDateTime.parse("2022-01-22T20:45:00+01:00[Europe/Amsterdam]")
        ));
        assertThat(dto)
                .usingRecursiveComparison()
                .isEqualTo(new DatesDTO(
                        sdf.parse("2022-01-22T20:15:00+01:00"),
                        sdf.parse("2022-01-22T20:30:00+01:00"),
                        sdf.parse("2022-01-22T20:45:00+01:00")
                ));
    }
}
