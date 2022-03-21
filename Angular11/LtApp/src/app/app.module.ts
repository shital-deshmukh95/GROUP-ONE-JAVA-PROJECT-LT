import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MyPipePipe } from './mycomponent/my-pipe.pipe';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { ModelcomponentComponent } from './modelcomponent/modelcomponent.component';

@NgModule({
  declarations: [// we need to be register angular Diractive and Component inside this section.
    AppComponent, MyPipePipe, CustomerComponent, HomeComponentComponent, ModelcomponentComponent 
  ],
  imports: [//we need to import all external module inside this section.
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],//inside the provider section we need to register the angular Services.
  bootstrap: [AppComponent]//here we need to put entry of the component which would be entry point of application
})
export class AppModule { }
