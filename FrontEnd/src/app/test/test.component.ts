import { Component, OnInit, ViewChild } from '@angular/core';
import { Test } from '../test';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Question } from '../question';
import { Option } from '../option';

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

  name:string;

  quests:Question[];

  option:Option = new Option();

  ngOnInit(): void {
  }

 createTest()
 {
    // this.quests = this.service.getAllQuestion();
  
    // alert(this.quests.length)
   alert(this.name);
  this.test.questions = this.quests;

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

  submit(){
    alert(this.name);
  }

//  createQuestion()
//  {
//    this.quest.option = this.option;
//    this.questions.push(this.quest);
//    alert("question added succeessfully");
//  }

  changeFlag() 
  {
    if(this.flag)
     this.flag = false;
    else
     this.flag = true; 
  }

}
