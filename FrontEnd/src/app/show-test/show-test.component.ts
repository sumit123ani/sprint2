import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { FetchService } from '../fetch.service';


@Component({
  selector: 'app-show-test',
  templateUrl: './show-test.component.html',
  styleUrls: ['./show-test.component.css']
})
export class ShowTestComponent implements OnInit {

  constructor(private service:FetchService) { }

  testType:any;
  test:Test = new Test();
  tests:Test[];
  tests1:Test[];

  ngOnInit(): void {
  }

  submit()
  {
    //alert(this.testType)
    this.service.getTestList().subscribe(data=>
      {
        this.tests = data

         this.tests1 = this.tests.filter(t => t.testTitle == this.testType+" test");
        // alert(this.tests[0].testTitle)

      },
      error=>
      {
        console.log("error occured", error);
        
      });
  }

   giveTest(index:number)
   {
     this.service.setTest(this.tests1[index]);
   } 

}
