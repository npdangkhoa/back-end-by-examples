import { Component, OnInit } from '@angular/core';
import { BikerService } from 'src/app/services/biker.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public bikers;

  constructor(private bikerService: BikerService) { }

  ngOnInit() {
    this.getBikers();
  }

  getBikers(){
    this.bikerService.getBikers().subscribe(
      data => {
        this.bikers = data;
      },
      err => {console.error(err); },
      () => {console.log('load biker data');}
    ) ;
  }
}
