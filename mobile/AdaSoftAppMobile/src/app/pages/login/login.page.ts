import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  texto: any;
  texto2: any;


  constructor(private router: Router,public fb: FormBuilder, private http: HttpClient ) { 
    this.formularioLogin = this.fb.group({
      'user': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required)
    })

  }

  ngOnInit() { 
    this.http.get<any>('https://api.npms.io/v2/search?q=scope:angular').subscribe(data => {
        this.texto = data.total;
        console.log(this.texto);
    })
    this.getApiTest();
    
  }

  getApiTest(){
    const url = "http://localhost:8091/v1/departamento/gerencia/usuario/findAll?page=0";
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return this.http.get<any>(url, {headers: headers})
    .subscribe(data => {
      this.texto2 = data.username;
      console.log(this.texto2);
    })
  }

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