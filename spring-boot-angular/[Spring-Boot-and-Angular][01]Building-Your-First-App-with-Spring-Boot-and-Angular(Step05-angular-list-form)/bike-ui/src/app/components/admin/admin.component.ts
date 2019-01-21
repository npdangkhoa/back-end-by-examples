import { Component, OnInit } from '@angular/core';
import { BikeService } from 'src/app/services/bike.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public bikes;

  constructor(private bikeService: BikeService) { }

  ngOnInit() {
    this.getBikes();
  }

  getBikes(){
    console.log('AdminComponent.getBikes()');
    this.bikeService.getBikes().subscribe(
      data => {
        this.bikes = data;
        console.log('AdminComponent.getBikes():    ==> '+ this.bikes);

      },
      err => {console.error(err); },
      () => {console.log('load bike data');}
    ) ;
  }
}
