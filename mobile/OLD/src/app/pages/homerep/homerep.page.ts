import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';
import { MapCustomService } from 'src/app/map-custom.service';

@Component({
  selector: 'app-homerep',
  templateUrl: './homerep.page.html',
  styleUrls: ['./homerep.page.scss'],
})
export class HomerepPage implements OnInit {
  @ViewChild('asGeoCoder') asGeoCoder: ElementRef;
  modeInput = 'start';
  wayPoints: wayPoint = {start: null, end:null};
  constructor(private mapCustomService: MapCustomService, private renderer2: Renderer2) {
    
  }

  ngOnInit(): void {
    this.mapCustomService.buildMap() 
    .then(({geocoder, map}) =>{
      //this.asGeoCoder
      this.renderer2.appendChild(this.asGeoCoder.nativeElement,
        geocoder.onAdd(map)
        )
      console.log('todo bien')

    }) 
    .catch((err) => {
      console.log('ERROR', err)
    });

    this.mapCustomService.cbAddress.subscribe((getPoint) =>{

      if(this.modeInput === 'start'){
        this.wayPoints.start = getPoint;
      }
      if(this.modeInput === 'end'){
        this.wayPoints.end = getPoint;
      }
    });
  }
  
  drawRoute(): void{
    console.log('****** punto de origen y destino',this.wayPoints)
    const coords = [
      this.wayPoints.start.center,
      this.wayPoints.end.center
    ];

    this.mapCustomService.loadCoords(coords);
  }

  changeMode(mode: string):void{
    this.modeInput = mode;
  }

}

export class wayPoint {
  start:any;
  end:any;
}
