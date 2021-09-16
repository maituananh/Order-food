import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SBRouteData } from '@modules/navigation/models';
import * as userContainers from './containers/index';
import { UserModule } from './user.module';

export const ROUTES: Routes = [
  {
    path: 'user',
    pathMatch: 'full',
    redirectTo: '',
  },
  {
    path: 'create',
    canActivate: [],
    component: userContainers.CreateUserComponent,
    data: {
      title: 'Pages Login - SB Admin Angular',
    } as SBRouteData,
  },
  {
    path: '',
    canActivate: [],
    component: userContainers.UserListComponent,
    data: {
      title: 'Pages Login - SB Admin Angular',
    } as SBRouteData,
  },
];

@NgModule({
  imports: [UserModule, RouterModule.forChild(ROUTES)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
