import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Componente1Component } from 'src/app/components/componente1/componente1.component';
import { Componente2Component } from 'src/app/components/componente2/componente2.component';
import { BienvenidaPage } from './bienvenida.page';

const routes: Routes = [
  {
    path: '',
    component: BienvenidaPage,
    children:[
      {
        path: 'compUno',
        component: Componente1Component
      },
      {
        path: 'compDos',
        component: Componente2Component
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class BienvenidaPageRoutingModule {}
