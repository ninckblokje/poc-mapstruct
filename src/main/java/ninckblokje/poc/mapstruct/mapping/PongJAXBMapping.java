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

import ninckblokje.pingpong.ObjectFactory;
import ninckblokje.pingpong.PongResponse;
import ninckblokje.poc.mapstruct.jaxb.PongResponseWrapper;
import ninckblokje.poc.mapstruct.model.Pong;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ObjectFactory.class)
public interface PongJAXBMapping {

    PongJAXBMapping INSTANCE = Mappers.getMapper(PongJAXBMapping.class);

    default Pong fromWrapper(PongResponseWrapper source) {
        if (source == null) {
            return null;
        }

        var elem = source.getElem();
        if (elem == null) {
            return null;
        }

        var value = elem.getValue();
        if (value == null) {
            return null;
        }

        return mapPong(value);
    }

    @Mapping(source = ".", target = "elem")
    PongResponseWrapper toWrapper(Pong source);

    @Mapping(source = "clientIPAddress", target = "client.IPAddress")
    @Mapping(source = "hostName", target = "host.hostName")
    @Mapping(source = "arch", target = "host.architecture")
    @Mapping(source = "os", target = "host.operatingSystem")
    @Mapping(source = "name", target = "applicationServer.name")
    @Mapping(source = "framework", target = "applicationServer.framework")
    PongResponse mapPongResponse(Pong source);

    @InheritInverseConfiguration(name = "mapPongResponse")
    Pong mapPong(PongResponse source);

}
