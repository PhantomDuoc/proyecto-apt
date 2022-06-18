import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';

interface LoginResponse {
  usuario: {
    id: number;
    username: string;
    password: string;
    email: string;
    type: string;
  };
}

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
      'username': new FormControl("",Validators.required),
      'password': new FormControl("",Validators.required)
    })
    this.segmentChanged({detail: {value: 'compUno'}})

  }

  columns = ["ID", "Username", "Password", "Email", "Tipo"];
  index = ["id", "username", "password", "email", "type"];
  users : LoginResponse[] = [];

  ngOnInit() { 
    /* this.http.get<any>('https://api.npms.io/v2/search?q=scope:angular').subscribe(data => {
        this.texto = data.total;
        console.log(this.texto);
    }) */
    /* this.getApiTest(); */
    /* this.getApiTest2(); */
    
    this.getUsers().subscribe( (response) =>  {
      this.users = response;
      console.log(this.users);
      console.log("hola");
      console.log(this.users['content']);
    },  (error) => {
      console.log("Error ocurred: " + error)
    });

    var result = this.users.map(person => ({id: person.usuario.id, username: person.usuario.username, password: person.usuario.password, email: person.usuario.email, type: person.usuario.type}));
    console.log(result);
    console.log("hola2")
    result.forEach((value, key) =>{
      console.log(key, value);
    })
  }

  /* getApiTest(){
    const url = "http://localhost:8091/v1/departamento/gerencia/usuario/findAll?page=0";
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return this.http.get<any>(url, {headers: headers})
    .subscribe(data => {
      this.texto2 = data.username;
      console.log(this.texto2);
    })
  }

  getApiTest2(){
    const url = "http://localhost:8091/v1/departamento/gerencia/usuario/findAll?page=0";
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    let jsonObject = this.http.get<any>(url, {headers: headers});
    console.log(jsonObject);
  } */

  getUsers(){
    const url = "http://localhost:8091/v1/departamento/gerencia/usuario/findAll?page=0";
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return this.http.get<LoginResponse[]>(url, {headers: headers})
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