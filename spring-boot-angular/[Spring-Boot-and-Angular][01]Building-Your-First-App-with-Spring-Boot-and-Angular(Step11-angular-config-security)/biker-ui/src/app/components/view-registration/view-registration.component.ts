import { Component, OnInit } from '@angular/core';
import { BikerService } from 'src/app/services/biker.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {

  public bikerReg;

  constructor(private bikerService: BikerService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.getBikerReg(this.router.snapshot.params.id);
  }

  getBikerReg(id:number){
    this.bikerService.getBiker(id).subscribe(
      data => {
        this.bikerReg = data;
      },
      error => {
        console.error('Error');
      },
      () => console.log('biker load')
    );
  }

}
