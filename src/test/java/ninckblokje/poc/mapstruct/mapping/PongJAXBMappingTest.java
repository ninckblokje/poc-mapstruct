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

import ninckblokje.pingpong.*;
import ninckblokje.poc.mapstruct.jaxb.PongResponseWrapper;
import ninckblokje.poc.mapstruct.model.Pong;
import ninckblokje.poc.mapstruct.test.JAXBTestUtil;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class PongJAXBMappingTest {

    @Test
    public void testFromWrapper() throws DatatypeConfigurationException, ParseException {
        var pojo = PongJAXBMapping.INSTANCE.fromWrapper(JAXBTestUtil.createPongResponseWrapper());
        assertThat(pojo)
                .usingRecursiveComparison()
                .isEqualTo(new Pong(
                        LocalDateTime.parse("2022-01-22T23:00:00"),
                        "127.0.0.1",
                        "localhost",
                        "amd64",
                        "windows",
                        "QUARKUS",
                        "JAKARTA_EE"
                ));
    }

    @Test
    public void testToWrapper() throws DatatypeConfigurationException, ParseException {
        var jaxb = PongJAXBMapping.INSTANCE.toWrapper(new Pong(
                LocalDateTime.parse("2022-01-22T23:00:00"),
                "127.0.0.1",
                "localhost",
                "amd64",
                "windows",
                "QUARKUS",
                "JAKARTA_EE"
        ));
        assertThat(jaxb)
                .usingRecursiveComparison()
                .ignoringFields("elem.value.dateTime")
                .isEqualTo(JAXBTestUtil.createPongResponseWrapper());
        assertThat(jaxb.getElem().getValue().getDateTime().toXMLFormat())
                .isEqualTo("2022-01-22T23:00:00.000");
    }
}
