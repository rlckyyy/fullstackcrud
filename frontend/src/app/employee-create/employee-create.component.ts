import {Component, OnInit} from '@angular/core';
import {Employee} from "../classes/employee";
import {EmployeeService} from "../services/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit{
  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService, private router: Router) {
  }

  ngOnInit(): void {
  }


  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe({
      next: value => {
        console.log(value);
        this.employee = new Employee();
      },
      error: err => console.log(err)
    });
    this.redirectToEmployeeList();
  }

  redirectToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  onSubmit(){
    this.saveEmployee();
  }
}
