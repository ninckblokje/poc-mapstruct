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

import ninckblokje.mapstruct.test.FieldItem;
import ninckblokje.mapstruct.test.ObjectFactory;
import ninckblokje.poc.mapstruct.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.xml.bind.JAXBElement;
import java.util.List;

@Mapper(uses = ObjectFactory.class)
public interface JAXBElementMapping {

    JAXBElementMapping INSTANCE = Mappers.getMapper(JAXBElementMapping.class);

    List<Item> fromJAXB(List<JAXBElement<FieldItem>> source);

    List<JAXBElement<FieldItem>> toJAXB(List<Item> source);

    @Mapping(source = "value.field.value", target = "field")
    @Mapping(source = "name.localPart", target = "important", qualifiedByName = "mapImportant")
    Item mapFieldItem(JAXBElement<FieldItem> source);

    FieldItem mapItem(Item source);

    default JAXBElement<FieldItem> mapJAXBItem(Item source) {
        if (source.isImportant()) {
            return new ObjectFactory().createImportantFieldItem(mapItem(source));
        } else {
            return new ObjectFactory().createUnimportantFieldItem(mapItem(source));
        }
    }

    @Named("mapImportant")
    default boolean mapImportant(String localPart) {
        return "ImportantFieldItem".equals(localPart);
    }
}
