package ma.enova.erdv.service.facade.admin;

import java.util.List;
import ma.enova.erdv.bean.core.Produit;
import ma.enova.erdv.dao.criteria.core.ProduitCriteria;
import ma.enova.erdv.dao.criteria.history.ProduitHistoryCriteria;
import ma.enova.erdv.zynerator.service.IService;

public interface ProduitAdminService extends  IService<Produit,ProduitCriteria, ProduitHistoryCriteria>  {




}
