import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import {RoleService} from 'src/app/zynerator/security/Role.service';
import {StringUtilService} from 'src/app/zynerator/util/StringUtil.service';

import {MessageService} from 'primeng/api';
import {MenuItem} from 'primeng/api';
import { environment } from 'src/environments/environment';
import {DroitUtilisateurService} from 'src/app/controller/service/DroitUtilisateur.service';
import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import {DroitUtilisateurCriteria} from 'src/app/controller/criteria/DroitUtilisateurCriteria.model';

import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import {UtilisateurService} from 'src/app/controller/service/Utilisateur.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitService} from 'src/app/controller/service/Droit.service';
@Component({
  selector: 'app-droit-utilisateur-view-admin',
  templateUrl: './droit-utilisateur-view-admin.component.html'
})
export class DroitUtilisateurViewAdminComponent extends AbstractViewController<DroitUtilisateurDto, DroitUtilisateurCriteria, DroitUtilisateurService> implements OnInit {


    constructor(private datePipe: DatePipe, private droitUtilisateurService: DroitUtilisateurService
                , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
                , private router: Router  
, private utilisateurService: UtilisateurService, private droitService: DroitService
    ){
        super(datePipe, droitUtilisateurService, messageService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
        this.droit = new DroitDto();
        this.droitService.findAll().subscribe((data) => this.droits = data);
        this.utilisateur = new UtilisateurDto();
        this.utilisateurService.findAll().subscribe((data) => this.utilisateurs = data);
    }


    get utilisateur(): UtilisateurDto {
       return this.utilisateurService.item;
    }
    set utilisateur(value: UtilisateurDto) {
        this.utilisateurService.item = value;
    }
    get utilisateurs():Array<UtilisateurDto> {
       return this.utilisateurService.items;
    }
    set utilisateurs(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
    }
    get droit(): DroitDto {
       return this.droitService.item;
    }
    set droit(value: DroitDto) {
        this.droitService.item = value;
    }
    get droits():Array<DroitDto> {
       return this.droitService.items;
    }
    set droits(value: Array<DroitDto>) {
        this.droitService.items = value;
    }


}
