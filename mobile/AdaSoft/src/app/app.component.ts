import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Inicio', url: 'home', icon: 'home' },
    { title: 'Mapa', url: 'map', icon: 'map' },
    { title: 'Perfil', url: 'profile', icon: 'person' },
    { title: 'Registrarse', url: 'register', icon: 'log-out' },
    { title: 'Iniciar Sesión', url: 'login', icon: 'log-in' },
    { title: 'Recuperar Contraseña', url: 'recovery', icon: 'key' },
    { title: 'Cerrar Sesión', url: 'login', icon: 'log-out' },
  ];
  /*   public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders']; */
  constructor() {}
}
