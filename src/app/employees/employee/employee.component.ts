import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { EmployeeService } from 'src/app/shared/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {
  public form: FormGroup;
  mobNumberPattern = "[789][0-9]{9}";

  constructor(public employeeService:EmployeeService) { }

  ngOnInit(): void {
  }

  //onSubmit Event
  onSubmit(form:NgForm){  //NgForm is datatype repressenting form
    //display
    console.log(form.value);

    let addId=this.employeeService.formData.empId;
    
    if(addId==0 || addId==null){
      //insert
      this.insertEmployee(form);
    }
    else {
      this.updateEmployee(form);

    }
  }
//insert method
insertEmployee(form?:NgForm){
  console.log("inserting a employee");
  this.employeeService.insertEmployee(form.value).subscribe(
    result=>{
      console.log(result);
      window.location.reload();
      //clear fields

    }
  );
}

updateEmployee(form?:NgForm){
  console.log("Updating a record");
  this.employeeService.updateEmployee(form.value).subscribe(
    (result)=>{
      console.log(result);
      window.location.reload();
    }, 
    (error)=>{
      //error
    }
  )
}

}