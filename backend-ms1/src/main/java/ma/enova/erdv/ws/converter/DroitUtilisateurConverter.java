package  ma.enova.erdv.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.enova.erdv.bean.core.Utilisateur;

import ma.enova.erdv.zynerator.util.StringUtil;
import ma.enova.erdv.zynerator.converter.AbstractConverter;
import ma.enova.erdv.zynerator.util.DateUtil;
import ma.enova.erdv.bean.history.DroitUtilisateurHistory;
import ma.enova.erdv.bean.core.DroitUtilisateur;
import ma.enova.erdv.ws.dto.DroitUtilisateurDto;

@Component
public class DroitUtilisateurConverter extends AbstractConverter<DroitUtilisateur, DroitUtilisateurDto, DroitUtilisateurHistory> {

    @Autowired
    private UtilisateurConverter utilisateurConverter ;
    @Autowired
    private DroitConverter droitConverter ;
    private boolean droit;
    private boolean utilisateur;

    public  DroitUtilisateurConverter(){
        super(DroitUtilisateur.class, DroitUtilisateurDto.class, DroitUtilisateurHistory.class);
    }

    @Override
    public DroitUtilisateur toItem(DroitUtilisateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        DroitUtilisateur item = new DroitUtilisateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.droit && dto.getDroit()!=null)
                item.setDroit(droitConverter.toItem(dto.getDroit())) ;

            if(dto.getUtilisateur() != null && dto.getUtilisateur().getId() != null){
                item.setUtilisateur(new Utilisateur());
                item.getUtilisateur().setId(dto.getUtilisateur().getId());
            }


        return item;
        }
    }

    @Override
    public DroitUtilisateurDto toDto(DroitUtilisateur item) {
        if (item == null) {
            return null;
        } else {
            DroitUtilisateurDto dto = new DroitUtilisateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.droit && item.getDroit()!=null) {
            dto.setDroit(droitConverter.toDto(item.getDroit())) ;
        }
        if(this.utilisateur && item.getUtilisateur()!=null) {
            dto.setUtilisateur(utilisateurConverter.toDto(item.getUtilisateur())) ;
        }
        return dto;
        }
    }


    public void initObject(boolean value) {
        this.droit = value;
        this.utilisateur = value;
    }


    public UtilisateurConverter getUtilisateurConverter(){
        return this.utilisateurConverter;
    }
    public void setUtilisateurConverter(UtilisateurConverter utilisateurConverter ){
        this.utilisateurConverter = utilisateurConverter;
    }
    public DroitConverter getDroitConverter(){
        return this.droitConverter;
    }
    public void setDroitConverter(DroitConverter droitConverter ){
        this.droitConverter = droitConverter;
    }
    public boolean  isDroit(){
        return this.droit;
    }
    public void  setDroit(boolean droit){
        this.droit = droit;
    }
    public boolean  isUtilisateur(){
        return this.utilisateur;
    }
    public void  setUtilisateur(boolean utilisateur){
        this.utilisateur = utilisateur;
    }
}
