import {DroitDto} from './Droit.model';
import {UtilisateurDto} from './Utilisateur.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

export class DroitUtilisateurDto  extends BaseDto{

    public id: number;
    public droit: DroitDto ;
    public utilisateur: UtilisateurDto ;

}
