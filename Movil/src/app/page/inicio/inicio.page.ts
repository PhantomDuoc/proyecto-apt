import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { ActivatedRoute, NavigationExtras, Router } from '@angular/router';
import { AlertController, AnimationController, NavController } from '@ionic/angular';


@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
})
export class InicioPage implements OnInit {
  name: string;
  formularioLogin: FormGroup;

  @ViewChild('miLogin', {read:ElementRef, static:true}) miLogin: ElementRef;
  constructor(public fb: FormBuilder,
    public alertController: AlertController,private activeRoute: ActivatedRoute,private router: Router,
    public navCtrl: NavController,private animationCtrl: AnimationController) { 

    this.formularioLogin = this.fb.group({
      'nombre': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required)
    })

  }
  ngAfterViewInit(){
    const animacion=this.animationCtrl
    .create()
    .addElement(this.miLogin.nativeElement)
    .duration(4500)
    .iterations(Infinity)
    .fromTo('transform', 'translateX(0px)', 'translateX(100px)')
    .fromTo('opacity', '1', '0.2');

    animacion.play();
  }


  ngOnInit() {
  }


  async login(){
    var f = this.formularioLogin.value;

    var usuario = JSON.parse(localStorage.getItem('usuario'));

    if(usuario.nombre == f.nombre && usuario.password == f.password){
      console.log('Ingresado')
      localStorage.setItem('ingresado','true');
      this.navCtrl.navigateRoot('menu/bienvenida');

    }else{
      const alert = await this.alertController.create({
        header: 'Datos incorrectos',
        message: 'Los datos que ingresaste son incorrectos.',
        buttons: ['Aceptar']
      });
  
      await alert.present();
    }
  }
  
}


