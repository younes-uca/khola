package ma.enova.erdv.dao.facade.core;


import ma.enova.erdv.zynerator.repository.AbstractRepository;
import ma.enova.erdv.bean.core.Produit;
import org.springframework.stereotype.Repository;
import ma.enova.erdv.bean.core.Produit;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {
    Produit findByReference(String reference);
    int deleteByReference(String reference);


}
