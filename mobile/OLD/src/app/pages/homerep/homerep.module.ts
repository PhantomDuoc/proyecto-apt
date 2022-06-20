import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { HomerepPageRoutingModule } from './homerep-routing.module';

import { HomerepPage } from './homerep.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomerepPageRoutingModule
  ],
  declarations: [HomerepPage]
})
export class HomerepPageModule {}
