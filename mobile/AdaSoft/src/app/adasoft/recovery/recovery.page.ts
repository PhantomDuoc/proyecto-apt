import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recovery',
  templateUrl: './recovery.page.html',
  styleUrls: ['./recovery.page.scss'],
})
export class RecoveryPage implements OnInit {
  public recovery: string;
  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.recovery = this.activatedRoute.snapshot.paramMap.get('id');
  }

}
