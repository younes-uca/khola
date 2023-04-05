
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { DroitListAdminComponent } from './droit-admin/list-admin/droit-list-admin.component';
import { DroitUtilisateurListAdminComponent } from './droit-utilisateur-admin/list-admin/droit-utilisateur-list-admin.component';
import { UtilisateurListAdminComponent } from './utilisateur-admin/list-admin/utilisateur-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'droit',
                            children: [
                                {
                                    path: 'list',
                                    component: DroitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'droit-utilisateur',
                            children: [
                                {
                                    path: 'list',
                                    component: DroitUtilisateurListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'utilisateur',
                            children: [
                                {
                                    path: 'list',
                                    component: UtilisateurListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class RepasAdminRoutingModule { }
