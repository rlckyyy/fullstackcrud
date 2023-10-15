import {Component, OnInit} from '@angular/core';
import {Employee} from "../classes/employee";
import {EmployeeService} from "../services/employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-update',
  templateUrl: './employee-update.component.html',
  styleUrls: ['./employee-update.component.css']
})
export class EmployeeUpdateComponent implements OnInit{

  id: number;
  employee: Employee;

  constructor(
    private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployeeById(this.id)
      .subscribe(data =>{
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe({
      next: data => {
        console.log(data);
        this.employee = new Employee();
      }, error: err => console.log(err)
    });
    this.redirectToEmployeeList();
  }

  onSubmit() {
    this.updateEmployee();
  }

  redirectToEmployeeList() {
    this.router.navigate([`/employees`]);
  }

}
