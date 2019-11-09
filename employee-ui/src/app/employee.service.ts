import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './Employee';
import { ResponseMessage } from './ResponseMessage';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService{

  private  baseUrl:string = 'http://localhost:8447';

  private employeeList : Employee[];

  constructor(private http:HttpClient){}

  getEmployees():Observable<Employee[]>{
    let url:string = "/getEmployees";
    url = this.baseUrl + url;
    return this.http.get<Employee[]>(url);
  }

  getEmployeeList():Employee[] {
    return this.employeeList;
  }

  saveEmployee(employee:Employee):Observable<ResponseMessage>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth-token'
      })
    };
    let url:string="/saveEmployee";
    url=this.baseUrl+url;
    return this.http.post<ResponseMessage>(url,employee);
  }
}
