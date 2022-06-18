import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {
  datauser: any;
  options = {
    centeredSlides: true,
    slidesPerView: 1,
    spaceBetween: -60,
  };

  categories = {
    slidesPerView: 2.5,
  };

  constructor(
    public api: ApiService
  ) {}


  ngOnInit() {
    this.getDataUser();
  }
  async getDataUser() {
    await this.api.getDataUser()
    .subscribe(res =>{
      console.log(res);
      this.datauser = res.results;
      console.log(this.datauser);
    }, err => {
      console.log(err);
    })
  }
}
