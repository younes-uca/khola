package  ma.enova.erdv.dao.criteria.core;


import ma.enova.erdv.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class UtilisateurCriteria extends  BaseCriteria  {

    private String email;
    private String emailLike;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private String username;
    private String usernameLike;
    private String password;
    private String passwordLike;
    private String lastName;
    private String lastNameLike;
    private String firstName;
    private String firstNameLike;
    private Boolean passwordChanged;
    private String failedAttemptCount;
    private String failedAttemptCountMin;
    private String failedAttemptCountMax;
    private LocalDateTime dateLock;
    private LocalDateTime dateLockFrom;
    private LocalDateTime dateLockTo;



    public UtilisateurCriteria(){}

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public Boolean getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(Boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public Boolean getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsernameLike(){
        return this.usernameLike;
    }
    public void setUsernameLike(String usernameLike){
        this.usernameLike = usernameLike;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPasswordLike(){
        return this.passwordLike;
    }
    public void setPasswordLike(String passwordLike){
        this.passwordLike = passwordLike;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastNameLike(){
        return this.lastNameLike;
    }
    public void setLastNameLike(String lastNameLike){
        this.lastNameLike = lastNameLike;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstNameLike(){
        return this.firstNameLike;
    }
    public void setFirstNameLike(String firstNameLike){
        this.firstNameLike = firstNameLike;
    }

    public Boolean getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public String getFailedAttemptCount(){
        return this.failedAttemptCount;
    }
    public void setFailedAttemptCount(String failedAttemptCount){
        this.failedAttemptCount = failedAttemptCount;
    }   
    public String getFailedAttemptCountMin(){
        return this.failedAttemptCountMin;
    }
    public void setFailedAttemptCountMin(String failedAttemptCountMin){
        this.failedAttemptCountMin = failedAttemptCountMin;
    }
    public String getFailedAttemptCountMax(){
        return this.failedAttemptCountMax;
    }
    public void setFailedAttemptCountMax(String failedAttemptCountMax){
        this.failedAttemptCountMax = failedAttemptCountMax;
    }
      
    public LocalDateTime getDateLock(){
        return this.dateLock;
    }
    public void setDateLock(LocalDateTime dateLock){
        this.dateLock = dateLock;
    }
    public LocalDateTime getDateLockFrom(){
        return this.dateLockFrom;
    }
    public void setDateLockFrom(LocalDateTime dateLockFrom){
        this.dateLockFrom = dateLockFrom;
    }
    public LocalDateTime getDateLockTo(){
        return this.dateLockTo;
    }
    public void setDateLockTo(LocalDateTime dateLockTo){
        this.dateLockTo = dateLockTo;
    }

}
