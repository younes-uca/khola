import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DroitUtilisateurDto} from '../model/DroitUtilisateur.model';
import {DroitUtilisateurCriteria} from '../criteria/DroitUtilisateurCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {DroitDto} from '../model/Droit.model';
import {UtilisateurDto} from '../model/Utilisateur.model';

@Injectable({
  providedIn: 'root'
})
export class DroitUtilisateurService extends AbstractService<DroitUtilisateurDto, DroitUtilisateurCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/droitUtilisateur/');
    }

    public constrcutDto(): DroitUtilisateurDto {
        return new DroitUtilisateurDto();
    }

    public constrcutCriteria(): DroitUtilisateurCriteria {
        return new DroitUtilisateurCriteria();
    }
}
