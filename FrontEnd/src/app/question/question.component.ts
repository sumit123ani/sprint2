import { Component, OnInit, ViewChild } from '@angular/core';
import { Question } from '../question';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Option } from '../option';


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
  option:Option = new Option();

  ngOnInit(): void {
  }

  createQuestion()
  {
     this.question.option = this.option;
    
    //  this.service.createQuestion(this.question).subscribe(data=>
    //   {
    //     alert("question added");
    //   },
    //   error=>
    //   {
    //     alert("error")
    //     console.log("error", error);
    //   });
    this.service.addQuestion(this.question);
    alert("question added"); 
  }

}
