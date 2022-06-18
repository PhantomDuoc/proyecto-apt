import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

interface User {
  id: number;
  username: string;
  password: string;
  email: string;
  type: string;
}

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss'],
})
export class ClienteComponent implements OnInit {
  formularioLogin: FormGroup;
  constructor(
    private router: Router,
    public fb: FormBuilder,
    private http: HttpClient,
    public alertController: AlertController
  ) {
    this.formularioLogin = this.fb.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  user: User;
  ngOnInit() {
    this.formularioLogin.reset();
    this.formularioLogin.setValue({
      username: 'admin',
      password: 'admin',
    });
    console.log(this.formularioLogin.value);

    /* this.getUser('admin').subscribe(
      (response) => {
        //console.log(response);
        this.user = response;
        console.log(this.user);
        console.log(this.user.password);
      },
      (error) => {
        console.log(error);
      }
    ); */
  }

  ionViewWillEnter() {
    /*     this.formularioLogin.reset(); */
  }

  getUser(username: string) {
    const url =
      'http://localhost:8091/v1/departamento/gerencia/usuario/findByUsername/';
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    headers.set('Access-Control-Allow-Origin', '*');
    return this.http.get<User>(`${url}${username}`, { headers });
  }

  async login() {
    let User: User;
    this.getUser(this.formularioLogin.controls.username.value).subscribe(
      (response) => {
        User = response;
        console.log(User);
        console.log(User.password);
        if (User.password == this.formularioLogin.controls.password.value) {
          this.router.navigate(['/menu/home']);
        } else {
          this.presentAlert();
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
  registro() {
    let navigationextras: NavigationExtras = {};
    this.router.navigate(['/registro'], navigationextras);
  }
  olvide() {
    let navigationextras: NavigationExtras = {};
    this.router.navigate(['/olvide'], navigationextras);
  }
  segmentChanged(event: any) {
    let direccion = event.detail.value;
    console.log(event.detail.value);
    this.router.navigate(['login/' + direccion]);
  }
  presentAlert() {
    throw new Error('Method not implemented.');
  }
}
