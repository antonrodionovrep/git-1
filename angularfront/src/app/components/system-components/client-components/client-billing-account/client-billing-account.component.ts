import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {ClientService} from "../../../../services/system-services/client.service";
import {BillingAccount} from "../../../../models/system-models/billingAccount.model";

@Component({
  selector: 'app-client-billing-account',
  templateUrl: './client-billing-account.component.html',
  styleUrls: ['./client-billing-account.component.css']
})
export class ClientBillingAccountComponent implements OnInit {
  private billingAccount: BillingAccount;

  constructor(private activatedRoute: ActivatedRoute, private clientService: ClientService) {

  }


  ngOnInit(){
    this.activatedRoute.params.subscribe((param) =>{
      this.clientService.getClientBillingAccount(param['id']).subscribe((billingAccount: BillingAccount) => {
        return this.billingAccount = billingAccount;
      });
    }, error => {
      console.log(error)
    });
  }

}
