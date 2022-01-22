import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Visit } from './visit';

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  visits: Visit[];
  formData:Visit=new Visit();


  constructor(private httpClient: HttpClient) { }

  //get all employees
  getAllVisits() {
    this.httpClient.get(environment.apiUrl + "/api/visits")
      .toPromise().then(
        response =>
        this.visits = response as Visit[]
      );
  }

  //get a particular Employee
  getVisit(visitId:number):Observable<any>{
    return this.httpClient.get(environment.apiUrl + "/api/visits/"+visitId);
  }
  //insert
  insertVisit(visit:Visit):Observable<any>{
    return this.httpClient.post(environment.apiUrl + "/api/visits" ,visit);
  }

  //update
  updateVisit(visit:Visit):Observable<any>{
    return this.httpClient.put(environment.apiUrl + "/api/visits" ,visit);
  }

  //delete
  deleteVisit(visitId:number){
    return this.httpClient.delete(environment.apiUrl + "/api/visits/"+visitId);
  }
}