import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../Employee';
import { SpinnerService } from 'angular-spinners';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  showSpinner:boolean;

  employeeList:Employee[] = [];

  message:string="No records found. Please add new one.";

  constructor(private employeeService:EmployeeService) {
  }

  ngOnInit() {
    this.showSpinner= true;

    this.employeeService.getEmployees().subscribe(data=>
    {
        this.employeeList = data;
        if(this.employeeList.length!=0){
          this.message = "Total records: "+this.employeeList.length;
        }
        //this.showSpinner=false;
    });
  }

}


