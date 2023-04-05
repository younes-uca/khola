package  ma.enova.erdv.ws.dto;

import ma.enova.erdv.zynerator.audit.Log;
import ma.enova.erdv.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilisateurDto  extends AuditBaseDto {

    private String email  ;
    private Boolean accountNonExpired  ;
    private Boolean accountNonLocked  ;
    private String username  ;
    private String password  ;
    private String lastName  ;
    private String firstName  ;
    private Boolean passwordChanged  ;
    private Integer failedAttemptCount  = 0 ;
    private String dateLock ;


    private List<DroitUtilisateurDto> droitUtilisateurs ;

    public UtilisateurDto(){
        super();
    }



    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }

    @Log
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }

    @Log
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    @Log
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Log
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Log
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Log
    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }

    @Log
    public Integer getFailedAttemptCount(){
        return this.failedAttemptCount;
    }
    public void setFailedAttemptCount(Integer failedAttemptCount){
        this.failedAttemptCount = failedAttemptCount;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLock(){
        return this.dateLock;
    }
    public void setDateLock(String dateLock){
        this.dateLock = dateLock;
    }



    public List<DroitUtilisateurDto> getDroitUtilisateurs(){
        return this.droitUtilisateurs;
    }

    public void setDroitUtilisateurs(List<DroitUtilisateurDto> droitUtilisateurs){
        this.droitUtilisateurs = droitUtilisateurs;
    }

}
