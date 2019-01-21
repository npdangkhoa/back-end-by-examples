import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { BikerService} from './services/biker.service';
import { AdminComponent } from './components/admin/admin.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ViewRegistrationComponent } from './components/view-registration/view-registration.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms'; 
import { AppService } from './services/app.service';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    ViewRegistrationComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    CommonModule,
    FormsModule
    ],
  providers: [BikerService, AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
