import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginregiPage } from './loginregi.page';

const routes: Routes = [
  {
    path: '',
    component: LoginregiPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoginregiPageRoutingModule {}
