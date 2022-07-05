import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AunthenticationService } from '../services/aunthentication.service';
import { map } from 'rxjs/operators';
@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss'],
})
export class Tab3Page {
  user: any ={};
  constructor(
    private authService: AunthenticationService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(){
    this.getUser();
  }

  async getToken() {
    const id = await this.authService.getToken();
    return id.value;
  }

  async getUser() {
    const id = await this.authService.getToken();
    console.log(id.value);
    return this.http
      .get(
        'http://localhost:8091/v1/departamento/gerencia/usuario/findById/' +
          id.value
      )
      .pipe(
        map((res: any) => {
          return res;
        })
      )
      .subscribe((data) => {
        console.log(data);
        this.user = data;
      });
  }

  async logout() {
    await this.authService.logout();
    this.router.navigateByUrl('/', { replaceUrl: true });
  }

  NombreCompleto(){
    if (this.user.nombre ==null && this.user.apellido ==null){
      return false;
    }else{
      return true;
    }
  }
}
