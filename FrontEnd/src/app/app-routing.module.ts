import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TestComponent } from './test/test.component';
import { QuestionComponent } from './question/question.component';
import { ShowTestComponent } from './show-test/show-test.component';
import { AttempTestComponent } from './attemp-test/attemp-test.component';


const routes: Routes = [{path: 'login', component:LoginComponent},
{path: 'register', component:RegisterComponent}, {path: 'test', component:TestComponent},
{path: 'question', component:QuestionComponent},
{path: 'showTest', component:ShowTestComponent}, {path: 'attempTest', component:AttempTestComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingcomponent =[LoginComponent, RegisterComponent, TestComponent, QuestionComponent, ShowTestComponent,
AttempTestComponent]
