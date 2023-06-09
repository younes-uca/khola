package  ma.enova.erdv.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.enova.erdv.zynerator.util.StringUtil;
import ma.enova.erdv.zynerator.converter.AbstractConverter;
import ma.enova.erdv.zynerator.util.DateUtil;
import ma.enova.erdv.bean.history.DroitHistory;
import ma.enova.erdv.bean.core.Droit;
import ma.enova.erdv.ws.dto.DroitDto;

@Component
public class DroitConverter extends AbstractConverter<Droit, DroitDto, DroitHistory> {


    public  DroitConverter(){
        super(Droit.class, DroitDto.class, DroitHistory.class);
    }

    @Override
    public Droit toItem(DroitDto dto) {
        if (dto == null) {
            return null;
        } else {
        Droit item = new Droit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getAuthority()))
                item.setAuthority(dto.getAuthority());

        return item;
        }
    }

    @Override
    public DroitDto toDto(Droit item) {
        if (item == null) {
            return null;
        } else {
            DroitDto dto = new DroitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getAuthority()))
                dto.setAuthority(item.getAuthority());
        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
