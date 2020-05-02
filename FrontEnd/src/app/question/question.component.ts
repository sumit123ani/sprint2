import { Component, OnInit, ViewChild } from '@angular/core';
import { Question } from '../question';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';


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

  ngOnInit(): void {
  }

  createQuestion()
  {
    this.service.addQuestion(this.question);
    alert("question added"); 
  }

 collect()
 {
    this.questions.push(this.question)
    alert(this.questions.length);

    this.service.addQuestion(this.question);
    alert("question added");

    this.questions[0] = null;
 }

}
