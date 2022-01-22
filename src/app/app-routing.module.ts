import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { SalescoordinatorComponent } from './salescoordinator/salescoordinator.component';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeComponent } from './employees/employee/employee.component';
import { EmployeeListComponent } from './employees/employee-list/employee-list.component';
import { VisitsComponent } from './visits/visits.component';
import { VisitComponent } from './visits/visit/visit.component';
import { VisitListComponent } from './visits/visit-list/visit-list.component';
import{AuthGuard} from './shared/auth.guard';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'salescoordinator',component:SalescoordinatorComponent,canActivate:[AuthGuard],data:{role:"sc"}},
  {path:'admin',component:AdminComponent,canActivate:[AuthGuard],data:{role:"admin"}},
  { path: 'employees', component: EmployeesComponent },
  { path: 'employee', component: EmployeeComponent },
  { path: 'employeelist', component: EmployeeListComponent },
  { path: 'visits', component: VisitsComponent },
  { path: 'visit', component: VisitComponent },
  { path: 'visitlist', component: VisitListComponent },
  { path: 'login', component: LoginComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
