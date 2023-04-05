package  ma.enova.erdv.dao.criteria.core;


import ma.enova.erdv.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DroitCriteria extends  BaseCriteria  {

    private String authority;
    private String authorityLike;



    public DroitCriteria(){}

    public String getAuthority(){
        return this.authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }
    public String getAuthorityLike(){
        return this.authorityLike;
    }
    public void setAuthorityLike(String authorityLike){
        this.authorityLike = authorityLike;
    }


}
