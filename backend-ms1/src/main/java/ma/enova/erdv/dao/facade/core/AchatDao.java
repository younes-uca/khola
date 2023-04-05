package ma.enova.erdv.dao.facade.core;


import ma.enova.erdv.zynerator.repository.AbstractRepository;
import ma.enova.erdv.bean.core.Achat;
import org.springframework.stereotype.Repository;
import ma.enova.erdv.bean.core.Achat;
import java.util.List;


@Repository
public interface AchatDao extends AbstractRepository<Achat,Long>  {
    Achat findByReference(String reference);
    int deleteByReference(String reference);

    List<Achat> findByClientId(Long id);
    int deleteByClientId(Long id);

}
