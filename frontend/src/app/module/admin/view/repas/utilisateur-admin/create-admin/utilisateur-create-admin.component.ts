import {Component, OnInit, Input} from '@angular/core';

import {RoleService} from 'src/app/zynerator/security/Role.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { environment } from 'src/environments/environment';
import { DatePipe } from '@angular/common';

import { StringUtilService } from 'src/app/zynerator/util/StringUtil.service';
import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {UtilisateurService} from 'src/app/controller/service/Utilisateur.service';
import {UtilisateurDto} from 'src/app/controller/model/Utilisateur.model';
import {UtilisateurCriteria} from 'src/app/controller/criteria/UtilisateurCriteria.model';
import {DroitUtilisateurDto} from 'src/app/controller/model/DroitUtilisateur.model';
import {DroitUtilisateurService} from 'src/app/controller/service/DroitUtilisateur.service';
import {DroitDto} from 'src/app/controller/model/Droit.model';
import {DroitService} from 'src/app/controller/service/Droit.service';
@Component({
  selector: 'app-utilisateur-create-admin',
  templateUrl: './utilisateur-create-admin.component.html'
})
export class UtilisateurCreateAdminComponent extends AbstractCreateController<UtilisateurDto, UtilisateurCriteria, UtilisateurService>  implements OnInit {

    private _droitUtilisateursElement = new DroitUtilisateurDto();


   private _validUtilisateurEmail = true;
   private _validUtilisateurUsername = true;
   private _validUtilisateurPassword = true;
   private _validUtilisateurLastName = true;
   private _validUtilisateurFirstName = true;
    private _droitUtilisateurs: Array<DroitUtilisateurDto> = [];

    constructor(private datePipe: DatePipe, private utilisateurService: UtilisateurService
     , private stringUtilService: StringUtilService, private roleService: RoleService,  private messageService: MessageService
    , private confirmationService: ConfirmationService, private router: Router  
, private droitUtilisateurService: DroitUtilisateurService, private droitService: DroitService
    ) {
        super(datePipe, utilisateurService, messageService, confirmationService, roleService, router, stringUtilService);
    }

    ngOnInit(): void {
        this.droitService.findAll().subscribe(data => this.prepareDroitUtilisateurs(data));
        this.droitUtilisateursElement.droit = new DroitDto();
        this.droitService.findAll().subscribe((data) => this.droits = data);
}

     prepareDroitUtilisateurs(droits: Array<DroitDto>): void{
        if( droits != null){
                droits.forEach(e => {
                const droitUtilisateur = new DroitUtilisateurDto();
                droitUtilisateur.droit = e;
                this.droitUtilisateurs.push(droitUtilisateur);
            });
        }
    }



    public setValidation(value: boolean){
        this.validUtilisateurEmail = value;
        this.validUtilisateurUsername = value;
        this.validUtilisateurPassword = value;
        this.validUtilisateurLastName = value;
        this.validUtilisateurFirstName = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateUtilisateurEmail();
        this.validateUtilisateurUsername();
        this.validateUtilisateurPassword();
        this.validateUtilisateurLastName();
        this.validateUtilisateurFirstName();
    }

    public validateUtilisateurEmail(){
        if (this.stringUtilService.isEmpty(this.item.email)) {
        this.errorMessages.push('Email non valide');
        this.validUtilisateurEmail = false;
        } else {
            this.validUtilisateurEmail = true;
        }
    }
    public validateUtilisateurUsername(){
        if (this.stringUtilService.isEmpty(this.item.username)) {
        this.errorMessages.push('Username non valide');
        this.validUtilisateurUsername = false;
        } else {
            this.validUtilisateurUsername = true;
        }
    }
    public validateUtilisateurPassword(){
        if (this.stringUtilService.isEmpty(this.item.password)) {
        this.errorMessages.push('Password non valide');
        this.validUtilisateurPassword = false;
        } else {
            this.validUtilisateurPassword = true;
        }
    }
    public validateUtilisateurLastName(){
        if (this.stringUtilService.isEmpty(this.item.lastName)) {
        this.errorMessages.push('Last name non valide');
        this.validUtilisateurLastName = false;
        } else {
            this.validUtilisateurLastName = true;
        }
    }
    public validateUtilisateurFirstName(){
        if (this.stringUtilService.isEmpty(this.item.firstName)) {
        this.errorMessages.push('First name non valide');
        this.validUtilisateurFirstName = false;
        } else {
            this.validUtilisateurFirstName = true;
        }
    }


    public async openCreateDroit(droit: string) {
    const isPermistted = await this.roleService.isPermitted('Droit', 'add');
    if(isPermistted) {
         this.droit = new DroitDto();
         this.createDroitDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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

    get droitUtilisateurs(): Array<DroitUtilisateurDto> {
        if( this._droitUtilisateurs == null )
            this._droitUtilisateurs = new Array();
        return this._droitUtilisateurs;
    }

    set droitUtilisateurs(value: Array<DroitUtilisateurDto>) {
        this._droitUtilisateurs = value;
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


    get droitUtilisateursElement(): DroitUtilisateurDto {
        if( this._droitUtilisateursElement == null )
            this._droitUtilisateursElement = new DroitUtilisateurDto();
        return this._droitUtilisateursElement;
    }

    set droitUtilisateursElement(value: DroitUtilisateurDto) {
        this._droitUtilisateursElement = value;
    }

}
