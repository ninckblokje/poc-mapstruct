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

package ninckblokje.poc.mapstruct.dto;

import java.util.Date;

public class DatesDTO {

    private Date ldt;
    private Date odt;
    private Date zdt;

    public DatesDTO() {}

    public DatesDTO(Date ldt, Date odt, Date zdt) {
        this.ldt = ldt;
        this.odt = odt;
        this.zdt = zdt;
    }

    public Date getLdt() {
        return ldt;
    }

    public void setLdt(Date ldt) {
        this.ldt = ldt;
    }

    public Date getOdt() {
        return odt;
    }

    public void setOdt(Date odt) {
        this.odt = odt;
    }

    public Date getZdt() {
        return zdt;
    }

    public void setZdt(Date zdt) {
        this.zdt = zdt;
    }

    @Override
    public String toString() {
        return "DatesDTO{" +
                "ldt=" + ldt +
                ", odt=" + odt +
                ", zdt=" + zdt +
                '}';
    }
}
