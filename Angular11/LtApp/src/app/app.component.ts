import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // we need to define all the module and component inside Appcomponent.
  title = 'Welcome L&T';
 // name = 'shital';
 today = new Date();


//write the events in angular 
clickMessage = 'my msg';

// writing event here 
  onClickMe() {
    this.clickMessage = 'i am in Training! changed msg';
  }

}
