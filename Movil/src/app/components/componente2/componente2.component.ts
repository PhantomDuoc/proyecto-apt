
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';
import { AlertController, NavController } from '@ionic/angular';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.scss'],
})
export class Componente2Component implements OnInit {
  name: string;
  formularioViaje: FormGroup;
  viaje: string;
  constructor(public alertController: AlertController,public navCtrl: NavController,private router: Router) {

   }

  ngOnInit() {
    this.viaje=JSON.parse(localStorage.getItem('viaje'));
  }

  async perfil(){


    if (localStorage){
    if(localStorage.getItem('viaje') !== undefined && localStorage.getItem('viaje')){
      this.navCtrl.navigateRoot('menu/perfil');
    }else{
      const alert = await this.alertController.create({
        header: 'No hay viajes',
        message: 'No se encuentran viajes disponibles',
        buttons: ['Aceptar']
      });
  
      await alert.present();
    }
  }
}
}


/*
import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-componente2',
  templateUrl: './componente2.component.html',
  styleUrls: ['./componente2.component.scss'],
})
export class Componente2Component implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {}



  perfil(){
    let navigationExtras: NavigationExtras={

    }
    this.router.navigate(['menu/perfil'], navigationExtras);
  }
}
*/