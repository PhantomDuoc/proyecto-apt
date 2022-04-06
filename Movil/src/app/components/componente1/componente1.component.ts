import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
  styleUrls: ['./componente1.component.scss'],
})
export class Componente1Component implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {}

  informacion:any={
    nombre:"",
    apellido:"",
    nivelEduc:"",
    fecha:""
  };

  pasa(){
    let navigationExtras: NavigationExtras={

    }
    this.router.navigate(['menu/agregarviaje'], navigationExtras);
  }
}
