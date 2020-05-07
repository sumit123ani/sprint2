import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TestComponent } from './test/test.component';


import { ShowTestComponent } from './show-test/show-test.component';
import { AttempTestComponent } from './attemp-test/attemp-test.component';
import { ViewTestComponent } from './view-test/view-test.component';
import { UpdateTestComponent } from './update-test/update-test.component';



const routes: Routes = [{path: 'login', component:LoginComponent},
{path: 'register', component:RegisterComponent}, {path: 'test', component:TestComponent},
{path: 'showTest', component:ShowTestComponent}, {path: 'attempTest', component:AttempTestComponent},
{path: 'viewTest', component:ViewTestComponent}, {path: 'updateTest', component:UpdateTestComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingcomponent =[LoginComponent, RegisterComponent, TestComponent,
AttempTestComponent, UpdateTestComponent, ViewTestComponent]
