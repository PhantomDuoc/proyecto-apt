import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder,
} from '@angular/forms';
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
    public alertController: AlertController,
  ) {
    this.formularioLogin = this.fb.group({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
    });
  }

  user: User;

  ngOnInit() {
    this.getUser("admin").subscribe((response) => {
      //console.log(response);
      this.user=response;
      console.log(this.user);
    }, (error) => {
      console.log(error);
    });
  }

  getUser(username: string) {
    const url = "http://localhost:8091/v1/departamento/gerencia/usuario/findByUsername/"
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return this.http.get<User>(
      `${url}${username}`, { headers }
    );
  }

  async login() {
    const { username, password } = this.formularioLogin.value;
    let User: User;
    await this.getUser(username).subscribe(data => {
      User = data;
      console.log(User);
    }, error => {
      console.log(error);
    }
    );
    if (User.password === password) {
      const navigationExtras: NavigationExtras = {
        queryParams: {
          username: User.username,
          password: User.password,
          email: User.email,
          type: User.type,
        },
      };
      this.router.navigate(['/home'], navigationExtras);
    } else {
      this.presentAlert();
    }
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
