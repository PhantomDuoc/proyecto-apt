import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  formularioLogin: FormGroup;


  constructor(private router: Router,public fb: FormBuilder ) { 
    this.formularioLogin = this.fb.group({
      'user': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required)
    })

  }

  ngOnInit() { }

  login() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/menu/home'], navigationextras)
  }

  registro() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/registro'], navigationextras)
  }

  segmentChanged(event: any){
    let direccion= event.detail.value
    console.log(event.detail.value)
    this.router.navigate(['login/'+direccion])
  }
}