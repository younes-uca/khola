package ma.enova.erdv.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.enova.erdv.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "droit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="droit_seq",sequenceName="droit_seq",allocationSize=1, initialValue = 1)
public class DroitHistory extends HistBusinessObject  {


    public DroitHistory() {
    super();
    }

    public DroitHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="droit_seq")
    public Long getId() {
    return id;
    }
}

