import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/employee';
import { EmployeeService } from 'src/app/shared/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

//constructor injection
constructor(public employeeService:EmployeeService) { }

ngOnInit(): void {   //life cycle hook
  //get all appointment thru service and stores in employee array 
  this.employeeService.getAllEmployees();
}

//implement populate form
//populate form by clicking the column fields
populateForm(employee:Employee){
  console.log(employee);
  this.employeeService.formData=Object.assign({},employee);
  
}

//update employee
updateEmployee(empId:number){
  console.log(empId);
}

//delete
deleteEmployee(empId:number){
  
  this.employeeService.deleteEmployee(empId);
  
}

confirmDelete(empId:number){
  if(confirm("Do you want to delete this record?")){
    this.deleteEmployee(empId);
  }
}

}

