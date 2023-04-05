import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';

import { DroitCreateAdminComponent } from './droit-admin/create-admin/droit-create-admin.component';
import { DroitEditAdminComponent } from './droit-admin/edit-admin/droit-edit-admin.component';
import { DroitViewAdminComponent } from './droit-admin/view-admin/droit-view-admin.component';
import { DroitListAdminComponent } from './droit-admin/list-admin/droit-list-admin.component';
import { DroitUtilisateurCreateAdminComponent } from './droit-utilisateur-admin/create-admin/droit-utilisateur-create-admin.component';
import { DroitUtilisateurEditAdminComponent } from './droit-utilisateur-admin/edit-admin/droit-utilisateur-edit-admin.component';
import { DroitUtilisateurViewAdminComponent } from './droit-utilisateur-admin/view-admin/droit-utilisateur-view-admin.component';
import { DroitUtilisateurListAdminComponent } from './droit-utilisateur-admin/list-admin/droit-utilisateur-list-admin.component';
import { UtilisateurCreateAdminComponent } from './utilisateur-admin/create-admin/utilisateur-create-admin.component';
import { UtilisateurEditAdminComponent } from './utilisateur-admin/edit-admin/utilisateur-edit-admin.component';
import { UtilisateurViewAdminComponent } from './utilisateur-admin/view-admin/utilisateur-view-admin.component';
import { UtilisateurListAdminComponent } from './utilisateur-admin/list-admin/utilisateur-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    DroitCreateAdminComponent,
    DroitListAdminComponent,
    DroitViewAdminComponent,
    DroitEditAdminComponent,
    DroitUtilisateurCreateAdminComponent,
    DroitUtilisateurListAdminComponent,
    DroitUtilisateurViewAdminComponent,
    DroitUtilisateurEditAdminComponent,
    UtilisateurCreateAdminComponent,
    UtilisateurListAdminComponent,
    UtilisateurViewAdminComponent,
    UtilisateurEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
  ],
  exports: [
  DroitCreateAdminComponent,
  DroitListAdminComponent,
  DroitViewAdminComponent,
  DroitEditAdminComponent,
  DroitUtilisateurCreateAdminComponent,
  DroitUtilisateurListAdminComponent,
  DroitUtilisateurViewAdminComponent,
  DroitUtilisateurEditAdminComponent,
  UtilisateurCreateAdminComponent,
  UtilisateurListAdminComponent,
  UtilisateurViewAdminComponent,
  UtilisateurEditAdminComponent,
  ],
  entryComponents: [],
})
export class RepasAdminModule { }