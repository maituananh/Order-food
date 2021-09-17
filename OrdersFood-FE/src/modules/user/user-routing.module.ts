import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from '@app/share/service/AuthGuardService';
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
    canActivate: [AuthGuardService],
    component: userContainers.CreateUserComponent,
    data: {
      title: 'Pages Login - SB Admin Angular',
    } as SBRouteData,
  },
  {
    path: '',
    canActivate: [AuthGuardService],
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
