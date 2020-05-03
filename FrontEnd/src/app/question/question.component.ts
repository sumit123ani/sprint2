import { Component, OnInit, ViewChild } from '@angular/core';
import { Question } from '../question';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Test } from '../test';


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

 @ViewChild("#formdata")
 form:NgForm;

  constructor(private service:FetchService) { }

  question:Question = new Question();
  questions:Question[] =[];
  test:Test = new Test();


  ngOnInit(): void {
    this.test = this.service.getTest();
  }

  createQuestion()
  {
    // this.questions[0] = this.question;
     this.test.testQuestions.push(this.question);

   alert(this.test.testQuestions[0].questionId)

    this.service.addQuestionToTest(this.test).subscribe(data=>
      {
         alert("added")
      },
      error=>
      {
        console.log(error);
        alert("can't add");
        
      });
   
  }

}
