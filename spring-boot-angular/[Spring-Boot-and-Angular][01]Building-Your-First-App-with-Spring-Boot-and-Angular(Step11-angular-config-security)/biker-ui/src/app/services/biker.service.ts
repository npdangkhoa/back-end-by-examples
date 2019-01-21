import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
//import {Observable} from 'rxjs/Observable';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BikerService {

  constructor(private http:HttpClient) { }

  getBikers(){
     return this.http.get('service/admin' 
     + '?access_token=' +  JSON.parse(window.sessionStorage.getItem('token')).access_token);  
  }
  getBiker(id: number){
    return this.http.get('service/' + id
    + '?access_token=' +  JSON.parse(window.sessionStorage.getItem('token')).access_token);  
  }

  createBiker(biker){
    var data = JSON.stringify(biker);
    return this.http.post('service'
     + '?access_token=' +  JSON.parse(window.sessionStorage.getItem('token')).access_token, data, httpOptions);
  }
}
