import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

import { ViewRegistrationComponent } from './components/view-registration/view-registration.component';

const routes: Routes = [
    {
        path: 'add',
        component: HomeComponent 
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'admin/view/:id',
        component: ViewRegistrationComponent
    },
    {   path: '', 
        component: LoginComponent
    }

];

@NgModule({
  imports: [RouterModule.forRoot(routes  ,    
                                { enableTracing: true } // <-- debugging purposes only
    )],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
