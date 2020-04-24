import { Component, OnInit } from '@angular/core';
import { FetchService } from '../fetch.service';
import { Question } from '../question';
import { Test } from '../test';

@Component({
  selector: 'app-attemp-test',
  templateUrl: './attemp-test.component.html',
  styleUrls: ['./attemp-test.component.css']
})
export class AttempTestComponent implements OnInit {

  constructor(private service:FetchService) { }

  questions:Question[];
  test:Test;


  ngOnInit(): void {
     
    this.test = this.service.getTest();
    this.service.getQuestionList(this.test.testId).subscribe(data=>
      {
        this.questions = data;
      },
      error=>
      {
        alert("error");
        console.log("error occured", error);
        
      });

  }

  

}
