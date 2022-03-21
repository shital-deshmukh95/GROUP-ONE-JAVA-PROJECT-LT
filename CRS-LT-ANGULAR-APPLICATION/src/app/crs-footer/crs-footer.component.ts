import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-crs-footer',
  templateUrl: './crs-footer.component.html',
  styleUrls: ['./crs-footer.component.css']
})
export class CrsFooterComponent implements OnInit {

  public dateAndTime: Date = new Date();
  constructor() { }

  ngOnInit() {
    this.currentDateAndTime();
  }

  currentDateAndTime() {
    setInterval(() => { this.dateAndTime = new Date();}, 1);
  }
}
