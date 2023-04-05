package ma.enova.erdv.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.enova.erdv.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "droit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="droit_seq",sequenceName="droit_seq",allocationSize=1, initialValue = 1)
public class Droit    extends AuditBusinessObject   {

    private Long id;

    @Column(length = 500)
    private String authority;



    public Droit(){
        super();
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="droit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getAuthority(){
        return this.authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }

    @Transient
    public String getLabel() {
        label = authority;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Droit droit = (Droit) o;
        return id != null && id.equals(droit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

