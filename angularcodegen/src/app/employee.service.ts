import { Injectable } from '@angular/core';
import { DefaultService as EmployeeApiService } from './api/services/default.service';
import { Observable } from 'rxjs';
import { Employee } from './api/models/employee';

@Injectable({providedIn: 'root'})
export class EmployeeService {
    constructor(private employeeApiService: EmployeeApiService) { }

    getEmployees(): Observable<any> {
        return this.employeeApiService.getEmployees();
    }
    
}