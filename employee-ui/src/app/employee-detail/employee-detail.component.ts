import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../Employee';
import {  Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ResponseMessage } from '../ResponseMessage';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrls: ['./employee-detail.component.css']
})
export class EmployeeDetailComponent implements OnInit {

  employee:Employee;
  formdata:FormGroup;
  message:ResponseMessage;

  constructor(private route:Router,private employeeService:EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.formdata = new FormGroup({
      id: new FormControl("", Validators.compose([
         Validators.required,
         Validators.pattern("[1-9]+")
      ])),
      name: new FormControl("", Validators.compose([
        Validators.required,
        Validators.pattern("[a-z A-Z]+")
      ])),
      designation: new FormControl("", Validators.compose([
        Validators.required,
        Validators.pattern("[a-zA-Z 1-9]+")
      ]))
   });
  }

  onSave(){
    this.employeeService.saveEmployee(this.employee).subscribe(data=>{
      this.message=data;
      this.route.navigate(['/employeeList']);
    });

  }
}
