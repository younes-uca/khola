package ma.enova.erdv.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.enova.erdv.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="utilisateur_seq",sequenceName="utilisateur_seq",allocationSize=1, initialValue = 1)
public class Utilisateur    extends AuditBusinessObject   {

    private Long id;

    @Column(length = 500)
    private String email;
    @Column(columnDefinition = "boolean default false")
    private Boolean accountNonExpired = false;
    @Column(columnDefinition = "boolean default false")
    private Boolean accountNonLocked = false;
    @Column(length = 500)
    private String username;
    @Column(length = 500)
    private String password;
    @Column(length = 500)
    private String lastName;
    @Column(length = 500)
    private String firstName;
    @Column(columnDefinition = "boolean default false")
    private Boolean passwordChanged = false;
    private Integer failedAttemptCount = 0;
    private LocalDateTime dateLock ;


    private List<DroitUtilisateur> droitUtilisateurs ;

    public Utilisateur(){
        super();
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="utilisateur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public boolean  getAccountNonExpired(){
        return this.accountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired){
        this.accountNonExpired = accountNonExpired;
    }
    public boolean  getAccountNonLocked(){
        return this.accountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked){
        this.accountNonLocked = accountNonLocked;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public boolean  getPasswordChanged(){
        return this.passwordChanged;
    }
    public void setPasswordChanged(boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
    public Integer getFailedAttemptCount(){
        return this.failedAttemptCount;
    }
    public void setFailedAttemptCount(Integer failedAttemptCount){
        this.failedAttemptCount = failedAttemptCount;
    }
    public LocalDateTime getDateLock(){
        return this.dateLock;
    }
    public void setDateLock(LocalDateTime dateLock){
        this.dateLock = dateLock;
    }
    @OneToMany(mappedBy = "utilisateur")
    public List<DroitUtilisateur> getDroitUtilisateurs(){
        return this.droitUtilisateurs;
    }
    public void setDroitUtilisateurs(List<DroitUtilisateur> droitUtilisateurs){
        this.droitUtilisateurs = droitUtilisateurs;
    }

    @Transient
    public String getLabel() {
        label = username;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur utilisateur = (Utilisateur) o;
        return id != null && id.equals(utilisateur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

