package ma.enova.erdv.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.enova.erdv.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "droit_utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="droit_utilisateur_seq",sequenceName="droit_utilisateur_seq",allocationSize=1, initialValue = 1)
public class DroitUtilisateurHistory extends HistBusinessObject  {


    public DroitUtilisateurHistory() {
    super();
    }

    public DroitUtilisateurHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="droit_utilisateur_seq")
    public Long getId() {
    return id;
    }
}

