import { Component, OnInit, ViewChild } from '@angular/core';
import { Test } from '../test';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Question } from '../question';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

 @ViewChild("#formdata")
 form:NgForm;

  constructor(private service:FetchService) { }

  test:Test = new Test();
  flag:boolean = false;
  quest:Question[] = [];


  ngOnInit(): void {
  }

 createTest()
 {
  this.quest = this.service.retrievQuest();
  alert(this.quest.length)

  alert(this.quest[0].questionId+" "+this.quest[1].questionId)

  if(this.test.testQuestions.length == 0)
  {

    alert("please add some question to the test")
   
  }
  else
  {
    this.service.createTest(this.test).subscribe(data=>
      {    
        alert("test added successfully");
      },
      error=>
      {
        alert("error")
        console.log("error occured", error);
        
      });
  }
 }


  changeFlag() 
  {
    if(this.flag)
     this.flag = false;
    else
     this.flag = true; 
  }

}
