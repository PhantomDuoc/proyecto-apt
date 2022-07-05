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

  constructor(
    private authService: AunthenticationService,
    private http: HttpClient
  ) {}

  ngOnInit() {
    this.getPedidos();
    /*     let id = this.getToken();
    console.log(id) */
  }

  async getToken() {
    const id = await this.authService.getToken();
    return id.value;
  }

  async getPedidos() {
    const id = await this.authService.getToken();
    console.log(id.value);
    return this.http
      .get(
        'http://localhost:8092/v1/departamento/gerencia/pedidos/findByRepartidor/' +
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
