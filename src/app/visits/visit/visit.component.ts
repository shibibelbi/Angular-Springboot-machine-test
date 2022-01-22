import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { VisitService } from 'src/app/shared/visit.service';

@Component({
  selector: 'app-visit',
  templateUrl: './visit.component.html',
  styleUrls: ['./visit.component.scss']
})
export class VisitComponent implements OnInit {
  public form: FormGroup;
  mobNumberPattern = "[789][0-9]{9}";

  constructor(public visitService:VisitService) { }

  ngOnInit(): void {
  }

  //onSubmit Event
  onSubmit(form:NgForm){  //NgForm is datatype repressenting form
    //display
    console.log(form.value);

    let addId=this.visitService.formData.visitId;
    
    if(addId==0 || addId==null){
      //insert
      this.insertVisit(form);
    }
    else {
      this.updateVisit(form);

    }
  }
//insert method
insertVisit(form?:NgForm){
  console.log("inserting a visit");
  this.visitService.insertVisit(form.value).subscribe(
    result=>{
      console.log(result);
      window.location.reload();
      //clear fields

    }
  );
}

updateVisit(form?:NgForm){
  console.log("Updating a record");
  this.visitService.updateVisit(form.value).subscribe(
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