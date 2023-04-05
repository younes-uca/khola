import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import {RoleService} from 'src/app/zynerator/security/Role.service';
import {StringUtilService} from 'src/app/zynerator/util/StringUtil.service';

import {MessageService} from 'primeng/api';
import {MenuItem} from 'primeng/api';
import { environment } from 'src/environments/environment';
import {UtilisateurService} from 'src/app/controller/service/Utilisateur.service';
import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/controller/criteria/UtilisateurCriteria.model';

import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import {DroitUtilisateurService} from 'src/app/controller/service/DroitUtilisateur.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitService} from 'src/app/controller/service/Droit.service';
@Component({
  selector: 'app-utilisateur-view-admin',
  templateUrl: './utilisateur-view-admin.component.html'
})
export class UtilisateurViewAdminComponent extends AbstractViewController<UtilisateurDto, UtilisateurCriteria, UtilisateurService> implements OnInit {

    droitUtilisateurs = new DroitUtilisateurDto();
    droitUtilisateurss: Array<DroitUtilisateurDto> = [];

    constructor(private datePipe: DatePipe, private utilisateurService: UtilisateurService
                , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
                , private router: Router  
, private droitUtilisateurService: DroitUtilisateurService, private droitService: DroitService
    ){
        super(datePipe, utilisateurService, messageService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
        this.droitUtilisateurs.droit = new DroitDto();
        this.droitService.findAll().subscribe((data) => this.droits = data);
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
