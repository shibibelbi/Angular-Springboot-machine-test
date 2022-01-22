import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  employees: Employee[];
  formData:Employee=new Employee();


  constructor(private httpClient: HttpClient) { }

  //get all employees
  getAllEmployees() {
    this.httpClient.get(environment.apiUrl + "/api/employees")
      .toPromise().then(
        response =>
        this.employees = response as Employee[]
      );
  }

  //get a particular Employee
  getEmployee(empId:number):Observable<any>{
    return this.httpClient.get(environment.apiUrl + "/api/employees/"+empId);
  }
  //insert
  insertEmployee(employee:Employee):Observable<any>{
    return this.httpClient.post(environment.apiUrl + "/api/employees" ,employee);
  }

  //update
  updateEmployee(employee:Employee):Observable<any>{
    return this.httpClient.put(environment.apiUrl + "/api/employees" ,employee);
  }

  //delete
  deleteEmployee(empId:number){
    return this.httpClient.delete(environment.apiUrl + "/api/employees/"+empId);
  }
}
