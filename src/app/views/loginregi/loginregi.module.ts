import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { LoginregiPageRoutingModule } from './loginregi-routing.module';

import { LoginregiPage } from './loginregi.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    LoginregiPageRoutingModule
  ],
  declarations: [LoginregiPage]
})
export class LoginregiPageModule {}
