import { AunthenticationService } from '../services/aunthentication.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertController, LoadingController } from '@ionic/angular';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Storage } from '@capacitor/storage';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
})
export class Tab1Page {
  orders: any = [];
  user: any ={};
  tipoUser: string;

  constructor(
    private authService: AunthenticationService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.getUser();
/*     this.getPedidos(); */
    /*     let id = this.getToken();
    console.log(id) */
  }

  async getToken() {
    const id = await this.authService.getToken();
    return id.value;
  }

  async getUser() {
    const id = await this.authService.getToken();
    return this.http
      .get(
        'http://localhost:8091/v1/departamento/gerencia/usuario/findById/' +
          id.value
      )
      .pipe(
        map((res: any) => {
          return res;
        })
      )
      .subscribe((data) => {
        console.log(data);
        this.user = data;
        console.log("tipo usuario " + this.user.type);
        if(this.user.type == 0){
          console.log("usuario tipo administrador");
          this.tipoUser = "Administrador";
        }
        if(this.user.type == 1){
          console.log("usuario tipo cliente");
          this.tipoUser = "Cliente";
        }
        if(this.user.type == 2){
          console.log("usuario tipo repartidor");
          this.tipoUser = "Repartidor";
        }
        this.getPedidos(this.tipoUser);
      });
  }

  async deleteOrder(id){
    console.log(id);
    return this.http.delete('http://localhost:8092/v1/departamento/gerencia/pedidos/delete/'+id).subscribe
    ((data) => {
      console.log(data);
    }
    );
  }

  async getPedidos(tipoUsuario) {
    const id = await this.authService.getToken();
    console.log(tipoUsuario)
    return this.http
      .get(
        'http://localhost:8092/v1/departamento/gerencia/pedidos/findBy'+tipoUsuario+'/' +
          id.value
      )
      .pipe(
        map((res: any) => {
          return res.content;
        })
      )
      .subscribe((data) => {
        console.log(data);
        this.orders = data;
      });
  }
}
