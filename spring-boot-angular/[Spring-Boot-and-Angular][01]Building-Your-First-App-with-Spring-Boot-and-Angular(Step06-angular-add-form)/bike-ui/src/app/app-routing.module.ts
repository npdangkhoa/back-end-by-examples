import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
    {
        path: '',
        component: HomeComponent 
    },
    {
        path: 'admin',
        component: AdminComponent
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
