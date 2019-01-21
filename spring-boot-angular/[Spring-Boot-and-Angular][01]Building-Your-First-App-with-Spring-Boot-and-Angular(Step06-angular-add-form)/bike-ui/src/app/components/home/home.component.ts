import { Component, OnInit } from '@angular/core';
import { BikeService } from 'src/app/services/bike.service';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  models: String[] = [
    'Globo MPT 29',
    'Globo Carbon',
    'Globo Time'
  ];

  validMessage: String = '';

  bikeForm: FormGroup;

  constructor(private bikeService : BikeService) { }

  ngOnInit() {
    this.bikeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
      model: new FormControl('', Validators.required),
      serialNumber: new FormControl('', Validators.required),
      purchasePrice: new FormControl('', Validators.required),
      purchaseDate: new FormControl('', Validators.required),
      contact: new FormControl()
    });
  }


  submitRegistration(){
    console.log('submit Registration');
    this.validMessage = 'Thank you';
    if(this.bikeForm.valid){
      this.bikeService.createBike(this.bikeForm.value).subscribe(
        data => {
          this.bikeForm.reset;
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
    } else {
      this.validMessage = 'Please fill out';
    }
  }
}
