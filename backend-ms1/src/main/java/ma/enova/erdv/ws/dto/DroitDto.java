package  ma.enova.erdv.ws.dto;

import ma.enova.erdv.zynerator.audit.Log;
import ma.enova.erdv.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class DroitDto  extends AuditBaseDto {

    private String authority  ;



    public DroitDto(){
        super();
    }



    @Log
    public String getAuthority(){
        return this.authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }




}
