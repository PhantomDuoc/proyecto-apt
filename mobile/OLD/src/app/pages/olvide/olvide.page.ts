import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  FormBuilder
} from '@angular/forms';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-olvide',
  templateUrl: './olvide.page.html',
  styleUrls: ['./olvide.page.scss'],
  
})
export class OlvidePage implements OnInit {
  formularioOlvide: FormGroup;

  constructor(private router: Router,public fb: FormBuilder ) { 
    this.formularioOlvide = this.fb.group({
      'correo': new FormControl("",Validators.required),

    })

  }
  ngOnInit() {}
  recuperar() {
    let navigationextras: NavigationExtras={
    }
    this.router.navigate(['/login'], navigationextras)
  }

}



