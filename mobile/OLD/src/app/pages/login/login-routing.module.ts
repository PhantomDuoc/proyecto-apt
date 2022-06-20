import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from 'src/app/components/cliente/cliente.component';
import { RepartidorComponent } from 'src/app/components/repartidor/repartidor.component';

import { LoginPage } from './login.page';

const routes: Routes = [
  {
    path: '',
    component: LoginPage,
    children:[
      {
        path: 'compUno',
        component: ClienteComponent
      },
      {
        path: 'compDos',
        component: RepartidorComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LoginPageRoutingModule {}
