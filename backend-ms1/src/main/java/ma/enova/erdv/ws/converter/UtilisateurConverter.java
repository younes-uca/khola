package  ma.enova.erdv.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.enova.erdv.zynerator.util.ListUtil;


import ma.enova.erdv.zynerator.util.StringUtil;
import ma.enova.erdv.zynerator.converter.AbstractConverter;
import ma.enova.erdv.zynerator.util.DateUtil;
import ma.enova.erdv.bean.history.UtilisateurHistory;
import ma.enova.erdv.bean.core.Utilisateur;
import ma.enova.erdv.ws.dto.UtilisateurDto;

@Component
public class UtilisateurConverter extends AbstractConverter<Utilisateur, UtilisateurDto, UtilisateurHistory> {

    @Autowired
    private DroitUtilisateurConverter droitUtilisateurConverter ;
    @Autowired
    private DroitConverter droitConverter ;
    private boolean droitUtilisateurs;

    public  UtilisateurConverter(){
        super(Utilisateur.class, UtilisateurDto.class, UtilisateurHistory.class);
        init(true);
    }

    @Override
    public Utilisateur toItem(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Utilisateur item = new Utilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(dto.getAccountNonExpired() != null)
                item.setAccountNonExpired(dto.getAccountNonExpired());
            if(dto.getAccountNonLocked() != null)
                item.setAccountNonLocked(dto.getAccountNonLocked());
            if(StringUtil.isNotEmpty(dto.getUsername()))
                item.setUsername(dto.getUsername());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());
            if(StringUtil.isNotEmpty(dto.getLastName()))
                item.setLastName(dto.getLastName());
            if(StringUtil.isNotEmpty(dto.getFirstName()))
                item.setFirstName(dto.getFirstName());
            if(dto.getPasswordChanged() != null)
                item.setPasswordChanged(dto.getPasswordChanged());
            if(StringUtil.isNotEmpty(dto.getFailedAttemptCount()))
                item.setFailedAttemptCount(dto.getFailedAttemptCount());
            if(StringUtil.isNotEmpty(dto.getDateLock()))
                item.setDateLock(DateUtil.stringEnToDate(dto.getDateLock()));

            if(this.droitUtilisateurs && ListUtil.isNotEmpty(dto.getDroitUtilisateurs()))
                item.setDroitUtilisateurs(droitUtilisateurConverter.toItem(dto.getDroitUtilisateurs()));
        return item;
        }
    }

    @Override
    public UtilisateurDto toDto(Utilisateur item) {
        if (item == null) {
            return null;
        } else {
            UtilisateurDto dto = new UtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getAccountNonExpired()))
                dto.setAccountNonExpired(item.getAccountNonExpired());
            if(StringUtil.isNotEmpty(item.getAccountNonLocked()))
                dto.setAccountNonLocked(item.getAccountNonLocked());
            if(StringUtil.isNotEmpty(item.getUsername()))
                dto.setUsername(item.getUsername());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());
            if(StringUtil.isNotEmpty(item.getLastName()))
                dto.setLastName(item.getLastName());
            if(StringUtil.isNotEmpty(item.getFirstName()))
                dto.setFirstName(item.getFirstName());
            if(StringUtil.isNotEmpty(item.getPasswordChanged()))
                dto.setPasswordChanged(item.getPasswordChanged());
            if(StringUtil.isNotEmpty(item.getFailedAttemptCount()))
                dto.setFailedAttemptCount(item.getFailedAttemptCount());
            if(item.getDateLock()!=null)
                dto.setDateLock(DateUtil.dateTimeToString(item.getDateLock()));
        if(this.droitUtilisateurs && ListUtil.isNotEmpty(item.getDroitUtilisateurs())){
            droitUtilisateurConverter.init(true);
            droitUtilisateurConverter.setUtilisateur(false);
            dto.setDroitUtilisateurs(droitUtilisateurConverter.toDto(item.getDroitUtilisateurs()));
            droitUtilisateurConverter.setUtilisateur(true);

        }
        return dto;
        }
    }

    public void initList(boolean value) {
        this.droitUtilisateurs = value;
    }

    public void initObject(boolean value) {
    }


    public DroitUtilisateurConverter getDroitUtilisateurConverter(){
        return this.droitUtilisateurConverter;
    }
    public void setDroitUtilisateurConverter(DroitUtilisateurConverter droitUtilisateurConverter ){
        this.droitUtilisateurConverter = droitUtilisateurConverter;
    }
    public DroitConverter getDroitConverter(){
        return this.droitConverter;
    }
    public void setDroitConverter(DroitConverter droitConverter ){
        this.droitConverter = droitConverter;
    }
    public boolean  isDroitUtilisateurs(){
        return this.droitUtilisateurs ;
    }
    public void  setDroitUtilisateurs(boolean droitUtilisateurs ){
        this.droitUtilisateurs  = droitUtilisateurs ;
    }
}
