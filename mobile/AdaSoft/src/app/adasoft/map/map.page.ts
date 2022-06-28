import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-map',
  templateUrl: './map.page.html',
  styleUrls: ['./map.page.scss'],
})
export class MapPage implements OnInit {
  public map: string;
  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.map = this.activatedRoute.snapshot.paramMap.get('id');
  }

}
