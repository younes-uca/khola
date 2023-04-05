package ma.enova.erdv.dao.facade.core;


import ma.enova.erdv.zynerator.repository.AbstractRepository;
import ma.enova.erdv.bean.core.Droit;
import org.springframework.stereotype.Repository;
import ma.enova.erdv.bean.core.Droit;
import java.util.List;


@Repository
public interface DroitDao extends AbstractRepository<Droit,Long>  {
    Droit findByAuthority(String authority);
    int deleteByAuthority(String authority);


}
