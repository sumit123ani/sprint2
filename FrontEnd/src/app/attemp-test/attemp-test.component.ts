import { Component, OnInit } from '@angular/core';
import { FetchService } from '../fetch.service';
import { Question } from '../question';
import { Test } from '../test';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-attemp-test',
  templateUrl: './attemp-test.component.html',
  styleUrls: ['./attemp-test.component.css']
})
export class AttempTestComponent implements OnInit {

  constructor(private service:FetchService) { }

  questions:Question[];
  test:Test = new Test();
  question:Question = new Question();
  answer:any;

  noOfQuestion:number;
  currentQuestion:number;
  totalMarks:number =0;
  totalScore:number =0;


  ngOnInit(): void {

    this.test = this.service.getTest();
    this.service.getQuestionList(this.test.testId).subscribe(data=>
      {
        this.questions = data;
        this.noOfQuestion = this.questions.length;
        this.currentQuestion = 0;
        this.loadNextQuestion();
      },
      error=>
      {
        alert("error");
        console.log("error occured", error);
        
      });

      
  }

  loadNextQuestion()
  {
    this.question = this.questions[this.currentQuestion];
    if(this.currentQuestion < this.questions.length)
    {
      this.currentQuestion++;
    }
  }

  loadPrevQuestion()
  {
    if(this.currentQuestion > 1)
    {
      this.currentQuestion--;
      this.question = this.questions[this.currentQuestion-1];
    }

  }

  submitTest()
  {
   
    this.calculateTotakMarks();

    this.test.testTotalMarks = this.totalMarks;
    this.test.testMarksScored = this.totalScore;

    this.service.setTest(this.test);
    this.service.updateTest(this.test).subscribe(data=>
      {
        alert("test submited successfully")
      },
      error=>
      { 
        alert("test not submited");
        console.log(error);
        
      });
  }

  calculateTotakMarks()
  {
    for(var i =0; i<this.questions.length; i++)
    {
       this.totalMarks += this.questions[i].questionMarks;

      if(this.questions[i].questionAnswer == this.questions[i].chosenAnswer)
      {
        this.questions[i].marksScored = this.questions[i].questionMarks;
        this.totalScore += this.questions[i].marksScored; 
      }

    this.service.updateQuestion(this.questions[i]).subscribe(data=>
      {
        console.log("updated");
      },
      error=>{
        alert("error");
        console.log(error);
        
      });
    }
  }

}
