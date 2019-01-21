import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
//import {Observable} from 'rxjs/Observable';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BikeService {

  constructor(private http:HttpClient) { }

  getBikes(){
    return this.http.get('/service/bikes');
  }

  getBike(id: number){
    return this.http.get('service/bikes/' + id);
  }

  createBike(bike){
    var data = JSON.stringify(bike);
    return this.http.post('service/bikes', data, httpOptions);
  }
}
