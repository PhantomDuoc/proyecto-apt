import { Component, OnInit } from '@angular/core';
import { Proveedor1Service } from 'src/app/proveedor1.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {
  datauser: any;
  constructor(
    public api: Proveedor1Service
  ) {}

  ngOnInit() {
	  this.getDataUser();
  }
  
  async getDataUser() {
    await this.api.getDataUser()
      .subscribe(res => {
        console.log(res);
        this.datauser = res.results;
		console.log(this.datauser);
      }, err => {
        console.log(err);
      });
  }
}