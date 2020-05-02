import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { FetchService } from '../fetch.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

@ViewChild("#formdata")
form:NgForm;

  constructor(private service:FetchService, private router:Router) { }

  user:User = new User();

   msg:string ="";
   errorMessage:string ="";

  ngOnInit(): void {
  }

createUser()
{

  alert(this.user.userName);
  this.service.createUser(this.user).subscribe(data=>
    {
      console.log("data", data);
      this.msg = data;
      alert(this.msg);
      this.errorMessage = undefined;
      // alert("user registerd successfully");
      this.router.navigateByUrl("/login")
    }, 
    error=>
    {
      this.errorMessage = JSON.parse(error.error).massege;

      this.msg = undefined;
      alert(this.errorMessage)
      console.log("error occured", error);
      
    });
}

}
