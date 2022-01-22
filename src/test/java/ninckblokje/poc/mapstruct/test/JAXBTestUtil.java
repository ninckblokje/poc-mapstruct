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

package ninckblokje.poc.mapstruct.test;

import ninckblokje.pingpong.*;
import ninckblokje.poc.mapstruct.jaxb.PongResponseWrapper;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class JAXBTestUtil {

    private JAXBTestUtil() {}

    public static PongResponseWrapper createPongResponseWrapper() throws DatatypeConfigurationException, ParseException {
        var wrapper = new PongResponseWrapper();

        wrapper.setElem(new ObjectFactory().createPongResponse(createPongResponse()));

        return wrapper;
    }

    public static PongResponse createPongResponse() throws ParseException, DatatypeConfigurationException {
        var response = new PongResponse();

        var sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        var date = sdf.parse("2022-01-22T23:00:00+01:00");
        var cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        response.setDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal));

        response.setClient(createClientInformation());
        response.setHost(createHostInformation());
        response.setApplicationServer(createApplicationServerInformation());

        return response;
    }

    public static ClientInformation createClientInformation() {
        var info = new ClientInformation();

        info.setIPAddress("127.0.0.1");

        return info;
    }

    public static HostInformation createHostInformation() {
        var info = new HostInformation();

        info.setHostName("localhost");
        info.setArchitecture("amd64");
        info.setOperatingSystem("windows");

        return info;
    }

    public static ApplicationServerInformation createApplicationServerInformation() {
        var info = new ApplicationServerInformation();

        info.setName(ApplicationServer.QUARKUS);
        info.setFramework(Framework.JAKARTA_EE);

        return info;
    }
}
