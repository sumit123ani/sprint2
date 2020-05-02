import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { FetchService } from '../fetch.service';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { error } from '@angular/compiler/src/util';
import { Question } from '../question';


@Component({
  selector: 'app-show-test',
  templateUrl: './show-test.component.html',
  styleUrls: ['./show-test.component.css']
})
export class ShowTestComponent implements OnInit {

  constructor(private service:FetchService, private serv:AuthenticationService) { }

  user:User = new User();
  testType:any;
  test:Test = new Test();
  tests:Test[];
  tests1:Test[];
  question:Question = new Question();

  ngOnInit(): void {

   this.user = this.serv.getUser();
   
   this.service.getTestList().subscribe(data=>
    {
      this.tests = data;
    },
    error=>
    {
      console.log("error occured", error);
    });
  }

  submit()
  {
    //alert(this.testType)
    
        // alert(this.tests[3].testTitle);
         this.tests = this.tests.filter((t) => t.testTitle.startsWith("java"));

         alert(this.tests[0].testTitle)

  }

   giveTest(index:number)
   {
     this.service.setTest(this.tests[index]);
     this.tests[index].testMarksScored = null;
     this.service.assignTest(this.tests[index]).subscribe(data=>
      {
        console.log("assigned");
        
      },
      error=>{
    console.log(error);
    alert("can not assign");

      });

 
      for(var i =0; i<this.tests[index].testQuestions.length; i++)
      {
        this.question = this.tests[index].testQuestions[i];
        this.question.chosenAnswer = null;
        this.question.marksScored =null;
        this.service.updateQuestion(this.question).subscribe(data=>
          {
            console.log("successfull");
            
          },
          error=>{
              console.log("not successful");
              
          })
      }
  

   } 

}
