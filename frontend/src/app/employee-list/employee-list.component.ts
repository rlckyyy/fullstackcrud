import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Employee} from "../classes/employee";
import {EmployeeService} from "../services/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
  employees: Observable<Employee[]>;

  ngOnInit(): void {
    this.reloadData();
  }


  constructor(
    private employeeService: EmployeeService,
    private router: Router) {
  }

  reloadData(){
    this.employees = this.employeeService.getEmployeeList();
  }

  updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error)
      );
    window.location.reload();
  }


}
