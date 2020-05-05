import { Component, OnInit, ViewChild } from '@angular/core';
import { Test } from '../test';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Question } from '../question';
import { Router } from '@angular/router';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

 @ViewChild("#formdata")
 form:NgForm;

  constructor(private service:FetchService, private router:Router) { }

  test:Test = new Test();
  flag:boolean = false;
  quest:Question[] = [];
  msg:string ="";
  errorMessage:string ="";

  ngOnInit(): void {
  }

 createTest()
 {

    this.service.createTest(this.test).subscribe(data=>
      {    
        this.msg = data;
        alert(this.msg);
       this.errorMessage = undefined;

        this.service.setTest(this.test);
        
        this.router.navigateByUrl("/question");
      },
      error=>
      {
        this.errorMessage = JSON.parse(error.error).massege;

        this.msg = undefined;
        alert(this.errorMessage)
        console.log("error occured", error);
        
      });
  
 }


  changeFlag() 
  {
    if(this.flag)
     this.flag = false;
    else
     this.flag = true; 
  }

}
