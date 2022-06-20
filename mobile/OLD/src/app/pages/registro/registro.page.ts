import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.page.html',
  styleUrls: ['./registro.page.scss'],
})
export class RegistroPage implements OnInit {
  formularioLogin: FormGroup;


  constructor(private router: Router,public fb: FormBuilder ) { 
    this.formularioLogin = this.fb.group({
      'name': new FormControl("",Validators.required),
      'email': new FormControl("",Validators.required),
      'number': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required),
      'user': new FormControl("",Validators.required),
      'confirm_password': new FormControl("",Validators.required)
    })

  }


  ngOnInit() { }

  registrarse() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/login'], navigationextras)
  }
}