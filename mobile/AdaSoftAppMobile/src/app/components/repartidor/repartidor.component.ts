import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';


@Component({
  selector: 'app-repartidor',
  templateUrl: './repartidor.component.html',
  styleUrls: ['./repartidor.component.scss'],
})
export class RepartidorComponent implements OnInit {
  formularioRegistro: FormGroup;

  constructor(private router: Router,public fb: FormBuilder ) { 
    this.formularioRegistro = this.fb.group({
      'user': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required)
    })

  }
  ngOnInit() {}
  login() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/homerep'], navigationextras)
  }
  olvide(){
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/olvide'], navigationextras)
  }

}
