import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService as EmployeeApiService } from '../openapi/services';

@Injectable({providedIn: 'root'})
export class EmployeeService {
    constructor(private employeeApiService: EmployeeApiService) { }

    getEmployees(): Observable<any> {
        return this.employeeApiService.getEmployees();
    }
    
}