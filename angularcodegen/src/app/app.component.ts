import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeService } from './employee.service';

import { JsonPipe } from '@angular/common';
import { BaseService } from '../openapi/base-service';
import { ApiConfiguration } from '../openapi/api-configuration';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, JsonPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [BaseService]
})
export class AppComponent implements OnInit{
  employeeData!: any;
  title = 'angularcodegen';
  

  constructor(private employeeService: EmployeeService, private apiConfiguration: ApiConfiguration) {
    apiConfiguration.rootUrl = "http://localhost:8080"
  }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(data => {
      this.employeeData = data;
    })
  }
  
}
