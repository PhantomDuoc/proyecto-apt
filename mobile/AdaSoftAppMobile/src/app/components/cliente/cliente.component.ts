import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss'],
})
export class ClienteComponent implements OnInit {
  user={
    usuario:"",
    password:""
  }
  formularioLogin: FormGroup;


  constructor(private router: Router,public fb: FormBuilder ) { 
({

    })

  }

  ngOnInit() { }
/*  async login(){
    var f = this.formularioLogin.value;

    if(this.formularioLogin.valid){
      let navigationextras: NavigationExtras={
      }
      this.router.navigate(['/menu/home'], navigationextras)
      ;
    
    }else{

        const alert = await this.alertController.create({
          header: 'Datos incompletos',
          message: 'Tienes que llenar todos los datos',
          buttons: ['Aceptar']
        });
      await alert.present();

    }

 } 
 */
  login() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/menu/home'], navigationextras)
    console.log(this.user);
  }
  registro() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/registro'], navigationextras)
  }
  olvide(){
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/olvide'], navigationextras)
  }
  segmentChanged(event: any){
    let direccion= event.detail.value
    console.log(event.detail.value)
    this.router.navigate(['login/'+direccion])
  }
}