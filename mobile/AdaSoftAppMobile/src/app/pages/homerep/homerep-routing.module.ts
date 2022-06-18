import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomerepPage } from './homerep.page';

const routes: Routes = [
  {
    path: '',
    component: HomerepPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomerepPageRoutingModule {}
