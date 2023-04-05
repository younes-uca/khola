import {Component, OnInit, Input} from '@angular/core';

import {ConfirmationService, MessageService} from 'primeng/api';
import {Router} from '@angular/router';
import {MenuItem} from 'primeng/api';
import { environment } from 'src/environments/environment';
import {DatePipe} from '@angular/common';

import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';
import {RoleService} from 'src/app/zynerator/security/Role.service';
import {StringUtilService} from 'src/app/zynerator/util/StringUtil.service';

import {DroitUtilisateurService} from 'src/app/controller/service/DroitUtilisateur.service';
import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import {DroitUtilisateurCriteria} from 'src/app/controller/criteria/DroitUtilisateurCriteria.model';


import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import {UtilisateurService} from 'src/app/controller/service/Utilisateur.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitService} from 'src/app/controller/service/Droit.service';

@Component({
  selector: 'app-droit-utilisateur-edit-admin',
  templateUrl: './droit-utilisateur-edit-admin.component.html'
})
export class DroitUtilisateurEditAdminComponent extends AbstractEditController<DroitUtilisateurDto, DroitUtilisateurCriteria, DroitUtilisateurService>   implements OnInit {



    private _validDroitAuthority = true;
    private _validUtilisateurEmail = true;
    private _validUtilisateurUsername = true;
    private _validUtilisateurPassword = true;
    private _validUtilisateurLastName = true;
    private _validUtilisateurFirstName = true;



    constructor(private datePipe: DatePipe, private droitUtilisateurService: DroitUtilisateurService
        , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
        , private confirmationService: ConfirmationService, private router: Router  
, private utilisateurService: UtilisateurService, private droitService: DroitService
    ) {
        super(datePipe, droitUtilisateurService, messageService, confirmationService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
    this.droit = new DroitDto();
    this.droitService.findAll().subscribe((data) => this.droits = data);
    this.utilisateur = new UtilisateurDto();
    this.utilisateurService.findAll().subscribe((data) => this.utilisateurs = data);
}

    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateUtilisateur(utilisateur: string) {
        const isPermistted = await this.roleService.isPermitted('Utilisateur', 'edit');
        if(isPermistted) {
             this.utilisateur = new UtilisateurDto();
             this.createUtilisateurDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateDroit(droit: string) {
        const isPermistted = await this.roleService.isPermitted('Droit', 'edit');
        if(isPermistted) {
             this.droit = new DroitDto();
             this.createDroitDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get utilisateur(): UtilisateurDto {
       return this.utilisateurService.item;
   }
  set utilisateur(value: UtilisateurDto) {
        this.utilisateurService.item = value;
   }
   get utilisateurs(): Array<UtilisateurDto> {
        return this.utilisateurService.items;
   }
   set utilisateurs(value: Array<UtilisateurDto>) {
        this.utilisateurService.items = value;
   }
   get createUtilisateurDialog(): boolean {
       return this.utilisateurService.createDialog;
   }
  set createUtilisateurDialog(value: boolean) {
       this.utilisateurService.createDialog= value;
   }
   get droit(): DroitDto {
       return this.droitService.item;
   }
  set droit(value: DroitDto) {
        this.droitService.item = value;
   }
   get droits(): Array<DroitDto> {
        return this.droitService.items;
   }
   set droits(value: Array<DroitDto>) {
        this.droitService.items = value;
   }
   get createDroitDialog(): boolean {
       return this.droitService.createDialog;
   }
  set createDroitDialog(value: boolean) {
       this.droitService.createDialog= value;
   }



    get validDroitAuthority(): boolean {
        return this._validDroitAuthority;
    }
    set validDroitAuthority(value: boolean) {
        this._validDroitAuthority = value;
    }
    get validUtilisateurEmail(): boolean {
        return this._validUtilisateurEmail;
    }
    set validUtilisateurEmail(value: boolean) {
        this._validUtilisateurEmail = value;
    }
    get validUtilisateurUsername(): boolean {
        return this._validUtilisateurUsername;
    }
    set validUtilisateurUsername(value: boolean) {
        this._validUtilisateurUsername = value;
    }
    get validUtilisateurPassword(): boolean {
        return this._validUtilisateurPassword;
    }
    set validUtilisateurPassword(value: boolean) {
        this._validUtilisateurPassword = value;
    }
    get validUtilisateurLastName(): boolean {
        return this._validUtilisateurLastName;
    }
    set validUtilisateurLastName(value: boolean) {
        this._validUtilisateurLastName = value;
    }
    get validUtilisateurFirstName(): boolean {
        return this._validUtilisateurFirstName;
    }
    set validUtilisateurFirstName(value: boolean) {
        this._validUtilisateurFirstName = value;
    }
}
