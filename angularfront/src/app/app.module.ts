import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { Routes, RouterModule } from "@angular/router";
import { ClientsListComponent } from "./components/system-components/client-components/clients-list/clients-list.component";
import { ClientService } from "./services/system-services/client.service";
import { ClientDetailsComponent } from "./components/system-components/client-components/client-details/client-details.component";
import { LoginComponent } from './components/security-components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthService } from "./services/security-services/auth.service";
import { CanActivateAuthGuard } from "./authguard/can-activate.authguard";
import { AdminPanelComponent } from './components/admin-components/admin-panel/admin-panel.component';
import { ModerPanelComponent } from './components/moderator-components/moder-panel/moder-panel.component';
import { ClientBillingAccountComponent } from "./components/system-components/client-components/client-billing-account/client-billing-account.component";
import {ClientServiceComponent} from "./components/system-components/client-components/client-service/client-service.component";
//import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";

const routes:Routes = [
  {path:'', pathMatch:'full', redirectTo:'api/clients'},
  {path:'api/clients', component: ClientsListComponent, canActivate: [CanActivateAuthGuard]},
  {path:'api/clients/:id', component: ClientDetailsComponent, canActivate: [CanActivateAuthGuard]},
  {path:'api/login', component: LoginComponent},
  {path:'api/admin', component: AdminPanelComponent, canActivate:[CanActivateAuthGuard]},
  {path:'api/moder', component: ModerPanelComponent, canActivate:[CanActivateAuthGuard]},
  {path:'api/clients/:id/billingAcc', component: ClientBillingAccountComponent, canActivate:[CanActivateAuthGuard]},
  {path:'api/clients/:id/service', component: ClientServiceComponent, canActivate:[CanActivateAuthGuard]}
  //{path:'**', component: PageNotFoundComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ClientsListComponent,
    //PageNotFoundComponent,
    ClientDetailsComponent,
    LoginComponent,
    LogoutComponent,
    ClientBillingAccountComponent,
    ClientServiceComponent,
    AdminPanelComponent,
    ModerPanelComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ClientService, AuthService, CanActivateAuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
